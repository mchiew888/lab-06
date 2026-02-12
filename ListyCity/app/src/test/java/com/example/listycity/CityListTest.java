package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }
    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Calgary", "Alberta");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Winnipeg", "Manitoba");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
// This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
// is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
// This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
// Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        City city = new City("Red Deer", "AB");
        cityList.add(city);
        assertTrue(cityList.hasCity(city));
    }

    @Test
    void testDeleteCity() {
        CityList cityList = mockCityList();
        City city = new City("Red Deer", "AB");
        cityList.add(city);
        cityList.deleteCity(city);
        assertEquals(0, cityList.countCities());
    }

    @Test
    void testDeleteCityException() {
        CityList cityList = mockCityList();
        City city = new City("Red Deer", "AB");
        City city1 = new City("New York", "NY");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.deleteCity(city1);
        });
    }

    @Test
    void testCountCities() {
        CityList cityList = mockCityList();
        City city = new City("Red Deer", "AB");
        City city1 = new City("New York", "NY");
        cityList.add(city);
        cityList.add(city1);
        assertEquals(2, cityList.countCities());
    }
}