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
}