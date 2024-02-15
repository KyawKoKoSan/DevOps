package com.napier.g7;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class AppIntegrationTest
{
    static App app;

    /**
     * Initializes the test environment before all tests are run.
     * This method creates an instance of the {@link App} class and establishes a connection to the MySQL database
     * running on localhost at port 33060, with a timeout of 30 seconds.
     * The {@link App} class should be properly configured to handle the connection to the MySQL database.
     */
    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);

    }

    // Stores the original System.out
    private final PrintStream standardOut = System.out;

    // Used to capture the output from System.out
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    /**
     * Restores the standard output stream after each test method.
     * This method is annotated with {@code @AfterEach} and is executed after each test method.
     * It sets the standard output stream back to its original value, ensuring that the output
     * produced during the test method execution is directed to the standard output as usual.
     */
    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
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

    /**
     * Test case for citiesByCountry method when country is null.
     * Verifies that the method returns a null list of cities when a null country is provided.
     */
    @Test
    void testCitiesByCountryNull() {
        // Define a null country for testing
        String country = null;

        // Call the method under test
        ArrayList<City> cities = app.citiesByCountry(country);

        // Check if the list of cities is null
        assertNull(cities, "List of cities should be null for null country input");
    }

    /**
     * Test case for citiesByCountry method when an invalid country name is provided.
     * Verifies that the method returns an empty list of cities for an invalid country.
     */
    @Test
    void testCitiesByCountryInvalidCountry() {
        // Define an invalid country name for testing
        String country = "InvalidCountry";

        // Call the method under test
        ArrayList<City> cities = app.citiesByCountry(country);

        // Check if the list of cities is empty
        assertTrue(cities.isEmpty(), "List of cities should be empty for an invalid country");
    }

    /**
     * Test case for citiesByCountry method when a valid country name is provided.
     * Verifies that the method returns a non-null and non-empty list of cities for a valid country.
     * Also verifies the correctness of the first city in the list.
     */
    @Test
    void testCitiesByCountryWithCorrectInput() {
        // Define a country for testing
        String country = "Myanmar";

        // Call the method under test
        ArrayList<City> cities = app.citiesByCountry(country);

        // Check if the list of cities is not null
        assertNotNull(cities, "List of cities should not be null for a valid country");

        // Check if the list of cities is not empty
        assertFalse(cities.isEmpty(), "List of cities should not be empty for a valid country");

        City firstCity = cities.get(0);
        assertEquals("Rangoon (Yangon)", firstCity.getName(),
                "Last country should be 'Rangoon (Yangon)'");
    }

    /**
     * Test case for citiesByDistrict method when district is null.
     * Verifies that the method returns a null list of cities when a null district is provided.
     */
    @Test
    void testCitiesByDistrictNull() {
        // Define a null district for testing
        String district = null;

        // Call the method under test
        ArrayList<City> cities = app.citiesByDistrict(district);

        // Check if the list of cities is null
        assertNull(cities, "List of cities should be null for null district input");
    }

    /**
     * Test case for citiesByDistrict method when an invalid district name is provided.
     * Verifies that the method returns an empty list of cities for an invalid district.
     */
    @Test
    void testCitiesByDistrictInvalidDistrict() {
        // Define an invalid district name for testing
        String district = "InvalidDistrict";

        // Call the method under test
        ArrayList<City> cities = app.citiesByDistrict(district);

        // Check if the list of cities is empty
        assertTrue(cities.isEmpty(), "List of cities should be empty for an invalid district");
    }

    /**
     * Test case for citiesByDistrict method when a valid district name is provided.
     * Verifies that the method returns a non-null and non-empty list of cities for a valid district.
     * Also verifies the correctness of the first city in the list.
     */
    @Test
    void testCitiesByDistrictWithCorrectInput() {
        // Define a district for testing
        String district = "England";

        // Call the method under test
        ArrayList<City> cities = app.citiesByDistrict(district);

        // Check if the list of cities is not null
        assertNotNull(cities, "List of cities should not be null for a valid district");

        // Check if the list of cities is not empty
        assertFalse(cities.isEmpty(), "List of cities should not be empty for a valid district");

        City firstCity = cities.get(0);
        assertEquals("London", firstCity.getName(),
                "Last country should be London'");
    }

    /**
     * Test case for displayTopPopulatedCitiesInWorld method when negative input is provided.
     * Verifies that the method returns an empty list of cities for negative input.
     */
    @Test
    void testDisplayTopPopulatedCitiesInWorldNegativeInput() {
        // Define a negative value for testing
        int topN = -5;

        // Call the method under test
        ArrayList<City> cities = app.displayTopPopulatedCitiesInWorld(topN);

        // Check if the list of cities is empty
        assertTrue(cities.isEmpty(), "List of cities should be empty for negative input");
    }

    /**
     * Test case for displayTopPopulatedCitiesInWorld method when zero input is provided.
     * Verifies that the method returns an empty list of cities for zero input.
     */
    @Test
    void testDisplayTopPopulatedCitiesInWorldZeroInput() {
        // Define a zero value for testing
        int topN = 0;

        // Call the method under test
        ArrayList<City> cities = app.displayTopPopulatedCitiesInWorld(topN);

        // Check if the list of cities is empty
        assertTrue(cities.isEmpty(), "List of cities should be empty for zero input");
    }

    /**
     * Test case for displayTopPopulatedCitiesInWorld method when a positive value is provided.
     * Verifies that the method returns a non-null and non-empty list of cities for a positive input.
     * Also verifies the correctness of the first city in the list.
     */
    @Test
    void testDisplayTopPopulatedCitiesInWorldWithCorrectInput() {
        // Define a positive value for testing
        int topN = 10;

        // Call the method under test
        ArrayList<City> cities = app.displayTopPopulatedCitiesInWorld(topN);

        // Check if the list of cities is not null
        assertNotNull(cities, "List of cities should not be null");

        // Check if the list of cities is not empty
        assertFalse(cities.isEmpty(), "List of cities should not be empty");

        City firstCity = cities.get(0);
        assertEquals("Mumbai (Bombay)", firstCity.getName(),
                "Last country should be 'Mumbai (Bombay)'");
    }

    /**
     * Test case for displayTopPopulatedCitiesInContinent method when negative input is provided.
     * Verifies that the method returns an empty list of cities for negative input.
     */

    @Test
    void testDisplayTopPopulatedCitiesInContinentNegativeInput() {
        // Define a negative value for testing
        int topN = -5;
        String continent = "Europe"; // Define a continent for testing

        // Call the method under test
        ArrayList<City> cities = app.displayTopPopulatedCitiesInContinent(topN, continent);

        // Check if the list of cities is empty
        assertTrue(cities.isEmpty(), "List of cities should be empty for negative input");
    }

    /**
     * Test case for displayTopPopulatedCitiesInContinent method when zero input is provided.
     * Verifies that the method returns an empty list of cities for zero input.
     */
    @Test
    void testDisplayTopPopulatedCitiesInContinentZeroInput() {
        // Define a zero value for testing
        int topN = 0;
        String continent = "Europe"; // Define a continent for testing

        // Call the method under test
        ArrayList<City> cities = app.displayTopPopulatedCitiesInContinent(topN, continent);

        // Check if the list of cities is empty
        assertTrue(cities.isEmpty(), "List of cities should be empty for zero input");
    }

    /**
     * Test case for displayTopPopulatedCitiesInContinent method when null continent is provided.
     * Verifies that the method returns null for null continent input.
     */
    @Test
    void testDisplayTopPopulatedCitiesInContinentNullContinent() {
        // Define a null continent for testing
        int topN = 5;
        String continent = null;

        // Call the method under test
        ArrayList<City> cities = app.displayTopPopulatedCitiesInContinent(topN, continent);

        // Check if the list of cities is null
        assertNull(cities, "List of cities should be null");

    }

    /**
     * Test case for displayTopPopulatedCitiesInContinent method when an invalid continent is provided.
     * Verifies that the method returns an empty list of cities for an invalid continent.
     */
    @Test
    void testDisplayTopPopulatedCitiesInContinentInvalidContinent() {
        // Define an invalid continent name for testing
        int topN = 5;
        String continent = "InvalidContinent";

        // Call the method under test
        ArrayList<City> cities = app.displayTopPopulatedCitiesInContinent(topN, continent);

        // Check if the list of cities is empty
        assertTrue(cities.isEmpty(), "List of cities should be empty for invalid continent");
    }

    /**
     * Test case for displayTopPopulatedCitiesInContinent method with correct input.
     * Verifies that the method returns a non-null and non-empty list of cities for a valid continent.
     * Also verifies the correctness of the last city in the list.
     */

    @Test
    void testDisplayTopPopulatedCitiesInContinentWithCorrectInput() {
        // Define a positive value for testing
        int topN = 10;
        String continent = "Europe"; // Define a continent for testing

        // Call the method under test
        ArrayList<City> cities = app.displayTopPopulatedCitiesInContinent(topN, continent);

        // Check if the list of cities is not null
        assertNotNull(cities, "List of cities should not be null");

        // Check if the list of cities is not empty
        assertFalse(cities.isEmpty(), "List of cities should not be empty");

        City lastCity = cities.get(cities.size() - 1);
        assertEquals("Budapest", lastCity.getName(),
                "Last city should be 'Budapest'");
    }

    /**
     * Test case for displayTopPopulatedCitiesInRegion method when negative input is provided.
     * Verifies that the method returns an empty list of cities for negative input.
     */
    @Test
    void testDisplayTopPopulatedCitiesInRegionNegativeInput() {
        // Define a negative value for testing
        int topN = -5;
        String region = "Southeast Asia"; // Define a region for testing

        // Call the method under test
        ArrayList<City> cities = app.displayTopPopulatedCitiesInRegion(topN, region);

        // Check if the list of cities is empty
        assertTrue(cities.isEmpty(), "List of cities should be empty for negative input");
    }

    /**
     * Test case for displayTopPopulatedCitiesInRegion method when zero input is provided.
     * Verifies that the method returns an empty list of cities for zero input.
     */
    @Test
    void testDisplayTopPopulatedCitiesInRegionZeroInput() {
        // Define a zero value for testing
        int topN = 0;
        String region = "Southeast Asia"; // Define a region for testing

        // Call the method under test
        ArrayList<City> cities = app.displayTopPopulatedCitiesInRegion(topN, region);

        // Check if the list of cities is empty
        assertTrue(cities.isEmpty(), "List of cities should be empty for zero input");
    }

    /**
     * Test case for displayTopPopulatedCitiesInRegion method when null region is provided.
     * Verifies that the method returns null for null region input.
     */

    @Test
    void testDisplayTopPopulatedCitiesInRegionNullRegion() {
        // Define a null region for testing
        int topN = 5;
        String region = null;

        // Call the method under test
        ArrayList<City> cities = app.displayTopPopulatedCitiesInRegion(topN, region);

        // Check if the list of cities is null
        assertNull(cities, "List of cities should be null");

    }

    /**
     * Test case for displayTopPopulatedCitiesInRegion method when an invalid region is provided.
     * Verifies that the method returns an empty list of cities for an invalid region.
     */
    @Test
    void testDisplayTopPopulatedCitiesInRegionInvalidRegion() {
        // Define an invalid region name for testing
        int topN = 5;
        String region = "InvalidRegion";

        // Call the method under test
        ArrayList<City> cities = app.displayTopPopulatedCitiesInRegion(topN, region);

        // Check if the list of cities is empty
        assertTrue(cities.isEmpty(), "List of cities should be empty for invalid region");
    }

    /**
     * Test case for displayTopPopulatedCitiesInRegion method with correct input.
     * Verifies that the method returns a non-null and non-empty list of cities for a valid region.
     * Also verifies the correctness of the last city in the list.
     */

    @Test
    void testDisplayTopPopulatedCitiesInRegionWithCorrectInput() {
        // Define a positive value for testing
        int topN = 10;
        String region = "Southeast Asia"; // Define a region for testing

        // Call the method under test
        ArrayList<City> cities = app.displayTopPopulatedCitiesInRegion(topN, region);

        // Check if the list of cities is not null
        assertNotNull(cities, "List of cities should not be null");

        // Check if the list of cities is not empty
        assertFalse(cities.isEmpty(), "List of cities should not be empty");

        City lastCity = cities.get(cities.size() - 1);
        assertEquals("Manila", lastCity.getName(),
                "Last city should be 'Manila'");
    }

    /**
     * Test case for displayTopPopulatedCitiesInCountry method when negative input is provided.
     * Verifies that the method returns an empty list of cities for negative input.
     */

    @Test
    void testDisplayTopPopulatedCitiesInCountryNegativeInput() {
        // Define a negative value for testing
        int topN = -5;
        String country = "Myanmar"; // Define a country for testing

        // Call the method under test
        ArrayList<City> cities = app.displayTopPopulatedCitiesInCountry(topN, country);

        // Check if the list of cities is empty
        assertTrue(cities.isEmpty(), "List of cities should be empty for negative input");
    }

    /**
     * Test case for displayTopPopulatedCitiesInCountry method when zero input is provided.
     * Verifies that the method returns an empty list of cities for zero input.
     */

    @Test
    void testDisplayTopPopulatedCitiesInCountryZeroInput() {
        // Define a zero value for testing
        int topN = 0;
        String country = "Myanmar"; // Define a country for testing

        // Call the method under test
        ArrayList<City> cities = app.displayTopPopulatedCitiesInCountry(topN, country);

        // Check if the list of cities is empty
        assertTrue(cities.isEmpty(), "List of cities should be empty for zero input");
    }

    /**
     * Test case for displayTopPopulatedCitiesInCountry method when null country is provided.
     * Verifies that the method returns null for null country input.
     */

    @Test
    void testDisplayTopPopulatedCitiesInCountryNullCountry() {
        // Define a null country for testing
        int topN = 5;
        String country = null;

        // Call the method under test
        ArrayList<City> cities = app.displayTopPopulatedCitiesInCountry(topN, country);

        // Check if the list of cities is null
        assertNull(cities, "List of cities should be null");

    }

    /**
     * Test case for displayTopPopulatedCitiesInCountry method when an invalid country is provided.
     * Verifies that the method returns an empty list of cities for an invalid country.
     */

    @Test
    void testDisplayTopPopulatedCitiesInCountryInvalidCountry() {
        // Define an invalid country name for testing
        int topN = 5;
        String country = "InvalidCountry";

        // Call the method under test
        ArrayList<City> cities = app.displayTopPopulatedCitiesInCountry(topN, country);

        // Check if the list of cities is empty
        assertTrue(cities.isEmpty(), "List of cities should be empty for invalid country");
    }

    /**
     * Test case for displayTopPopulatedCitiesInCountry method with correct input.
     * Verifies that the method returns a non-null and non-empty list of cities for a valid country.
     * Also verifies the correctness of the last city in the list.
     */

    @Test
    void testDisplayTopPopulatedCitiesInCountryWithCorrectInput() {
        // Define a positive value for testing
        int topN = 10;
        String country = "Myanmar"; // Define a country for testing

        // Call the method under test
        ArrayList<City> cities = app.displayTopPopulatedCitiesInCountry(topN, country);

        // Check if the list of cities is not null
        assertNotNull(cities, "List of cities should not be null");

        // Check if the list of cities is not empty
        assertFalse(cities.isEmpty(), "List of cities should not be empty");

        City lastCity = cities.get(cities.size() - 1);
        assertEquals("Mergui (Myeik)", lastCity.getName(),
                "Last city should be 'Mergui (Myeik)'");
    }

    /**
     * Test case for displayTopPopulatedCitiesInDistrict method when negative input is provided.
     * Verifies that the method returns an empty list of cities for negative input.
     */
    @Test
    void testDisplayTopPopulatedCitiesInDistrictNegativeInput() {
        // Define a negative value for testing
        int topN = -5;
        String district = "England"; // Define a district for testing

        // Call the method under test
        ArrayList<City> cities = app.displayTopPopulatedCitiesInDistrict(topN, district);

        // Check if the list of cities is empty
        assertTrue(cities.isEmpty(), "List of cities should be empty for negative input");
    }

    /**
     * Test case for displayTopPopulatedCitiesInDistrict method when zero input is provided.
     * Verifies that the method returns an empty list of cities for zero input.
     */
    @Test
    void testDisplayTopPopulatedCitiesInDistrictZeroInput() {
        // Define a zero value for testing
        int topN = 0;
        String district = "England"; // Define a district for testing

        // Call the method under test
        ArrayList<City> cities = app.displayTopPopulatedCitiesInDistrict(topN, district);

        // Check if the list of cities is empty
        assertTrue(cities.isEmpty(), "List of cities should be empty for zero input");
    }

    /**
     * Test case for displayTopPopulatedCitiesInDistrict method when null district is provided.
     * Verifies that the method returns null for null district input.
     */
    @Test
    void testDisplayTopPopulatedCitiesInDistrictNullDistrict() {
        // Define a null district for testing
        int topN = 5;
        String district = null;

        // Call the method under test
        ArrayList<City> cities = app.displayTopPopulatedCitiesInDistrict(topN, district);

        // Check if the list of cities is null
        assertNull(cities, "List of cities should be null");

    }

    /**
     * Test case for displayTopPopulatedCitiesInDistrict method when an invalid district is provided.
     * Verifies that the method returns an empty list of cities for an invalid district.
     */
    @Test
    void testDisplayTopPopulatedCitiesInCountryInvalidDistrict() {
        // Define an invalid country name for testing
        int topN = 5;
        String country = "InvalidDistrict";

        // Call the method under test
        ArrayList<City> cities = app.displayTopPopulatedCitiesInCountry(topN, country);

        // Check if the list of cities is empty
        assertTrue(cities.isEmpty(), "List of cities should be empty for invalid district");
    }

    /**
     * Test case for displayTopPopulatedCitiesInDistrict method with correct input.
     * Verifies that the method returns a non-null and non-empty list of cities for a valid district.
     * Also verifies the correctness of the last city in the list.
     */
    @Test
    void testDisplayTopPopulatedCitiesInDistrictWithCorrectInput() {
        // Define a positive value for testing
        int topN = 10;
        String district = "England"; // Define a district for testing

        // Call the method under test
        ArrayList<City> cities = app.displayTopPopulatedCitiesInDistrict(topN, district);

        // Check if the list of cities is not null
        assertNotNull(cities, "List of cities should not be null");

        // Check if the list of cities is not empty
        assertFalse(cities.isEmpty(), "List of cities should not be empty");

        City lastCity = cities.get(cities.size() - 1);
        assertEquals("Bradford", lastCity.getName(),
                "Last city should be 'Bradford'");
    }
    /**
     * Test method for {@link App#getAllCapitalCities()}.
     */
    @Test
    void testGetAllCapitalCities() {
        // Call the method under test
        ArrayList<Capital> capitals = app.getAllCapitalCities();

        // Check if the list of capitals is not null
        assertNotNull(capitals, "List of capital cities should not be null");

        // Check if the list of capitals is not empty
        assertFalse(capitals.isEmpty(), "List of capital cities should not be empty");

        Capital lastCapital = capitals.get(0);
        assertEquals("Seoul", lastCapital.getName(),
                "Last city should be 'Seoul'");
    }
    /**
     * This method tests the behavior of the {@code capitalCitiesByContinent} method
     * when provided with a null continent input.
     */
    @Test
    void testCapitalCitiesByContinentNull() {
        // Define a null continent for testing
        String continent = null;

        // Call the method under test
        ArrayList<Capital> capitals = app.capitalCitiesByContinent(continent);

        // Check if the list of capitals is null
        assertNull(capitals, "List of capitals should be null for null continent input");
    }

    /**
     * This method tests the behavior of the {@code capitalCitiesByContinent} method
     * when provided with an invalid continent input.
     */
    @Test
    void testCapitalCitiesByContinentInvalidContinent() {
        // Define an invalid continent name for testing
        String continent = "InvalidContinent";

        // Call the method under test
        ArrayList<Capital> capitals = app.capitalCitiesByContinent(continent);

        // Check if the list of capitals is empty
        assertTrue(capitals.isEmpty(), "List of capitals should be empty for an invalid continent");
    }

    /**
     * This method tests the behavior of the {@code capitalCitiesByContinent} method
     * when provided with a correct continent input.
     */
    @Test
    void testCapitalCitiesByContinentWithCorrectInput() {
        // Define a continent for testing
        String continent = "Europe";

        // Call the method under test
        ArrayList<Capital> capitals = app.capitalCitiesByContinent(continent);

        // Check if the list of capitals is not null
        assertNotNull(capitals, "List of capitals should not be null for a valid continent");

        // Check if the list of capitals is not empty
        assertFalse(capitals.isEmpty(), "List of capitals should not be empty for a valid continent");
        Capital firstCapital = capitals.get(0);
        assertEquals("Moscow", firstCapital.getName(),
                "Last country should be 'Moscow'");

    }
    /**
     * This method tests the behavior of the {@code capitalCitiesByRegion} method
     * when provided with a null region input.
     */
    @Test
    void testCapitalCitiesByRegionNull() {
        // Define a null region for testing
        String region = null;

        // Call the method under test
        ArrayList<Capital> capitals = app.capitalCitiesByRegion(region);

        // Check if the list of capitals is null
        assertNull(capitals, "List of capitals should be null for null region input");
    }

    /**
     * This method tests the behavior of the {@code capitalCitiesByRegion} method
     * when provided with an invalid region input.
     */
    @Test
    void testCapitalCitiesByRegionInvalidRegion() {
        // Define an invalid region name for testing
        String region = "InvalidRegion";

        // Call the method under test
        ArrayList<Capital> capitals = app.capitalCitiesByRegion(region);

        // Check if the list of capitals is empty
        assertTrue(capitals.isEmpty(), "List of capitals should be empty for an invalid region");
    }

    /**
     * This method tests the behavior of the {@code capitalCitiesByRegion} method
     * when provided with a correct region input.
     */
    @Test
    void testCapitalCitiesByRegionWithCorrectInput() {
        // Define a region for testing
        String region = "Southeast Asia";

        // Call the method under test
        ArrayList<Capital> capitals = app.capitalCitiesByRegion(region);

        // Check if the list of capitals is not null
        assertNotNull(capitals, "List of capitals should not be null for a valid region");

        // Check if the list of capitals is not empty
        assertFalse(capitals.isEmpty(), "List of capitals should not be empty for a valid continent");
        Capital firstCapital = capitals.get(0);
        assertEquals("Jakarta", firstCapital.getName(),
                "Last country should be 'Jakarta'");
    }
    /**
     * This method tests the behavior of the {@code displayTopPopulatedCapitalCitiesInWorld} method
     * when provided with a negative input for the number of cities.
     */
    @Test
    void testDisplayTopPopulatedCapitalCitiesInWorldNegativeInput() {
        // Define a negative value for testing
        int topN = -5;

        // Call the method under test
        ArrayList<Capital> capitals = app.displayTopPopulatedCapitalCitiesInWorld(topN);

        // Check if the list of capitals is empty
        assertTrue(capitals.isEmpty(), "List of capitals should be empty for negative input");
    }

    /**
     * This method tests the behavior of the {@code displayTopPopulatedCapitalCitiesInWorld} method
     * when provided with a zero input for the number of cities.
     */
    @Test
    void testDisplayTopPopulatedCapitalCitiesInWorldZeroInput() {
        // Define a zero value for testing
        int topN = 0;

        // Call the method under test
        ArrayList<Capital> capitals = app.displayTopPopulatedCapitalCitiesInWorld(topN);

        // Check if the list of capitals is empty
        assertTrue(capitals.isEmpty(), "List of capitals should be empty for zero input");
    }

    /**
     * This method tests the behavior of the {@code displayTopPopulatedCapitalCitiesInWorld} method
     * when provided with a positive input for the number of cities.
     */
    @Test
    void testDisplayTopPopulatedCapitalCitiesInWorldWithCorrectInput() {
        // Define a positive value for testing
        int topN = 10;

        // Call the method under test
        ArrayList<Capital> capitals = app.displayTopPopulatedCapitalCitiesInWorld(topN);

        // Check if the list of capitals is not null
        assertNotNull(capitals, "List of capitals should not be null");

        // Check if the list of capitals is not empty
        assertFalse(capitals.isEmpty(), "List of capitals should not be empty");

        Capital firstCapital = capitals.get(0);
        assertEquals("Seoul", firstCapital.getName(),
                "Last country should be 'Seoul'");
    }
    /**
     * This method tests the behavior of the {@code displayTopPopulatedCapitalCitiesInContinent} method
     * when provided with a negative input for the number of cities and a continent.
     */
    @Test
    void testDisplayTopPopulatedCapitalCitiesInContinentNegativeInput() {
        // Define a negative value for testing
        int topN = -5;
        String continent = "Europe"; // Define a continent for testing

        // Call the method under test
        ArrayList<Capital> capitals = app.displayTopPopulatedCapitalCitiesInContinent(topN, continent);

        // Check if the list of capitals is empty
        assertTrue(capitals.isEmpty(), "List of capitals should be empty for negative input");
    }

    /**
     * This method tests the behavior of the {@code displayTopPopulatedCapitalCitiesInContinent} method
     * when provided with a zero input for the number of cities and a continent.
     */
    @Test
    void testDisplayTopPopulatedCapitalCitiesInContinentZeroInput() {
        // Define a zero value for testing
        int topN = 0;
        String continent = "Europe"; // Define a continent for testing

        // Call the method under test
        ArrayList<Capital> capitals = app.displayTopPopulatedCapitalCitiesInContinent(topN, continent);

        // Check if the list of capitals is empty
        assertTrue(capitals.isEmpty(), "List of capitals should be empty for zero input");
    }

    /**
     * This method tests the behavior of the {@code displayTopPopulatedCapitalCitiesInContinent} method
     * when provided with a null continent and a positive input for the number of cities.
     */
    @Test
    void testDisplayTopPopulatedCapitalCitiesInContinentNullContinent() {
        // Define a null continent for testing
        int topN = 5;
        String continent = null;

        // Call the method under test
        ArrayList<Capital> capitals = app.displayTopPopulatedCapitalCitiesInContinent(topN, continent);

        // Check if the list of capitals is null
        assertNull(capitals, "List of capitals should be null for null continent");
    }

    /**
     * This method tests the behavior of the {@code displayTopPopulatedCapitalCitiesInContinent} method
     * when provided with an invalid continent name and a positive input for the number of cities.
     */
    @Test
    void testDisplayTopPopulatedCapitalCitiesInContinentInvalidContinent() {
        // Define an invalid continent name for testing
        int topN = 5;
        String continent = "InvalidContinent";

        // Call the method under test
        ArrayList<Capital> capitals = app.displayTopPopulatedCapitalCitiesInContinent(topN, continent);

        // Check if the list of capitals is empty
        assertTrue(capitals.isEmpty(), "List of capitals should be empty for invalid continent");
    }

    /**
     * This method tests the behavior of the {@code displayTopPopulatedCapitalCitiesInContinent} method
     * when provided with correct input: a positive value for the number of cities and a valid continent.
     * It verifies that the method returns a non-null list of capitals, which is not empty, and that
     * the last capital city in the list matches the expected value for the specified continent.
     */
    @Test
    void testDisplayTopPopulatedCapitalCitiesInContinentWithCorrectInput() {
        // Define a positive value for testing
        int topN = 10;
        String continent = "Europe"; // Define a continent for testing

        // Call the method under test
        ArrayList<Capital> capitals = app.displayTopPopulatedCapitalCitiesInContinent(topN, continent);

        // Check if the list of capitals is not null
        assertNotNull(capitals, "List of capitals should not be null");

        // Check if the list of capitals is not empty
        assertFalse(capitals.isEmpty(), "List of capitals should not be empty");

        Capital lastCapital = capitals.get(capitals.size() - 1);
        assertEquals("Minsk", lastCapital.getName(),
                "Last capital city should be 'Minsk'");
    }

    /**
     * This method tests the behavior of the {@code displayTopPopulatedCapitalCitiesInContinent} method
     * when provided with correct input: a positive value for the number of cities and a valid continent.
     * It verifies that the method returns a non-null list of capitals, which is not empty, and that
     * the last capital city in the list matches the expected value for the specified continent.
     */
    @Test
    void testDisplayTopPopulatedCapitalCitiesInRegionNegativeInput() {
        // Define a negative value for testing
        int topN = -5;
        String region = "Southeast Asia"; // Define a region for testing

        // Call the method under test
        ArrayList<Capital> capitals = app.displayTopPopulatedCapitalCitiesInRegion(topN, region);

        // Check if the list of capitals is empty
        assertTrue(capitals.isEmpty(), "List of capitals should be empty for negative input");
    }

    /**
     * This method tests the behavior of the {@code displayTopPopulatedCapitalCitiesInRegion} method
     * when provided with a zero input for the number of cities and a specific region.
     * It verifies that the method returns an empty list of capitals as expected.
     */
    @Test
    void testDisplayTopPopulatedCapitalCitiesInRegionZeroInput() {
        // Define a zero value for testing
        int topN = 0;
        String region = "Southeast Asia"; // Define a region for testing

        // Call the method under test
        ArrayList<Capital> capitals = app.displayTopPopulatedCapitalCitiesInRegion(topN, region);

        // Check if the list of capitals is empty
        assertTrue(capitals.isEmpty(), "List of capitals should be empty for zero input");
    }

    /**
     * This method tests the behavior of the {@code displayTopPopulatedCapitalCitiesInRegion} method
     * when provided with a null input for the region and a positive value for the number of cities.
     * It verifies that the method returns null, as expected, when the region parameter is null.
     */
    @Test
    void testDisplayTopPopulatedCapitalCitiesInRegionNullRegion() {
        // Define a null region for testing
        int topN = 5;
        String region = null;

        // Call the method under test
        ArrayList<Capital> capitals = app.displayTopPopulatedCapitalCitiesInRegion(topN, region);

        // Check if the list of capitals is null
        assertNull(capitals, "List of capitals should be null for null region");
    }

    /**
     * This method tests the behavior of the {@code displayTopPopulatedCapitalCitiesInRegion} method
     * when provided with an invalid region name and a positive value for the number of cities.
     * It verifies that the method returns an empty list of capitals as expected for an invalid region.
     */
    @Test
    void testDisplayTopPopulatedCapitalCitiesInRegionInvalidRegion() {
        // Define an invalid region name for testing
        int topN = 5;
        String region = "InvalidRegion";

        // Call the method under test
        ArrayList<Capital> capitals = app.displayTopPopulatedCapitalCitiesInRegion(topN, region);

        // Check if the list of capitals is empty
        assertTrue(capitals.isEmpty(), "List of capitals should be empty for an invalid region");
    }

    /**
     * This method tests the behavior of the {@code displayTopPopulatedCapitalCitiesInRegion} method
     * when provided with correct input: a positive value for the number of cities and a valid region.
     * It verifies that the method returns a non-null list of capitals, which is not empty, and that
     * the last capital city in the list matches the expected value for the specified region.
     */
    @Test
    void testDisplayTopPopulatedCapitalCitiesInRegionWithCorrectInput() {
        // Define a positive value for testing
        int topN = 10;
        String region = "Southeast Asia"; // Define a region for testing

        // Call the method under test
        ArrayList<Capital> capitals = app.displayTopPopulatedCapitalCitiesInRegion(topN, region);

        // Check if the list of capitals is not null
        assertNotNull(capitals, "List of capitals should not be null");

        // Check if the list of capitals is not empty
        assertFalse(capitals.isEmpty(), "List of capitals should not be empty");

        Capital lastCapital = capitals.get(capitals.size() - 1);
        assertEquals("Dili", lastCapital.getName(),
                "Last capital city should be 'Dili'");
    }

    @Test
    void testDisplayPopulationDetailsByContinent() {
        // Redirect System.out to outputStreamCaptor
        System.setOut(new PrintStream(outputStreamCaptor));

        // Call the method under test
        app.displayPopulationDetailsByContinent();

        // Get the printed output
        String printedOutput = outputStreamCaptor.toString().trim();

        // Assert that the output is as expected
        Assertions.assertTrue(printedOutput.contains("Asia"), "Output is not as expected");
    }

    @Test
    void testDisplayPopulationDetailsByRegion() {
        // Redirect System.out to outputStreamCaptor
        System.setOut(new PrintStream(outputStreamCaptor));

        // Call the method under test
        app.displayPopulationDetailsByRegion();

        // Get the printed output
        String printedOutput = outputStreamCaptor.toString().trim();

        // Assert that the output is as expected
        Assertions.assertTrue(printedOutput.contains("Southeast Asia"), "Output is not as expected");
    }

    @Test
    void testDisplayPopulationDetailsByCountry() {
        // Redirect System.out to outputStreamCaptor
        System.setOut(new PrintStream(outputStreamCaptor));

        // Call the method under test
        app.displayPopulationDetailsByCountry();

        // Get the printed output
        String printedOutput = outputStreamCaptor.toString().trim();

        // Assert that the output is as expected
        Assertions.assertTrue(printedOutput.contains("Afghanistan"), "Output is not as expected");
    }




}