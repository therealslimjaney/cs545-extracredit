// Leetcode description: Given an array nums containing n distinct numbers in the range [0, n],
// return the only number in the range that is missing from the array.

public class MissingNumber {

    // Since I know the sum of the numbers in range 0 to n has a closed form solution,
    // I will compute this and then subtract the actual sum of the integers in the array. This difference is the missing integer
    // O(n)
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = (n)*(n+1)/2;
        int actualSum = 0;
        // Find the sum of the array
        for (int i = 0; i<n; i++) {
            actualSum += nums[i];
        }

        return (sum-actualSum);
    }
    public static void main(String args[]) {
        int[] someNumbers= {0, 1, 2, 3, 5};
        int missing  = missingNumber(someNumbers);
        System.out.println("The missing integer is: " + missing);
    }

}