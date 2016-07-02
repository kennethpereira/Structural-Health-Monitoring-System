/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.ConstructionCompanyWorkArea;

import Business.Architecture.Architecture;
import Business.Email.EmailManagementSystem;
import Business.MunicipalCorporation.MunicipalCorporation;
import Business.Organization.CitizenOrganization;
import Business.Organization.ConstructionCompanyOrganization;
import Business.Organization.Organization;
import Business.Person.Person;
import Business.StructuralHealthMonitor.Sensor1Data;
import Business.StructuralHealthMonitor.Sensor2Data;
import Business.StructuralHealthMonitor.Sensor3Data;
import Business.StructuralHealthMonitor.SensorData;
import Business.StructuralHealthMonitor.StructuralHealthHistory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ContractRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Calendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class DecisionMakingJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DecisionMakingJPanel
     */
    private JPanel userProcessContainer;
    private MunicipalCorporation municipalCorporation;
    private ConstructionCompanyOrganization organization;
    private UserAccount account;

    public DecisionMakingJPanel(JPanel userProcessContainer, 
            UserAccount account, ConstructionCompanyOrganization organization,
            MunicipalCorporation municipalCorporation) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.municipalCorporation=municipalCorporation;
        this.organization=organization;
        this.account=account;
        
        populateCombo();
        
        
        
    }
    
   public void populateCombo(){
        
        contractCombo.removeAllItems();
        
        for(ContractRequest contract:organization.getWorkQueue().getContractList()){
            if(account==contract.getCompany())
            contractCombo.addItem(contract);
        }
    }
   
   public void populateFields(){
       
       ContractRequest contract=(ContractRequest) contractCombo.getSelectedItem();
        Calendar now = Calendar.getInstance();
        Architecture building=contract.getArchitecture();
        
        fldName.setText(building.getArchitectureName());
        fldCity.setText(municipalCorporation.getName());
        
        int buildingAge=now.get((Calendar.YEAR))-building.getYearConstructed();
        
        int counter=1;
        float sensor1AvgInput = 0;
        float sensor2AvgInput = 0;
        float sensor3AvgInput = 0;
        float sensor1AvgOutput = 0;
        float sensor2AvgOutput = 0;
        float sensor3AvgOutput = 0;
        String location1="";
        String location2="";
        String location3="";
        String majorRepair="";
        String minorRepair="";
        String temp1="";
        String temp2="";
        String temp3="";
        
        Sensor1Data sensor1=null;
        Sensor2Data sensor2=null;
        Sensor3Data sensor3=null;
        
        for(SensorData sensor:building.getShh().getBuildingHealthData()){
            
            if(sensor instanceof Sensor1Data){
                
                int input1=sensor.getInputForce();
                float output1=sensor.getOutputVoltage();
                
                sensor1AvgInput=input1/counter;
                sensor1AvgOutput=output1/counter;
                sensor1=(Sensor1Data) sensor;
                
                
            }else if(sensor instanceof Sensor2Data){
                
                int input2=sensor.getInputForce();
                float output2=sensor.getOutputVoltage();
                
                sensor2AvgInput=input2/counter;
                sensor2AvgOutput=output2/counter;
                sensor2=(Sensor2Data) sensor;
                
                
                
            }else if(sensor instanceof Sensor3Data){
                
                int input3=sensor.getInputForce();
                float output3=sensor.getOutputVoltage();
                
                sensor3AvgInput=input3/counter;
                sensor3AvgOutput=output3/counter;
                sensor3=(Sensor3Data) sensor;
                
                
                
            }
        }
        
                
        
        Random r = new Random();
        int rank = 0;
                
                
        
        float avgInput=(sensor3AvgInput+sensor2AvgInput+sensor1AvgInput)/3;
        float avgOutput=(sensor1AvgOutput+sensor2AvgOutput+sensor3AvgOutput)/3;
        
        if(avgInput>=70&&avgOutput>=3){
                
              building.setStatus("Critical!");
              int days=180;
              building.setRepairDays(days);
              fldRepair.setText(String.valueOf(days));
              rank=r.nextInt((10 - 7) + 7);
              building.setRanking(rank);
              
              EmailManagementSystem email=new EmailManagementSystem();
              
              for(Organization org:municipalCorporation.getOrganizationDirectory().getOrganizationList()){
                  if(org instanceof CitizenOrganization){
                      for(Person person:org.getPersonDirectory().getEmployeeList()){
                          String to=person.getEmailID();
                          String Subject="Urgent Attention!!";
                          String body="This email is on behalf of the maintainance company. Building "+
                                  building.getArchitectureName()+'\n'+" is unsafe and the structure is critical."+'\n'
                                  +"Our officials on the location will guide you further. Please contact them at the earliest.";
                          
                          try {
                              email.GenerateMail(to, Subject, body);
                          } catch (MessagingException ex) {
                              JOptionPane.showMessageDialog(this, "Exception while generating an email");
                              return;
                          }
                      }
                  }
              }
                
            }
            else if((avgInput>=40&&avgOutput>=2&&avgInput<70&&avgOutput<3)){
                building.setStatus("Moderate");
                int day1=90;
                building.setRepairDays(day1);
                fldRepair.setText(String.valueOf(day1));

                rank=r.nextInt((6 - 4) + 4);
                building.setRanking(rank);
              
               
            }
            else{
                building.setStatus("Normal");
                
                int day2=20;
                building.setRepairDays(day2);
                fldRepair.setText(String.valueOf(day2));

                rank=r.nextInt((3 - 1) + 1);
                building.setRanking(rank);
              
            }
            
        
            if(sensor1AvgInput>=70&&sensor1AvgOutput>=3){
                    location1=sensor1.getLocation();
                }else{
                     temp1=sensor1.getLocation();
                }
         
                if(sensor2AvgInput>=70&&sensor2AvgOutput>=3){
                    location2=sensor2.getLocation();
                }else{
                     temp2=sensor2.getLocation();
                }
       
                if(sensor3AvgInput>=70&&sensor3AvgOutput>=3){
                    location3=sensor3.getLocation();
                }else{
                     temp3=sensor3.getLocation();
                }
        
                 StructuralHealthHistory shh=building.getShh();
                 
                
                
                
            majorRepair=location1+" "+location2+" "+location3;
        minorRepair=temp1+" "+temp2+" "+temp3;
        
        
        
        fldMajor.setText(majorRepair.trim());
        fldMinor.setText(minorRepair.trim());
        
            building.setMajorRepairsLocation(majorRepair.trim());
            building.setMinorRepairLocations(minorRepair.trim());
            
        if(buildingAge>=50){
            
            if(avgInput>=70&&avgOutput>=3){
                
                txtComments.setText(building.getArchitectureName()+" is "+
                        buildingAge+" years old."+'\n'+" Consider evacuating the Citizens and begin repairing");
                building.setComments(building.getArchitectureName()+" is "+
                        buildingAge+" years old."+'\n'+" Consider evacuating the Citizens and begin repairing");
            }
            else{
               txtComments.setText(building.getArchitectureName()+" is "+buildingAge+" years old. "+'\n'
                       + "The building is well maintained.Complete the major Repairs"); 
               
               building.setComments(building.getArchitectureName()+" is "+buildingAge+" years old. "+'\n'
                       + "The building is well maintained.Complete the major Repairs");
            }
            
            
            
        } else if(buildingAge<50&&buildingAge>=20){
            if(avgInput>=70&&avgOutput>=3){
                
                txtComments.setText(building.getArchitectureName()+" is "+buildingAge+" "
                        + "years old."+'\n'+" Consider Repairing the building's major repair locations "
                        + "at the earlies");
                
                building.setComments(building.getArchitectureName()+" is "+buildingAge+" "
                        + "years old."+'\n'+" Consider Repairing the building's major repair locations "
                        + "at the earlies");
                
            }
            else{
               txtComments.setText(building.getArchitectureName()+" is "+buildingAge+" "
                       + "years old."+'\n'+" The building is well maintained. Handle the repairs"); 
               
               building.setComments(building.getArchitectureName()+" is "+buildingAge+" "
                       + "years old."+'\n'+" The building is well maintained. Handle the repairs");
            }
            
            
        } else if (buildingAge<20&&buildingAge>=10){
            
            if(avgInput>=70&&avgOutput>=3){
                
                txtComments.setText(building.getArchitectureName()+" is "+
                        buildingAge+" years old."+'\n'+" Consider Repairing the "
                        + "building's major repair locations at the earlies");
                building.setComments(building.getArchitectureName()+" is "+
                        buildingAge+" years old."+'\n'+" Consider Repairing the "
                        + "building's major repair locations at the earlies");
                
            }
            else{
               txtComments.setText(building.getArchitectureName()+" is "+buildingAge+" "
                       + "years old."+'\n'+" The building is well maintained. Handle the repairs");
               
               building.setComments(building.getArchitectureName()+" is "+buildingAge+" "
                       + "years old."+'\n'+" The building is well maintained. Handle the repairs");
            }
            
            
            
        }
        
        
   }
   
   


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        contractCombo = new javax.swing.JComboBox();
        fldName = new javax.swing.JTextField();
        fldCity = new javax.swing.JTextField();
        fldMajor = new javax.swing.JTextField();
        fldMinor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtComments = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        fldRepair = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setText("Contract ID:");
        add(jLabel1);
        jLabel1.setBounds(130, 65, 86, 29);

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setText("Building Name ");
        add(jLabel2);
        jLabel2.setBounds(130, 122, 138, 29);

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setText("City");
        add(jLabel3);
        jLabel3.setBounds(414, 122, 138, 29);

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setText("Locations needing Major Repair");
        add(jLabel4);
        jLabel4.setBounds(130, 208, 212, 29);

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setText("Locations needing minor Repairs");
        add(jLabel5);
        jLabel5.setBounds(414, 208, 214, 29);

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel6.setText("Comments & Notes ");
        add(jLabel6);
        jLabel6.setBounds(414, 292, 212, 29);

        btnBack.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnBack.setText("<< BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(183, 376, 118, 31);

        btnPrint.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnPrint.setText("PRINT / SAVE");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        add(btnPrint);
        btnPrint.setBounds(183, 418, 118, 31);

        contractCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contractComboActionPerformed(evt);
            }
        });
        add(contractCombo);
        contractCombo.setBounds(268, 65, 159, 29);

        fldName.setEditable(false);
        add(fldName);
        fldName.setBounds(130, 157, 147, 27);

        fldCity.setEditable(false);
        add(fldCity);
        fldCity.setBounds(414, 157, 169, 27);

        fldMajor.setEditable(false);
        add(fldMajor);
        fldMajor.setBounds(130, 243, 226, 31);

        fldMinor.setEditable(false);
        add(fldMinor);
        fldMinor.setBounds(414, 243, 227, 31);

        txtComments.setEditable(false);
        txtComments.setColumns(20);
        txtComments.setRows(5);
        jScrollPane1.setViewportView(txtComments);

        add(jScrollPane1);
        jScrollPane1.setBounds(414, 327, 227, 133);

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel7.setText("Days required to complete the repair");
        add(jLabel7);
        jLabel7.setBounds(130, 292, 226, 29);

        fldRepair.setEditable(false);
        add(fldRepair);
        fldRepair.setBounds(130, 327, 226, 31);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/4878226_annual_report_300.jpg"))); // NOI18N
        add(jLabel8);
        jLabel8.setBounds(0, 0, 960, 510);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        DecisionMakingJPanel ajp = (DecisionMakingJPanel) component;
            
        PrinterJob pj = PrinterJob.getPrinterJob();
  pj.setJobName(" Print Component ");

  pj.setPrintable (new Printable() {    
    public int print(Graphics pg, PageFormat pf, int pageNum){
      if (pageNum > 0){
      return Printable.NO_SUCH_PAGE;
      }

      Graphics2D g2 = (Graphics2D) pg;
      g2.translate(pf.getImageableX(), pf.getImageableY());
      ajp.paint(g2);
      return Printable.PAGE_EXISTS;
    }
  });
  if (pj.printDialog() == false)
  return;

  try {
        pj.print();
  } catch (PrinterException ex) {
        // handle exception
  }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void contractComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contractComboActionPerformed
        // TODO add your handling code here:
        populateFields();
    }//GEN-LAST:event_contractComboActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnPrint;
    private javax.swing.JComboBox contractCombo;
    private javax.swing.JTextField fldCity;
    private javax.swing.JTextField fldMajor;
    private javax.swing.JTextField fldMinor;
    private javax.swing.JTextField fldName;
    private javax.swing.JTextField fldRepair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtComments;
    // End of variables declaration//GEN-END:variables
}
