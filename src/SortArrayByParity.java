// This is leetcode problem 905. Sort Array by parity
// The task description is: Given an integer array nums, move all the even integers at the beginning of
// the array followed by all the odd integers.
//Return any array that satisfies this condition.

// I am going to make a new array with even numbers first followed by odd numbers, and then split them into 2 arrays, sort them, and merge them

public class SortArrayByParity {

    public static int[] sortArrayByParity(int[] numbers) {

        int n = numbers.length;

        int[] result = new int[n];

        //Use two pointers to populate the resulting array with even numbers from front and odd from back
        int even = 0;
        int odd = n-1;

        for (int i = 0; i<n; i++) {
            if (numbers[i]%2==0) {
                result[even] = numbers[i];
                even++;
            } else {
                result[odd] = numbers[i];
                odd--;
            }
        }

        //sort even numbers with insertion sort
        //right now the even numbers are all at indexes <even
        for (int i=1; i<even; i++) {
            int current = result[i];
            int j =i-1;
            while (j>=0 && result[j]>current) {
                int temp = result[j+1];
                result[j+1] =result[j];
                result[j] = temp;
                j--;
            }
        }

        //sort odd numbers with insertion sort
        //right now the odd numbers are all at indexes >=even
        for (int i=even+1; i<n; i++) {
            int current = result[i];
            int j =i-1;
            while (j>=even && result[j]>current) {
                int temp = result[j+1];
                result[j+1] =result[j];
                result[j] = temp;
                j--;
            }
        }
        return result;
    }


        public static void main (String[]args){
            int[] nums = {4, 1, 3, 2, 10, 15, 20, 24, -2, -5, 13};
            int[] answer = sortArrayByParity(nums);
            for (int i = 0; i < answer.length; i++) {
                System.out.println(answer[i]);
            }

        }
    }
