package com.napier.g7;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    /**
     * Test case for printing countries when the input list is null.
     */
    @Test
    void printCountriesTestNull()
    {
        app.printCountries(null);
    }

    /**
     * Test case for printing countries when the input list is empty.
     */
    @Test
    void printCountriesTestEmpty()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountries(countries);
    }

    /**
     * Test case for printing countries when the input list contains null elements.
     */
    @Test
    void printCountriesTestContainsNull()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(null);
        app.printCountries(countries);
    }

    /**
     * Test case for printing countries when the input list contains valid country objects.
     */
    @Test
    void printCountriesTest() {
        // Create a list of countries
        ArrayList<Country> countries = new ArrayList<>();

        // Create a few country objects
        Country country1 = new Country();
        country1.setCode("USA");
        country1.setName("United States");
        country1.setContinent("North America");
        country1.setRegion("North America");
        country1.setPopulation(331449281); // Population of the USA
        country1.setCapitalName("Washington D.C.");
        countries.add(country1);

        // Call the method under test
        System.out.println("\n********** Countries Details ********\n");
        app.printCountries(countries);
    }

}