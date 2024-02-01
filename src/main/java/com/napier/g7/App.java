package com.napier.g7;
import java.sql.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

// Class declaration for the main application
public class App
{
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();
        String targetContinent = "Asia";  // Replace "Asia" with the desired continent


        // Extract country population information
        ArrayList<Country> countries = a.getAllCountries();
        System.out.println("\n**********Countries********\n");
        // Print the count of countries
        System.out.println("Number of countries: " + countries.size()+"\n");
        a.printCountries(countries);

        // Get all countries in the specified continent
        ArrayList<Country> countriesByContinent = a.countriesByContinent(targetContinent);
        System.out.println("\n**********Countries in " + targetContinent + "********\n");
        // Print the count of countries
        System.out.println("Number of countries: " + countriesByContinent.size()+"\n");
        a.printCountries(countriesByContinent);


        // Disconnect from database
        a.disconnect();
    }

    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
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
        // Print header
        System.out.println(String.format("%-5s %-50s %-15s %-40s %-15s %-10s",
                "Code", "Name", "Continent", "Region", "Population", "Capital"));

        // Loop over all countries in the list
        for (Country country : countries) {
            // Format population with commas
            NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
            String formattedPopulation = numberFormat.format(country.getPopulation());
            String countryString = String.format("%-5s %-50s %-15s %-40s %-15s %-10s",
                    country.getCode(), country.getName(), country.getContinent(),
                    country.getRegion(), formattedPopulation, country.getCapital());
            System.out.println(countryString);
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
                    "SELECT code, name, continent, region, surfaceArea, indepYear, " +
                            "population, lifeExpectancy, gnp, gnpOld, localName, " +
                            "governmentForm, headOfState, capital " +
                            "FROM country " +
                            "ORDER BY population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract country information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                Country country = new Country();
                country.setCode(rset.getString("code"));
                country.setName(rset.getString("name"));
                country.setContinent(rset.getString("continent"));
                country.setRegion(rset.getString("region"));
                country.setSurfaceArea(rset.getFloat("surfaceArea"));
                country.setIndepYear(rset.getInt("indepYear"));
                country.setPopulation(rset.getInt("population"));
                country.setLifeExpectancy(rset.getFloat("lifeExpectancy"));
                country.setGnp(rset.getFloat("gnp"));
                country.setGnpOld(rset.getFloat("gnpOld"));
                country.setLocalName(rset.getString("localName"));
                country.setGovernmentForm(rset.getString("governmentForm"));
                country.setHeadOfState(rset.getString("headOfState"));
                country.setCapital(rset.getInt("capital"));

                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
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
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT code, name, continent, region, surfaceArea, indepYear, " +
                            "population, lifeExpectancy, gnp, gnpOld, localName, " +
                            "governmentForm, headOfState, capital " +
                            "FROM country " +
                            "WHERE continent = '" + continent + "' " +
                            "ORDER BY population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract country information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                Country country = new Country();
                country.setCode(rset.getString("code"));
                country.setName(rset.getString("name"));
                country.setContinent(rset.getString("continent"));
                country.setRegion(rset.getString("region"));
                country.setSurfaceArea(rset.getFloat("surfaceArea"));
                country.setIndepYear(rset.getInt("indepYear"));
                country.setPopulation(rset.getInt("population"));
                country.setLifeExpectancy(rset.getFloat("lifeExpectancy"));
                country.setGnp(rset.getFloat("gnp"));
                country.setGnpOld(rset.getFloat("gnpOld"));
                country.setLocalName(rset.getString("localName"));
                country.setGovernmentForm(rset.getString("governmentForm"));
                country.setHeadOfState(rset.getString("headOfState"));
                country.setCapital(rset.getInt("capital"));

                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details by continent");
            return null;
        }
    }


}