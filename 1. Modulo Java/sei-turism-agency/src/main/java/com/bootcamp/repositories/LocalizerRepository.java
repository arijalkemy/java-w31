package com.bootcamp.repositories;

import com.bootcamp.models.Localizer;

import java.util.ArrayList;
import java.util.List;

public class LocalizerRepository {

    private static List<Localizer> localizers = new ArrayList<>();

    public static List<Localizer> getLocalizers() {
        System.out.println("\nShowing localizers...");
        return localizers;
    }

    public static void addLocalizer(Localizer localizer) {
        System.out.println("\nAdding localizer with id: " + localizer.getId());
        localizers.add(localizer);
        System.out.println(getLocalizers());
    }

    public static Localizer getLocalizerById(String id) {
        System.out.println("\nShowing localizer by id: " + id);
        return localizers.stream().filter(l -> l.getId().equals(id)).findFirst().get();
    }

    public static List<Localizer> getLocalizersByClientDni(String dni) {
        System.out.println("\nShowing localizers by Client Dni: " + dni);
        return localizers.stream().filter(l -> l.getClient().getDni().equals(dni)).toList();
    }

    public static Integer getLocalizerCount() {
        System.out.println("\nShowing localizers count...");
        return localizers.size();
    }

    public static Integer getBookingsCount() {
        System.out.println("\nShowing localizers bookings count...");
        return localizers.stream().mapToInt(l -> l.getBookings().size()).sum();
    }

    public static Double getTotalSalesAmount() {
        System.out.println("\nShowing localizers total sales amount...");
        return localizers.stream().mapToDouble(Localizer::getTotalPrice).sum();
    }

    public static Double getTotalSalesAverageAmount() {
        System.out.println("\nShowing localizers total sales average amount...");
        return localizers.stream().mapToDouble(Localizer::getTotalPrice).average().getAsDouble();
    }

    public static void removeLocalizerById(Integer localizerId) {
        System.out.println("\nRemoving localizer: " + localizerId);
        localizers.removeIf(l -> l.getId().equals(localizerId));
        System.out.println(getLocalizers());
    }

    public static void removeLocalizerByClientDni(String dni) {
        System.out.println("\nRemoving localizer by client Dni: " + dni);
        localizers.removeIf(l -> l.getClient().getDni().equals(dni));
        System.out.println(getLocalizers());
    }
}
