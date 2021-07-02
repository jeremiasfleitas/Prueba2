/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Juan Fleitas
 */
public class AMB_asistencias extends javax.swing.JFrame {

    conexion cc = new conexion();
    Connection cn = cc.conexion();
    ArrayList mlistaAlumnos;
    ArrayList mlistaMaterias;

    /*conexion mConexion;*/
    /**
     * Creates new form AMB_asistencias
     */
    public AMB_asistencias() {
        initComponents();
        ArrayList mlistaAlumnos = new ArrayList();
        LlenarCBAlumnos();
        LlenarCBMaterias();
        ArrayList mlistaMaterias = new ArrayList();
        Txtfecha.setDate(fechaActual());
        //mostrardatos();
    }
    
    public void LlenarCBAlumnos() {
                cbAlumnos.removeAllItems();
                mlistaAlumnos = cc.getListaAlumnos();
                Iterator Iterador = mlistaAlumnos.iterator();
                
           while(Iterador.hasNext()) {
                alumnos mAlumnos = (alumnos) Iterador.next();
                cbAlumnos.addItem(mAlumnos);   
           }
         AutoCompleteDecorator.decorate(cbAlumnos);       
        }
    
    public void LlenarCBAlumnospormaterias(Integer id) {
                cbAlumnos.removeAllItems();
                mlistaAlumnos = cc.getListaAlumnospormaterias(id);
                Iterator Iterador = mlistaAlumnos.iterator();
                
           while(Iterador.hasNext()) {
                alumnos mAlumnos = (alumnos) Iterador.next();
               // System.out.println("Cargar:" + mAlumnos.getId_materia());
                cbAlumnos.addItem(mAlumnos);   
           }
                
        } 
    
    public void LlenarCBMaterias(){
               cbMaterias.removeAllItems();
               mlistaMaterias = cc.getListaMaterias();
                Iterator Iterador = mlistaMaterias.iterator();
                
           while(Iterador.hasNext()) {
                materias mMaterias = (materias) Iterador.next();
                cbMaterias.addItem(mMaterias); 
           }
         AutoCompleteDecorator.decorate(cbMaterias);
    }  
    
    
    public void buscarmaterias(String materia){
        String sql= "SELECT * FROM materias WHERE nombre_materia= '"+materia+"'"; 
        try {
            Statement ts = cn.createStatement();
            ResultSet rs = ts.executeQuery(sql);
            rs.next();
            //lbid.setText("Código:"+ rs.getInt(1)+ rs.getString(2));
            System.out.println("Código:"+ rs.getInt(1)+ rs.getString(2));
            LlenarCBAlumnospormaterias(rs.getInt(1));
            }
        
        catch(Exception ex){}   
    }
    
