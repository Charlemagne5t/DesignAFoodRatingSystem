import java.util.*;

public class FoodRatings {
    Map<String, PriorityQueue<String>> cuisinesPq = new HashMap<>();
    Map<String, CuisineAndRating> foodsCuisine = new HashMap<>();


    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            foodsCuisine.put(foods[i], new CuisineAndRating(cuisines[i], ratings[i]));
            PriorityQueue<String> pq = cuisinesPq.getOrDefault(cuisines[i],
                    new PriorityQueue<>(Comparator.comparingInt((String food) -> -foodsCuisine.get(food).rating).thenComparing(Comparator.naturalOrder())));
            pq.offer(foods[i]);
            cuisinesPq.put(cuisines[i], pq);
        }
    }

    public void changeRating(String food, int newRating) {
        CuisineAndRating cr = foodsCuisine.get(food);
        foodsCuisine.remove(cr);
        String cuisine = cr.cuisine;
        foodsCuisine.put(food, new CuisineAndRating(cr.cuisine, newRating));
        cuisinesPq.get(cuisine).remove(food);
        cuisinesPq.get(cuisine).add(food);
    }

    public String highestRated(String cuisine) {
        return cuisinesPq.get(cuisine).peek();
    }
}
class CuisineAndRating{
    String cuisine;
    int rating;

    public CuisineAndRating(String cuisine, int rating) {
        this.cuisine = cuisine;
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CuisineAndRating that = (CuisineAndRating) o;

        if (rating != that.rating) return false;
        return Objects.equals(cuisine, that.cuisine);
    }

    @Override
    public int hashCode() {
        int result = cuisine != null ? cuisine.hashCode() : 0;
        result = 31 * result + rating;
        return result;
    }
}
