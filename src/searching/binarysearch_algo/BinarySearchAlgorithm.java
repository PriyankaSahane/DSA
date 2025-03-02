package searching.binarysearch_algo;

import java.util.Scanner;

public class BinarySearchAlgorithm {

    // Binary Search Implementation
    int searchNumber(int input[], int num) {
        int start = 0, end = input.length - 1; // Correcting end value

        while (start <= end) {
            int mid = start + (end - start) / 2; // Correct mid calculation

            if (input[mid] == num) {
                return mid; // Found the number
            } else if (input[mid] < num) {
                start = mid + 1; // Search in the right half
            } else {
                end = mid - 1; // Search in the left half
            }
        }

        return -1; // Number not found
    }

    /* Recusive approach
    int searchNumber(int input[], int start, int end, int num) {
        if (start > end) {
            return -1; // Element not found
        }

        int mid = start + (end - start) / 2;

        if (input[mid] == num) {
            return mid;
        } else if (input[mid] < num) {
            return searchNumber(input, mid + 1, end, num); // Search right half
        } else {
            return searchNumber(input, start, mid - 1, num); // Search left half
        }
    }
     */

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        BinarySearchAlgorithm obj = new BinarySearchAlgorithm();

        // Array should be sorted before applying binary search
        System.out.println("Enter the size of the sorted array:");
        int size = sc.nextInt();
        int arr_input[] = new int[size];

        System.out.println("Enter sorted elements:");
        for (int i = 0; i < size; i++) {
            arr_input[i] = sc.nextInt();
        }

        System.out.println("Enter number to search:");
        int num = sc.nextInt();

        int position = obj.searchNumber(arr_input, num);
        if (position != -1) {
            System.out.println("Number found at index: " + position);
        } else {
            System.out.println("Number not found in the array.");
        }

        sc.close();
    }
}
