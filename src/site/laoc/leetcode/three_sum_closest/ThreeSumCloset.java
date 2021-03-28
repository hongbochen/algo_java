package site.laoc.leetcode.three_sum_closest;

import java.util.Arrays;

public class ThreeSumCloset {

    public int threeSumClosest(int[] nums, int target) {
        Integer closestSum = null;

        int innums[] = Arrays.stream(nums).sorted().toArray();

        int p0 = 0;
        int p1,p2;

        for(p0 = 0; p0 < innums.length; p0++){

            p1 = p0 + 1;
            p2 = innums.length - 1;

            while(p1 < p2){
                int allSum = innums[p0] + innums[p1] + innums[p2];

                //System.out.println("p0 = " + innums[p0] + ";p1 = " + innums[p1] + ";p2= " + innums[p2]);
                if(closestSum == null){
                    closestSum = allSum;
                    continue;
                }

                if(allSum > target){
                    p2--;
                }else if(allSum < target){
                    p1++;
                }else{
                    p1++;
                    p2--;
                }

//                System.out.println("allSum = " +  allSum);
//                System.out.println("allSum-target -- " + Math.abs(allSum-target));
//                System.out.println("closestSum-target -- " + Math.abs(closestSum-target));

                if(Math.abs(allSum-target) < Math.abs(closestSum-target)){
                    closestSum = allSum;

                    //System.out.println("closestSum -- " + closestSum);
                }

            }
        }

        return closestSum;
    }

    public static void main(String [] args){
        int nums[] = {1,1,-1,-1,3};
        int target = -1;

        ThreeSumCloset threeSumCloset = new ThreeSumCloset();
        int sum = threeSumCloset.threeSumClosest(nums,target);

        System.out.println(sum);
    }
}
