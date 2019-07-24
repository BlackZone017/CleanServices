/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gouripc
 */
public class Queries_Usuario {
    DefaultTableModel ModeloTabla; //Objeto para llenar la tabla
    Conexion conn=new Conexion();
    
    Statement ejecutar;
    ResultSet resultado;
    String query;
         
    public boolean validarUsuario(String usuario){
        String registros;     
        query = "SELECT usuario FROM usuario"; //Query que ejecutare
       
        try{
            conn.conexion(); //hago la conexion
            ejecutar = conn.conexion().createStatement(); //creo mi declaracion
            resultado=ejecutar.executeQuery(query);
            
            //bucle para evaluar todos los datos que hay en el campo usuario
            while (resultado.next()){               
                registros = resultado.getString("usuario");
                
                //Condicion que me evalua cada resultado de la consulta, y que si existe al menos un usuario creado
                //me diga que este usuario ya existe
                if(registros.equals(usuario)){
                    return true;
                }
            }
        }catch(Exception w){
            return false;
        }
        return false;
    }
    
    public void buscar(JTable tabla){
        //Columnas a mostrarse en la tabla
        String [] columnas={"ID Usuario","Usuario","Contraseña"};
        String [] registros=new String[3];
        ModeloTabla=new DefaultTableModel(null,columnas);
        
        query = "SELECT * FROM usuario"; //Query que ejecutare
        
        try{
            conn.conexion(); //hago la conexion
            ejecutar = conn.conexion().createStatement(); //creo mi declaracion
            resultado=ejecutar.executeQuery(query); //le paso la query a mi declaracion y le paso los valores al result set
             
            while(resultado.next()){
                registros[0]=resultado.getString("id");
                registros[1]=resultado.getString("nombre");
                registros[2]=resultado.getString("password");
                
                ModeloTabla.addRow(registros);
            }
            
            tabla.setModel(ModeloTabla);
            
            //Force para no mostrar la columna de contraseña
            tabla.getColumnModel().getColumn(2).setMaxWidth(0);
            tabla.getColumnModel().getColumn(2).setMinWidth(0);
            tabla.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(0);
            tabla.getTableHeader().getColumnModel().getColumn(2).setMinWidth(0);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error en la tabla SQL: "+e);
        }

    }
    
    public boolean eliminar(String codigo){
        conn.conexion();
        try{
            //Elimina el registro a traves del usuario
            PreparedStatement pstm = conn.conexion().prepareStatement("DELETE FROM usuario WHERE nombre=?");
            pstm.setString(1, codigo);
            pstm.execute();
            pstm.close();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"El error es: "+e);
            return false;
        }
    }
    
    public boolean modificar(String codigo, String nombre, String contra){
        conn.conexion();
        try{
            conn.conexion();
            Statement query = conn.conexion().createStatement();
            query.execute("update usuario set nombre = '"+nombre+"', password='"+contra+"' where id="+codigo);
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"El error es: "+e);
            return false;
        }
    }

    public void buscarPor(String valor,String cbo, JTable tabla){
        String [] columnas={"ID Usuario","Usuario","Contraseña"};
        String [] registros=new String[3];
        ModeloTabla=new DefaultTableModel(null,columnas);
        
        query = "SELECT * FROM usuario WHERE "+cbo+" LIKE '"+valor+"%';"; //Query que ejecutare
        
        try{
            conn.conexion(); //hago la conexion
            ejecutar = conn.conexion().createStatement(); //creo mi declaracion
            resultado=ejecutar.executeQuery(query); //le paso la query a mi declaracion y le paso los valores al result set
            
            while(resultado.next()){
                registros[0]=resultado.getString("id");
                registros[1]=resultado.getString("nombre");
                registros[2]=resultado.getString("password");
                
                ModeloTabla.addRow(registros);
            }
            
            tabla.setModel(ModeloTabla);
            
            //Force para no mostrar la columna de contraseña
            tabla.getColumnModel().getColumn(2).setMaxWidth(0);
            tabla.getColumnModel().getColumn(2).setMinWidth(0);
            tabla.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(0);
            tabla.getTableHeader().getColumnModel().getColumn(2).setMinWidth(0);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error en la tabla SQL: "+e);
        }      
    }
}
