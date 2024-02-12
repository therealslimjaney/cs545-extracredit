// Leetcode 1356. Sort integers by the number of 1 bits
// You are given an integer array arr.
// Sort the integers in the array in ascending order by the number of 1's in their binary representation
// and in case of two or more integers have the same number of 1's you have to sort them in ascending order.


// I'm sorting using a variation of quickSort (pivot is last element)

// I have the bits logic, now I must put in the integer logic

import java.lang.Integer;

public class SortByBits {

    public static void quickSort(int[] array, int lowIndex, int highIndex) {

        // Check for base case
        if (lowIndex >= highIndex) {
            return;
        }

        int pivot = array[highIndex];

        int pivotBits = Integer.bitCount(pivot);

        int leftPointer = lowIndex;

        int rightPointer = highIndex - 1;

        while (leftPointer <= rightPointer) {

            while (leftPointer <= rightPointer && Integer.bitCount(array[leftPointer]) <= pivotBits && array[leftPointer] <= pivot) {
                leftPointer++;
            }
            while (rightPointer >= leftPointer && Integer.bitCount(array[rightPointer]) >= pivotBits && array[rightPointer] >= pivot) {
                rightPointer--;
            }
            if (leftPointer < rightPointer) {
                swap(array, leftPointer, rightPointer);
                leftPointer++;
                rightPointer--;
            }
        }

            //When we exit the outer while loop, we want to swap the pivot with the element that left and right are pointing at
            swap(array, leftPointer, highIndex);

            quickSort(array, lowIndex, leftPointer - 1);
            quickSort(array, leftPointer + 1, highIndex);

        }


    // I made my own swap method to call
    private static void swap(int[] array, int low, int high) {
        int temp = array[high];
        array[high] = array[low];
        array[low] = temp;
    }

    public static void main(String args[]) {
        int[] arr = {1024,512,256,128,64,32,16,8,4,2,1};

        quickSort(arr, 0, arr.length-1);

        for (int i = 0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}