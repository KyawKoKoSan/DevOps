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

    /**
     * Test method to verify the behavior of displayTopPopulatedCountriesInContinent
     * when negative input is provided.
     */
    @Test
    void testDisplayTopPopulatedCountriesInContinentNegativeInput() {
        // Define a negative value for testing
        int topN = -5;
        String continent = "Europe"; // Define a continent for testing

        // Call the method under test
        ArrayList<Country> countries = app.displayTopPopulatedCountriesInContinent(topN, continent);

        // Check if the list of countries is empty
        assertTrue(countries.isEmpty(), "List of countries should be empty for negative input");
    }

    /**
     * Test method to verify the behavior of displayTopPopulatedCountriesInContinent
     * when zero input is provided.
     */
    @Test
    void testDisplayTopPopulatedCountriesInContinentZeroInput() {
        // Define a zero value for testing
        int topN = 0;
        String continent = "Europe"; // Define a continent for testing

        // Call the method under test
        ArrayList<Country> countries = app.displayTopPopulatedCountriesInContinent(topN, continent);

        // Check if the list of countries is empty
        assertTrue(countries.isEmpty(), "List of countries should be empty for zero input");
    }

    /**
     * Test method to verify the behavior of displayTopPopulatedCountriesInContinent
     * when a null continent is provided.
     */
    @Test
    void testDisplayTopPopulatedCountriesInContinentNullContinent() {
        // Define a null continent for testing
        int topN = 5;
        String continent = null;

        // Call the method under test
        ArrayList<Country> countries = app.displayTopPopulatedCountriesInContinent(topN, continent);

        // Check if the list of countries is null
        assertNull(countries, "List of countries should be null");

    }


    /**
     * Test method to verify the behavior of displayTopPopulatedCountriesInContinent
     * when an invalid continent is provided.
     */
    @Test
    void testDisplayTopPopulatedCountriesInContinentInvalidContinent() {
        // Define an invalid continent name for testing
        int topN = 5;
        String continent = "InvalidContinent";

        // Call the method under test
        ArrayList<Country> countries = app.displayTopPopulatedCountriesInContinent(topN, continent);

        // Check if the list of countries is empty
        assertTrue(countries.isEmpty(), "List of countries should be empty for invalid continent");
    }

    /**
     * Test method to verify the behavior of displayTopPopulatedCountriesInContinent
     * when correct input is provided.
     */
    @Test
    void testDisplayTopPopulatedCountriesInContinentWithCorrectInput() {
        // Define a positive value for testing
        int topN = 10;
        String continent = "Europe"; // Define a continent for testing

        // Call the method under test
        ArrayList<Country> countries = app.displayTopPopulatedCountriesInContinent(topN, continent);

        // Check if the list of countries is not null
        assertNotNull(countries, "List of countries should not be null");

        // Check if the list of countries is not empty
        assertFalse(countries.isEmpty(), "List of countries should not be empty");

        Country lastCountry = countries.get(countries.size() - 1);
        assertEquals("Netherlands", lastCountry.getName(),
                "Last country should be 'Netherlands'");
    }

    /**
     * Test method to verify the behavior of displayTopPopulatedCountriesInRegion
     * when a negative value is provided for topN.
     */
    @Test
    void testDisplayTopPopulatedCountriesInRegionNegativeInput() {
        // Define a negative value for testing
        int topN = -5;
        String region = "Southeast Asia"; // Define a region for testing

        // Call the method under test
        ArrayList<Country> countries = app.displayTopPopulatedCountriesInRegion(topN, region);

        // Check if the list of countries is empty
        assertTrue(countries.isEmpty(), "List of countries should be empty for negative input");
    }

    /**
     * Test method to verify the behavior of displayTopPopulatedCountriesInRegion
     * when zero is provided for topN.
     */
    @Test
    void testDisplayTopPopulatedCountriesInRegionZeroInput() {
        // Define a zero value for testing
        int topN = 0;
        String region = "Southeast Asia"; // Define a region for testing

        // Call the method under test
        ArrayList<Country> countries = app.displayTopPopulatedCountriesInRegion(topN, region);

        // Check if the list of countries is empty
        assertTrue(countries.isEmpty(), "List of countries should be empty for zero input");
    }

    /**
     * Test method to verify the behavior of displayTopPopulatedCountriesInRegion
     * when a null region is provided.
     */
    @Test
    void testDisplayTopPopulatedCountriesInRegionNullRegion() {
        // Define a null region for testing
        int topN = 5;
        String region = null;

        // Call the method under test
        ArrayList<Country> countries = app.displayTopPopulatedCountriesInRegion(topN, region);

        // Check if the list of countries is null
        assertNull(countries, "List of countries should be null");
    }

    /**
     * Test method to verify the behavior of displayTopPopulatedCountriesInRegion
     * when an invalid region is provided.
     */
    @Test
    void testDisplayTopPopulatedCountriesInRegionInvalidRegion() {
        // Define an invalid region name for testing
        int topN = 5;
        String region = "InvalidRegion";

        // Call the method under test
        ArrayList<Country> countries = app.displayTopPopulatedCountriesInRegion(topN, region);

        // Check if the list of countries is empty
        assertTrue(countries.isEmpty(), "List of countries should be empty for an invalid region");
    }

    /**
     * Test method to verify the behavior of displayTopPopulatedCountriesInRegion
     * when correct input is provided.
     */
    @Test
    void testDisplayTopPopulatedCountriesInRegionWithCorrectInput() {
        // Define a positive value for testing
        int topN = 10;
        String region = "Southeast Asia"; // Define a region for testing

        // Call the method under test
        ArrayList<Country> countries = app.displayTopPopulatedCountriesInRegion(topN, region);

        // Check if the list of countries is not null
        assertNotNull(countries, "List of countries should not be null");

        // Check if the list of countries is not empty
        assertFalse(countries.isEmpty(), "List of countries should not be empty");

        Country lastCountry = countries.get(countries.size() - 1);
        assertEquals("East Timor", lastCountry.getName(),
                "Last country should be 'East Timor'");
    }

    /**
     * Test method to verify the behavior of getAllCities.
     * Retrieves all cities and performs basic validation.
     */
    @Test
    void testGetAllCities() {
        // Call the method under test
        ArrayList<City> cities = app.getAllCities();

        // Check if the list of cities is not null
        assertNotNull(cities, "List of cities should not be null");

        // Check if the list of cities is not empty
        assertFalse(cities.isEmpty(), "List of cities should not be empty");

        City firstCity = cities.get(0);
        assertEquals("Mumbai (Bombay)", firstCity.getName(),
                "Last country should be 'Mumbai (Bombay)'");
    }

    /**
     * Test method to verify the behavior of citiesByContinent when a null continent is provided.
     */
    @Test
    void testCitiesByContinentNull() {
        // Define a null continent for testing
        String continent = null;

        // Call the method under test
        ArrayList<City> cities = app.citiesByContinent(continent);

        // Check if the list of cities is null
        assertNull(cities, "List of cities should be null for null continent input");
    }

    /**
     * Test method to verify the behavior of citiesByContinent when an invalid continent is provided.
     */
    @Test
    void testCitiesByContinentInvalidContinent() {
        // Define an invalid continent name for testing
        String continent = "InvalidContinent";

        // Call the method under test
        ArrayList<City> cities = app.citiesByContinent(continent);

        // Check if the list of cities is empty
        assertTrue(cities.isEmpty(), "List of cities should be empty for an invalid continent");
    }

    /**
     * Test method to verify the behavior of citiesByContinent when correct input is provided.
     */
    @Test
    void testCitiesByContinentWithCorrectInput() {
        // Define a continent for testing
        String continent = "Europe";

        // Call the method under test
        ArrayList<City> cities = app.citiesByContinent(continent);

        // Check if the list of cities is not null
        assertNotNull(cities, "List of cities should not be null for a valid continent");

        // Check if the list of cities is not empty
        assertFalse(cities.isEmpty(), "List of cities should not be empty for a valid continent");

        City firstCity = cities.get(0);
        assertEquals("Moscow", firstCity.getName(),
                "Last country should be 'Moscow'");
    }

    /**
     * Test method to verify the behavior of citiesByRegion when a null region is provided.
     */
    @Test
    void testCitiesByRegionNull() {
        // Define a null region for testing
        String region = null;

        // Call the method under test
        ArrayList<City> cities = app.citiesByRegion(region);

        // Check if the list of cities is null
        assertNull(cities, "List of cities should be null for null region input");
    }

    /**
     * Test method to verify the behavior of citiesByRegion when an invalid region is provided.
     */
    @Test
    void testCitiesByRegionInvalidRegion() {
        // Define an invalid region name for testing
        String region = "InvalidRegion";

        // Call the method under test
        ArrayList<City> cities = app.citiesByRegion(region);

        // Check if the list of cities is empty
        assertTrue(cities.isEmpty(), "List of cities should be empty for an invalid region");
    }

    /**
     * Test method to verify the behavior of citiesByRegion when correct input is provided.
     */
    @Test
    void testCitiesByRegionWithCorrectInput() {
        // Define a region for testing
        String region = "Southeast Asia";

        // Call the method under test
        ArrayList<City> cities = app.citiesByRegion(region);

        // Check if the list of cities is not null
        assertNotNull(cities, "List of cities should not be null for a valid region");

        // Check if the list of cities is not empty
        assertFalse(cities.isEmpty(), "List of cities should not be empty for a valid region");

        City firstCity = cities.get(0);
        assertEquals("Jakarta", firstCity.getName(),
                "Last country should be 'Jakarta'");
    }

}