/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.ConstructionCompanyWorkArea;

import Business.Architecture.Architecture;
import Business.MunicipalCorporation.MunicipalCorporation;
import Business.Organization.ConstructionCompanyOrganization;
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
public class ViewChartJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewChartJPanel
     */
    private JPanel userProcessContainer;
    private MunicipalCorporation municipalCorporation;
    private ConstructionCompanyOrganization organization;
    private UserAccount account;
    
    public ViewChartJPanel(JPanel userProcessContainer, 
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
            if(contract.getCompany()==account){
            contractCombo.addItem(contract);
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

        btnCompleteView = new javax.swing.JButton();
        btnIndividual = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        contractCombo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        btnCompleteView.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnCompleteView.setText("Complete View");
        btnCompleteView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteViewActionPerformed(evt);
            }
        });
        add(btnCompleteView);
        btnCompleteView.setBounds(310, 138, 280, 80);

        btnIndividual.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnIndividual.setText("Individual Sensor Data");
        btnIndividual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIndividualActionPerformed(evt);
            }
        });
        add(btnIndividual);
        btnIndividual.setBounds(310, 247, 280, 80);

        jButton2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton2.setText("<< Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(165, 365, 140, 50);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setText("Contract ID :");
        add(jLabel1);
        jLabel1.setBounds(165, 72, 97, 17);

        add(contractCombo);
        contractCombo.setBounds(334, 61, 199, 39);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webranking_01.png"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(0, 20, 640, 410);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCompleteViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteViewActionPerformed
        // TODO add your handling code here:
        ContractRequest contract=(ContractRequest) contractCombo.getSelectedItem();
        
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
        ContractRequest contract=(ContractRequest) contractCombo.getSelectedItem();
        
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
            }else if (sensor instanceof Sensor3Data){
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCompleteView;
    private javax.swing.JButton btnIndividual;
    private javax.swing.JComboBox contractCombo;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
