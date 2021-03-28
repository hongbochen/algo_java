package site.laoc.leetcode.four_sum;

import site.laoc.leetcode.three_sum.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        int [] innums = Arrays.stream(nums).sorted().toArray();

        List<List<Integer>> list = new ArrayList<>();

        int p0,p1;
        for(int i = 0;i < innums.length;i++){
            for(int j = i+1;j < innums.length;j++){

                p0 = j + 1;
                p1 = innums.length - 1;

                while(p0 < p1){
                    int val0 = innums[i];
                    int val1 = innums[j];
                    int val3 = innums[p0];
                    int val4 = innums[p1];

                    int left = target - val0 - val1;

                    if(val3 + val4 == left){

                        boolean has = false;

                        for(int m = 0; m < list.size();m++){
                            List<Integer> tlist = list.get(m);

                            if(tlist.get(0) == val0
                            && tlist.get(1) == val1
                            && tlist.get(2) == val3
                            && tlist.get(3) == val4){
                                has = true;
                            }
                        }

                        if(has == true){
                            p0++;
                            p1--;
                            continue;
                        }

                        // 添加数据
                        List<Integer> inlist = new ArrayList<>();
                        inlist.add(val0);
                        inlist.add(val1);
                        inlist.add(val3);
                        inlist.add(val4);

                        list.add(inlist);
                        p0++;
                        p1--;
                    }else if(val3 + val4 < left){
                        p0++;
                    }else{
                        p1--;
                    }
                }


            }
        }

        return list;
    }

    public static void main(String[] args){
        int nums[] = {-5,-4,-3,-2,-1,0,0,1,2,3,4,5};

        FourSum fourSum = new FourSum();
        List<List<Integer>> list = fourSum.fourSum(nums,0);

        for(int i = 0;i < list.size();i++){
            List<Integer> inlist = list.get(i);

            for(int j = 0; j < inlist.size();j++){
                System.out.print(inlist.get(j) + " ");
            }

            System.out.println();
        }
    }
}
