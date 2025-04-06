package com.bootcamp.models;

import java.util.List;
import java.util.stream.Collectors;

public class Localizer {
    private Integer id;
    private List<Booking> bookings;
    private Client client;
    private Double totalPrice = 0.0;
    private static int counterIds = 0;

    public Localizer(List<Booking> bookings, Client client) {
        System.out.println("\nLocalizer created");
        counterIds += 1;
        this.id = counterIds;
        this.bookings = bookings;
        this.client = client;
        client.addLocalizerId(id);
        calculateTotalPrice();
        System.out.println(this);
    }

    public Integer getId() {
        return id;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public Client getClient() {
        return client;
    }

    public Double getTotalPrice() { return totalPrice; }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
        calculateTotalPrice();
    }

    public void addBooking(Booking booking) {
        this.bookings.add(booking);
        calculateTotalPrice();
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void calculateTotalPrice() {
        Double discount = getClient().getDiscount();

        // Check for complete package bookings and update discount if applicable
        if (isCompletePackageBooking()) {
            discount = 0.1;
            System.out.println("\nApplying 10% discount as this is a complete package booking");
        }

        // Process each booking to apply booking disccount if applicable
        for (Booking booking : bookings) {
            totalPrice += applyBookingDiscounts(booking);
        }

        if (discount > 0.0) {
            totalPrice -= totalPrice * discount;
            System.out.println("\n----------------\nTotal price after discounts: $" + totalPrice);
        }else {
            System.out.println("\n----------------\nTotal price: $" + totalPrice);
        }
    }

    private boolean isCompletePackageBooking() {
        List<Class> completePackageBookings = List.of(Hotel.class, Food.class, Travel.class, Transportation.class);
        return bookings.size() == completePackageBookings.size() &&
                bookings.stream().map(Booking::getClass).collect(Collectors.toSet()).containsAll(completePackageBookings);
    }

    private Double applyBookingDiscounts(Booking booking) {
        double price = booking.getPrice();

        // Apply discount for Hotel bookings
        if (booking.getClass().equals(Hotel.class) && getBookingCount(Hotel.class) == 2) {
            price -= price * 0.05;
            System.out.println("\nApplying 5% discount to the hotel booking: $" + price);
        }

        // Apply discount for Travel bookings
        if (booking.getClass().equals(Travel.class) && getBookingCount(Travel.class) == 2) {
            price -= price * 0.05;
            System.out.println("\nApplying 5% discount to the travel booking: $" + price);
        }

        return price;
    }

    // Count the number of bookings for a specific class type
    private long getBookingCount(Class<?> bookingClass) {
        return bookings.stream().filter(booking -> booking.getClass().equals(bookingClass)).count();
    }

    @Override
    public String toString() {
        return "\nLocalizer:" +
                "\nid= " + id +
                "\nbookings= " + bookings +
                "\nclient= " + client +
                "\ntotal Price= " + totalPrice;
    }
}
