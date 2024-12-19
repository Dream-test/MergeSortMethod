public class QuickSort {
    public int[] sort(int[] arrayToSort) {
        return sorting(arrayToSort, 0, arrayToSort.length-1);
    }

    private int[] sorting(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            sorting(array, low, pivotIndex - 1);
            sorting(array, pivotIndex + 1, high);
        }
        return array;
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[low];
        int left = low + 1;
        int right = high;
        while (true) {
            while (left <= right && array[left] <= pivot) {
                left++;
            }
            while (right >= left && array[right] >= pivot) {
                right--;
            }
            if (right < left) {
                break;
            } else {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        int temp = array[low];
        array[low] = array[right];
        array[right] = temp;
        return right;
    }

}
