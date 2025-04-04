package org.example.models;

public interface Transaccion {
     default void transaccionOk(){
          System.out.println("Transaccion ok.");
     };
     default void transaccionNoOk(){
          System.out.println("Transaccion no ok.");
     };
}
