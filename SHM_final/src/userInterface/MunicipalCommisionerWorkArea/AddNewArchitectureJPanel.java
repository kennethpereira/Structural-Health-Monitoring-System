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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class AddNewArchitectureJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AddNewArchitectureJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private MunicipalCommsionerOrganization mco;
    private MunicipalCorporation municipalCorporation;
    
    public AddNewArchitectureJPanel(JPanel userProcessContainer,UserAccount account,
           MunicipalCommsionerOrganization mco,MunicipalCorporation municipalCorporation ) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.mco=mco;
        this.municipalCorporation=municipalCorporation;
        this.account=account;
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
        fldbuilding = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fldRegID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fldYear = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setText("Architecture Name :");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, 24));
        add(fldbuilding, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 151, -1));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setText("Year Built :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 80, 24));
        add(fldRegID, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 151, -1));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setText("Regestration ID :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, 24));
        add(fldYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 151, -1));

        btnBack.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        btnSubmit.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnSubmit.setText("Add");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 76, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/2011-10-03_23.13.45.png"))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 490));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        
      //  validateFields();
        try{
        ArchitectureDirectory arch=municipalCorporation.getBuildingDirectory();
        String regEx="^[a-zA-Z0-9][0-9a-zA-Z .,'-]*$";
         String regEx1="^\\d{4}$";
            
        String name=fldbuilding.getText();
        int ID=Integer.parseInt(fldRegID.getText());
        int year=Integer.parseInt(fldYear.getText());
        
        if(!name.trim().matches(regEx)&&!fldYear.getText().trim().matches(regEx1)&&!fldRegID.getText().trim().matches(regEx1)){
            JOptionPane.showMessageDialog(this, "Unforeseen error. Please enter the correct details.", 
                "Warning", JOptionPane.WARNING_MESSAGE);
            
        }
        else
        {
           Architecture a=arch.createBuilding();
        
        a.setArchitectureName(name);
        a.setRegID(ID);
        a.setYearConstructed(year);
        
        JOptionPane.showMessageDialog(this, "New Architecture added to the system!.", 
                "Information", JOptionPane.INFORMATION_MESSAGE);
         
        }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Unforeseen error. Please enter the correct details.", 
                "Warning", JOptionPane.WARNING_MESSAGE);
                return;
        }
        
        fldRegID.setText("");
        fldYear.setText("");
        fldbuilding.setText("");
        
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JTextField fldRegID;
    private javax.swing.JTextField fldYear;
    private javax.swing.JTextField fldbuilding;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}