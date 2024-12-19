import java.util.Arrays;

public class MergeSort {
    public int[] sort(int[] arrayToSort) {
        return split(arrayToSort);
    }

    private int[] split(int[] arrayToSort) {
        if (arrayToSort.length == 0) {
            throw new IllegalArgumentException("Array length must be greater than 0");
        }
        if (arrayToSort.length < 2) {
            return arrayToSort;
        }
            int mid = arrayToSort.length / 2;
            int[] leftArray = Arrays.copyOfRange(arrayToSort, 0, mid);
            int[] rightArray = Arrays.copyOfRange(arrayToSort, mid, arrayToSort.length);

            leftArray = split(leftArray);
            rightArray = split(rightArray);
            arrayToSort = mergeArray(leftArray, rightArray);
            return arrayToSort;
    }

    private int[] mergeArray(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                merged[k] = left[i];
                i++;
            } else {
                merged[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length){
            merged[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            merged[k] = right[j];
            j++;
            k++;
        }
        return merged;
    }

}
