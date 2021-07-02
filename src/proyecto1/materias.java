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
class materias {
    int id_materia;
   String nombre_materia;
   int dia;

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public materias() {
        this.id_materia = id_materia;
        this.nombre_materia = nombre_materia;
        this.dia = dia;
    }
   
   
    public materias(int id_materia, String nombre_materia) {
        this.id_materia = id_materia;
        this.nombre_materia = nombre_materia;
    }
    
    /*public materias() {
        this.id_materia = id_materia;
        this.nombre_materia = nombre_materia;
    }*/

    public int getId_materia() {
        return id_materia;
    }

    public String getNombre_materia() {
        return nombre_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    public void setNombre_materia(String nombre_materia) {
        this.nombre_materia = nombre_materia;
    }

    @Override
    public String toString() {
        return getNombre_materia(); 
    }
   
   
   
   
   
   
   
   
}




