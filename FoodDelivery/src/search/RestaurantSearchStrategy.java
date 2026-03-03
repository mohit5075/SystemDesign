package search;

import models.Restaurant;

import java.util.List;

public interface RestaurantSearchStrategy {
    List<Restaurant> search(List<Restaurant> restaurants);
}
