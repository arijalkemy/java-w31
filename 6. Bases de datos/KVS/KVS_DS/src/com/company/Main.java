package com.company;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        KVSClient kvs = new KVSClient();

        User user = new User("1", "Miguel", "Bustos", "M", LocalDate.of(1994,05,02),"ARGENTINA");

        kvs.create(user);
        System.out.println("Usuario creado: " + kvs.read("1"));

        user.setFirstName("José Perez");
        kvs.update(user);
        System.out.println("Usuario actualizado: " + kvs.read("1"));

        kvs.delete("1");
        System.out.println("Usuario eliminado: " + kvs.read("1")); // null

        // Disparar rate limit
        /*for (int i = 0; i < 10; i++) {
            kvs.read("1");
        }*/


        //EJERCICIO 2

        UserDocumentStore ds = new UserDocumentStore();

        // Crear usuarios
        User u1 = new User("1", "Juan", "Pérez", "M", LocalDate.of(1990, 5, 20), "Argentina");
        User u2 = new User("2", "Ana", "García", "F", LocalDate.of(1985, 10, 15), "Chile");
        User u3 = new User("3", "Luis", "Martínez", "M", LocalDate.of(1992, 1, 5), "Argentina");

        // Indexar en DS
        ds.index(u1);
        ds.index(u2);
        ds.index(u3);

        // Buscar usuarios por país
        List<User> argentinos = ds.findUsersByPais("Argentina");
        System.out.println("Usuarios de Argentina:");
        argentinos.forEach(System.out::println);
    }
}
