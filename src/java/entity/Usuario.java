/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author labtw04
 */
public class Usuario extends Persona{
    int codigo;
    String nombre;
    String sexo;
    int edad;
    String nombreusuario;
    String contraseña;

    public Usuario() {
        
        
    }

    public Usuario(int codigo, String nombre, String sexo, int edad, String nombreusuario, String contraseña) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public String getContraseña() {
        return contraseña;
    }

   
    
    public String getNombre() {
        return nombre;

    }

    public String getSexo() {
        return sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
  
    


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public static void main(String[] args) {
        Usuario u1 = new Usuario();
        Usuario u2 = new Usuario();
        Usuario u3 = new Usuario();

        ArrayList<Usuario> listas = new ArrayList<>();
        listas.add(u1);
        listas.add(u2);
        listas.add(u3);
        
        
        u1.setCodigo(1);
        u1.setNombre("Juan");
        u1.setEdad(20);
        u1.setSexo("Hombre");
        u1.setNombreusuario("Lopéz");
        u1.setContraseña("reck");
        
        u2.setCodigo(2);
        u2.setNombre("Luis");
        u2.setEdad(21);
        u2.setSexo("Hombre");
        u2.setNombreusuario("lui");
        u2.setContraseña("lex");

        u2.setCodigo(3);
        u3.setNombre("Ana");
        u3.setEdad(18);
        u3.setSexo("Hombre");
        u3.setNombreusuario("anita");
        u3.setContraseña("anis");

        for (int i = 0; i < 3; i++) {
            System.out.println("Codigo: " + listas.get(i).getCodigo());
            System.out.println("Nombre: " + listas.get(i).getNombre());
            System.out.println("Edad: " + listas.get(i).getEdad());
            System.out.println("Sexo: " + listas.get(i).getSexo());
            System.out.println("Nombre usuario: "+ listas.get(i).getNombreusuario());
            System.out.println("Contraseña: "+listas.get(i).getContraseña()+"\n");
            
        }    
    }
}




