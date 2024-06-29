package site.laoc.leetcode.only_one_num;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组，数组中有一个数出现了一次，其他数出现了两次，请找出只出现了一次的数。
 *
 * 数据范围：数组中元素个数满足 1≤n≤100000 , 数组中的元素大小满足∣val∣≤ 109
 *
 */
public class OnlyOneNum {

    public int singleNumber (int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i < nums.length;i++){
            Integer num = map.get(nums[i]);

            if(num == null){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],num+1);
            }
        }


        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }

        return -1;
    }

    public static void main(String args[]){
        OnlyOneNum onlyOneNum = new OnlyOneNum();

        int nums[] = {2,3,2,1,1};

        System.out.println(onlyOneNum.singleNumber(nums));
    }
}
