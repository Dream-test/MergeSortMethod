public class GnomeSort {
    public int[] sort(int[] arrayToSort) {
        int index = 1;
        int nextIndex = index + 1;

        while (index < arrayToSort.length) {
            if (arrayToSort[index - 1] <= arrayToSort[index]) {
                index = nextIndex;
                nextIndex++;
            } else {
                swap(arrayToSort, index - 1, index);
                index--;
                if (index == 0) {
                    index = nextIndex;
                    nextIndex++;
                }
            }
        }
        return arrayToSort;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
