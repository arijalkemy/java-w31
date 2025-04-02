package com.bootcamp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Map<String, String>> categories = new HashMap<>();
        Map<Integer, Map<String, String>> participants = new HashMap<>();
        Map<Integer, Map<String, Integer>> registrations = new HashMap<>();

        Map<String, String> small = Map.of("name","Circuit small", "description","2 km por selva y arroyos");
        Map<String, String> medium = Map.of("name","Circuit medium", "description","5 km por selva, arroyos y barro.");
        Map<String, String> advanced = Map.of("name","Circuit advanced", "description","10 km por selva, arroyos, barro y escalada en piedra.");

        Map<String, String> laura = Map.of("dni", "1234567890", "name", "Laura", "lastName", "Bustamante",
                "age", "16", "phoneNum", "3029876578", "emergencyPhoneNum", "9876554323", "bloodType", "O+");
        Map<String, String> juan = Map.of("dni", "1014309954", "name", "Juan David", "lastName", "Montes",
                "age", "25", "phoneNum", "3138197634", "emergencyPhoneNum", "3108708696", "bloodType", "O+");
        Map<String, String> jose = Map.of("dni", "1234566790", "name", "Josefina", "lastName", "Beltran",
                "age", "14", "phoneNum", "3512345632", "emergencyPhoneNum", "3513456723", "bloodType", "AB-");
        Map<String, String> sara = Map.of("dni", "1227867890", "name", "Sara", "lastName", "Salas",
                "age", "15", "phoneNum", "3162386323", "emergencyPhoneNum", "3162346323", "bloodType", "O+");

        // add Circuits
        categories.put(1, small);
        categories.put(2, medium);
        categories.put(3, advanced);

        System.out.println("-------");
        System.out.println("Categories");
        printMap(categories);

        // add participants
        participants.put(1, laura);
        participants.put(2, juan);
        participants.put(3, jose);
        participants.put(4, sara);

        System.out.println("\n-------");
        System.out.println("Participants");
        printMap(participants);

        // create registrations
        System.out.println("\nCreating registrations...\n");
        createRegistrations(participants, registrations);

        System.out.println("\n-------");
        System.out.println("Registrations created:");
        printMap(registrations);

        printPaymentAmountsPerCategory(registrations);

        Scanner inputScan = new Scanner(System.in);
        System.out.println("\n-------");

        System.out.println("Do you want to remove a random participant? (y/n) or hit enter to quit");
        String input = inputScan.nextLine();
        if(input.equalsIgnoreCase("y")) {
            removeRandomParticipant(registrations, participants);
        }
    }

    private static void removeRandomParticipant(Map<Integer, Map<String, Integer>> registrations,
                                                Map<Integer, Map<String, String>> participants) {
        int randParticipant  = (int) (Math.random() * participants.size()) + 1;
        String participant = participants.get(randParticipant).get("name");

        if (registrations.containsKey(randParticipant)) {
            System.out.println("---> Participant " + participant + " removed");

            participants.remove(randParticipant);
            registrations.remove(randParticipant);

            System.out.println("-------");
            System.out.println("Registrations");
            printMap(registrations);
            printPaymentAmountsPerCategory(registrations);
        } else {
            System.out.println("Participant " + participant + " not found on the registration list");
        }
    }

    private static void createRegistrations(Map<Integer, Map<String, String>> participants, Map<Integer, Map<String, Integer>> registrations) {
        for(Map.Entry<Integer, Map<String, String>> item: participants.entrySet()) {
            Integer id = item.getKey();
            Map<String, String> data = item.getValue();

            int category = (int)(Math.random() * 3) + 1;
            int age = Integer.parseInt(data.get("age"));

            calculatePaymentAmountPerRegistration(category, id, age, registrations);
        }
    }

    private static void calculatePaymentAmountPerRegistration(int category, Integer id, int age, Map<Integer, Map<String, Integer>> registrations) {
        Map<String, Integer> registration = new HashMap<>();
        registration.put("category", category);
        registration.put("participant", id);

        switch (category) {
            case 1:
                if(age < 18) {
                    registration.put("payment", 1300);
                } else {
                    registration.put("payment", 1500);
                }
                break;
            case 2:
                if(age < 18) {
                    registration.put("payment", 2000);
                } else {
                    registration.put("payment", 2300);
                }
                break;
            case 3:
                if(age < 18) {
                    registration = new HashMap<>();
                    System.out.println("Only 18+ allowed. Cannot create registration for participant " + id);
                } else {
                    registration.put("payment", 2800);
                }
                break;
            default:
                System.out.println("Not a valid category");
        }

        if (!registration.isEmpty()) {
            registrations.put(id, registration);
        }
    }

    private static <T> void printMap(Map<Integer, Map<String, T>> map) {
        map.forEach((id, insideMap) -> {
            System.out.println("\nNo.: " + id);
            insideMap.forEach((k, v) -> System.out.println(k + ": " + v));
        });
    }

    private static void printPaymentAmountsPerCategory(Map<Integer, Map<String, Integer>> registrations) {
        int paymentSmallCircuit = 0, paymentMediumCircuit = 0, paymentAdvancedCircuit = 0;
        for (Map.Entry<Integer, Map<String, Integer>> item: registrations.entrySet()) {
            Map<String, Integer> data = item.getValue();

            if (data.get("category") == 1) {
                paymentSmallCircuit += data.get("payment");
            } else if (data.get("category") == 2) {
                paymentMediumCircuit += data.get("payment");
            } else if (data.get("category") == 3) {
                paymentAdvancedCircuit += data.get("payment");
            }
        }

        System.out.println("\n-------");
        System.out.println("Payments Category 1: $" + paymentSmallCircuit);
        System.out.println("Payments Category 2: $" + paymentMediumCircuit);
        System.out.println("Payments Category 3: $" + paymentAdvancedCircuit);
        System.out.println("-------");
        System.out.println("Total Payments: $" + (paymentSmallCircuit + paymentMediumCircuit + paymentAdvancedCircuit));
    }
}