package site.laoc.leetcode.binary_search;

public class BinarySearch {

    public int search(int[] nums, int target) {
        return binarySearch(nums,target,0,nums.length-1);
    }

    private int binarySearch(int[] nums,int target,int start,int end){
        int medium = (start + end) / 2;

        if(nums[start] == target){
            return start;
        }

        if(nums[end] == target){
            return end;
        }

        if(nums[medium] == target){
            return medium;
        }

        if(medium == end - 1){
            return -1;
        }

        if(target > nums[start] && target < nums[medium]){
            return binarySearch(nums,target,start,medium);
        }else if(target > nums[medium] && target < nums[end]){
            return binarySearch(nums,target,medium,end);
        }else{
            return -1;
        }
    }

    public static void main(String args[]){
        int nums[] = {-1,0,3,5,9,12};
        int target = 6;

        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(nums,target));
    }
}
