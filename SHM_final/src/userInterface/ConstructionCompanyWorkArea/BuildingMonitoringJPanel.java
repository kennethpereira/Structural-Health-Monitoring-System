/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.ConstructionCompanyWorkArea;

import Business.Architecture.Architecture;
import Business.StructuralHealthMonitor.Sensor1Data;
import Business.StructuralHealthMonitor.Sensor2Data;
import Business.StructuralHealthMonitor.Sensor3Data;

import Business.StructuralHealthMonitor.SensorData;
import Business.StructuralHealthMonitor.StructuralHealthHistory;
import java.awt.CardLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class BuildingMonitoringJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BuildingMonitoringJPanel
     */
    private JPanel userProcessContainer;
    private Architecture building;
    private ScheduledExecutorService service;
    private ScheduledExecutorService service1;
    private ScheduledExecutorService service2;
    private int counter;
    private StructuralHealthHistory shh;
    private Runnable runnable1;

    public BuildingMonitoringJPanel(JPanel userProcessContainer, Architecture building) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.building = building;

        populateSensor1();
        populateSensor2();
        populateSensor3();

    }

    public void populateSensor1() {

        DefaultTableModel dtm = (DefaultTableModel) tblSensor1.getModel();
        dtm.setRowCount(0);

        for (SensorData sensor : building.getShh().getBuildingHealthData()) {

            if (sensor instanceof Sensor1Data) {
                Object[] row = new Object[4];

                row[0] = ((Sensor1Data) sensor).getSerialNumber();
                row[1] = ((Sensor1Data) sensor).getDate();
                row[2] = ((Sensor1Data) sensor).getInputForce();
                row[3] = ((Sensor1Data) sensor).getOutputVoltage();

                dtm.addRow(row);
            }
        }
    }

    public void populateSensor2() {

        DefaultTableModel dtm = (DefaultTableModel) tblSensor2.getModel();
        dtm.setRowCount(0);

        for (SensorData sensor : building.getShh().getBuildingHealthData()) {

            if (sensor instanceof Sensor2Data) {
                Object[] row = new Object[4];

                row[0] = ((Sensor2Data) sensor).getSerialNumber();
                row[1] = ((Sensor2Data) sensor).getDate();
                row[2] = ((Sensor2Data) sensor).getInputForce();
                row[3] = ((Sensor2Data) sensor).getOutputVoltage();

                dtm.addRow(row);
            }

        }

    }

    public void populateSensor3() {

        DefaultTableModel dtm = (DefaultTableModel) tblSensor3.getModel();
        dtm.setRowCount(0);

        for (SensorData sensor : building.getShh().getBuildingHealthData()) {

            if (sensor instanceof Sensor3Data) {
                Object[] row = new Object[4];

                row[0] = ((Sensor3Data) sensor).getSerialNumber();
                row[1] = ((Sensor3Data) sensor).getDate();
                row[2] = ((Sensor3Data) sensor).getInputForce();
                row[3] = ((Sensor3Data) sensor).getOutputVoltage();

                dtm.addRow(row);
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

        tabPanel = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSensor1 = new javax.swing.JTable();
        btnStart = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSensor2 = new javax.swing.JTable();
        btnRefresh2 = new javax.swing.JButton();
        btnStart2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSensor3 = new javax.swing.JTable();
        btnRefresh3 = new javax.swing.JButton();
        btnStart3 = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 255));

        tblSensor1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serial #", "Date & Time", "Force in Newtons", "Output Volts"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSensor1);

        btnStart.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnStart.setText("START");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        btnRefresh.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        tabPanel.addTab("Sensor 1", jPanel3);

        tblSensor2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serial #", "Date & Time", "Force in Newtons", "Output Volts"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblSensor2);

        btnRefresh2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnRefresh2.setText("Refresh");
        btnRefresh2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefresh2ActionPerformed(evt);
            }
        });

        btnStart2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnStart2.setText("START");
        btnStart2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStart2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(btnStart2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btnRefresh2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStart2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        tabPanel.addTab("Sensor 2", jPanel1);

        tblSensor3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serial #", "Date & Time", "Force in Newtons", "Output Volts"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblSensor3);

        btnRefresh3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnRefresh3.setText("Refresh");
        btnRefresh3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefresh3ActionPerformed(evt);
            }
        });

        btnStart3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnStart3.setText("START");
        btnStart3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStart3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(btnStart3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btnRefresh3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStart3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        tabPanel.addTab("Sensor3", jPanel2);

        btnBack.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnStop.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnStop.setText("STOP ALL");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(tabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(208, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(tabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btnStop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(62, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        // TODO add your handling code here:
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        runnable1 = new Runnable() {
            public void run() {

                Random r = new Random();
                int inputForce = r.nextInt((100 - 1) + 1) + 1;
                String SID = "S1ID" + counter;

                shh = building.getShh();

                Sensor1Data sensor = new Sensor1Data();

                sensor.setDate(date.toString());
                sensor.setInputForce(inputForce);
                sensor.setOutputVoltage(inputForce);
                sensor.setSerialNumber(SID);
                sensor.setLocation("Beams");

                counter++;

                shh.getBuildingHealthData().add(sensor);

                populateSensor1();
            }
        };

        service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(runnable1, 0, 5, TimeUnit.SECONDS);


    }//GEN-LAST:event_btnStartActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:

        populateSensor1();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnRefresh2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefresh2ActionPerformed
        // TODO add your handling code here:
        populateSensor2();
    }//GEN-LAST:event_btnRefresh2ActionPerformed

    private void btnStart2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStart2ActionPerformed
        // TODO add your handling code here:
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        runnable1 = new Runnable() {
            public void run() {

                Random r = new Random();
                int inputForce = r.nextInt((100 - 1) + 1) + 1;
                String SID = "S2ID" + counter;

                shh = building.getShh();

                Sensor2Data sensor2 = new Sensor2Data();

                sensor2.setDate(date.toString());
                sensor2.setInputForce(inputForce);
                sensor2.setOutputVoltage(inputForce);
                sensor2.setSerialNumber(SID);
                sensor2.setLocation("Columns");

                counter++;

                shh.getBuildingHealthData().add(sensor2);

                populateSensor2();
            }
        };

        service1 = Executors.newSingleThreadScheduledExecutor();
        service1.scheduleAtFixedRate(runnable1, 0, 5, TimeUnit.SECONDS);


    }//GEN-LAST:event_btnStart2ActionPerformed

    private void btnRefresh3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefresh3ActionPerformed
        // TODO add your handling code here:
        populateSensor3();
    }//GEN-LAST:event_btnRefresh3ActionPerformed

    private void btnStart3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStart3ActionPerformed
        // TODO add your handling code here:
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        runnable1 = new Runnable() {
            public void run() {

                Random r = new Random();
                int inputForce = r.nextInt((100 - 1) + 1) + 1;
                String SID = "S3ID" + counter;

                shh = building.getShh();

                Sensor3Data sensor3 = new Sensor3Data();

                sensor3.setDate(date.toString());
                sensor3.setInputForce(inputForce);
                sensor3.setOutputVoltage(inputForce);
                sensor3.setSerialNumber(SID);
                sensor3.setLocation("Braces");

                counter++;

                shh.getBuildingHealthData().add(sensor3);

                populateSensor3();
            }
        };

        service2 = Executors.newSingleThreadScheduledExecutor();
        service2.scheduleAtFixedRate(runnable1, 0, 5, TimeUnit.SECONDS);


    }//GEN-LAST:event_btnStart3ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);


    }//GEN-LAST:event_btnBackActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        // TODO add your handling code here:
        service.shutdown();
        service1.shutdown();
        service2.shutdown();
        JOptionPane.showMessageDialog(this, "All sensor services have been stopped!");
        /*if(service.isShutdown()){
         JOptionPane.showMessageDialog(this, "Sensor Services are already shut!");
         }
         else{
         service.shutdownNow();
         JOptionPane.showMessageDialog(this, "All sensor services have been stopped!");
         }*/
    }//GEN-LAST:event_btnStopActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRefresh2;
    private javax.swing.JButton btnRefresh3;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStart2;
    private javax.swing.JButton btnStart3;
    private javax.swing.JButton btnStop;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane tabPanel;
    private javax.swing.JTable tblSensor1;
    private javax.swing.JTable tblSensor2;
    private javax.swing.JTable tblSensor3;
    // End of variables declaration//GEN-END:variables
}
