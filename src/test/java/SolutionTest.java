import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1(){
        String[] foods = {"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"};
        String[] cuisines = {"korean", "japanese", "japanese", "greek", "japanese", "korean"};
        int[] ratings = {9, 12, 8, 15, 14, 7};
        FoodRatings foodRatings = new FoodRatings(foods, cuisines, ratings);
        Assert.assertEquals("kimchi", foodRatings.highestRated("korean"));
        Assert.assertEquals("ramen", foodRatings.highestRated("japanese"));
        foodRatings.changeRating("sushi", 16);
        Assert.assertEquals("sushi", foodRatings.highestRated("japanese"));
        foodRatings.changeRating("ramen", 16);
        Assert.assertEquals("ramen", foodRatings.highestRated("japanese"));

    }
}
