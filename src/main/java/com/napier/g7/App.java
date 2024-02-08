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
}