import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FoodRatings {
    Map<String, Integer> foodToRating;
    Map<String, String> foodToCuisine;
    Map<String, PriorityQueue<Food>> cuisineToPQ;


    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToRating = new HashMap<>();
        foodToCuisine = new HashMap<>();
        cuisineToPQ = new HashMap<>();

        for(int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodToRating.put(food, rating);
            foodToCuisine.put(food, cuisine);

            cuisineToPQ.putIfAbsent(cuisine, new PriorityQueue<>( (a, b) -> {
                if (b.rating != a.rating) {
                    return b.rating - a.rating; // Higher rating first
                } else {
                    return a.name.compareTo(b.name); // Lexicographically smaller first
                }
            }));
            cuisineToPQ.get(cuisine).offer(new Food(food, rating));
        }
    }
    public void changeRating(String food, int newRating) {
        foodToRating.put(food, newRating);
        String cuisine = foodToCuisine.get(food);
        cuisineToPQ.get(cuisine).offer(new Food(food, newRating));
    }

    public String highestRated(String cuisine) {
         PriorityQueue<Food> pq = cuisineToPQ.get(cuisine);

         while (true) {
             Food topFood = pq.peek();
             int currentRating = foodToRating.get(topFood.name);
             if(topFood.rating == currentRating) {
                 return topFood.name;
             } else {
                 pq.poll(); // Remove outdated entry
             }
         }

    }

    public static void main(String[] args) {
        String[] foods = {"sushi", "ramen", "tempura"};
        String[] cuisines = {"japanese", "japanese", "japanese"};
        int[] ratings = {5, 4, 3};

        FoodRatings foodRatings = new FoodRatings(foods, cuisines, ratings);
        System.out.println(foodRatings.highestRated("japanese")); // Output: sushi

        foodRatings.changeRating("ramen", 6);
        System.out.println(foodRatings.highestRated("japanese")); // Output: ramen
    }
}
