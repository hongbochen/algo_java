package site.laoc.leetcode.search_insert_position;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid = (left + right) / 2;

            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid;
            }else{
                return mid;
            }
        }

        if(target > nums[left]){
            return left + 1;
        }else{
            return left;
        }
    }

    public static void main(String  args[]){
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();

        int nums[] = {1};
        int target = 0;

        System.out.println(searchInsertPosition.searchInsert(nums,target));
    }
}
