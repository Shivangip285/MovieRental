package com.thoughtworks.movierental.statement;

import com.thoughtworks.movierental.Rental;
import com.thoughtworks.movierental.Rentals;

public class HtmlStatement {

    private String name;
    private Rentals rentals;


    public HtmlStatement(String name, Rentals rentals) {
        this.name = name;
        this.rentals = rentals;
    }

    public String statement() {
        return header() + body() + footer();
    }

    public String footer() {
        return "Amount owed is " + "<B>"+rentals.totalAmount() +"</B>"+ "\n" + "You earned " +"<B>"+ rentals.frequentRenterPoints()+"</B>"
                + " frequent renter points";
    }

    public String header() {
        return "<H1>Rental Record for " + "<B>"+name +"</B>"+"</H1>"+ "\n";
    }

    public String body() {
        String result = "";
        for (Rental rental : rentals) {
            result += "\t" + rental.getMovie().getTitle() + "\t" +
                    "<B>"+rental.amount()+"</B>" + "\n";
        }
        return result;
    }
}
