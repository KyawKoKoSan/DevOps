/**
 * @author Htoo Myat Linn, Kyaw Ko Ko San, Bhone Myat, Wai Yan Moe, Zayar Phyo, Pyae Sone
 * @version 0.1-alpha-3
 * @since 2024-01-23
 */
package com.napier.g7;

/**
 * Represents a country with various attributes such as code, name, continent, etc.
 */
public class Country {

    // Country code.
    private String code;

    // Country name.
    private String name;

    // Continent to which the country belongs.
    private String continent;

    // Region or subcontinent.
    private String region;

    // Total land area of the country.
    private float surfaceArea;

    // Year when the country gained independence.
    private Integer indepYear;

    // Population of the country.
    private int population;

    // Average life expectancy in the country.
    private Float lifeExpectancy;

    // Gross National Product.
    private float gnp;

    // Old Gross National Product.
    private Float gnpOld;

    // Local name of the country.
    private String localName;

    // Form of government.
    private String governmentForm;

    // Head of state.
    private String headOfState;

    // Capital city (assuming it is an ID referencing the city).
    private int capital;

    /**
     * Get the country code.
     *
     * @return The country code.
     */
    public String getCode() {
        return code;
    }

    /**
     * Set the country code.
     *
     * @param code The country code to set.
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Get the country name.
     *
     * @return The country name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the country name.
     *
     * @param name The country name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the continent to which the country belongs.
     *
     * @return The continent of the country.
     */
    public String getContinent() {
        return continent;
    }

    /**
     * Set the continent to which the country belongs.
     *
     * @param continent The continent to set.
     */
    public void setContinent(String continent) {
        this.continent = continent;
    }

    /**
     * Get the region or subcontinent of the country.
     *
     * @return The region or subcontinent.
     */
    public String getRegion() {
        return region;
    }

    /**
     * Set the region or subcontinent of the country.
     *
     * @param region The region or subcontinent to set.
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Get the total land area of the country.
     *
     * @return The surface area of the country.
     */
    public float getSurfaceArea() {
        return surfaceArea;
    }

    /**
     * Set the total land area of the country.
     *
     * @param surfaceArea The surface area to set.
     */
    public void setSurfaceArea(float surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    /**
     * Get the year when the country gained independence.
     *
     * @return The year of independence.
     */
    public Integer getIndepYear() {
        return indepYear;
    }

    /**
     * Set the year when the country gained independence.
     *
     * @param indepYear The year of independence to set.
     */
    public void setIndepYear(Integer indepYear) {
        this.indepYear = indepYear;
    }

    /**
     * Get the population of the country.
     *
     * @return The population of the country.
     */
    public int getPopulation() {
        return population;
    }

    /**
     * Set the population of the country.
     *
     * @param population The population to set.
     */
    public void setPopulation(int population) {
        this.population = population;
    }

    /**
     * Get the average life expectancy in the country.
     *
     * @return The average life expectancy.
     */
    public Float getLifeExpectancy() {
        return lifeExpectancy;
    }

    /**
     * Set the average life expectancy in the country.
     *
     * @param lifeExpectancy The average life expectancy to set.
     */
    public void setLifeExpectancy(Float lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    /**
     * Get the Gross National Product of the country.
     *
     * @return The Gross National Product.
     */
    public float getGnp() {
        return gnp;
    }

    /**
     * Set the Gross National Product of the country.
     *
     * @param gnp The Gross National Product to set.
     */
    public void setGnp(float gnp) {
        this.gnp = gnp;
    }

    /**
     * Get the Old Gross National Product of the country.
     *
     * @return The Old Gross National Product.
     */
    public Float getGnpOld() {
        return gnpOld;
    }

    /**
     * Set the Old Gross National Product of the country.
     *
     * @param gnpOld The Old Gross National Product to set.
     */
    public void setGnpOld(Float gnpOld) {
        this.gnpOld = gnpOld;
    }

    /**
     * Get the local name of the country.
     *
     * @return The local name of the country.
     */
    public String getLocalName() {
        return localName;
    }

    /**
     * Set the local name of the country.
     *
     * @param localName The local name to set.
     */
    public void setLocalName(String localName) {
        this.localName = localName;
    }

    /**
     * Get the form of government.
     *
     * @return The form of government.
     */
    public String getGovernmentForm() {
        return governmentForm;
    }

    /**
     * Set the form of government.
     *
     * @param governmentForm The form of government to set.
     */
    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }

    /**
     * Get the head of state.
     *
     * @return The head of state.
     */
    public String getHeadOfState() {
        return headOfState;
    }

    /**
     * Set the head of state.
     *
     * @param headOfState The head of state to set.
     */
    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }

    /**
     * Get the ID of the capital city.
     *
     * @return The ID of the capital city.
     */
    public int getCapital() {
        return capital;
    }

    /**
     * Set the ID of the capital city.
     *
     * @param capital The ID of the capital city to set.
     */
    public void setCapital(int capital) {
        this.capital = capital;
    }
}
