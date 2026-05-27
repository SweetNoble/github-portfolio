import java.util.Scanner;

public class MergeSortUserInput {

    // ===== MAIN METHOD =====
    // This is where the program starts running
    public static void main(String[] args) {

        // Create Scanner object to read user input from keyboard
        Scanner scanner = new Scanner(System.in);

        // ===== ASK USER FOR ARRAY SIZE =====
        // User will decide how many numbers they want to sort
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        // Create an array with size n (based on user input)
        int[] numbers = new int[n];

        // ===== INPUT VALUES INTO ARRAY =====
        // Loop runs n times to store each number into the array
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt(); // store user input into array
        }

        // ===== DISPLAY ORIGINAL ARRAY =====
        System.out.println("\nBefore:");
        printArray(numbers);

        // ===== SORT THE ARRAY USING MERGE SORT =====
        // This method will divide and sort the array recursively
        mergeSort(numbers);

        // ===== DISPLAY SORTED ARRAY =====
        System.out.println("\nAfter:");
        printArray(numbers);

        // Close scanner to avoid memory leak (good practice)
        scanner.close();
    }

    // ===== MERGE SORT METHOD =====
    // This method uses RECURSION (function calls itself)
    // Purpose: Divide the array into smaller parts until it cannot be divided
    // anymore
    private static void mergeSort(int[] inputArray) {

        int inputLength = inputArray.length;

        // ===== BASE CASE =====
        // If array has only 1 or 0 elements, it is already sorted
        // So we stop dividing (this prevents infinite recursion)
        if (inputLength < 2) {
            return;
        }

        // ===== FIND MIDDLE INDEX =====
        // This is where we split the array into two halves
        int midIndex = inputLength / 2;

        // Create two new arrays: left half and right half
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputLength - midIndex];

        // ===== COPY DATA INTO LEFT HALF =====
        // Copy elements from index 0 up to midIndex - 1
        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = inputArray[i];
        }

        // ===== COPY DATA INTO RIGHT HALF =====
        // Copy remaining elements from midIndex to end
        for (int i = midIndex; i < inputLength; i++) {
            rightHalf[i - midIndex] = inputArray[i];
        }

        // ===== RECURSIVE CALLS =====
        // Keep dividing the left half until it becomes size 1
        mergeSort(leftHalf);

        // Keep dividing the right half until it becomes size 1
        mergeSort(rightHalf);

        // ===== MERGE STEP =====
        // Combine the two sorted halves into one sorted array
        merge(inputArray, leftHalf, rightHalf);
    }

    // ===== MERGE METHOD =====
    // Purpose: Combine two already sorted arrays into one sorted array
    private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {

        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        // i = pointer for leftHalf
        // j = pointer for rightHalf
        // k = pointer for inputArray (final merged array)
        int i = 0, j = 0, k = 0;

        // ===== COMPARE ELEMENTS FROM BOTH HALVES =====
        // Continue until one of the arrays is fully used
        while (i < leftSize && j < rightSize) {

            // Compare current elements of left and right
            if (leftHalf[i] <= rightHalf[j]) {
                // If left element is smaller or equal, place it into main array
                inputArray[k] = leftHalf[i];
                i++; // move to next element in leftHalf
            } else {
                // If right element is smaller, place it into main array
                inputArray[k] = rightHalf[j];
                j++; // move to next element in rightHalf
            }
            k++; // move to next position in merged array
        }

        // ===== COPY REMAINING ELEMENTS FROM LEFT HALF =====
        // If there are still elements left in leftHalf, copy them
        while (i < leftSize) {
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }

        // ===== COPY REMAINING ELEMENTS FROM RIGHT HALF =====
        // If there are still elements left in rightHalf, copy them
        while (j < rightSize) {
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }
    }

    // ===== PRINT METHOD =====
    // Purpose: Display all elements in the array
    private static void printArray(int[] numbers) {

        // Loop through array and print each value
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}