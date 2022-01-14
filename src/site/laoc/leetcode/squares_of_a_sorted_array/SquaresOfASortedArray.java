package site.laoc.leetcode.squares_of_a_sorted_array;

public class SquaresOfASortedArray {

    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int arr[] = new int[nums.length];
        int cur = nums.length - 1;

        while(left <= right){
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                arr[cur] = nums[left] * nums[left];
                left++;
                cur--;
            }else{
                arr[cur] = nums[right] * nums[right];
                right--;
                cur--;
            }
        }

        return arr;
    }

    public static void printArray(int[] nums){
        for(int i = 0; i < nums.length;i++){
            System.out.print(nums[i] + " ");
        }

        System.out.println();
    }

    public static void main(String args[]){
        int nums[] = {-7,-3,2,3,11};

        SquaresOfASortedArray squaresOfASortedArray = new SquaresOfASortedArray();

        int arr[] = squaresOfASortedArray.sortedSquares(nums);
        printArray(arr);
    }

}
