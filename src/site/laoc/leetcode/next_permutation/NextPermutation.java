package site.laoc.leetcode.next_permutation;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        // 1. 先从右向左找到第一个违反递增趋势的数字

        int partitionNumIndex = -1;

        for(int i = nums.length - 1;i > 0;i--){
            if(nums[i-1] < nums[i]){
                partitionNumIndex = i-1;
                break;
            }
        }

        if(partitionNumIndex == -1){
            //return;
            //全部反转
            for(int m = 0,n = nums.length-1;m <= n;m++,n--){
                swap(nums,m,n);
            }
            return;
        }

        // 2. 从右向左找到第一个比 partitionNumber 大的数 changeNumber
        int changeNumIndex = -1;
        for(int i = nums.length - 1;i >= 0;i--){
            if(nums[i] > nums[partitionNumIndex]){
                changeNumIndex = i;
                break;
            }
        }

        if(changeNumIndex == -1){
            return;
        }

//        System.out.println("partitionNumber = " + nums[partitionNumIndex]);
//        System.out.println("changeNumber = " + nums[changeNumIndex]);

        // 3. 交换 partitionNumber 和 changeNumber
        swap(nums,partitionNumIndex,changeNumIndex);

        // 4. 将数组位置partitionNumber后的位置进行反转
        for(int m = partitionNumIndex + 1,n = nums.length-1;m <= n;m++,n--){
            swap(nums,m,n);
        }
    }

    private void swap(int nums[],int index1,int index2){
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public void printList(int nums[]){
        for(int i = 0;i < nums.length;i++){
            System.out.print(nums[i] + " ");
        }

        System.out.println();
    }



    public static void main(String args[]){
        NextPermutation nextPermutation = new NextPermutation();

        int nums[] = {3,2,1};

        nextPermutation.nextPermutation(nums);
        nextPermutation.printList(nums);
    }
}
