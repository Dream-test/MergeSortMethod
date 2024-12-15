public class InsertionSort {

    public int[] sort(int[] arrayToSort) {
        int[] sortedArray = arrayToSort.clone();
        for (int i = 0; i < sortedArray.length; i++) {
            /*for (int j = i; j > 0 && sortedArray[j - 1] > sortedArray[j]; j--) {
                int temp = sortedArray[j];
                sortedArray[j] = sortedArray[j - 1];
                sortedArray[j - 1] = temp;
            } */
            int current = sortedArray[i];
            int j = i-1;

            while (j >= 0 && sortedArray[j] > current) {
                sortedArray[j +1] = sortedArray[j];
                j--;
            }
            sortedArray[j +1] = current;
        }
        return sortedArray;
    }
}
