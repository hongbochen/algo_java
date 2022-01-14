package site.laoc.leetcode.move_zeros;

public class MoveZeros {

    public void moveZeroes(int[] nums) {

        for(int i = 0;i < nums.length;i++){
            int cur = nums[i];

            if(cur == 0){
                // 往后移动，调换位置
                int j = i + 1;
                for(j = i + 1; j < nums.length && nums[j] == 0;j++){

                }

                if(j != nums.length){
                    swap(nums,i,j);
                }
            }
        }
    }

    private void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void printArray(int[] nums){
        for(int i = 0;i < nums.length;i++){
            System.out.print(nums[i] + " ");
        }

        System.out.println();
    }

    public static void main(String args[]){
        MoveZeros moveZeros = new MoveZeros();
        int nums[] = {0,1,0,3,12};

        moveZeros.moveZeroes(nums);
        printArray(nums);

    }
}
