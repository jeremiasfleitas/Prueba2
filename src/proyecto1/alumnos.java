/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

/**
 *
 * @author ACER
 */
public class alumnos {
    
    private int id_alumno;
    private String nombre_alumno;


    public alumnos() {
        this.id_alumno = id_alumno;
        this.nombre_alumno = nombre_alumno;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getNombre_alumno() {
        return nombre_alumno;
    }

    public void setNombre_alumno(String nombre_alumno) {
        this.nombre_alumno = nombre_alumno;
    }

    
    @Override
    public String toString(){
       return getNombre_alumno();
    }

}
