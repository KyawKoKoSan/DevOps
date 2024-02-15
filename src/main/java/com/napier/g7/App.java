/**
 * @author Htoo Myat Linn, Kyaw Ko Ko San, Bhone Myat, Wai Yan Moe, Zayar Phyo, Pyae Sone
 * @version 0.1-alpha-3
 * @since 2024-01-23
 */

package com.napier.g7;
import java.sql.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * The `App` class contains the main method and serves as the entry point for the application.
 * It demonstrates connecting to the database, querying and displaying country and city information,
 * and performing specific queries based on continent and region.
 */
public class App
{
    /**
     * Application entry point. Demonstrates connecting to a MySQL database,
     * querying and displaying country and city information, and performing
     * specific queries based on continent and region.
     *
     * @param args Command-line arguments (unused).
     */
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        if(args.length < 1){
            a.connect("localhost:33060", 0);
        }else{
            a.connect("db:3306",30000);
        }

        //Declaring Variables
        String targetContinent = "Europe";  // Replace "Europe" with the desired continent
        String targetRegion = "Southeast Asia";  // Replace "Southeast Asia" with the desired region
        String targetCountry = "Myanmar"; // Replace "Myanmar" with the desired country
        String targetDistrict = "England"; // Replace "England" with the desired District
        int numberOfCountries = 10; // Replace "10" with the desired number
        int numberOfCities = 10; // Replace "10" with the desired number
        int numberOfCapitals = 10; // Replace "10" with the desired number




        // Extract country population information
        ArrayList<Country> countries = a.getAllCountries();
        System.out.println("\n**********Countries********\n");
        // Print the count of countries
        int countOfCountries = countries.size();
        System.out.println("Number of countries: " + countOfCountries +"\n");
        a.printCountries(countries);

        // Get all countries in the specified continent
        ArrayList<Country> countriesByContinent = a.countriesByContinent(targetContinent);
        System.out.println("\n**********Countries in " + targetContinent + "********\n");
        // Print the count of countries
        int countCountriesByContinent = countriesByContinent.size();
        System.out.println("Number of countries: " + countCountriesByContinent +"\n");
        a.printCountries(countriesByContinent);

        // Get all countries in the specified region
        ArrayList<Country> countriesByRegion = a.countriesByRegion("Southeast Asia");
        System.out.println("\n**********Countries in " + targetRegion + "********\n");
        // Print the count of countries
        int countCountriesByRegion = countriesByRegion.size();
        System.out.println("Number of countries: " + countCountriesByRegion+"\n");
        a.printCountries(countriesByRegion);

        // Extract top N country population information
        System.out.println("\n**********Top "+ numberOfCountries +" Countries********\n");
        a.displayTopPopulatedCountries(numberOfCountries);

        // Extract top N country population information on specific continent
        System.out.println("\n**********Top "+ numberOfCountries +" Countries in " + targetContinent+" ********\n");
        a.displayTopPopulatedCountriesInContinent(numberOfCountries,targetContinent);

        // Extract top N country population information on specific region
        System.out.println("\n**********Top "+ numberOfCountries +" Countries in " + targetRegion+" ********\n");
        a.displayTopPopulatedCountriesInRegion(numberOfCountries,targetRegion);

        // Extract city population information
        ArrayList<City> cities = a.getAllCities();
        System.out.println("\n**********Cities********\n");
        // Print the count of cities
        int countOfCities = cities.size();
        System.out.println("Number of cities: " + countOfCities+"\n");
        a.printCities(cities);

        // Get all cities in the specified continent
        ArrayList<City> citiesByContinent = a.citiesByContinent(targetContinent);
        System.out.println("\n**********Cities in " + targetContinent + "********\n");
        // Print the count of cities
        int countCitiesByContinent = citiesByContinent.size();
        System.out.println("Number of cities: " + countCitiesByContinent+"\n");
        a.printCities(citiesByContinent);

        // Get all cities in the specified region
        ArrayList<City> citiesByRegion = a.citiesByRegion(targetRegion);
        System.out.println("\n**********Cities in " + targetRegion + "********\n");
        // Print the count of cities
        int countCitiesByRegion = citiesByRegion.size();
        System.out.println("Number of cities: " + countCitiesByRegion+"\n");
        a.printCities(citiesByRegion);

        // Get all cities in the specified country
        ArrayList<City> citiesByCountry = a.citiesByCountry(targetCountry);
        System.out.println("\n**********Cities in " + targetCountry + "********\n");
        // Print the count of cities
        int countCitiesByCountry = citiesByCountry.size();
        System.out.println("Number of cities: " + countCitiesByCountry+"\n");
        a.printCities(citiesByCountry);

        // Get all cities in the specified district
        ArrayList<City> citiesByDistrict = a.citiesByDistrict(targetDistrict);
        System.out.println("\n**********Cities in " + targetDistrict + "********\n");
        // Print the count of cities
        int countCitiesByDistrict = citiesByDistrict.size();
        System.out.println("Number of cities: " + countCitiesByDistrict+"\n");
        a.printCities(citiesByDistrict);

        // Extract top N city population information in the world
        System.out.println("\n**********Top " + numberOfCities + " Cities in the World********\n");
        a.displayTopPopulatedCitiesInWorld(numberOfCities);

        // Extract top N city population information on a specific continent
        System.out.println("\n**********Top " + numberOfCities + " Cities in " + targetContinent + "********\n");
        a.displayTopPopulatedCitiesInContinent(numberOfCities, targetContinent);

        // Extract top N city population information in a specific region
        System.out.println("\n**********Top " + numberOfCities + " Cities in " + targetRegion + "********\n");
        a.displayTopPopulatedCitiesInRegion(numberOfCities, targetRegion);

        // Extract top N city population information in a specific country
        System.out.println("\n**********Top " + numberOfCities + " Cities in " + targetCountry + "********\n");
        a.displayTopPopulatedCitiesInCountry(numberOfCities, targetCountry);

        // Extract top N city population information in a specific district
        System.out.println("\n**********Top " + numberOfCities + " Cities in " + targetDistrict + "********\n");
        a.displayTopPopulatedCitiesInDistrict(numberOfCities, targetDistrict);

        // Call the method and print the details
        ArrayList<Capital> capitalCities = a.getAllCapitalCities();
        System.out.println("\n**********Capital Cities********\n");
        // Print the count of capital cities
        int countOfCapitals = capitalCities.size();
        System.out.println("Number of capital cities: " + countOfCapitals + "\n");
        a.printCapitalCities(capitalCities);

        // Get all capital cities in the specified continent
        ArrayList<Capital> capitalsByContinent = a.capitalCitiesByContinent(targetContinent);
        System.out.println("\n**********Capital Cities in " + targetContinent + "********\n");
        // Print the count of capital cities
        int countCapitalsByContinent = capitalsByContinent.size();
        System.out.println("Number of capital cities: " + countCapitalsByContinent + "\n");
        a.printCapitalCities(capitalsByContinent);


        // Get all capital cities in the specified region
        ArrayList<Capital> capitalsByRegion = a.capitalCitiesByRegion(targetRegion);
        System.out.println("\n**********Capital Cities in " + targetRegion + "********\n");
        // Print the count of capital cities
        int countCapitalsByRegion = capitalsByRegion.size();
        System.out.println("Number of capital cities: " + countCapitalsByRegion + "\n");
        a.printCapitalCities(capitalsByRegion);

        // Extract top N capital city population information in the world
        System.out.println("\n**********Top " + numberOfCapitals + " Capital Cities in the World********\n");
        a.displayTopPopulatedCapitalCitiesInWorld(numberOfCapitals);

