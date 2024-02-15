package com.napier.g7;


/**
 * Represents a capital city with various attributes such as ID, name, country code, etc.
 */
public class Capital {

    // Capital ID.
    private int id;

    // Capital name.
    private String name;

    // Country code to which the capital belongs.
    private String countryCode;

    // District or region where the capital is located.
    private String district;

    // Population of the capital.
    private long population;

    // New attribute for country name
    private String countryName;

    /**
     * Get the capital ID.
     *
     * @return The capital ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the capital ID.
     *
     * @param id The capital ID to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the capital name.
     *
     * @return The capital name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the capital name.
     *
     * @param name The capital name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the country code to which the capital belongs.
     *
     * @return The country code.
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Set the country code to which the capital belongs.
     *
     * @param countryCode The country code to set.
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * Get the district or region where the capital is located.
     *
     * @return The district or region.
     */
    public String getDistrict() {
        return district;
    }

    /**
     * Set the district or region where the capital is located.
     *
     * @param district The district or region to set.
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * Get the population of the capital.
     *
     * @return The population of the capital.
     */
    public long getPopulation() {
        return population;
    }

    /**
     * Set the population of the capital.
     *
     * @param population The population to set.
     */
    public void setPopulation(long population) {
        this.population = population;
    }

    /**
     * Get the country name to which the capital city belongs.
     *
     * @return The country name.
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Set the country name to which the capital city belongs.
     *
     * @param countryName The country name to set.
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}

