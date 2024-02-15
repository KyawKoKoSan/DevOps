package com.napier.g7;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest
{
    static App app;

    /**
     * Initializes the test environment before all tests are run.
     * This method creates an instance of the {@link App} class, which is used for testing purposes.
     * The {@link App} class should be properly configured to handle the requirements of the tests.
     */
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


    /**
     * Test case for printing cities when the input list is null.
     */
    @Test
    void printCitiesTestNull() {
        app.printCities(null);
    }

    /**
     * Test case for printing cities when the input list is empty.
     */
    @Test
    void printCitiesTestEmpty() {
        ArrayList<City> cities = new ArrayList<>();
        app.printCities(cities);
    }

    /**
     * Test case for printing cities when the input list contains null elements.
     */
    @Test
    void printCitiesTestContainsNull() {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(null);
        app.printCities(cities);
    }

    /**
     * Test case for printing cities when the input list contains valid city objects.
     */
    @Test
    void printCitiesTest() {
        // Create a list of cities
        ArrayList<City> cities = new ArrayList<>();

        // Create a few city objects
        City city1 = new City();
        city1.setName("Kabul");
        city1.setCountryCode("AFG");
        city1.setDistrict("Kabol");
        city1.setPopulation(1780000); // Population of Paris
        cities.add(city1);

        // Call the method under test
        System.out.println("\n********** Cities Details ********\n");
        app.printCities(cities);
    }

    /**
     * Test case for printing capital cities when the input list is null.
     */
    @Test
    void printCapitalCitiesTestNull() {
        try {
            // Call the method under test with null parameter
            app.printCapitalCities(null);
        } catch (Exception e) {
            fail("Unexpected exception occurred: " + e.getMessage());
        }
    }

    /**
     * Test case for printing capital cities when the input list is empty.
     */
    @Test
    void printCapitalCitiesTestEmpty() {
        try{
            // Create an empty list of capital cities
            ArrayList<Capital> capitals = new ArrayList<>();

            // Call the method under test with empty input list
            app.printCapitalCities(capitals);
        } catch (Exception e) {
            fail("Unexpected exception occurred: " + e.getMessage());
        }
    }

    /**
     * Test case for printing capital cities when the input list contains null elements.
     */
    @Test
    void printCapitalCitiesTestContainsNull() {
        try{
            // Create a list of capital cities containing null elements
            ArrayList<Capital> capitals = new ArrayList<>();
            capitals.add(null);

            // Call the method under test with input list containing null elements
            app.printCapitalCities(capitals);
        } catch (Exception e) {
            fail("Unexpected exception occurred: " + e.getMessage());
        }
    }

    /**
     * Test case for printing capital cities when the input list contains valid capital city objects.
     */
    @Test
    void printCapitalCitiesTest() {
        // Create a list of capital cities
        ArrayList<Capital> capitals = new ArrayList<>();

        // Create a few capital city objects
        Capital capital1 = new Capital();
        capital1.setId(1);
        capital1.setName("Tokyo");
        capital1.setCountryName("Japan");
        capital1.setPopulation(37400000); // Population of Tokyo
        capitals.add(capital1);

        // Call the method under test
        System.out.println("\n********** Capital Cities Details ********\n");
        app.printCapitalCities(capitals);
        assertEquals("Tokyo", capital1.getName(),
                "First country should be 'Tokyo'");
    }

}