    public static Date fechaActual(){
        Date fecha=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date parsed = null;
        return(fecha);
    }
    
    
    public void buscarasistencia(){
        String sql= "SELECT nombre_alumno, presencia_asistencia, fecha_asistencia, nombre_materia FROM alumnos, materias, asistencias"; 
        try {
            Statement ts = cn.createStatement();
            ResultSet rs = ts.executeQuery(sql);
            rs.next();
            System.out.println("Código:"+ rs.getInt(1)+ rs.getString(2) + rs.getString(3));
            }
        catch(Exception ex){}   
    }
       //recibir variable 
    void mostrardatos(){        
        DefaultTableModel modelo = new DefaultTableModel(); 
        modelo.addColumn ("Nombre");
        modelo.addColumn ("Estado");
        modelo.addColumn ("Fecha");
        modelo.addColumn ("Materia");
        
        tablaAsistencia.setModel(modelo);
         alumnos Alumno = (alumnos) cbAlumnos.getSelectedItem();
        String sql = "SELECT a.nombre_alumno, asis.presencia_asistencia, asis.fecha_asistencia, m.nombre_materia   FROM alumnos a, materias m, asistencias asis, alumnos_materias am "
                + "WHERE" + " asis.fecha_asistencia= '"+ Txtfecha.getDate()+"'" 
                + " and am.id_alumno_materia = asis.id_alumno_materia and am.id_alumno = a.id_alumno and m.id_materia = am.id_materia";
     
    String [] datos = new String [4];
    try {
            Statement ts = cn.createStatement();
            ResultSet rs = ts.executeQuery(sql);
            
            while(rs.next()){ 
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                modelo.addRow(datos);
            }
            
         tablaAsistencia.setModel (modelo);
     } catch (SQLException ex) {
         Logger.getLogger(AMB_asistencias.class.getName()).log(Level.SEVERE, null, ex);   
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

        jPanel6 = new javax.swing.JPanel();
        btnbuscar = new javax.swing.JButton();
        txtreporte = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAsistencia = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cbAlumnos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbAsistencia = new javax.swing.JComboBox<>();
        btnguardar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Txtfecha = new com.toedter.calendar.JDateChooser();
        cbMaterias = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnbuscar.setText(" Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(txtreporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btnbuscar)
                .addGap(18, 18, 18))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtreporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablaAsistencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaAsistencia.setToolTipText("");
        tablaAsistencia.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(tablaAsistencia);
        tablaAsistencia.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Materia: ");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cbAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAlumnosActionPerformed(evt);
            }
        });

        jLabel2.setText("  Estado:");

        cbAsistencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Presente", "Ausente", "Virtual" }));
        cbAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAsistenciaActionPerformed(evt);
            }
        });

        btnguardar.setText(" Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        jLabel3.setText("Fecha asistencia");

        cbMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMateriasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnguardar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnguardar)
                    .addComponent(cbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(312, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        materias M = (materias) cbMaterias.getSelectedItem();
        System.out.println(M.getNombre_materia());
        if(M.getNombre_materia().length()>0){ 
          buscarmaterias(M.getNombre_materia());  
          System.out.println(M.getDia());
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        String path = "C:\\Users\\ACER\\Documents\\NetBeansProjects\\proyecto1\\src\\proyecto1\\asistencias.jasper"; //Ponemos la localizacion del reporte creado
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            HashMap map = new HashMap();
            System.out.println();
            
           map.put("Fecha", txtreporte.getDate()); 
            JasperPrint jasperPrint = null;
            Connection connection = null;
            //map.put("p_StuID","MCA001"); 
JasperPrint jprint = JasperFillManager.fillReport(reporte, map, cc.conexion());
            JasperViewer viewer = new JasperViewer(jprint, false); 
            viewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Se declara con dispose_on_close para que no se cierre el programa cuando se cierre el reporte
            viewer.setVisible(true); //Se vizualiza el reporte
        } catch (JRException ex) {  
        }
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        alumnos Alumno= (alumnos) cbAlumnos.getSelectedItem();
        String Fecha= Txtfecha.getDate().toString();
        Date fecha2=null; 
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date parsed = null;
        java.sql.Date data = null;
        /*try {
        parsed = sdf.parse(Txtfecha.getDate().toString());
        data = new java.sql.Date(parsed.getTime()); 
        } catch (ParseException e1) {
        e1.printStackTrace();
     }*/
        data = new java.sql.Date(Txtfecha.getDate().getTime());
        String Presente= cbAsistencia.getSelectedItem().toString();
        Integer id_alumno_materia = Alumno.getId_alumno();   
        try {
            PreparedStatement pst = cn.prepareStatement("INSERT INTO asistencias (id_alumno_materia, fecha_asistencia, presencia_asistencia) VALUES (?,?,?)");
            pst.setInt(1, id_alumno_materia);
            pst.setDate(2, (java.sql.Date) data);
            pst.setString(3, Presente);
            pst.executeUpdate();  
        } catch (SQLException ex) {
            Logger.getLogger(ABM_alumnos.class.getName()).log(Level.SEVERE, null, ex);
        } 
           mostrardatos();      

    }//GEN-LAST:event_btnguardarActionPerformed

    private void cbAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAsistenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAsistenciaActionPerformed

    private void cbAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlumnosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAlumnosActionPerformed

    private void cbMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMateriasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMateriasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AMB_asistencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AMB_asistencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AMB_asistencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AMB_asistencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AMB_asistencias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Txtfecha;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JComboBox<alumnos> cbAlumnos;
    private javax.swing.JComboBox<String> cbAsistencia;
    private javax.swing.JComboBox<materias> cbMaterias;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaAsistencia;
    private com.toedter.calendar.JDateChooser txtreporte;
    // End of variables declaration//GEN-END:variables

}
