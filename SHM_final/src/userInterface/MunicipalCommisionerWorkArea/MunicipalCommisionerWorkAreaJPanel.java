/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.MunicipalCommisionerWorkArea;

import Business.Architecture.Architecture;
import Business.Architecture.ArchitectureDirectory;
import Business.MunicipalCorporation.MunicipalCorporation;
import Business.Organization.MunicipalCommsionerOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class MunicipalCommisionerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form MunicipalCommisionerWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private MunicipalCommsionerOrganization mco;
    private MunicipalCorporation municipalCorporation;
    
    public MunicipalCommisionerWorkAreaJPanel(JPanel userProcessContainer,UserAccount account,MunicipalCommsionerOrganization mco,MunicipalCorporation municipalCorporation) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.account=account;
        this.mco=mco;
        this.municipalCorporation=municipalCorporation;
       
        populateBuilding();
    }  
    
    public void populateBuilding(){
        int regID[]={789,856,365,756,968,258,741,364,125,025};
        int buildingYear[]={1789,1852,1974,1742,1947,1975,1942,1985,1742,1965};
        String buildingNumber[]={"75","100","25","1171","1167","1185","1186","1147","1198","1325"};
        String streetName[]={"Boylston street","St. Alphonsus street","Smith Street","Parker Street",
            "WestLand Avenue","Roxbury","Churchill street","Park Drive","Cedar Street","1st Street","Maple Street"};
        
        ArchitectureDirectory bd=null;
       
            
                 bd=municipalCorporation.getBuildingDirectory();
                for(int i=0;i<buildingNumber.length;i++){
                   int reg=regID[i];
                   int year=buildingYear[i];
                  
                   String name=buildingNumber[i]+" "+streetName[i];
                  // System.out.println(bd);
                    Architecture b=bd.createBuilding();
                    b.setArchitectureName(name);
                    b.setYearConstructed(year);
                    b.setRegID(reg);
                    
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

        btnReleaseBids = new javax.swing.JButton();
        btnReports = new javax.swing.JButton();
        btnAddStructure = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnReleaseBids.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnReleaseBids.setText("Bidding & Contract Panel");
        btnReleaseBids.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReleaseBidsActionPerformed(evt);
            }
        });
        add(btnReleaseBids, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, 203, 41));

        btnReports.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnReports.setText("Reports");
        btnReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportsActionPerformed(evt);
            }
        });
        add(btnReports, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 310, 203, 45));

        btnAddStructure.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnAddStructure.setText("Add new Building/Bridges");
        btnAddStructure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStructureActionPerformed(evt);
            }
        });
        add(btnAddStructure, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 203, 39));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dudley-Square-Municipal-Office-Facility_Edited.JPG"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 570));
    }// </editor-fold>//GEN-END:initComponents

    private void btnReleaseBidsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReleaseBidsActionPerformed
        // TODO add your handling code here:
        ReleaseBidsWorkArea rbw=new ReleaseBidsWorkArea(userProcessContainer, account, mco, municipalCorporation);
        
        userProcessContainer.add("ReleaseBidsWorkArea", rbw);
        
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnReleaseBidsActionPerformed

    private void btnReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportsActionPerformed
        // TODO add your handling code here:
        ReportsJPanel rjp=new ReportsJPanel(userProcessContainer, account, mco, municipalCorporation);
        userProcessContainer.add("ReportsJPanel", rjp);
        
        CardLayout layout=(CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnReportsActionPerformed

    private void btnAddStructureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStructureActionPerformed
        // TODO add your handling code here:
        AddNewArchitectureJPanel ana=new AddNewArchitectureJPanel(userProcessContainer, account, mco, municipalCorporation);
        
        userProcessContainer.add("AddNewArchitectureJPanel", ana);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnAddStructureActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddStructure;
    private javax.swing.JButton btnReleaseBids;
    private javax.swing.JButton btnReports;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}