package site.laoc.leetcode.search_in_rotated_sorted_array;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int medium;

        while(left <= right){
            medium = (left + right) / 2;
            System.out.println("left = " + left + ";right=" + right + ";medium=" + medium);

            if(nums[medium] == target){
                return medium;
            }

            if(nums[left] == target){
                return left;
            }

            if(nums[right] == target){
                return right;
            }

            if(left == medium || right == medium){
                return -1;
            }

            int leftVal = nums[left];
            int rightVal = nums[right];
            int mediumVal = nums[medium];

           if(target > leftVal && target < mediumVal){
               right = medium;
           }else if(target > leftVal && target > mediumVal && target < rightVal){
               left = medium;
           }else if(target > leftVal && target < mediumVal &&  target < rightVal){
               right = medium;
           }else if(target > leftVal && target > mediumVal && target < rightVal){
               left = medium;
           }
        }

        return -1;
    }

    public static void main(String args[]){
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();

        int nums[] = {4,5,6,7,8,1,2,3};
        int index = searchInRotatedSortedArray.search(nums,8);
        System.out.println(index);
    }
}
