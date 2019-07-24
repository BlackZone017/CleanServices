/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cleanservices;

import Clases.Conexion;
import Clases.Queries_Usuario;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author olive
 */
public class formUsuario extends javax.swing.JInternalFrame {

    Conexion conn = new Conexion();
    Queries_Usuario consultas = new Queries_Usuario();
    /**
     * Creates new form formUsuario
     */
    public formUsuario() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usuarios = new javax.swing.JLabel();
        usuario = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        Guardar = new javax.swing.JButton();
        Limpiar = new javax.swing.JButton();
        registro = new javax.swing.JButton();
        buscarPor = new javax.swing.JLabel();
        buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        anterior = new javax.swing.JButton();
        next = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        modify = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        txtBuscarPor = new javax.swing.JTextField();
        box_BuscarPor = new javax.swing.JComboBox<>();
        txtPassword = new javax.swing.JPasswordField();
        fondo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usuarios.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        usuarios.setForeground(new java.awt.Color(255, 255, 255));
        usuarios.setText("MANTENIMIENTO DE USUARIOS");
        getContentPane().add(usuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 470, 40));

        usuario.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        usuario.setForeground(new java.awt.Color(255, 255, 255));
        usuario.setText("Usuario");
        getContentPane().add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, 30));

        password.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setText("Contraseña");
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, 30));

        Guardar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Guardar.setText("Insertar");
        Guardar.setBorder(new javax.swing.border.MatteBorder(null));
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });
        getContentPane().add(Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 130, 30));

        Limpiar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Limpiar.setText("Limpiar");
        Limpiar.setBorder(new javax.swing.border.MatteBorder(null));
        Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(Limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 130, 30));

        registro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        registro.setText("Buscar Todo");
        registro.setBorder(new javax.swing.border.MatteBorder(null));
        registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroActionPerformed(evt);
            }
        });
        getContentPane().add(registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 120, 30));

        buscarPor.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        buscarPor.setForeground(new java.awt.Color(255, 255, 255));
        buscarPor.setText("Buscar por:");
        getContentPane().add(buscarPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 120, 30));

        buscar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cleanservices/buzca_32.png"))); // NOI18N
        buscar.setBorder(new javax.swing.border.MatteBorder(null));
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        getContentPane().add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, 40, 30));

        tblDatos.setBorder(new javax.swing.border.MatteBorder(null));
        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblDatos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 510, 170));

        anterior.setBackground(new java.awt.Color(255, 255, 255));
        anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/antes_48.png"))); // NOI18N
        anterior.setBorder(new javax.swing.border.MatteBorder(null));
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });
        getContentPane().add(anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, 50, 40));

        next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/despues_48.png"))); // NOI18N
        next.setBorder(new javax.swing.border.MatteBorder(null));
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });
        getContentPane().add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 490, 50, 40));

        borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/remove_48.png"))); // NOI18N
        borrar.setBorder(new javax.swing.border.MatteBorder(null));
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });
        getContentPane().add(borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 490, 50, 40));

        modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit_48.png"))); // NOI18N
        modificar.setBorder(new javax.swing.border.MatteBorder(null));
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        getContentPane().add(modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 490, 50, 40));

        modify.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/guardar_48.png"))); // NOI18N
        modify.setBorder(new javax.swing.border.MatteBorder(null));
        modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyActionPerformed(evt);
            }
        });
        getContentPane().add(modify, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 490, 50, 40));
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 300, 30));
        getContentPane().add(txtBuscarPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 110, 30));

        box_BuscarPor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        box_BuscarPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar:", "Nombre", "Apellido", "Usuario", "perfil_usuario" }));
        getContentPane().add(box_BuscarPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 120, 30));
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 300, 30));

        fondo.setBackground(new java.awt.Color(255, 51, 0));
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MANTENER.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        //Boton que hace el filtro de los usuarios, el cual confirma si se ha escrito un criterio de busqueda
        int fila=0;
        if(box_BuscarPor.getSelectedItem().toString().equals("Seleccionar:")){
            JOptionPane.showMessageDialog(rootPane, "Selecciona un criterio de busqueda!");
        }else{
            consultas.buscarPor(txtBuscarPor.getText(),box_BuscarPor.getSelectedItem().toString(), tblDatos);
            fila=tblDatos.getRowCount();
            if(fila==0){
                JOptionPane.showMessageDialog(rootPane, "No existe registro con la descripcion deseada");
            }
        }
        
    }//GEN-LAST:event_buscarActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        // TODO add your handling code here:
        //Boton para moverse hacia delante en la tabla
        int fila1= tblDatos.getSelectedRow();
        fila1=fila1+1;
        tblDatos.setRowSelectionInterval(fila1, fila1);
    }//GEN-LAST:event_nextActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
            //Boton para insertar un nuevo registro a la tabla, luego de haberse llenado los campos
            //Llama el metodo validarUsiario() para verificar si este no existe
            if(consultas.validarUsuario(txtUsuario.getText())){
                String msg="El usuario que trata de insertar ya existe";
                JOptionPane.showMessageDialog(null,"Error: "+msg);
            }else{
                //Llama el metodo guardar para hacer la conexion
                guardar();
                JOptionPane.showMessageDialog(rootPane, "Datos Guardados");
                consultas.buscar(tblDatos);   
            }
    }//GEN-LAST:event_GuardarActionPerformed

    private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarActionPerformed
        // Metodo para limpiar los textbox's
        txtUsuario.setText(null);
        txtPassword.setText(null);  
    }//GEN-LAST:event_LimpiarActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        // TODO add your handling code here:
        //Boton para moverse hacia el registro anterior en la tabla
        int fila1= tblDatos.getSelectedRow();
        fila1=fila1-1;
        tblDatos.setRowSelectionInterval(fila1, fila1);
    }//GEN-LAST:event_anteriorActionPerformed

    private void modifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyActionPerformed
            //Boton para hacer la confirmacion de los datos modificados y a la vez los inserta en la tabla
            int FilaSelec =  tblDatos.getSelectedRow();
            String codigo = String.valueOf(tblDatos.getValueAt(FilaSelec, 0));//toma el id que esta en la posicion 0
            consultas.modificar(codigo,txtUsuario.getText(),txtPassword.getText());
        
            JOptionPane.showMessageDialog(rootPane, "Datos Modificados");
        //Cuando modifica los datos, los campos se limpian
            txtUsuario.setText(null);
            txtPassword.setText(null);
            tblDatos.setSelectionMode(FilaSelec);
            consultas.buscar(tblDatos);
             
    }//GEN-LAST:event_modifyActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed

        //Metodo para eliminar los registros seleccionados de la tabla [tblDatos]
        int resp=JOptionPane.showConfirmDialog(this,"¿Desea Eliminar este Registro?","Eliminar",JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        if(resp==0){
            //Si la respuesta es "Si", este procede a eliminar dicho registro
            int fila = tblDatos.getSelectedRow();
            if (fila >= 0){
                String codigo = String.valueOf(tblDatos.getValueAt(fila, 1));
                consultas.eliminar(codigo);
                JOptionPane.showMessageDialog(rootPane, "Registro Eliminado");
                consultas.buscar(tblDatos);
            }
        }
        
    }//GEN-LAST:event_borrarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        // Este selecciona la fila deseada para modificar y a su vez, pone los valores del registro en su respectivo campo
        
        int FilaSelec =  tblDatos.getSelectedRow();
        if (FilaSelec>=0){
            txtUsuario.setText(tblDatos.getValueAt(FilaSelec, 1).toString());
            txtPassword.setText(tblDatos.getValueAt(FilaSelec, 2).toString());        
        }else{
            JOptionPane.showMessageDialog(this,"Fila NO Seleccionada","Row Defaul Error",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_modificarActionPerformed

    private void registroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroActionPerformed
        // Muestra todos los campos de la tabla
        consultas.buscar(tblDatos);
    }//GEN-LAST:event_registroActionPerformed

    //Metodo que sirve para guardar los datos
    private boolean guardar(){
        //trato de acceder a la BD para luego hacer una query de insert
        try{
            conn.conexion();
            Statement query = conn.conexion().createStatement();
            
            String usuario = this.txtUsuario.getText();
            String contra = this.txtPassword.getText();
            //ESTABLECE QUE SI NADA SE SELECCIONA EN EL BOX ..Nos dara el mensaje de que debemos llenarlo
            
                //Inserta los valores a la tabla
                query.execute("INSERT INTO usuario VALUES('"+usuario+"','"+contra+"');");
            
            return true;
                                
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane,"El error es: "+e);
            //System.out.println(e);
            return false;
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Guardar;
    private javax.swing.JButton Limpiar;
    private javax.swing.JButton anterior;
    private javax.swing.JButton borrar;
    private javax.swing.JComboBox<String> box_BuscarPor;
    private javax.swing.JButton buscar;
    private javax.swing.JLabel buscarPor;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificar;
    private javax.swing.JButton modify;
    private javax.swing.JButton next;
    private javax.swing.JLabel password;
    private javax.swing.JButton registro;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtBuscarPor;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JLabel usuario;
    private javax.swing.JLabel usuarios;
    // End of variables declaration//GEN-END:variables
}