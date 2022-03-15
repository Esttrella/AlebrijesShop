/*
 Autor: Leonel Alexis García Juárez
 Fecha de creación:07 de Marzo 2022
 Fecha de Actualización: 07 de Marzo de 2022
 Descripción: Ejemplifica el la clase producto
 */
package entity;

import java.util.ArrayList;

public class Producto {

    private String codigo;
    private String nombre;
    private String descripcion;
    private double precio;

    public Producto() {
    }

    public Producto(String codigo, String nombre, String descripcion, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public void getcodigo() {
    }

    ;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public static void main(String[] args) {
        Producto p1 = new Producto();
        Producto p2 = new Producto();
        Producto p3 = new Producto();

        Persona pers1 = new Persona();
        Persona pers2 = new Persona();
        Persona pers3 = new Persona();

        Usuario u1 = new Usuario();
        Usuario u2 = new Usuario();
        Usuario u3 = new Usuario();

        ArrayList<Usuario> listUser = new ArrayList<>();
        ArrayList<Producto> list = new ArrayList<>();

        p1.setCodigo("123");
        p1.setDescripcion("Color Azul");
        p1.setNombre("Camisa");
        p1.setPrecio(100.50);

        p2.setCodigo("456");
        p2.setDescripcion("Color Verde");
        p2.setNombre("Pantalon");
        p2.setPrecio(220.50);

        p3.setCodigo("789");
        p3.setDescripcion("Color Negro");
        p3.setNombre("Gorra");
        p3.setPrecio(50.00);

        u1.setEdad(18);
        u1.setNombre("Juan");
        u1.setSexo("Masculino");
        u1.setCodigo(1);
        u1.setContraseña("1x1");
        u1.setNombreUsuario("user1");

        u2.setEdad(25);
        u2.setNombre("Mariana");
        u2.setSexo("Femenino");
        u2.setCodigo(2);
        u2.setContraseña("2x2");
        u2.setNombreUsuario("user2");

        u3.setEdad(18);
        u3.setNombre("Diana");
        u3.setSexo("Femenino");
        u3.setCodigo(3);
        u3.setContraseña("3x3");
        u3.setNombreUsuario("user3");

        listUser.add(u1);
        listUser.add(u2);
        listUser.add(u3);

        list.add(p1);
        list.add(p2);
        list.add(p3);

        for (int i = 0; i < 3; i++) {
            System.out.println("nombre: " + listUser.get(i).getNombre() + "\n");
            System.out.println("sexo: " + listUser.get(i).getSexo() + "\n");
            System.out.println("edad: " + listUser.get(i).getEdad() + "\n");
            System.out.println("codigo: " + listUser.get(i).getCodigo() + "\n");
            System.out.println("contraseña: " + listUser.get(i).getContraseña() + "\n");
            System.out.println("precio: " + listUser.get(i).getNombreUsuario() + "\n");
            System.out.println("\n\n");
        }

        for (int i = 0; i < 3; i++) {
            System.out.println("codigo: " + list.get(i).getCodigo() + "\n");
            System.out.println("descripcion: " + list.get(i).getDescripcion() + "\n");
            System.out.println("nombre: " + list.get(i).getNombre() + "\n");
            System.out.println("precio: " + list.get(i).getPrecio() + "\n");
            System.out.println("\n\n");
        }
    }

}
