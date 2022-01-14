package site.laoc.leetcode.two_sum_2_input_array_is_sorted;

public class TwoSum2 {

    public int[] twoSum(int[] numbers, int target) {

        for(int i = 0;i < numbers.length;i++){
            for(int j = i + 1;j < numbers.length;j++){
                if(numbers[i] + numbers[j] == target){
                    int[] arr = {i+1,j+1};
                    return arr;
                }
            }
        }

        return new int[2];
    }

    public static void printArray(int nums[]){
        for(int i = 0;i < nums.length;i++){
            System.out.print(nums[i] + " ");
        }

        System.out.println();
    }


    public static void main(String args[]){
        TwoSum2 twoSum2 = new TwoSum2();
        int numbers[] = {2,7,11,15};
        int target = 9;

       int arr[] = twoSum2.twoSum(numbers,target);

       printArray(arr);
    }

}
