import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SomeSortMethodTest {
    @Test
    public void characterCount_whenThree() {
        int[] toAdd = {1, 2, 3};
        int result = RunSortMethod.characterCount(toAdd);
        Assertions.assertEquals(9, result);

    }

    @Test
    public void add_fiveNumbers() {
        int toAdd = 5;
        int oldSize = RunSortMethod.getSize();
        for (int i = 0; i < toAdd; i++) {
            RunSortMethod.add(i);
        }
        int result = RunSortMethod.getSize() - oldSize;
        Assertions.assertEquals(5, result);
    }

    @Test
    public void addNumberFive() {
        int toAdd = 5;
        RunSortMethod.add(toAdd);
        int result = RunSortMethod.getAdded();
        Assertions.assertEquals(5, result);
    }

    @Test
    public void sortArrayByMergeSort_whenFive() {
        int[] toSort = {5, 4, 1, 3, 2};
        int[] expectedResult = {1, 2, 3, 4, 5};
        MergeSort sorted = new MergeSort();
        int[] result = sorted.sort(toSort);
        for (int i = 0; i < toSort.length; i++) {
            Assertions.assertEquals(expectedResult[i], result[i]);
        }
    }

    @Test
    public void sortArrayByInsertSort_whenFive() {
        int[] toSort = {5, 4, 1, 3, 2};
        int[] expectedResult = {1, 2, 3, 4, 5};
        InsertionSort sorted = new InsertionSort();
        int[] result = sorted.sort(toSort);
        for (int i = 0; i < toSort.length; i++) {
            Assertions.assertEquals(expectedResult[i], result[i]);
        }
    }
}
