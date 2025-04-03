package main.java;

public class Distribuidora {
    // punto 4 del ejercicio 2
/*Crear una clase ejecutable llamada Distribuidora
 donde van a crear un array de productos, imprimir
  el precio total al vender 5 productos de cada
  tipo. Crear los elementos del array con los
  datos que quieras.
 */

        public static void main(String []args){
            Producto[] productosVarios = new Producto[4];
            productosVarios[0] = new Perecedero("Leche",2100.0,3);
            productosVarios[1]= new Perecedero("yogurt",1800.0,7);
            productosVarios[2]= new NoPerecedero("arroz",1200.0,"paquete");
            productosVarios[3]= new NoPerecedero("Arvejas",800.0,"lata");

            double precioTotal = 0.0;
            for (Producto producto:productosVarios){
                precioTotal+= producto.calcular(5);
            }
            System.out.println("El total de la venta de los 5 productos de cada tipo es:"+ precioTotal);
        }
    }

