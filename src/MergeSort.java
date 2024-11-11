import java.util.Arrays;

public class MergeSort {
    public int[] sort(int[] arrayToSort) {
        return split(arrayToSort);
    }

    private int[] split(int[] arrayToSort) {
        if (arrayToSort.length < 2) return arrayToSort;
        else {
            int mid = arrayToSort.length / 2;
            int[] left = Arrays.copyOfRange(arrayToSort, 0, mid);
            int[] right = Arrays.copyOfRange(arrayToSort, mid, arrayToSort.length);

            left = split(left);
            right = split(right);
            arrayToSort = mergeArray(left, right);
            return arrayToSort;
        }
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
