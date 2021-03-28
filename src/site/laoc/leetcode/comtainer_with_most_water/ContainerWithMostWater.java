package site.laoc.leetcode.comtainer_with_most_water;

public class ContainerWithMostWater {
    public int maxArea1(int[] height) {
        int size = 0;

        for(int i = 0;i < height.length;i++){
            int tmp = height[i];

            for(int j = i+1;j < height.length;j++){
                int tmp1 = height[j];

                int len = 0;

                if(j <= i){
                    len = i - j;
                }else{
                    len = j - i;
                }

                if(tmp <= tmp1){
                    int sz = tmp * len;
                    if(sz > size){
                        size = sz;
                    }
                }else{
                    int sz = tmp1 * len;
                    if(sz > size){
                        size = sz;
                    }
                }
            }
        }

        return size;
    }

    /**
     * 双指针法
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int size = 0;

        int i = 0, j = height.length-1;

        while(i != j){
            int ini = height[i];
            int inj = height[j];

            int min = ini <= inj ? ini : inj;

            int sz = (j-i) * min;

            if(sz > size){
                size = sz;
            }

            if(ini < inj)
                i++;
            else
                j--;
        }

        return size;
    }

    public static void main(String [] args){
        int [] height = {1,8,6,2,5,4,8,3,7};

        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(height));
    }
}
