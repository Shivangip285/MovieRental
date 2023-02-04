package com.thoughtworks.movierental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    @Test
    public void shouldGenerateTextStatementWithoutRental() {
        Customer customer=new Customer("Cust1");

        String actualStatement = customer.textStatement();
        String expectedStatement="Rental Record for Cust1\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points";

        assertEquals(actualStatement,expectedStatement);
    }
    @Test
    public void shouldGenerateTextStatementWithRental() {
        Customer customer=new Customer("Cust1");
        Rental rental=new Rental(new Movie("movie",Movie.CHILDRENS),5);

        customer.addRental(rental);
        String actualStatement = customer.textStatement();
        String expectedStatement="Rental Record for Cust1\n" +
                "\tmovie\t4.5\n" +
                "Amount owed is 4.5\n" +
                "You earned 1 frequent renter points";

        assertEquals(actualStatement,expectedStatement);
    }
    @Test
    public void shouldGenerateHtmlStatement() {
        Customer customer = new Customer("ABC");
        customer.addRental(new Rental(new Movie("Movie-1", Movie.REGULAR), 4));
        customer.addRental(new Rental(new Movie("Movie-2", Movie.CHILDRENS), 5));
        customer.addRental(new Rental(new Movie("Movie-2", Movie.NEW_RELEASE), 3));

        assertEquals("<H1>Rental Record for <B>ABC</B></H1>\n" +
                "\tMovie-1\t<B>5.0</B>\n" +
                "\tMovie-2\t<B>4.5</B>\n" +
                "\tMovie-2\t<B>9.0</B>\n" +
                "Amount owed is <B>18.5</B>\n" +
                "You earned <B>4</B> frequent renter points", customer.htmlStatement());
    }
    @Test
    public void shouldGenerateTextStatement() {
        Customer customer = new Customer("ABC");
        customer.addRental(new Rental(new Movie("Movie-1", Movie.REGULAR), 4));
        customer.addRental(new Rental(new Movie("Movie-2", Movie.CHILDRENS), 5));
        customer.addRental(new Rental(new Movie("Movie-2", Movie.NEW_RELEASE), 3));

        assertEquals("Rental Record for ABC\n" +
                "\tMovie-1\t5.0\n" +
                "\tMovie-2\t4.5\n" +
                "\tMovie-2\t9.0\n" +
                "Amount owed is 18.5\n" +
                "You earned 4 frequent renter points", customer.textStatement());
    }

}