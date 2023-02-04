package com.thoughtworks.movierental.statement;

import com.thoughtworks.movierental.Rental;
import com.thoughtworks.movierental.Rentals;

public class TextStatement {
    private String name;
    private Rentals rentals;


    public TextStatement(String name, Rentals rentals) {
        this.name = name;
        this.rentals = rentals;
    }

    public String statement() {
        return header() + body() + footer();
    }

    public String footer() {
        return "Amount owed is " + rentals.totalAmount() + "\n" + "You earned " + rentals.frequentRenterPoints()
                + " frequent renter points";
    }

    public String header() {
        return "Rental Record for " + name + "\n";
    }

    public String body() {
        String result = "";
        for (Rental rental : rentals) {
            result += "\t" + rental.getMovie().getTitle() + "\t" +
                    rental.amount() + "\n";
        }
        return result;
    }
}
