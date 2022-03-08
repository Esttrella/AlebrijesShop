/*
 Autor: Leonel Alexis García Juárez
 Fecha de creación:07 de Marzo 2022
 Fecha de Actualización: 07 de Marzo de 2022
 Descripción: 
 */

package entity;

public class Persona {
    private String nombre;
    private String sexo;
    int edad;
    
    public Persona() {
    }

    public Persona(String nombre, String sexo, int edad) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
