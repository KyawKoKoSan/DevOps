package com.napier.g7;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);

    }

    /**
     * Test method for {@link App#getAllCountries()}.
     */
    @Test
    void testGetAllCountries() {
        // Call the method under test
        ArrayList<Country> countries = app.getAllCountries();

        // Check if the list of countries is not null
        assertNotNull(countries, "List of countries should not be null");

        // Check if the list of countries is not empty
        assertFalse(countries.isEmpty(), "List of countries should not be empty");

        Country lastCountry = countries.get(countries.size() - 1);
        assertEquals("United States Minor Outlying Islands", lastCountry.getName(),
                "Last country should be 'United States Minor Outlying Islands'");
    }

    /**
     * Test case for retrieving countries by continent when the continent input is null.
     */
    @Test
    void testCountriesByContinentNull() {
        // Define a continent for testing
        String continent = null;

        // Call the method under test
        ArrayList<Country> countries = app.countriesByContinent(continent);

        // Check if the list of countries is null
        assertNull(countries, "List of countries should be null");
    }


    /**
     * Test case for retrieving countries by continent when the continent input is invalid.
     */
    @Test
    void testCountriesByContinentEmpty() {
        // Define a continent for testing
        String continent = "InvalidContinent";

        // Call the method under test
        ArrayList<Country> countries = app.countriesByContinent(continent);

        // Check if the list of countries is empty
        assertTrue(countries.isEmpty(), "List of countries should be empty");
    }

    /**
     * Test case for retrieving countries by continent with correct input.
     */
    @Test
    void testCountriesByContinentWithCorrectInput() {
        // Define a continent for testing
        String continent = "Europe";

        // Call the method under test
        ArrayList<Country> countries = app.countriesByContinent(continent);

        // Check if the list of countries is not null
        assertNotNull(countries, "List of countries should not be null");

        // Check if the list of countries is not empty
        assertFalse(countries.isEmpty(), "List of countries should not be empty");

        Country FirstCountry = countries.get(0);
        assertEquals("Russian Federation", FirstCountry.getName(),
                "Last country should be 'Russian Federation'");

    }

    /**
     * Test case for retrieving countries by region when the region input is null.
     */
    @Test
    void testCountriesByRegionNull() {
        // Define a region for testing
        String region = null;

        // Call the method under test
        ArrayList<Country> countries = app.countriesByRegion(region);

        // Check if the list of countries is null
        assertNull(countries, "List of countries should be null");
    }

    /**
     * Test case for retrieving countries by region when the region input is invalid.
     */
    @Test
    void testCountriesByRegionEmpty() {
        // Define a region for testing
        String region = "InvalidRegion";

        // Call the method under test
        ArrayList<Country> countries = app.countriesByRegion(region);

        // Check if the list of countries is empty
        assertTrue(countries.isEmpty(), "List of countries should be empty");
    }

    /**
     * Test case for retrieving countries by region with correct input.
     */
    @Test
    void testCountriesByRegionWithCorrectInput() {
        // Define a region for testing
        String region = "Southeast Asia";

        // Call the method under test
        ArrayList<Country> countries = app.countriesByRegion(region);

        // Check if the list of countries is not null
        assertNotNull(countries, "List of countries should not be null");

        // Check if the list of countries is not empty
        assertFalse(countries.isEmpty(), "List of countries should not be empty");

        Country lastCountry = countries.get(countries.size() - 1);
        assertEquals("Brunei", lastCountry.getName(),
                "Last country should be 'Brunei'");
    }

    /**
     * Test case for displaying top populated countries when the input is negative.
     */
    @Test
    void testDisplayTopPopulatedCountriesNegativeInput() {
        // Define a negative value for testing
        int topN = -5;

        // Call the method under test
        ArrayList<Country> countries = app.displayTopPopulatedCountries(topN);

        // Check if the list of countries is empty
        assertTrue(countries.isEmpty(), "List of countries should be empty for negative input");
    }

    /**
     * Test case for displaying top populated countries when the input is zero.
     */
    @Test
    void testDisplayTopPopulatedCountriesZeroInput() {
        // Define a zero value for testing
        int topN = 0;

        // Call the method under test
        ArrayList<Country> countries = app.displayTopPopulatedCountries(topN);

        // Check if the list of countries is empty
        assertTrue(countries.isEmpty(), "List of countries should be empty for zero input");
    }

    /**
     * Test case for displaying top populated countries with correct input.
     */
    @Test
    void testDisplayTopPopulatedCountriesWithCorrectInput() {
        // Define a positive value for testing
        int topN = 10;

        // Call the method under test
        ArrayList<Country> countries = app.displayTopPopulatedCountries(topN);

        // Check if the list of countries is not null
        assertNotNull(countries, "List of countries should not be null");

        // Check if the list of countries is not empty
        assertFalse(countries.isEmpty(), "List of countries should not be empty");

        Country lastCountry = countries.get(countries.size() - 1);
        assertEquals("Nigeria", lastCountry.getName(),
                "Last country should be 'Nigeria '");
    }
}