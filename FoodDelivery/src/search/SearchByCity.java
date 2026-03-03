package search;

import models.Restaurant;

import java.util.List;

public class SearchByCity implements RestaurantSearchStrategy{
    private String city;
    public SearchByCity(String city) {
        this.city = city;
    }
    @Override
    public List<Restaurant> search(List<Restaurant> restaurants) {
        return restaurants.stream().filter(res->res.getAddress().getCity().equalsIgnoreCase(city)).toList();
    }
}
