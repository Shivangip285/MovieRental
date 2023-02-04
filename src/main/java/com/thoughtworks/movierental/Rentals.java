package com.thoughtworks.movierental;

import java.util.ArrayList;

public class Rentals extends ArrayList<Rental> {
    public int frequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : this) {
            frequentRenterPoints += rental.frequentRenterPoints();
        }
        return frequentRenterPoints;
    }

    public double totalAmount() {
        double totalAmount = 0;
        for (Rental rental : this) {
            totalAmount += rental.amount();
        }
        return totalAmount;
    }
}
