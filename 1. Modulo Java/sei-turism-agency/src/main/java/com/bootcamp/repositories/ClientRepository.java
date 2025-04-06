package com.bootcamp.repositories;

import com.bootcamp.models.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientRepository {
    private static List<Client> clients = new ArrayList<>();

    public static List<Client> getClients() {
        System.out.println("\nShowing clients...");
        return clients;
    }

    public static void addClient(Client client) {
        System.out.println("\nAdding client: " + client);
        clients.add(client);
        System.out.println(getClients());
    }

    public static Client getClientByDni(String dni) {
        System.out.println("\nShowing clients by Dni: " + dni);
        return clients.stream().filter(c -> c.getDni().equals(dni)).findFirst().get();
    }

    public static void removeClientByDni(String dni) {
        System.out.println("\nRemoving client: " + dni);
        clients.removeIf(c -> c.getDni().equals(dni));
        System.out.println(getClients());
    }
}
