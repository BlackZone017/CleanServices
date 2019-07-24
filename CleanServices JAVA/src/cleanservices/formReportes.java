/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cleanservices;

import Clases.Queries_Reportes;

public class formReportes extends javax.swing.JInternalFrame {

    /**
     * Creates new form formReportes
     */
    public formReportes() {
        initComponents();
    }

    Queries_Reportes consultas = new Queries_Reportes();
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        asistentes = new javax.swing.JLabel();
        reportesDiarios = new javax.swing.JButton();
        reportesAnuales = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        reportesMensuales = new javax.swing.JButton();
        next = new javax.swing.JButton();
        anterior = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        asistentes.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        asistentes.setForeground(new java.awt.Color(255, 255, 255));
        asistentes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        asistentes.setText("REPORTES");
        getContentPane().add(asistentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 240, 40));

        reportesDiarios.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        reportesDiarios.setText("Reportes Diarios (hoy)");
        reportesDiarios.setBorder(new javax.swing.border.MatteBorder(null));
        reportesDiarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportesDiariosActionPerformed(evt);
            }
        });
        getContentPane().add(reportesDiarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 200, 30));

        reportesAnuales.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        reportesAnuales.setText("Reportes Anuales");
        reportesAnuales.setBorder(new javax.swing.border.MatteBorder(null));
        reportesAnuales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportesAnualesActionPerformed(evt);
            }
        });
        getContentPane().add(reportesAnuales, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 200, 30));

        tblDatos.setBorder(new javax.swing.border.MatteBorder(null));
        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblDatos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 640, 260));

        reportesMensuales.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        reportesMensuales.setText("Reportes Mensuales");
        reportesMensuales.setBorder(new javax.swing.border.MatteBorder(null));
        reportesMensuales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportesMensualesActionPerformed(evt);
            }
        });
        getContentPane().add(reportesMensuales, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 200, 30));

        next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/despues_48.png"))); // NOI18N
        next.setBorder(new javax.swing.border.MatteBorder(null));
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });
        getContentPane().add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 420, 50, 40));

        anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/antes_48.png"))); // NOI18N
        anterior.setBorder(new javax.swing.border.MatteBorder(null));
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });
        getContentPane().add(anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 420, 50, 40));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MANTENER.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reportesDiariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportesDiariosActionPerformed
        // TODO add your handling code here:
        consultas.reportesDiarios(tblDatos);
    }//GEN-LAST:event_reportesDiariosActionPerformed

    private void reportesAnualesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportesAnualesActionPerformed
        consultas.reportesAnuales(tblDatos);
        
    }//GEN-LAST:event_reportesAnualesActionPerformed

    private void reportesMensualesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportesMensualesActionPerformed
        consultas.reportesMensuales(tblDatos);
    }//GEN-LAST:event_reportesMensualesActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        // TODO add your handling code here:
        //Boton para moverse hacia el registro anterior en la tabla
        int fila1= tblDatos.getSelectedRow();
        fila1=fila1-1;
        tblDatos.setRowSelectionInterval(fila1, fila1);
    }//GEN-LAST:event_anteriorActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        // TODO add your handling code here:
        //Boton para moverse hacia delante en la tabla
        int fila1= tblDatos.getSelectedRow();
        fila1=fila1+1;
        tblDatos.setRowSelectionInterval(fila1, fila1);
    }//GEN-LAST:event_nextActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anterior;
    private javax.swing.JLabel asistentes;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton next;
    private javax.swing.JButton reportesAnuales;
    private javax.swing.JButton reportesDiarios;
    private javax.swing.JButton reportesMensuales;
    private javax.swing.JTable tblDatos;
    // End of variables declaration//GEN-END:variables
}
