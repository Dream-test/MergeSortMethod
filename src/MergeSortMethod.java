import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MergeSortMethod {
    private final static int DEFAULT_CAPACITY = 2;
    private final static int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private static int[] secondArrayToSort = new int[DEFAULT_CAPACITY];
    private static int size = 0;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int[] arrayToSort;
        String boundString;
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

        int space = Math.max(characterCount(arrayToSort), 37); // нахожу количество знаков в преобразованном в строку массиве для отделения
        System.out.println("Array to sort is: " + Arrays.toString(arrayToSort));
        printSpace(space); // отделяю массивы подчеркиванием
        MergeSort sorting = new MergeSort();
        System.out.println("Sorted array:      " + Arrays.toString(sorting.sort(arrayToSort)));
        printSpace(space);
        System.out.println("Create new array of " + bound + " random numbers");
        newRandomArrayToSort(bound); // формирую новый массив случайных чисел используя метод add() для динамического массива
        secondArrayToSort = Arrays.copyOf(secondArrayToSort, size); // убираю незаполненные элементы массива
        System.out.print("New array to sort is: ");
        print(secondArrayToSort);
        printSpace(space);
        int[] secondSortedArray = sorting.sort(secondArrayToSort);
        System.out.print("Sorted second array: ");
        print(secondSortedArray);

    }

    public static int characterCount (int[] arrayToSort) {
        StringBuilder lengthArrayToSort = new StringBuilder();
        for (int number : arrayToSort) {
            lengthArrayToSort.append(number).append(",").append(" ");
        }
        int length = lengthArrayToSort.length();
        return length;
    }

    private static void printSpace(int space) {
        for (int i = 0; i <= (space + 17); i++ ) {
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