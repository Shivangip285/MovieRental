package com.thoughtworks.movierental;

import com.thoughtworks.movierental.statement.HtmlStatement;
import com.thoughtworks.movierental.statement.TextStatement;

public class Customer {
    private final String name;
    private final Rentals rentals = new Rentals();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String textStatement(){
       return new TextStatement(name, rentals).statement();
    }
    public String htmlStatement(){
        return new HtmlStatement(name, rentals).statement();
    }


}