        // Extract top N capital city population information on a specific continent
        System.out.println("\n**********Top " + numberOfCapitals + " Capital Cities in " + targetContinent + "********\n");
        a.displayTopPopulatedCapitalCitiesInContinent(numberOfCapitals, targetContinent);

        // Extract top N capital city population information in a specific region
        System.out.println("\n**********Top " + numberOfCapitals + " Capital Cities in " + targetRegion + "********\n");
        a.displayTopPopulatedCapitalCitiesInRegion(numberOfCapitals, targetRegion);

        // Call the method to display population details by continent
        System.out.println("\n**********Population Details by Continent********\n");
        a.displayPopulationDetailsByContinent();

        // Call the method to display population details by region
        System.out.println("\n**********Population Details by Region********\n");
        a.displayPopulationDetailsByRegion();

        // Call the method to display population details by country
        System.out.println("\n**********Population Details by Country********\n");
        a.displayPopulationDetailsByCountry();

        // Call the method to display world population
        System.out.println("\n**********World Population********\n");
        a.displayWorldPopulation();

        // Call the method to display continent population
        System.out.println("\n**********Population Details in "+ targetContinent +  " Continent********\n");
        a.displayContinentPopulation(targetContinent);

        // Call the method to display the population of a region
        System.out.println("\n**********Population Details in " +targetRegion+ " Region********\n");
        a.displayRegionPopulation(targetRegion);

        // Call the method to display the population of a country
        System.out.println("\n**********Population Details in "+ targetCountry+ " Country********\n");
        a.displayCountryPopulation(targetCountry);

        // Call the method to display the population of a district
        System.out.println("\n**********Population Details in " +targetDistrict+  " District********\n");
        a.displayDistrictPopulation(targetDistrict);

