import java.util.Arrays;
import java.util.Scanner;

public class MergeSortMethod {
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
        arrayToSort = RandomGenerator.randomArray(bound);

        int space = Math.max(characterCount(arrayToSort), 37);
        printSpace(space);
        System.out.println("Array to sort is: " + Arrays.toString(arrayToSort));
        printSpace(space);
        System.out.println("Sorted array:      " + Arrays.toString(MergeSort.split(arrayToSort)));
    }

    private static int characterCount (int[] arrayToSort) {
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
}