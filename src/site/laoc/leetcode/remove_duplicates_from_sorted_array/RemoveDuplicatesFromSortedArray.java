package site.laoc.leetcode.remove_duplicates_from_sorted_array;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return nums.length;
        }

        int k = 1;

        for(int i = 1;i < nums.length;i++){
            int has = 0;

            for(int j = 0; j < k;j++){
                if(nums[j] == nums[i]){
                    has = 1;
                }
            }

            if(has == 0){
                nums[k] = nums[i];

                if(i > k){
                    nums[i] = -1;
                }
                k++;
            }else{
                nums[i] = -1;
            }
        }


        return k;
    }

    public static void main(String args[]){
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();

        int nums[] = {0,0,1,1,1,2,2,3,3,4};

        removeDuplicatesFromSortedArray.removeDuplicates(nums);
    }
}
//    for(int i = 0;i < nums.length;i++){
//        System.out.print(nums[i] + ",");
//        }
//
//        System.out.println();
//
//        System.out.println(k);