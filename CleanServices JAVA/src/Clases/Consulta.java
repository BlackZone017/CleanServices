/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author gouripc
 */
public class Consulta {
    
    //Clases para ejecutar la Conexion a la BD
    Conexion con=new Conexion();  
    Connection conect;
    Statement st; 
    ResultSet rs=null;
    String query;
    //--------Fin Clases--------\\
    
    
    public void conectar(){
        // Implementacion Metodos de la Conexion
        try{
            conect= con.conexion();
            st=conect.createStatement();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error SQL "+ex);
        }
    }
    
    public boolean verificar(String usuario, String contra){
        
        int retorno=0;
        query="SELECT nombre,password FROM usuario WHERE nombre='"+usuario
                +"' AND password='"+contra+"'";
        
        try{
            conect=con.conexion();
            st=conect.createStatement();
            rs=st.executeQuery(query);
            while(rs.next()){
                if(rs.getString(1)==null){
                    retorno=0;
                }else{
                    retorno=1;
                }
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error: "+ex);
        }
        
        if(retorno==1){return true;}
        return false;
    }
}
