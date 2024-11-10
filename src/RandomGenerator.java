import java.util.Random;

public class RandomGenerator {

    public static int[] randomArray(int bound) {
        Random nextArrayNumber = new Random(bound);
        int[] randomArray = new int[bound];
        for (int i = 0; i < bound; i++) {
            randomArray[i] = nextArrayNumber.nextInt(bound);
        }
        return randomArray;
    }
}
