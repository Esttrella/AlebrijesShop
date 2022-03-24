/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;


public class Producto {

    int codigo;
    String nombre;
    String descripcion;
    double precio;

    public Producto() {
    }

    public Producto(int codigo, String nombre, String descripcion, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public static void main(String[] args) {

        Producto p = new Producto();
        Producto p1 = new Producto();
        Producto p2 = new Producto();

        ArrayList<Producto> listas = new ArrayList<>();
        listas.add(p);
        listas.add(p1);
        listas.add(p2);

        p.setCodigo(1);
        p.setNombre("Alebrijes");
        p.setDescripcion("Producto echa de madera");
        p.setPrecio(50.50);

        p1.setCodigo(2);
        p1.setNombre("Comales");
        p1.setDescripcion("Producto echa de barro");
        p1.setPrecio(80.50);

        p2.setCodigo(3);
        p2.setNombre("Ropa");
        p2.setDescripcion("Producto echa de lana");
        p2.setPrecio(150.50);

        for (int i = 0; i < 3; i++) {
            System.out.println("Codigo: " + listas.get(i).getCodigo());
            System.out.println("Nombre: " + listas.get(i).getNombre());
            System.out.println("Descripcion: " + listas.get(i).getDescripcion());
            System.out.println("Presio: " + listas.get(i).getPrecio() + "\n");
        }
        
        
        

    }
}
