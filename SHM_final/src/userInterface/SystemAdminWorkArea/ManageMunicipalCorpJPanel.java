/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.SystemAdminWorkArea;

import Business.MunicipalCorporation.MunicipalCorporation;
import Business.FedGoverment;
import Business.StateGoverment.StateGoverment;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class ManageMunicipalCorpJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageMunicipalCorpJPanel
     */
    private JPanel userProcessContainer;
    private FedGoverment fedGoverment;
    
    public ManageMunicipalCorpJPanel(JPanel userProcessContainer,FedGoverment fedGoverment) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.fedGoverment=fedGoverment;
        
        populateTable();
        populateCombo();
       
    }
    
    public void populateTable(){     
        
        
        DefaultTableModel dtm=(DefaultTableModel) departmentTable.getModel();
        dtm.setNumRows(0);
         for(StateGoverment state:fedGoverment.getStateGovermentList()){
             for(MunicipalCorporation department:state.getMunicipalCorporationDirectory().getMunicipalCorporationList()){
                 
                 Object row[]=new Object[3];
                 
                 row[0]=state;
                 row[1]=department.getName();
                 row[2]=department.getDepartmentType().getValue();
                 
                 dtm.addRow(row);
             }
         }
        
    }
    
    public void populateCombo(){
        
        stateCombo.removeAllItems();
        
        for(StateGoverment state:fedGoverment.getStateGovermentList()){
            if(state!=null){
                stateCombo.addItem(state);
                Submit.setEnabled(true);
            }
            
        }
        
        departmentCombo.removeAllItems();
        
        for(MunicipalCorporation.DepartmentType type:MunicipalCorporation.DepartmentType.values()){
           departmentCombo.addItem(type);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        departmentTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        stateCombo = new javax.swing.JComboBox();
        departmentCombo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDepartment = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        Submit = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 255));
        setLayout(null);

        departmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "State Goverment", "Municipal Corp", "Municipal Department"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(departmentTable);

        add(jScrollPane1);
        jScrollPane1.setBounds(19, 31, 452, 93);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("State Goverment Name:");
        add(jLabel1);
        jLabel1.setBounds(48, 161, 150, 24);

        add(stateCombo);
        stateCombo.setBounds(210, 160, 94, 20);

        add(departmentCombo);
        departmentCombo.setBounds(210, 240, 130, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Municipal Department");
        add(jLabel2);
        jLabel2.setBounds(48, 236, 150, 24);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Municipal Corp Name:");
        add(jLabel3);
        jLabel3.setBounds(48, 203, 140, 22);
        add(txtDepartment);
        txtDepartment.setBounds(210, 210, 150, 20);

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(78, 287, 90, 23);

        Submit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Submit.setText("Submit");
        Submit.setEnabled(false);
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });
        add(Submit);
        Submit.setBounds(209, 287, 80, 23);
    }// </editor-fold>//GEN-END:initComponents

    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed
        // TODO add your handling code here:
        try{
            StateGoverment state = (StateGoverment) stateCombo.getSelectedItem();
        MunicipalCorporation.DepartmentType type = (MunicipalCorporation.DepartmentType) 
                departmentCombo.getSelectedItem();

        if (state == null || type == null) {
            JOptionPane.showMessageDialog(null, "Invalid Input!");
            return;
        }

        String name = txtDepartment.getText();
        String Regex = "^[a-zA-Z]+$";
        if(!name.trim().matches(Regex)){
            JOptionPane.showMessageDialog(this, "Please add valid name into the fields.",
                            "ERROR", JOptionPane.ERROR_MESSAGE);   
            
        }
        else{
            MunicipalCorporation enterprise = state.getMunicipalCorporationDirectory().createAndAddDepaartment(name, type);

        JOptionPane.showMessageDialog(this, "Municipal Corporation "+name+" added");
        
        populateTable();
        
        }
        
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Please add proper data into the fields.",
                            "ERROR", JOptionPane.ERROR_MESSAGE);   
            
        }
        
    }//GEN-LAST:event_SubmitActionPerformed

   
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        
        userProcessContainer.remove(this);
         Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
        sysAdminwjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Submit;
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox departmentCombo;
    private javax.swing.JTable departmentTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox stateCombo;
    private javax.swing.JTextField txtDepartment;
    // End of variables declaration//GEN-END:variables
}
