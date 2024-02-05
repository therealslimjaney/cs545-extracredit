// This is a leetcode problem I am doing called "977. Squares of a Sorted Array"
// Here is the instruction: Given an integer array nums sorted in non-decreasing order,
// return an array of the squares of each number sorted in non-decreasing order.

// I made an array to store the result and used a two pointer approach within a for loop to populate the resulting array with squares
public class SquaresOfSortedArray {

    public static int[] squaresOfSortedArray(int[] numbers) {
        int left = 0;
        int right = numbers.length-1;
        int[] result = new int[numbers.length];

        for (int i = numbers.length-1; i>=0; i--) {
            if (Math.abs(numbers[left])<Math.abs(numbers[right])) {
                int square = (numbers[right])*(numbers[right]);
                result[i]=square;
                right--;
            } else {
                int square = (numbers[left])*(numbers[left]);
                result[i]=square;
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        int[] answer = squaresOfSortedArray(nums);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }

    }
}
