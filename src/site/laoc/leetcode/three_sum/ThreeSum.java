package site.laoc.leetcode.three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 3sum
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int[] innums = Arrays.stream(nums).sorted().toArray();

        List<List<Integer>> list = new ArrayList<>();

        int p0 = 0;
        int p1,p2;

        for(p0 = 0; p0 < innums.length;p0++){
            int pNum0 = innums[p0];

            // 去重
            if(p0 > 0 && innums[p0] == innums[p0-1])
                continue;

            int left = 0 - pNum0;

            p1 = p0 + 1;
            p2 = innums.length-1;

            while(p1 < p2){
                if(innums[p1] + innums[p2] == left){
                    // 添加数据
                    List<Integer> inlist = new ArrayList<>();
                    inlist.add(innums[p0]);
                    inlist.add(innums[p1]);
                    inlist.add(innums[p2]);

                    list.add(inlist);

                    // 去重
                    while(p1 < p2 && innums[p1] == innums[p1+1])
                        p1++;

                    while(p1 < p2 && innums[p2] == innums[p2-1])
                        p2--;

                    p1++;
                    p2--;
                }else if(innums[p1] + innums[p2] < left){
                    p1++;
                }else{
                    p2--;
                }
            }
        }

        return list;
    }

    public static void main(String [] args){
        int nums[] = {-1,0,1,2,-1,-4};

        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> list = threeSum.threeSum(nums);

        for(int i = 0;i < list.size();i++){
            List<Integer> inlist = list.get(i);

            for(int j = 0; j < inlist.size();j++){
                System.out.print(inlist.get(j) + " ");
            }

            System.out.println();
        }
    }
}
