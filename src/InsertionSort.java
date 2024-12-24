public class InsertionSort {
    long durationMicro;

    public int[] sort(int[] arrayToSort) {
        int[] sortedArray = arrayToSort.clone();
        long startTime = System.nanoTime();
        for (int i = 0; i < sortedArray.length; i++) {
            int current = sortedArray[i];
            int j = i-1;

            while (j >= 0 && sortedArray[j] > current) {
                sortedArray[j +1] = sortedArray[j];
                j--;
            }
            sortedArray[j +1] = current;
        }
        long endTime = System.nanoTime();
        durationMicro = (endTime -startTime);
        return sortedArray;
    }
}
