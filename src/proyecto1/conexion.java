/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class conexion {
        private static Connection Conection;
        private static Statement Sentencia;
        private static ResultSet Resultado;
        String host="localhost";
        String port="5432";
        String db_name="db_institucion";
        String username="postgres";
        String password="jeremias12345";
   
    public static void main(String[] args){} 
        public Connection conexion()        
    {
       Connection connection = null; 
    
        try {
               Class.forName("org.postgresql.Driver");
               connection = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+db_name+"", ""+username+"", ""+password+"");
            if (connection != null) {
                //System.out.println("Connection ok"); 
                Statement stmt = connection.createStatement();
                ResultSet rs;
                //connection.close();
            }
             else {
                    //System.out.println("Connection Failed");
                 } 
            } catch (Exception e) {
                e.printStackTrace();

            }  
            return connection; 
    }
        
        public ArrayList getListaAlumnos() {
        ArrayList mListaAlumnos = new ArrayList();
        alumnos mAlumnos= null;
        Statement consulta;
        ResultSet resultado;
        
       try {
                consulta = this.conexion().createStatement();
                resultado = consulta.executeQuery("SELECT * FROM alumnos");
                      
              while(resultado.next()){
                  mAlumnos = new alumnos(); 
                  mAlumnos.setId_alumno(resultado.getInt(1));
                  mAlumnos.setNombre_alumno(resultado.getString(2));
                  mListaAlumnos.add(mAlumnos);   
                }             
            } catch (SQLException e) {
            }             
    
            return mListaAlumnos;
       }
        

        
        public ArrayList getListaAlumnospormaterias(Integer id) {
        ArrayList mListaAlumnos = new ArrayList();
        alumnos mAlumnos= null;
        Statement consulta;
        ResultSet resultado;
        
       try {
                consulta = this.conexion().createStatement();
                resultado = consulta.executeQuery("SELECT am.id_alumno_materia, a.nombre_alumno, am.id_materia FROM alumnos a, alumnos_materias am, materias m WHERE a.id_alumno = am.id_alumno and am.id_materia = m.id_materia and am.id_materia =  " + id);
                      
              while(resultado.next()){
                  mAlumnos = new alumnos(); 
                  mAlumnos.setId_alumno(resultado.getInt(1));
                  mAlumnos.setNombre_alumno(resultado.getString(2));
                  mListaAlumnos.add(mAlumnos);   
                }             
            } catch (SQLException e) {
            }             
    
            return mListaAlumnos;
       }

    ArrayList getListaMaterias() {
        ArrayList mListaMaterias = new ArrayList();
        materias mMaterias= null;
        Statement consulta;
        ResultSet resultado;
        
       try {
                consulta = this.conexion().createStatement();
                resultado = consulta.executeQuery("SELECT * FROM materias");
                      
              while(resultado.next()){
                  mMaterias = new materias(); 
                  mMaterias.setId_materia(resultado.getInt(1));
                  mMaterias.setNombre_materia(resultado.getString(2));
                  mMaterias.setDia(9);
                  mListaMaterias.add(mMaterias);   
                }             
            } catch (SQLException e) {
            }             
    
            return mListaMaterias;
    }
}
