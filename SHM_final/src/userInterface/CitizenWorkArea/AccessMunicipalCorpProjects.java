/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.CitizenWorkArea;

import Business.Architecture.Architecture;
import Business.FedGoverment;
import Business.MunicipalCorporation.MunicipalCorporation;
import Business.Organization.CitizenOrganization;
import Business.Organization.Organization;
import Business.StateGoverment.StateGoverment;
import Business.StructuralHealthMonitor.Sensor1Data;
import Business.StructuralHealthMonitor.Sensor2Data;
import Business.StructuralHealthMonitor.Sensor3Data;
import Business.StructuralHealthMonitor.SensorData;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ContractRequest;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author User
 */
public class AccessMunicipalCorpProjects extends javax.swing.JPanel {

    /**
     * Creates new form AccessMunicipalCorpProjects
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private CitizenOrganization mco;
    private MunicipalCorporation municipalCorporation;
    private FedGoverment fedGoverment;
    
    public AccessMunicipalCorpProjects(JPanel userProcessContainer,
            UserAccount account,CitizenOrganization mco,
            MunicipalCorporation municipalCorporation,FedGoverment fedGoverment) {
        initComponents();
        
        this.userProcessContainer=userProcessContainer;
        this.mco=mco;
        this.account=account;
        this.municipalCorporation=municipalCorporation;
        this.fedGoverment=fedGoverment;
        populateMunicpalCombo();
    }

    public void populateMunicpalCombo(){
        
        comboMunicipal.removeAllItems();
        
        for(StateGoverment state:fedGoverment.getStateGovermentList()){
            for(MunicipalCorporation municipalCorporation:state.getMunicipalCorporationDirectory().getMunicipalCorporationList()){
                comboMunicipal.addItem(municipalCorporation);
                
            }
        }
        
        
    }
    
    public void  populateContract(MunicipalCorporation municipal){
        
        comboContract.removeAllItems();
        
        for(Organization org:municipal.getOrganizationDirectory().getOrganizationList()){
            for(ContractRequest contract:org.getWorkQueue().getContractList()){
                comboContract.addItem(contract);
            }
            
        }
        btnCompleteView.setEnabled(true);
        btnIndividual.setEnabled(true);
        
        
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
        comboMunicipal = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        comboContract = new javax.swing.JComboBox();
        btnCompleteView = new javax.swing.JButton();
        btnIndividual = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setText("Municipal Corporation");
        add(jLabel1);
        jLabel1.setBounds(75, 58, 141, 25);

        comboMunicipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMunicipalActionPerformed(evt);
            }
        });
        add(comboMunicipal);
        comboMunicipal.setBounds(244, 60, 150, 20);

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setText("Contract Request ID : ");
        add(jLabel2);
        jLabel2.setBounds(75, 109, 141, 22);

        add(comboContract);
        comboContract.setBounds(244, 109, 150, 22);

        btnCompleteView.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnCompleteView.setText("Complete View");
        btnCompleteView.setEnabled(false);
        btnCompleteView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteViewActionPerformed(evt);
            }
        });
        add(btnCompleteView);
        btnCompleteView.setBounds(55, 168, 179, 35);

        btnIndividual.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnIndividual.setText("Individual Sensor Data");
        btnIndividual.setEnabled(false);
        btnIndividual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIndividualActionPerformed(evt);
            }
        });
        add(btnIndividual);
        btnIndividual.setBounds(261, 166, 179, 38);

        jButton1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jButton1.setText("<< Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(212, 231, 88, 31);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/our-projects.jpg"))); // NOI18N
        add(jLabel3);
        jLabel3.setBounds(0, 0, 1020, 510);
    }// </editor-fold>//GEN-END:initComponents

    private void comboMunicipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMunicipalActionPerformed
        // TODO add your handling code here:
        comboContract.removeAllItems();
        MunicipalCorporation municipal=(MunicipalCorporation) comboMunicipal.getSelectedItem();
        populateContract(municipal);
        
        
    }//GEN-LAST:event_comboMunicipalActionPerformed

    private void btnCompleteViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteViewActionPerformed
        // TODO add your handling code here:
        ContractRequest contract=(ContractRequest) comboContract.getSelectedItem();

        Architecture building=contract.getArchitecture();
        DefaultCategoryDataset dcd=new DefaultCategoryDataset();
        DefaultCategoryDataset dcd1=new DefaultCategoryDataset();
        for(SensorData sensor:building.getShh().getBuildingHealthData()){

            //   Double input=Double.parseDouble(String.valueOf(sensor.getInputForce()));
            //   Double output=Double.parseDouble(String.valueOf(sensor.getOutputVoltage()));
            //   System.out.println(sensor.getDate());
            dcd.addValue(sensor.getInputForce(), "Values", sensor.getDate());
            dcd1.addValue(sensor.getOutputVoltage(), "Values", sensor.getDate());

        }

        JFreeChart chart= ChartFactory.createLineChart("Piezoelectric Sensor Data",
            "Date and Time", "Force in Newton", dcd,
            PlotOrientation.VERTICAL, false, true, false);

        CategoryPlot p=chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.MAGENTA);

        ChartFrame frame=new ChartFrame("Piezoelectric Data",chart);
        frame.setVisible(true);
        frame.setSize(450, 400);

        JFreeChart chart1= ChartFactory.createLineChart("Piezoelectric  Sensor Data",
            "Date and Time", "Voltage (V)", dcd1,
            PlotOrientation.VERTICAL, false, true, false);

        CategoryPlot p1=chart1.getCategoryPlot();
        p1.setRangeGridlinePaint(Color.MAGENTA);

        ChartFrame frame1=new ChartFrame("Piezoelectric Data",chart1);
        frame1.setVisible(true);
        frame1.setSize(450, 400);
    }//GEN-LAST:event_btnCompleteViewActionPerformed

    private void btnIndividualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIndividualActionPerformed
        // TODO add your handling code here:
        ContractRequest contract=(ContractRequest) comboContract.getSelectedItem();

        Architecture building=contract.getArchitecture();
        DefaultCategoryDataset dcd=new DefaultCategoryDataset();
        DefaultCategoryDataset dcd1=new DefaultCategoryDataset();
        for(SensorData sensor:building.getShh().getBuildingHealthData()){

            if(sensor instanceof Sensor1Data){
                dcd.addValue(((Sensor1Data)sensor).getInputForce(), "Values", "Sensor 1");
                dcd1.addValue(((Sensor1Data)sensor).getOutputVoltage(), "Values", "Sensor 1");

            } else if (sensor instanceof Sensor2Data){
                dcd.addValue(((Sensor2Data)sensor).getInputForce(), "Values", "Sensor 2");
                dcd1.addValue(((Sensor2Data)sensor).getOutputVoltage(), "Values", "Sensor 2");
            }else {
                dcd.addValue(((Sensor3Data)sensor).getInputForce(), "Values", "Sensor 3");
                dcd1.addValue(((Sensor3Data)sensor).getOutputVoltage(), "Values", "Sensor 3");
            }

        }
        JFreeChart chart= ChartFactory.createBarChart3D("Piezoelectric Sensor Data",
            "Date and Time", "Force in Newtons", dcd,
            PlotOrientation.VERTICAL, false, true, false);

        CategoryPlot p=chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.MAGENTA);

        ChartFrame frame=new ChartFrame("Piezoelectric Data",chart);
        frame.setVisible(true);
        frame.setSize(450, 400);

        JFreeChart chart1= ChartFactory.createBarChart3D("Piezoelectric  Sensor Data",
            "Date and Time", "Voltage (V)", dcd1,
            PlotOrientation.VERTICAL, false, true, false);

        CategoryPlot p1=chart1.getCategoryPlot();
        p1.setRangeGridlinePaint(Color.MAGENTA);

        ChartFrame frame1=new ChartFrame("Piezoelectric Data",chart1);
        frame1.setVisible(true);
        frame1.setSize(450, 400);

    }//GEN-LAST:event_btnIndividualActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCompleteView;
    private javax.swing.JButton btnIndividual;
    private javax.swing.JComboBox comboContract;
    private javax.swing.JComboBox comboMunicipal;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}