import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RunSortMethod {
    private final static int DEFAULT_CAPACITY = 2;
    private final static int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private static int[] secondArrayToSort = new int[DEFAULT_CAPACITY];
    private static int size = 0;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int[] arrayToSort;
        int bound;

        System.out.println("Enter the number of elements in the array");
        while (true) {
            String input = in.nextLine();
            if (input.matches("\\d+")) {
                bound = Integer.parseInt(input);
                break;
            } else {
                System.out.println("Please enter only positive numbers");
            }
        }
        in.close();

        System.out.println("Create an array of " + bound + " random numbers");
        RandomGenerator generator = new RandomGenerator();
        arrayToSort = generator.randomArray(bound);

        int space = Math.max(characterCount(arrayToSort), 50); // нахожу количество знаков в преобразованном в строку массиве для отделения
        System.out.println("Array to InsertionSort is: " + Arrays.toString(arrayToSort));
        printSpace(space); // отделяю массивы подчеркиванием

        //MergeSort sorting = new MergeSort();
        InsertionSort iSorting = new InsertionSort();
        System.out.println("Sorted array by InsertionSort: " + Arrays.toString(iSorting.sort(arrayToSort)));
        System.out.println("InsertionSort Execution time: " + iSorting.durationMicro + " μs");
        printSpace(space);
        System.out.println("Create new array of " + bound + " random numbers");
        newRandomArrayToSort(bound); // формирую новый массив случайных чисел используя метод add() для динамического массива
        secondArrayToSort = Arrays.copyOf(secondArrayToSort, size); // убираю незаполненные элементы массива
        System.out.print("New array to InsertionSort is: ");
        print(secondArrayToSort);
        printSpace(space);
        int[] secondSortedArray = iSorting.sort(secondArrayToSort);
        System.out.print("Sorted second array by InsertionSort: ");
        print(secondSortedArray);
        System.out.println("InsertionSort Execution time: " + iSorting.durationMicro + " μs");

        printSpace(space);
        arrayToSort = generator.randomArray(bound);
        System.out.println("Array to MergeSort is: " + Arrays.toString(arrayToSort));
        printSpace(space);
        MergeSort mSorting = new MergeSort();
        //InsertionSort sorting = new InsertionSort();
        System.out.println("Sorted array by MergeSort:  " + Arrays.toString(mSorting.sort(arrayToSort)));
        printSpace(space);
        System.out.println("Create new array of " + bound + " random numbers");
        //System.out.println("Bound= " + bound);
        size = 0;
        newRandomArrayToSort(bound); // формирую новый массив случайных чисел используя метод add() для динамического массива
        secondArrayToSort = Arrays.copyOf(secondArrayToSort, size); // убираю незаполненные элементы массива
        System.out.print("New array to MergeSort is: ");
        print(secondArrayToSort);
        printSpace(space);
        secondSortedArray = mSorting.sort(secondArrayToSort);
        System.out.print("Sorted second array by MergeSort: ");
        print(secondSortedArray);

        printSpace(space);
        arrayToSort = generator.randomArray(bound);
        System.out.println("Array to QuickSort is: " + Arrays.toString(arrayToSort));
        printSpace(space);
        QuickSort qSorting = new QuickSort();
        //InsertionSort sorting = new InsertionSort();
        System.out.println("Sorted array by QuickSort:   " + Arrays.toString(qSorting.sort(arrayToSort)));
        printSpace(space);
        System.out.println("Create new array of " + bound + " random numbers");
        //System.out.println("Bound= " + bound);
        size = 0;
        newRandomArrayToSort(bound); // формирую новый массив случайных чисел используя метод add() для динамического массива
        secondArrayToSort = Arrays.copyOf(secondArrayToSort, size); // убираю незаполненные элементы массива
        System.out.print("New array to QuickSort is: ");
        print(secondArrayToSort);
        printSpace(space);
        secondSortedArray = mSorting.sort(secondArrayToSort);
        System.out.print("Sorted second array by QuckSort: ");
        print(secondSortedArray);

    }

    public static int characterCount (int[] arrayToSort) {
        StringBuilder lengthArrayToSort = new StringBuilder();
        for (int number : arrayToSort) {
            lengthArrayToSort.append(number).append(",").append(" ");
        }
        return lengthArrayToSort.length();
    }

    private static void printSpace(int space) {
        for (int i = 0; i <= (space + 28); i++ ) {
            System.out.print("-");
        }
        System.out.println(" ");
    }
    // вторая реализация по заданию с использованием методов add() для динамического массива
    // и print() для вывода на печать - используя прежнее количество элементов массива и его
    // рандомную генерацию

    private static void newRandomArrayToSort(int bound) {
        Random numberToAdd = new Random(bound);
        for (int i = 0; i < bound; i++) {
            add(numberToAdd.nextInt(bound * 12));
        }
    }

    public static void add(int toAdd) {
        int requiredSize = size + 1;
        if (!canAdd(requiredSize)) { // проверяет выход на максимальный размер массива, при превышении возвращает false
            throw new OutOfMemoryError("Limit arrays elements");
        } else if (requiredSize <= secondArrayToSort.length) {
            secondArrayToSort[size] = toAdd;
            size++;
        } else {
            int oldSize = secondArrayToSort.length;
            int newSize = Math.min((oldSize + (oldSize >> 1)), MAX_ARRAY_SIZE);
            secondArrayToSort = Arrays.copyOf(secondArrayToSort, newSize);
            secondArrayToSort[size] = toAdd;
            size++;
        }

    }

    public static int getAdded() {
        return secondArrayToSort[size - 1];
    }

    public static int getSize() {
        return size;
    }

    private static boolean canAdd(int requiredSize) { //проверяет не достиг ли необходимый минимум массива максимально возможного значения
        return requiredSize < Integer.MAX_VALUE;
    }

    private static void print(int[] arrayToPrint) {
        IntStream numberStream = Arrays.stream(arrayToPrint);
        String result = numberStream
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("[" + result + "]");
    }
}