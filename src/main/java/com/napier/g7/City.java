/**
 * @author Htoo Myat Linn, Kyaw Ko Ko San, Bhone Myat, Wai Yan Moe, Zayar Phyo, Pyae Sone
 * @version 0.1-alpha-3
 * @since 2024-01-23
 */
package com.napier.g7;

/**
 * Represents a city with various attributes such as ID, name, country code, etc.
 */
public class City {

    // City ID.
    private int id;

    // City name.
    private String name;

    // Country code to which the city belongs.
    private String countryCode;

    // District or region where the city is located.
    private String district;

    // Population of the city.
    private int population;

    /**
     * Get the city ID.
     *
     * @return The city ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the city ID.
     *
     * @param id The city ID to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the city name.
     *
     * @return The city name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the city name.
     *
     * @param name The city name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the country code to which the city belongs.
     *
     * @return The country code.
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Set the country code to which the city belongs.
     *
     * @param countryCode The country code to set.
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * Get the district or region where the city is located.
     *
     * @return The district or region.
     */
    public String getDistrict() {
        return district;
    }

    /**
     * Set the district or region where the city is located.
     *
     * @param district The district or region to set.
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * Get the population of the city.
     *
     * @return The population of the city.
     */
    public int getPopulation() {
        return population;
    }

    /**
     * Set the population of the city.
     *
     * @param population The population to set.
     */
    public void setPopulation(int population) {
        this.population = population;
    }
}

