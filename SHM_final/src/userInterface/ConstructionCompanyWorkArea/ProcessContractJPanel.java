/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.ConstructionCompanyWorkArea;

import Business.MunicipalCorporation.MunicipalCorporation;
import Business.WorkQueue.ContractRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class ProcessContractJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ProcessContractJPanel
     */
    private JPanel UserProcessContainer;
    private ContractRequest contract;
    private MunicipalCorporation municpalCorporation;
    
    
    public ProcessContractJPanel(JPanel UserProcessContainer,MunicipalCorporation municpalCorporation,ContractRequest contract) {
        initComponents();
        this.UserProcessContainer=UserProcessContainer;
        this.municpalCorporation=municpalCorporation;
        this.contract=contract;
        
        populateFields();
        
    }
    
    public void populateFields(){
        
        fldMunicipalCorporation.setText(municpalCorporation.getName());
        fldBuildingName.setText(contract.getArchitecture().getArchitectureName());
        fldBuidinYear.setText(String.valueOf(contract.getArchitecture().getYearConstructed()));
        fldContractID.setText(contract.getContractID());
        
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
        fldContractID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fldMunicipalCorporation = new javax.swing.JTextField();
        fldBuidinYear = new javax.swing.JTextField();
        fldBuildingName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnMonitor = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setText("Contract ID");
        add(jLabel1);
        jLabel1.setBounds(56, 35, 96, 26);

        fldContractID.setEditable(false);
        fldContractID.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        add(fldContractID);
        fldContractID.setBounds(232, 37, 153, 23);

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setText("Municipal Corporation:");
        add(jLabel2);
        jLabel2.setBounds(56, 90, 151, 23);

        fldMunicipalCorporation.setEditable(false);
        add(fldMunicipalCorporation);
        fldMunicipalCorporation.setBounds(232, 90, 153, 20);

        fldBuidinYear.setEditable(false);
        add(fldBuidinYear);
        fldBuidinYear.setBounds(232, 183, 153, 20);

        fldBuildingName.setEditable(false);
        add(fldBuildingName);
        fldBuildingName.setBounds(232, 137, 204, 20);

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setText("Year Constructed");
        add(jLabel3);
        jLabel3.setBounds(56, 180, 151, 23);

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setText("Building # & Address");
        add(jLabel4);
        jLabel4.setBounds(56, 136, 151, 23);

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(84, 238, 100, 23);

        btnMonitor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnMonitor.setText("Begin Monitoring");
        btnMonitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMonitorActionPerformed(evt);
            }
        });
        add(btnMonitor);
        btnMonitor.setBounds(243, 238, 150, 23);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plant-layout-design.jpg"))); // NOI18N
        add(jLabel5);
        jLabel5.setBounds(0, 0, 510, 380);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        UserProcessContainer.remove(this);
        Component[] componentArray = UserProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ContractViewPanel ccw = (ContractViewPanel) component;
        ccw.populateTable();
        
        
        CardLayout layout=(CardLayout) UserProcessContainer.getLayout();
        layout.previous(UserProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnMonitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonitorActionPerformed
        // TODO add your handling code here:
        BuildingMonitoringJPanel bmj=new BuildingMonitoringJPanel(UserProcessContainer,contract.getArchitecture());
        UserProcessContainer.add("BuildingMonitoringJPanel", bmj);
        
        CardLayout layout=(CardLayout)UserProcessContainer.getLayout();
        layout.next(UserProcessContainer);
    }//GEN-LAST:event_btnMonitorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnMonitor;
    private javax.swing.JTextField fldBuidinYear;
    private javax.swing.JTextField fldBuildingName;
    private javax.swing.JTextField fldContractID;
    private javax.swing.JTextField fldMunicipalCorporation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
