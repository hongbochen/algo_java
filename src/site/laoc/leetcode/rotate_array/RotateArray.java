package site.laoc.leetcode.rotate_array;

public class RotateArray{

    /**
     * 该方法时间超时
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int temp = -1;

        for(int i = 0;i < k;i++){
            temp = nums[nums.length-1];
            for(int j = nums.length - 1;j >= 1;j--){
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }
    }

    /**
     * 该方法时间效率和空间效率较低
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        if(k > nums.length){
            k = k % nums.length;
        }

        int innums[] = new int[k];

        for(int i = 0;i < k;i++){
            //System.out.println((nums.length - k + i));
            innums[i] = nums[nums.length - k + i];
        }

        for(int j = nums.length - 1;j >= k;j--){
            nums[j] = nums[j-k];
        }

        for(int i = 0;i < k;i++){
            nums[i] = innums[i];
        }
    }

    /**
     * nums = {1 2 3 4 5 6 7}
     * k = 3
     * 先旋转前 n - k个元素
     * 4 3 2 1 5 6 7
     * 再旋转后K个元素
     * 4 3 2 1 7 6 5
     * 最终选中整个数组
     * 5 6 7 1 2 3 4
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
         if(k > nums.length){
            k = k % nums.length;
        }

         int n = nums.length;

        reverse(nums,0,n-k);
        reverse(nums,n-k+1,n-1);
        reverse(nums,0,n-1);
    }

    private void reverse(int nums[],int start,int end){
        int left = start;
        int right = end;

        while(left < right){
            exchange(nums,left,right);
            left++;
            right--;
        }
    }

    private void exchange(int nums[],int a,int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void printArray(int nums[]){
        for(int i = 0;i < nums.length;i++){
            System.out.print(nums[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args){
        RotateArray rotateArray = new RotateArray();

        int nums[] = {1,2,3,4,5,6,7};
        int k = 4;

        rotateArray.rotate2(nums,k);
        //printArray(nums);
    }
}
