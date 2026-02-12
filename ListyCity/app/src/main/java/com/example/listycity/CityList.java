package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This returns a boolean (false if it doesn't have the city, true if it does have the city)
     * @param city
     *      This is a city we want to check if it's in the list
     * @return
     * Return boolean
     */
    public boolean hasCity(City city) {
        for (City c : cities) {
            if (c.equals(city)) {
                return c.equals(city);
            }
        }
        return false;
    }
    /**
     * This removes a city from the list
     * @param city
     *      This is a city we want to remove from the list
     */
    public void deleteCity(City city) {
        if (hasCity(city)) {
            cities.remove(city);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This returns how many cities are in the list
     * @return int
     *      This is the number of cities in the list
     */
    public int countCities() {
        return cities.size();
    }
}
