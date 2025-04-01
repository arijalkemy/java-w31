package com.mercadolibre;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main (String[]args){
        Vehiculo v = new Vehiculo("Fiesta", "Ford", 1000.0);
        Vehiculo v2 =new Vehiculo("Focus", "Ford", 1200.0);
        Vehiculo v3 =new Vehiculo("Explorer", "Ford", 2500.0);
        Vehiculo v4 =new Vehiculo("Uno", "Fiat", 500.0);
        Vehiculo v5 =new Vehiculo("Cronos", "Fiat", 1000.0);
        Vehiculo v6 =new Vehiculo("Torino", "Fiat", 1250.0);
        Vehiculo v7 =new Vehiculo("Aveo", "Chevrolet", 1250.0);
        Vehiculo v8 =new Vehiculo("Spin", "Chevrolet", 2500.0);
        Vehiculo v9 =new Vehiculo("Corolla", "Toyota", 1200.0);
        Vehiculo v10 =new Vehiculo("Fortuner", "Toyota", 3000.0);
        Vehiculo v11 =new Vehiculo("Logan", "Renault", 950.0);

        LinkedList<Vehiculo> vehiculos = new LinkedList<>(List.of(v, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11));

        Garaje g = new Garaje(1, vehiculos);
        System.out.println("*--------------------Orden por precio-------------------------*");
        g.ordenarPorPrecioDeMenorAMayor();
        System.out.println("*----------------Orden por marca y precio---------------------*");
        g.ordenarPorMarcaYPrecioMenorAMayor();
        System.out.println("*-----------------Filtro menor a mil--------------------------*");
        g.filtrarPorPrecioMenorAMil();
        System.out.println("*-------------Filtro mayor o igual a mil----------------------*");
        g.filtrarPorPrecioMayorOIgualAMil();
        System.out.println("*-------------Obtener promedio total----------------------*");
        System.out.println("Promedio: " + g.obtenerPromedioTotalDePrecios());


    }
}
