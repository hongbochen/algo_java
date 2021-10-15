package site.laoc.leetcode.remove_element;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        if(nums.length == 0){
            return 0;
        }

        int k = -1;

        for(int i = 0;i < nums.length;i++){

            if(nums[i] == val){
                nums[i] = -1;
                if(k == -1){
                    k = i;
                }
            }else{
                if(k != -1){
                    nums[k] = nums[i];
                    nums[i] = -1;

                    int j = k + 1;
                    for(j = k + 1;j < nums.length;j++){
                        if(nums[j] == -1){
                            break;
                        }
                    }

                    if(j >= nums.length){
                        k = -1;
                    }else{
                        k = j;
                    }
                }
            }
        }

        int size = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] != -1){
                size++;
            }
        }
//
//        System.out.println();
//
//        System.out.println(k);

        return size;
    }

    public static void main(String args[]){
        int nums[] = {2};
        RemoveElement removeElement = new RemoveElement();
        removeElement.removeElement(nums,3);
    }
}