        // Disconnect from database
        a.disconnect();
    }

    private Connection con = null;

    /**
     * Connects to the MySQL database.
     * The method loads the MySQL JDBC driver, attempts to connect to the database,
     * and handles connection retries in case of failure.
     *
     * @throws ClassNotFoundException If the MySQL JDBC driver is not found.
     */
    public void connect(String location, int delay) {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(delay);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location
                                + "/world?allowPublicKeyRetrieval=true&useSSL=false",
                        "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " +                                  Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }
    /**
     * Disconnects from the MySQL database.
     * Closes the database connection if it is open.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     * Prints the details of a list of countries in a formatted table.
     *
     * @param countries The list of Country objects to print.
     */
    public void printCountries(ArrayList<Country> countries) {
        // Check employees is not null
        if (countries == null)
        {
            System.out.println("No Countries");
            return;
        }
        // Print header
        System.out.println(String.format("%-5s %-50s %-15s %-40s %-15s %-10s",
                "Code", "Name", "Continent", "Region", "Population", "Capital"));

        // Loop over all countries in the list
        for (Country country : countries) {
            if(country == null)
                continue;
            // Format population with commas
            NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
            String formattedPopulation = numberFormat.format(country.getPopulation());
            String countryString = String.format("%-5s %-50s %-15s %-40s %-15s %-10s",
                    country.getCode(), country.getName(), country.getContinent(),
                    country.getRegion(), formattedPopulation, country.getCapitalName());
            System.out.println(countryString);
        }
    }

    /**
     * Prints the details of a list of cities in a formatted table.
     *
     * @param cities The list of City objects to print.
     */
    public void printCities(ArrayList<City> cities) {
        if (cities == null)
        {
            System.out.println("No cities");
            return;
        }
        // Print header
        System.out.println(String.format("%-40s %-40s %-30s %-15s",
                "Name", "CountryName", "District", "Population"));

        // Loop over all cities in the list
        for (City city : cities) {
            if(city == null)
                continue;
            // Format population with commas
            NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
            String formattedPopulation = numberFormat.format(city.getPopulation());
            String cityString = String.format("%-40s %-40s %-30s %-15s",
                    city.getName(), city.getCountryCode(), city.getDistrict(), formattedPopulation);
            System.out.println(cityString);
        }
    }

    /**
     * Prints the details of a list of capital cities in a formatted table.
     *
     * @param capitals The list of Capital objects to print.
     */
    public void printCapitalCities(ArrayList<Capital> capitals) {
        // Check if capitals is not null
        if (capitals == null || capitals.isEmpty()) {
            System.out.println("No capital cities");
            return;
        }

        // Print header
        System.out.println(String.format("%-15s %-35s %-45s %-15s",
                "ID", "Name", "Country Name", "Population"));

        // Loop over all capital cities in the list
        for (Capital capital : capitals) {
            if (capital == null)
                continue;
            // Format population with commas
            NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
            String formattedPopulation = numberFormat.format(capital.getPopulation());
            String capitalString = String.format("%-15s %-35s %-45s %-15s",
                    capital.getId(), capital.getName(), capital.getCountryName(), formattedPopulation);
            System.out.println(capitalString);
        }
    }

    /**
     * Retrieves a list of all countries ordered by population in descending
     * order.
     *
     * @return An ArrayList of Country objects representing all countries,
     *         ordered by population in descending order.
     */
    public ArrayList<Country> getAllCountries() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT c.code, c.name, c.continent, c.region, c.surfaceArea, c.indepYear, " +
                            "c.population, c.lifeExpectancy, c.gnp, c.gnpOld, c.localName, " +
                            "c.governmentForm, c.headOfState, c.capital, ci.name AS capitalName " +
                            "FROM country c " +
                            "LEFT JOIN city ci ON c.capital = ci.id " +
                            "ORDER BY c.population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract country information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                // Create a new Country object
                Country country = new Country();
                // Set country attributes from the result set
                country.setCode(rset.getString("code"));
                country.setName(rset.getString("name"));
                country.setContinent(rset.getString("continent"));
                country.setRegion(rset.getString("region"));
                country.setSurfaceArea(rset.getFloat("surfaceArea"));
                country.setIndepYear(rset.getInt("indepYear"));
                country.setPopulation(rset.getLong("population"));
                country.setLifeExpectancy(rset.getFloat("lifeExpectancy"));
                country.setGnp(rset.getFloat("gnp"));
                country.setGnpOld(rset.getFloat("gnpOld"));
                country.setLocalName(rset.getString("localName"));
                country.setGovernmentForm(rset.getString("governmentForm"));
                country.setHeadOfState(rset.getString("headOfState"));
                country.setCapital(rset.getInt("capital"));
                country.setCapitalName(rset.getString("capitalName"));
                // Add the Country object to the ArrayList
                countries.add(country);
            }
            // Check if any countries were found
            if (countries.isEmpty()) {
                System.out.println("No countries found");
            }
            // Return the list of countries
            return countries;
        } catch (Exception e) {
            // Print error messages in case of an exception
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return new ArrayList<>();
        }
    }

    /**
     * Retrieves a list of countries based on the specified continent, ordered
     * by population in descending order.
     *
     * @param continent The continent to filter countries.
     * @return An ArrayList of Country objects representing countries in the
     *         specified continent, ordered by population in descending order.
     */
    public ArrayList<Country> countriesByContinent(String continent) {
        try {
            if (continent == null) {
                System.out.println("Continent cannot be null");
                return null;
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT c.code, c.name, c.continent, c.region, c.surfaceArea, c.indepYear, " +
                            "c.population, c.lifeExpectancy, c.gnp, c.gnpOld, c.localName, " +
                            "c.governmentForm, c.headOfState, c.capital, ci.name AS capitalName " +
                            "FROM country c " +
                            "LEFT JOIN city ci ON c.capital = ci.id " +
                            "WHERE c.continent = '" + continent + "' " +
                            "ORDER BY c.population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract country information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                // Create a new Country object
                Country country = new Country();
                // Set country attributes from the result set
                country.setCode(rset.getString("code"));
                country.setName(rset.getString("name"));
                country.setContinent(rset.getString("continent"));
                country.setRegion(rset.getString("region"));
                country.setSurfaceArea(rset.getFloat("surfaceArea"));
                country.setIndepYear(rset.getInt("indepYear"));
                country.setPopulation(rset.getLong("population"));
                country.setLifeExpectancy(rset.getFloat("lifeExpectancy"));
                country.setGnp(rset.getFloat("gnp"));
                country.setGnpOld(rset.getFloat("gnpOld"));
                country.setLocalName(rset.getString("localName"));
                country.setGovernmentForm(rset.getString("governmentForm"));
                country.setHeadOfState(rset.getString("headOfState"));
                country.setCapital(rset.getInt("capital"));
                country.setCapitalName(rset.getString("capitalName"));
                // Add the Country object to the ArrayList
                countries.add(country);
            }
            // Check if any countries were found for the given continent
            if (countries.isEmpty()) {
                System.out.println("No countries found for continent: " + continent);
            }
            // Return the list of countries
            return countries;
        } catch (Exception e) {
            // Print error messages in case of an exception
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details by continent");
            return new ArrayList<>();
        }
    }

    /**
     * Retrieves a list of countries based on the specified region, ordered by
     * population in descending order.
     *
     * @param region The region to filter countries.
     * @return An ArrayList of Country objects representing countries in the
     *         specified region, ordered by population in descending order.
     */
    public ArrayList<Country> countriesByRegion(String region) {
        try {
            if (region == null) {
                System.out.println("Region cannot be null");
                return null;
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT c.code, c.name, c.continent, c.region, c.surfaceArea, c.indepYear, " +
                            "c.population, c.lifeExpectancy, c.gnp, c.gnpOld, c.localName, " +
                            "c.governmentForm, c.headOfState, c.capital, ci.name AS capitalName " +
                            "FROM country c " +
                            "LEFT JOIN city ci ON c.capital = ci.id " +
                            "WHERE c.region = '" + region + "' " +
                            "ORDER BY c.population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract country information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                // Create a new Country object
                Country country = new Country();
                // Set country attributes from the result set
                country.setCode(rset.getString("code"));
                country.setName(rset.getString("name"));
                country.setContinent(rset.getString("continent"));
                country.setRegion(rset.getString("region"));
                country.setSurfaceArea(rset.getFloat("surfaceArea"));
                country.setIndepYear(rset.getInt("indepYear"));
                country.setPopulation(rset.getLong("population"));
                country.setLifeExpectancy(rset.getFloat("lifeExpectancy"));
                country.setGnp(rset.getFloat("gnp"));
                country.setGnpOld(rset.getFloat("gnpOld"));
                country.setLocalName(rset.getString("localName"));
                country.setGovernmentForm(rset.getString("governmentForm"));
                country.setHeadOfState(rset.getString("headOfState"));
                country.setCapital(rset.getInt("capital"));
                country.setCapitalName(rset.getString("capitalName"));
                // Add the Country object to the ArrayList
                countries.add(country);
            }
            // Check if any countries were found for the given continent
            if (countries.isEmpty()) {
                System.out.println("No countries found for region: " + region);
            }
            // Return the list of countries
            return countries;
        } catch (Exception e) {
            // Print error messages in case of an exception
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details by region");
            return new ArrayList<>();
        }
    }

    /**
     * Displays the top N populated countries based on population in
     * descending order.
     *
     * @param topN The number of top populated countries to display.
     */
    public ArrayList<Country> displayTopPopulatedCountries(int topN) {
        // Check if topN is non-positive
        if (topN < 0) {
            System.out.println("Invalid input: topN should be a positive integer.");
            return new ArrayList<>(); // Return an empty list
        }
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT c.code, c.name, c.continent, c.region, c.surfaceArea, c.indepYear, " +
                            "c.population, c.lifeExpectancy, c.gnp, c.gnpOld, c.localName, " +
                            "c.governmentForm, c.headOfState, c.capital, ci.name AS capitalName " +
                            "FROM country c " +
                            "LEFT JOIN city ci ON c.capital = ci.id " +
                            "ORDER BY c.population DESC " +
                            "LIMIT " + topN;

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract country information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                // Create a new Country object
                Country country = new Country();
                // Set country attributes from the result set
                country.setCode(rset.getString("code"));
                country.setName(rset.getString("name"));
                country.setContinent(rset.getString("continent"));
                country.setRegion(rset.getString("region"));
                country.setSurfaceArea(rset.getFloat("surfaceArea"));
                country.setIndepYear(rset.getInt("indepYear"));
                country.setPopulation(rset.getLong("population"));
                country.setLifeExpectancy(rset.getFloat("lifeExpectancy"));
                country.setGnp(rset.getFloat("gnp"));
                country.setGnpOld(rset.getFloat("gnpOld"));
                country.setLocalName(rset.getString("localName"));
                country.setGovernmentForm(rset.getString("governmentForm"));
                country.setHeadOfState(rset.getString("headOfState"));
                country.setCapital(rset.getInt("capital"));
                country.setCapitalName(rset.getString("capitalName"));
                // Add the Country object to the ArrayList
                countries.add(country);
            }
            // Check if any countries were found for the given continent
            if (countries.isEmpty()) {
                System.out.println("No countries found for Top: " + topN);
            }
            else{
                // Print the top N populated countries
                printCountries(countries);
            }

            // Return the list of countries
            return countries;
        } catch (Exception e) {
            // Print error messages in case of an exception
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated countries");
            return new ArrayList<>();
        }
    }

    /**
     * Displays the top N populated countries in the specified continent based
     * on population in descending order.
     *
     * @param topN      The number of top populated countries to display.
     * @param continent The continent to filter countries.
     */
    public ArrayList<Country> displayTopPopulatedCountriesInContinent(int topN, String continent) {
        try {
            // Check if topN is non-positive
            if (topN < 0) {
                System.out.println("Invalid input: topN should be a positive integer.");
                return new ArrayList<>(); // Return an empty list
            }
            if (continent == null) {
                System.out.println("Continent cannot be null");
                return null;
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT c.code, c.name, c.continent, c.region, c.surfaceArea, c.indepYear, " +
                            "c.population, c.lifeExpectancy, c.gnp, c.gnpOld, c.localName, " +
                            "c.governmentForm, c.headOfState, c.capital, ci.name AS capitalName " +
                            "FROM country c " +
                            "LEFT JOIN city ci ON c.capital = ci.id " +
                            "WHERE c.continent = '" + continent + "' " +
                            "ORDER BY c.population DESC " +
                            "LIMIT " + topN;


            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract country information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                // Create a new Country object
                Country country = new Country();
                // Set country attributes from the result set
                country.setCode(rset.getString("code"));
                country.setName(rset.getString("name"));
                country.setContinent(rset.getString("continent"));
                country.setRegion(rset.getString("region"));
                country.setSurfaceArea(rset.getFloat("surfaceArea"));
                country.setIndepYear(rset.getInt("indepYear"));
                country.setPopulation(rset.getLong("population"));
                country.setLifeExpectancy(rset.getFloat("lifeExpectancy"));
                country.setGnp(rset.getFloat("gnp"));
                country.setGnpOld(rset.getFloat("gnpOld"));
                country.setLocalName(rset.getString("localName"));
                country.setGovernmentForm(rset.getString("governmentForm"));
                country.setHeadOfState(rset.getString("headOfState"));
                country.setCapital(rset.getInt("capital"));
                country.setCapitalName(rset.getString("capitalName"));
                // Add the Country object to the ArrayList
                countries.add(country);
            }
            if (countries.isEmpty()) {
                System.out.println("No countries found for Top: " + topN+" in continent: " + continent);
            }else {
                // Print the top N populated countries in the specified continent
                printCountries(countries);
            }
            return countries;
        } catch (Exception e) {
            // Print error messages in case of an exception
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated countries in the continent");
            return new ArrayList<>();
        }
    }

    /**
     * Displays the top N populated countries in the specified region based on
     * population in descending order.
     *
     * @param topN   The number of top populated countries to display.
     * @param region The region to filter countries.
     */
    public ArrayList<Country> displayTopPopulatedCountriesInRegion(int topN, String region) {
        // Check if topN is non-positive
        if (topN < 0) {
            System.out.println("Invalid input: topN should be a positive integer.");
            return new ArrayList<>(); // Return an empty list
        }
        if (region == null) {
            System.out.println("Region cannot be null");
            return null;
        }
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT c.code, c.name, c.continent, c.region, c.surfaceArea, c.indepYear, " +
                            "c.population, c.lifeExpectancy, c.gnp, c.gnpOld, c.localName, " +
                            "c.governmentForm, c.headOfState, c.capital, ci.name AS capitalName " +
                            "FROM country c " +
                            "LEFT JOIN city ci ON c.capital = ci.id " +
                            "WHERE c.region = '" + region + "' " +
                            "ORDER BY c.population DESC " +
                            "LIMIT " + topN;

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract country information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                // Create a new Country object
                Country country = new Country();
                country.setCode(rset.getString("code"));
                country.setName(rset.getString("name"));
                country.setContinent(rset.getString("continent"));
                country.setRegion(rset.getString("region"));
                country.setSurfaceArea(rset.getFloat("surfaceArea"));
                country.setIndepYear(rset.getInt("indepYear"));
                country.setPopulation(rset.getLong("population"));
                country.setLifeExpectancy(rset.getFloat("lifeExpectancy"));
                country.setGnp(rset.getFloat("gnp"));
                country.setGnpOld(rset.getFloat("gnpOld"));
                country.setLocalName(rset.getString("localName"));
                country.setGovernmentForm(rset.getString("governmentForm"));
                country.setHeadOfState(rset.getString("headOfState"));
                country.setCapital(rset.getInt("capital"));
                country.setCapitalName(rset.getString("capitalName"));
                // Add the Country object to the ArrayList
                countries.add(country);
            }

            if (countries.isEmpty()) {
                System.out.println("No countries found for Top: " + topN + " in region: " + region);
            }else{
                // Print the top N populated countries in the specified region
                printCountries(countries);}
            return countries;
        } catch (Exception e) {
            // Print error messages in case of an exception
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated countries in the region");
            return new ArrayList<>();
        }
    }

    /**
     * Retrieves a list of all cities ordered by population in descending
     * order, along with their respective country names.
     *
     * @return An ArrayList of City objects representing all cities,
     *         ordered by population in descending order.
     */
    public ArrayList<City> getAllCities() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name AS cityName, country.Name AS countryName, city.District, city.Population " +
                            "FROM city " +
                            "JOIN country ON city.CountryCode = country.Code " +
                            "ORDER BY city.Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                // Create a new City object
                City city = new City();
                // Set city attributes from the result set
                city.setId(rset.getInt("ID"));
                city.setName(rset.getString("cityName"));
                city.setCountryCode(rset.getString("countryName"));
                city.setDistrict(rset.getString("District"));
                city.setPopulation(rset.getLong("Population"));
                // Add the City object to the ArrayList
                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            // Print error messages in case of an exception
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return new ArrayList<>();
        }
    }

    /**
     * Retrieves a list of cities based on the specified continent, along with
     * their respective country names, ordered by population in descending
     * order.
     *
     * @param continent The continent to filter cities.
     * @return An ArrayList of City objects representing cities in the specified
     *         continent, ordered by population in descending order.
     */
    public ArrayList<City> citiesByContinent(String continent) {
        try {
            if (continent == null) {
                System.out.println("Continent cannot be null");
                return null;
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name AS cityName, country.Name AS countryName, city.District, city.Population " +
                            "FROM city " +
                            "JOIN country ON city.CountryCode = country.Code " +
                            "WHERE country.Continent = '" + continent + "' " +
                            "ORDER BY city.Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                // Create a new City object
                City city = new City();
                // Set city attributes from the result set
                city.setId(rset.getInt("ID"));
                city.setName(rset.getString("cityName"));
                city.setCountryCode(rset.getString("countryName"));
                city.setDistrict(rset.getString("District"));
                city.setPopulation(rset.getLong("Population"));
                // Add the City object to the ArrayList
                cities.add(city);
            }
            // Check if any countries were found for the given continent
            if (cities.isEmpty()) {
                System.out.println("No cities found for continent: " + continent);
            }
            return cities;
        } catch (Exception e) {
            // Print error messages in case of an exception
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details by continent");
            return new ArrayList<>();
        }
    }

    /**
     * Retrieves all the cities in a specified region, organized by largest population to smallest.
     *
     * @param region The region for which cities are to be retrieved.
     * @return An ArrayList of City objects representing cities in the specified region.
     */
    public ArrayList<City> citiesByRegion(String region) {
        try {
            if (region == null) {
                System.out.println("Region cannot be null");
                return null;
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name AS cityName, country.Name AS countryName, city.District, city.Population " +
                            "FROM city " +
                            "JOIN country ON city.CountryCode = country.Code " +
                            "WHERE country.Region = '" + region + "' " +
                            "ORDER BY city.Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                // Create a new City object
                City city = new City();
                // Set city attributes from the result set
                city.setId(rset.getInt("ID"));
                city.setName(rset.getString("cityName"));
                city.setCountryCode(rset.getString("countryName"));
                city.setDistrict(rset.getString("District"));
                city.setPopulation(rset.getLong("Population"));
                // Add the City object to the ArrayList
                cities.add(city);
            }
            // Check if any cities were found for the given region
            if (cities.isEmpty()) {
                System.out.println("No cities found for region: " + region);
            }
            return cities;
        } catch (Exception e) {
            // Print error messages in case of an exception
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details by region");
            return new ArrayList<>();
        }
    }


    /**
     * Retrieves all the cities in a specified country, organized by largest population to smallest.
     *
     * @param country The country for which cities are to be retrieved.
     * @return An ArrayList of City objects representing cities in the specified country.
     */
    public ArrayList<City> citiesByCountry(String country) {
        try {
            if (country == null) {
                System.out.println("Country cannot be null");
                return null;
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name AS cityName, country.Name AS countryName, city.District, city.Population " +
                            "FROM city " +
                            "JOIN country ON city.CountryCode = country.Code " +
                            "WHERE country.Name = '" + country + "' " +
                            "ORDER BY city.Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                // Create a new City object
                City city = new City();
                // Set city attributes from the result set
                city.setId(rset.getInt("ID"));
                city.setName(rset.getString("cityName"));
                city.setCountryCode(rset.getString("countryName"));
                city.setDistrict(rset.getString("District"));
                city.setPopulation(rset.getLong("Population"));
                // Add the City object to the ArrayList
                cities.add(city);
            }
            // Check if any cities were found for the given country
            if (cities.isEmpty()) {
                System.out.println("No cities found for country: " + country);
            }
            return cities;
        } catch (Exception e) {
            // Print error messages in case of an exception
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details by country");
            return new ArrayList<>();
        }
    }


    /**
     * Retrieves all the cities in a specified district, organized by largest population to smallest.
     *
     * @param district The district for which cities are to be retrieved.
     * @return An ArrayList of City objects representing cities in the specified district.
     */
    public ArrayList<City> citiesByDistrict(String district) {
        try {
            if (district == null) {
                System.out.println("District cannot be null");
                return null;
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name AS cityName, country.Name AS countryName, city.District, city.Population " +
                            "FROM city " +
                            "JOIN country ON city.CountryCode = country.Code " +
                            "WHERE city.District = '" + district + "' " +
                            "ORDER BY city.Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                // Create a new City object
                City city = new City();
                // Set city attributes from the result set
                city.setId(rset.getInt("ID"));
                city.setName(rset.getString("cityName"));
                city.setCountryCode(rset.getString("countryName"));
                city.setDistrict(rset.getString("District"));
                city.setPopulation(rset.getLong("Population"));
                // Add the City object to the ArrayList
                cities.add(city);
            }
            // Check if any cities were found for the given district
            if (cities.isEmpty()) {
                System.out.println("No cities found for district: " + district);
            }
            return cities;
        } catch (Exception e) {
            // Print error messages in case of an exception
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details by district");
            return new ArrayList<>();
        }
    }

    /**
     * Displays the top N populated cities in the world based on population in descending order.
     *
     * @param topN The number of top populated cities to display.
     * @return An ArrayList of City objects representing the top populated cities.
     */
    public ArrayList<City> displayTopPopulatedCitiesInWorld(int topN) {
        // Check if topN is non-positive
        if (topN < 0) {
            System.out.println("Invalid input: topN should be a positive integer.");
            return new ArrayList<>(); // Return an empty list
        }
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name AS cityName, country.Name AS countryName, city.District, city.Population " +
                            "FROM city " +
                            "JOIN country ON city.CountryCode = country.Code " +
                            "ORDER BY city.Population DESC " +
                            "LIMIT " + topN;

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                // Create a new City object
                City city = new City();
                // Set city attributes from the result set
                city.setId(rset.getInt("ID"));
                city.setName(rset.getString("cityName"));
                city.setCountryCode(rset.getString("countryName"));
                city.setDistrict(rset.getString("District"));
                city.setPopulation(rset.getLong("Population"));
                // Add the City object to the ArrayList
                cities.add(city);
            }
            // Check if any cities were found
            if (cities.isEmpty()) {
                System.out.println("No cities found in the database.");
            } else {
                // Print the top N populated cities in the world
                printCities(cities);
            }
            // Return the list of top populated cities
            return cities;
        } catch (Exception e) {
            // Print error messages in case of an exception
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated cities in the world");
            return new ArrayList<>();
        }
    }

    /**
     * Displays the top N populated cities in a continent based on population in descending order.
     *
     * @param topN      The number of top populated cities to display.
     * @param continent The continent to filter cities.
     * @return An ArrayList of City objects representing the top populated cities in the specified continent.
     */
    public ArrayList<City> displayTopPopulatedCitiesInContinent(int topN, String continent) {
        // Check if topN is non-positive
        if (topN < 0) {
            System.out.println("Invalid input: topN should be a positive integer.");
            return new ArrayList<>(); // Return an empty list
        }
        if (continent == null) {
            System.out.println("Continent cannot be null");
            return null;
        }
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name AS cityName, country.Name AS countryName, city.District, city.Population " +
                            "FROM city " +
                            "JOIN country ON city.CountryCode = country.Code " +
                            "WHERE country.Continent = '" + continent + "' " +
                            "ORDER BY city.Population DESC " +
                            "LIMIT " + topN;

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                // Create a new City object
                City city = new City();
                // Set city attributes from the result set
                city.setId(rset.getInt("ID"));
                city.setName(rset.getString("cityName"));
                city.setCountryCode(rset.getString("countryName"));
                city.setDistrict(rset.getString("District"));
                city.setPopulation(rset.getLong("Population"));
                // Add the City object to the ArrayList
                cities.add(city);
            }
            // Check if any cities were found
            if (cities.isEmpty()) {
                System.out.println("No cities found for continent: " + continent);
            } else {
                // Print the top N populated cities in the continent
                printCities(cities);
            }
            // Return the list of top populated cities in the specified continent
            return cities;
        } catch (Exception e) {
            // Print error messages in case of an exception
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated cities in the continent");
            return new ArrayList<>();
        }
    }

    /**
     * Displays the top N populated cities in a region based on population in descending order.
     *
     * @param topN   The number of top populated cities to display.
     * @param region The region to filter cities.
     * @return An ArrayList of City objects representing the top populated cities in the specified region.
     */
    public ArrayList<City> displayTopPopulatedCitiesInRegion(int topN, String region) {
        // Check if topN is non-positive
        if (topN < 0) {
            System.out.println("Invalid input: topN should be a positive integer.");
            return new ArrayList<>(); // Return an empty list
        }
        if (region == null) {
            System.out.println("Region cannot be null");
            return null;
        }
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name AS cityName, country.Name AS countryName, city.District, city.Population " +
                            "FROM city " +
                            "JOIN country ON city.CountryCode = country.Code " +
                            "WHERE country.Region = '" + region + "' " +
                            "ORDER BY city.Population DESC " +
                            "LIMIT " + topN;

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                // Create a new City object
                City city = new City();
                // Set city attributes from the result set
                city.setId(rset.getInt("ID"));
                city.setName(rset.getString("cityName"));
                city.setCountryCode(rset.getString("countryName"));
                city.setDistrict(rset.getString("District"));
                city.setPopulation(rset.getLong("Population"));
                // Add the City object to the ArrayList
                cities.add(city);
            }
            // Check if any cities were found
            if (cities.isEmpty()) {
                System.out.println("No cities found for region: " + region);
            } else {
                // Print the top N populated cities in the region
                printCities(cities);
            }
            // Return the list of top populated cities in the specified region
            return cities;
        } catch (Exception e) {
            // Print error messages in case of an exception
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated cities in the region");
            return new ArrayList<>();
        }
    }

    /**
     * Displays the top N populated cities in a country based on population in descending order.
     *
     * @param topN    The number of top populated cities to display.
     * @param country The country to filter cities.
     * @return An ArrayList of City objects representing the top populated cities in the specified country.
     */
    public ArrayList<City> displayTopPopulatedCitiesInCountry(int topN, String country) {
        // Check if topN is non-positive
        if (topN < 0) {
            System.out.println("Invalid input: topN should be a positive integer.");
            return new ArrayList<>(); // Return an empty list
        }
        if (country == null) {
            System.out.println("Country cannot be null");
            return null;
        }
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name AS cityName, country.Name AS countryName, city.District, city.Population " +
                            "FROM city " +
                            "JOIN country ON city.CountryCode = country.Code " +
                            "WHERE country.Name = '" + country + "' " +
                            "ORDER BY city.Population DESC " +
                            "LIMIT " + topN;

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                // Create a new City object
                City city = new City();
                // Set city attributes from the result set
                city.setId(rset.getInt("ID"));
                city.setName(rset.getString("cityName"));
                city.setCountryCode(rset.getString("countryName"));
                city.setDistrict(rset.getString("District"));
                city.setPopulation(rset.getLong("Population"));
                // Add the City object to the ArrayList
                cities.add(city);
            }
            // Check if any cities were found
            if (cities.isEmpty()) {
                System.out.println("No cities found for country: " + country);
            } else {
                // Print the top N populated cities in the country
                printCities(cities);
            }
            // Return the list of top populated cities in the specified country
            return cities;
        } catch (Exception e) {
            // Print error messages in case of an exception
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated cities in the country");
            return new ArrayList<>();
        }
    }

    /**
     * Displays the top N populated cities in a district based on population in descending order.
     *
     * @param topN     The number of top populated cities to display.
     * @param district The district to filter cities.
     * @return An ArrayList of City objects representing the top populated cities in the specified district.
     */
    public ArrayList<City> displayTopPopulatedCitiesInDistrict(int topN, String district) {
        // Check if topN is non-positive
        if (topN < 0) {
            System.out.println("Invalid input: topN should be a positive integer.");
            return new ArrayList<>(); // Return an empty list
        }
        if (district == null) {
            System.out.println("District cannot be null");
            return null;
        }
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name AS cityName, country.Name AS countryName, city.District, city.Population " +
                            "FROM city " +
                            "JOIN country ON city.CountryCode = country.Code " +
                            "WHERE city.District = '" + district + "' " +
                            "ORDER BY city.Population DESC " +
                            "LIMIT " + topN;

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                // Create a new City object
                City city = new City();
                // Set city attributes from the result set
                city.setId(rset.getInt("ID"));
                city.setName(rset.getString("cityName"));
                city.setCountryCode(rset.getString("countryName"));
                city.setDistrict(rset.getString("District"));
                city.setPopulation(rset.getLong("Population"));
                // Add the City object to the ArrayList
                cities.add(city);
            }
            // Check if any cities were found
            if (cities.isEmpty()) {
                System.out.println("No cities found for district: " + district);
            } else {
                // Print the top N populated cities in the district
                printCities(cities);
            }
            // Return the list of top populated cities in the specified district
            return cities;
        } catch (Exception e) {
            // Print error messages in case of an exception
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated cities in the district");
            return new ArrayList<>();
        }
    }

    /**
     * Retrieves all the capital cities in the world organized by the largest population to smallest.
     *
     * @return An ArrayList of Capital objects representing the capital cities.
     *         Returns empty array list in case of an exception or failure.
     * @throws SQLException If a database access error occurs.
     */
    public ArrayList<Capital> getAllCapitalCities() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT ci.ID, ci.name AS cityName, c.name AS countryName, ci.population " +
                            "FROM country c " +
                            "LEFT JOIN city ci ON c.capital = ci.id " +
                            "ORDER BY ci.population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract capital city information
            ArrayList<Capital> capitals = new ArrayList<>();
            while (rset.next()) {
                // Create a new Capital object
                Capital capital = new Capital();
                // Set capital attributes from the result set
                capital.setId(rset.getInt("ID"));
                capital.setName(rset.getString("cityName"));
                capital.setCountryName(rset.getString("countryName"));
                capital.setPopulation(rset.getLong("population"));
                // Add the Capital object to the ArrayList
                capitals.add(capital);
            }
            // Check if any capitals were found
            if (capitals.isEmpty()) {
                System.out.println("No capital cities found");
            }
            // Return the list of capital cities
            return capitals;
        } catch (Exception e) {
            // Print error messages in case of an exception
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital city details");
            // Return an empty list in case of an exception
            return new ArrayList<>();
        }
    }

    /**
     * Retrieves a list of capital cities based on the specified continent, ordered by
     * population in descending order.
     *
     * @param continent The continent to filter capital cities.
     * @return An ArrayList of Capital objects representing capital cities in the specified
     *         continent, ordered by population in descending order.
     */
    public ArrayList<Capital> capitalCitiesByContinent(String continent) {
        try {
            if (continent == null) {
                System.out.println("Continent cannot be null");
                return null;
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT ci.ID, ci.name AS cityName, c.name AS countryName, ci.population " +
                            "FROM country c " +
                            "LEFT JOIN city ci ON c.capital = ci.id " +
                            "WHERE c.continent = '" + continent + "' " +
                            "ORDER BY ci.population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract capital city information
            ArrayList<Capital> capitals = new ArrayList<>();
            while (rset.next()) {
                // Create a new Capital object
                Capital capital = new Capital();
                // Set capital attributes from the result set
                capital.setId(rset.getInt("ID"));
                capital.setName(rset.getString("cityName"));
                capital.setCountryName(rset.getString("countryName"));
                capital.setPopulation(rset.getLong("population"));
                // Add the Capital object to the ArrayList
                capitals.add(capital);
            }
            // Check if any capital cities were found for the given continent
            if (capitals.isEmpty()) {
                System.out.println("No capital cities found for continent: " + continent);
            }
            // Return the list of capital cities
            return capitals;
        } catch (Exception e) {
            // Print error messages in case of an exception
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital city details by continent");
            return new ArrayList<>();
        }
    }

    /**
     * Retrieves a list of capital cities based on the specified region, ordered by
     * population in descending order.
     *
     * @param region The region to filter capital cities.
     * @return An ArrayList of Capital objects representing capital cities in the specified
     *         region, ordered by population in descending order.
     */
    public ArrayList<Capital> capitalCitiesByRegion(String region) {
        try {
            if (region == null) {
                System.out.println("Region cannot be null");
                return null;
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT ci.ID, ci.name AS cityName, c.name AS countryName, ci.population " +
                            "FROM country c " +
                            "LEFT JOIN city ci ON c.capital = ci.id " +
                            "WHERE c.region = '" + region + "' " +
                            "ORDER BY ci.population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract capital city information
            ArrayList<Capital> capitals = new ArrayList<>();
            while (rset.next()) {
                // Create a new Capital object
                Capital capital = new Capital();
                // Set capital attributes from the result set
                capital.setId(rset.getInt("ID"));
                capital.setName(rset.getString("cityName"));
                capital.setCountryName(rset.getString("countryName"));
                capital.setPopulation(rset.getLong("population"));
                // Add the Capital object to the ArrayList
                capitals.add(capital);
            }
            // Check if any capital cities were found for the given region
            if (capitals.isEmpty()) {
                System.out.println("No capital cities found for region: " + region);
            }
            // Return the list of capital cities
            return capitals;
        } catch (Exception e) {
            // Print error messages in case of an exception
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital city details by region");
            return new ArrayList<>();
        }
    }

    /**
     * Displays the top N populated capital cities in the world based on population in descending order.
     *
     * @param topN The number of top populated capital cities to display.
     */
    public ArrayList<Capital> displayTopPopulatedCapitalCitiesInWorld(int topN) {
        // Check if topN is non-positive
        if (topN < 0) {
            System.out.println("Invalid input: topN should be a positive integer.");
            return new ArrayList<>();
        }
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT ci.ID, ci.name AS cityName, c.name AS countryName, ci.population " +
                            "FROM country c " +
                            "LEFT JOIN city ci ON c.capital = ci.id " +
                            "ORDER BY ci.population DESC " +
                            "LIMIT " + topN;

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract capital city information
            ArrayList<Capital> capitals = new ArrayList<>();
            while (rset.next()) {
                // Create a new Capital object
                Capital capital = new Capital();
                // Set capital attributes from the result set
                capital.setId(rset.getInt("ID"));
                capital.setName(rset.getString("cityName"));
                capital.setCountryName(rset.getString("countryName"));
                capital.setPopulation(rset.getLong("population"));
                // Add the Capital object to the ArrayList
                capitals.add(capital);
            }

            // Check if any capital cities were found
            if (capitals.isEmpty()) {
                System.out.println("No capital cities found");
            } else {
                // Print the top N populated capital cities in the world
                printCapitalCities(capitals);
            }
            return capitals;
        } catch (Exception e) {
            // Print error messages in case of an exception
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated capital cities in the world");
            return new ArrayList<>();
        }
    }

    /**
     * Displays the top N populated capital cities in a continent based on population in descending order.
     *
     * @param topN      The number of top populated capital cities to display.
     * @param continent The continent to filter capital cities.
     */
    public ArrayList<Capital> displayTopPopulatedCapitalCitiesInContinent(int topN, String continent) {
        // Check if topN is non-positive
        if (topN < 0) {
            System.out.println("Invalid input: topN should be a positive integer.");
            return new ArrayList<>();
        }
        try {
            if (continent == null) {
                System.out.println("Continent cannot be null");
                return null;
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT ci.ID, ci.name AS cityName, c.name AS countryName, ci.population " +
                            "FROM country c " +
                            "LEFT JOIN city ci ON c.capital = ci.id " +
                            "WHERE c.continent = '" + continent + "' " +
                            "ORDER BY ci.population DESC " +
                            "LIMIT " + topN;

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract capital city information
            ArrayList<Capital> capitals = new ArrayList<>();
            while (rset.next()) {
                // Create a new Capital object
                Capital capital = new Capital();
                // Set capital attributes from the result set
                capital.setId(rset.getInt("ID"));
                capital.setName(rset.getString("cityName"));
                capital.setCountryName(rset.getString("countryName"));
                capital.setPopulation(rset.getLong("population"));
                // Add the Capital object to the ArrayList
                capitals.add(capital);
            }

            // Check if any capital cities were found for the given continent
            if (capitals.isEmpty()) {
                System.out.println("No capital cities found for Top: " + topN + " in continent: " + continent);
            } else {
                // Print the top N populated capital cities in the continent
                printCapitalCities(capitals);
            }
            return capitals;
        } catch (Exception e) {
            // Print error messages in case of an exception
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated capital cities in the continent");
            return new ArrayList<>();
        }
    }

    /**
     * Displays the top N populated capital cities in a region based on population in descending order.
     *
     * @param topN   The number of top populated capital cities to display.
     * @param region The region to filter capital cities.
     */
    public ArrayList<Capital> displayTopPopulatedCapitalCitiesInRegion(int topN, String region) {
        // Check if topN is non-positive
        if (topN < 0) {
            System.out.println("Invalid input: topN should be a positive integer.");
            return new ArrayList<>();
        }
        try {
            if (region == null) {
                System.out.println("Region cannot be null");
                return null;
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT ci.ID, ci.name AS cityName, c.name AS countryName, ci.population " +
                            "FROM country c " +
                            "LEFT JOIN city ci ON c.capital = ci.id " +
                            "WHERE c.region = '" + region + "' " +
                            "ORDER BY ci.population DESC " +
                            "LIMIT " + topN;

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract capital city information
            ArrayList<Capital> capitals = new ArrayList<>();
            while (rset.next()) {
                // Create a new Capital object
                Capital capital = new Capital();
                // Set capital attributes from the result set
                capital.setId(rset.getInt("ID"));
                capital.setName(rset.getString("cityName"));
                capital.setCountryName(rset.getString("countryName"));
                capital.setPopulation(rset.getLong("population"));
                // Add the Capital object to the ArrayList
                capitals.add(capital);
            }

            // Check if any capital cities were found for the given region
            if (capitals.isEmpty()) {
                System.out.println("No capital cities found for region: " + region);
            } else {
                // Print the top N populated capital cities in the region
                printCapitalCities(capitals);
            }
            return capitals;
        } catch (Exception e) {
            // Print error messages in case of an exception
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated capital cities in the region");
            return new ArrayList<>();
        }
    }

    /**
     * Displays the population of people, people living in cities, and people not
     * living in cities in each continent.
     */
    public void displayPopulationDetailsByContinent() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT continent, " +
                            "SUM(country.population) AS totalPopulation, " +
                            "SUM(city_populations.population_in_cities) AS populationInCities " +
                            "FROM country " +
                            "LEFT JOIN ( " +
                            "    SELECT CountryCode, SUM(Population) AS population_in_cities " +
                            "    FROM city " +
                            "    GROUP BY CountryCode " +
                            ") AS city_populations ON country.Code = city_populations.CountryCode " +
                            "GROUP BY continent " +
                            "ORDER BY continent ASC"; // Add ORDER BY clause

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Print header
            System.out.println(String.format("%-20s %-20s %-20s %-35s %-35s %-35s",
                    "Continent", "Total Population", "Population in Cities", "Population In Cities Percentage", "Population Not in Cities", "Population Not In Cities Percentage"));

            // Loop over the results
            while (rset.next()) {
                String continent = rset.getString("continent");
                long totalPopulation = rset.getLong("totalPopulation");
                long populationInCities = rset.getLong("populationInCities");
                long populationNotInCities = totalPopulation - populationInCities;

                // Calculate percentages, handling division by zero
                double populationInCitiesPercentage = (totalPopulation == 0) ? 0 : (double) populationInCities / totalPopulation * 100;
                double populationNotInCitiesPercentage = (totalPopulation == 0) ? 0 : (double) populationNotInCities / totalPopulation * 100;

                // Format numbers with commas
                String formattedTotalPopulation = String.format("%,d", totalPopulation);
                String formattedPopulationInCities = String.format("%,d", populationInCities);
                String formattedPopulationNotInCities = String.format("%,d", populationNotInCities);

                // Format percentages with two decimal places
                String formattedPopulationInCitiesPercentage = String.format("%.2f%%", populationInCitiesPercentage);
                String formattedPopulationNotInCitiesPercentage = String.format("%.2f%%", populationNotInCitiesPercentage);

                // Print the details with % sign and formatted numbers
                System.out.println(String.format("%-20s %-20s %-20s %-35s %-35s %-35s",
                        continent, formattedTotalPopulation, formattedPopulationInCities, formattedPopulationInCitiesPercentage,
                        formattedPopulationNotInCities, formattedPopulationNotInCitiesPercentage));
            }

        } catch (Exception e) {
            // Print error messages in case of an exception
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details by continent");
        }
    }

    /**
     * Displays the population of people, people living in cities, and people not living in cities in each region.
     */
    public void displayPopulationDetailsByRegion() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT region, " +
                            "SUM(country.population) AS totalPopulation, " +
                            "SUM(city_populations.population_in_cities) AS populationInCities " +
                            "FROM country " +
                            "LEFT JOIN ( " +
                            "    SELECT CountryCode, SUM(Population) AS population_in_cities " +
                            "    FROM city " +
                            "    GROUP BY CountryCode " +
                            ") AS city_populations ON country.Code = city_populations.CountryCode " +
                            "GROUP BY region " +
                            "ORDER BY region ASC"; // Add ORDER BY clause

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Print header
            System.out.println(String.format("%-30s %-20s %-20s %-35s %-35s %-35s",
                    "Region", "Total Population", "Population in Cities", "Population In Cities Percentage", "Population Not in Cities", "Population Not In Cities Percentage"));

            // Loop over the results
            while (rset.next()) {
                String region = rset.getString("region");
                long totalPopulation = rset.getLong("totalPopulation");
                long populationInCities = rset.getLong("populationInCities");
                long populationNotInCities = totalPopulation - populationInCities;

                // Calculate percentages, handling division by zero
                double populationInCitiesPercentage = (totalPopulation == 0) ? 0 : (double) populationInCities / totalPopulation * 100;
                double populationNotInCitiesPercentage = (totalPopulation == 0) ? 0 : (double) populationNotInCities / totalPopulation * 100;

                // Format numbers with commas
                String formattedTotalPopulation = String.format("%,d", totalPopulation);
                String formattedPopulationInCities = String.format("%,d", populationInCities);
                String formattedPopulationNotInCities = String.format("%,d", populationNotInCities);

                // Format percentages with two decimal places
                String formattedPopulationInCitiesPercentage = String.format("%.2f%%", populationInCitiesPercentage);
                String formattedPopulationNotInCitiesPercentage = String.format("%.2f%%", populationNotInCitiesPercentage);

                // Print the details with % sign and formatted numbers
                System.out.println(String.format("%-30s %-20s %-20s %-35s %-35s %-35s",
                        region, formattedTotalPopulation, formattedPopulationInCities, formattedPopulationInCitiesPercentage,
                        formattedPopulationNotInCities, formattedPopulationNotInCitiesPercentage));
            }

        } catch (Exception e) {
            // Print error messages in case of an exception
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details by region");
        }
    }

    /**
     * Displays the population details of people, people living in cities, and people not
     * living in cities in each country.
     */
    public void displayPopulationDetailsByCountry() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Name AS countryName, " +
                            "SUM(country.population) AS totalPopulation, " +
                            "SUM(city_populations.population_in_cities) AS populationInCities " +
                            "FROM country " +
                            "LEFT JOIN ( " +
                            "    SELECT CountryCode, SUM(Population) AS population_in_cities " +
                            "    FROM city " +
                            "    GROUP BY CountryCode " +
                            ") AS city_populations ON country.Code = city_populations.CountryCode " +
                            "GROUP BY countryName " +
                            "ORDER BY countryName ASC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Print header
            System.out.println(String.format("%-45s %-20s %-20s %-35s %-35s",
                    "Country", "Total Population", "Population in Cities", "Population In Cities Percentage", "Population Not in Cities Percentage"));

            // Loop over the results
            while (rset.next()) {
                String countryName = rset.getString("countryName");
                long totalPopulation = rset.getLong("totalPopulation");
                long populationInCities = rset.getLong("populationInCities");
                long populationNotInCities = totalPopulation - populationInCities;

                // Calculate percentages, handling division by zero
                double populationInCitiesPercentage = (totalPopulation == 0) ? 0 : (double) populationInCities / totalPopulation * 100;
                double populationNotInCitiesPercentage = (totalPopulation == 0) ? 0 : (double) populationNotInCities / totalPopulation * 100;

                // Format numbers with commas
                String formattedTotalPopulation = String.format("%,d", totalPopulation);
                String formattedPopulationInCities = String.format("%,d", populationInCities);
                String formattedPopulationNotInCities = String.format("%,d", populationNotInCities);

                // Format percentages with two decimal places
                String formattedPopulationInCitiesPercentage = String.format("%.2f%%", populationInCitiesPercentage);
                String formattedPopulationNotInCitiesPercentage = String.format("%.2f%%", populationNotInCitiesPercentage);

                // Print the details with % sign and formatted numbers
                System.out.println(String.format("%-45s %-20s %-20s %-35s %-35s",
                        countryName, formattedTotalPopulation, formattedPopulationInCities, formattedPopulationInCitiesPercentage,
                        formattedPopulationNotInCitiesPercentage));
            }

        } catch (Exception e) {
            // Print error messages in case of an exception
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details by country");
        }
    }


    /**
     * Displays the population of the world.
     */
    public long displayWorldPopulation() {
        long worldPopulation = 0;
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(population) AS worldPopulation " +
                            "FROM country";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Loop over the results
            if (rset.next()) {
                worldPopulation = rset.getLong("worldPopulation");

                // Format numbers with commas
                String formattedWorldPopulation = String.format("%,d", worldPopulation);

                // Print the details
                System.out.println(String.format("%-20s",
                        formattedWorldPopulation));
            }

        } catch (Exception e) {
            // Print error messages in case of an exception
            System.out.println(e.getMessage());
            System.out.println("Failed to get world population details");
        }
        return worldPopulation;
    }

    /**
     * Displays the population of a continent.
     *
     * @param continent The continent for which to display the population.
     */
    public long displayContinentPopulation(String continent) {
        long continentPopulation = 0;
        try {
            if (continent == null) {
                System.out.println("Region cannot be null");
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(population) AS continentPopulation " +
                            "FROM country " +
                            "WHERE continent = '" + continent + "'";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Loop over the results
            if (rset.next()) {
                continentPopulation = rset.getLong("continentPopulation");

                // Format numbers with commas
                String formattedContinentPopulation = String.format("%,d", continentPopulation);

                // Print the details
                System.out.println(String.format("%-20s",
                        formattedContinentPopulation));
            }

        } catch (Exception e) {
            // Print error messages in case of an exception
            System.out.println(e.getMessage());
            System.out.println("Failed to get continent population details");
        }
        return continentPopulation;
    }

    /**
     * Displays the population of a region.
     *
     * @param region The region for which to display the population.
     */
    public long displayRegionPopulation(String region) {
        long regionPopulation = 0;
        try {
            if (region == null) {
                System.out.println("Region cannot be null");
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(population) AS regionPopulation " +
                            "FROM country " +
                            "WHERE region = '" + region + "'";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);


            // Loop over the results
            if (rset.next()) {
                regionPopulation = rset.getLong("regionPopulation");

                // Format numbers with commas
                String formattedRegionPopulation = String.format("%,d", regionPopulation);

                // Print the details
                System.out.println(String.format("%-20s",
                        formattedRegionPopulation));
            }

        } catch (Exception e) {
            // Print error messages in case of an exception
            System.out.println(e.getMessage());
            System.out.println("Failed to get region population details");
        }
        return regionPopulation;
    }

    /**
     * Displays the population of a country.
     *
     * @param country The country for which to display the population.
     */
    public long displayCountryPopulation(String country) {
        long countryPopulation = 0;
        try {
            if (country == null) {
                System.out.println("Region cannot be null");
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT population " +
                            "FROM country " +
                            "WHERE name = '" + country + "'";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);


            // Loop over the results
            if (rset.next()) {
                countryPopulation = rset.getLong("population");

                // Format numbers with commas
                String formattedCountryPopulation = String.format("%,d", countryPopulation);

                // Print the details
                System.out.println(String.format("%-20s",
                        formattedCountryPopulation));
            }

        } catch (Exception e) {
            // Print error messages in case of an exception
            System.out.println(e.getMessage());
            System.out.println("Failed to get country population details");
        }
        return countryPopulation;
    }

    /**
     * Displays the population of a district.
     *
     * @param district The district for which to display the population.
     */
    public long displayDistrictPopulation(String district) {
        long districtPopulation = 0;
        try {
            if (district == null) {
                System.out.println("Region cannot be null");
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(population) AS districtPopulation " +
                            "FROM city " +
                            "WHERE district = '" + district + "'";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);


            // Loop over the results
            if (rset.next()) {
                districtPopulation = rset.getLong("districtPopulation");

                // Format numbers with commas
                String formattedDistrictPopulation = String.format("%,d", districtPopulation);

                // Print the details
                System.out.println(String.format("%-20s",
                        formattedDistrictPopulation));
            }

        } catch (Exception e) {
            // Print error messages in case of an exception
            System.out.println(e.getMessage());
            System.out.println("Failed to get district population details");
        }
        return districtPopulation;
    }





}