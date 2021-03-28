package site.laoc.leetcode.longest_common_prefix;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if(strs.length == 0){
            return "";
        }

        int index = 0;

        while(true){
            String tt = strs[0];

            if(index >= tt.length()){
                break;
            }

            char ttChar = tt.charAt(index);

            boolean hasEql = true;
            for(int i = 1;i < strs.length;i++){
                String tti = strs[i];

                if(index >= tti.length()){
                    hasEql = false;
                    break;
                }

                if(ttChar != tti.charAt(index)){
                    hasEql = false;
                    break;
                }
            }

            if(!hasEql){
                break;
            }

            index++;
        }

        return strs[0].substring(0,index);
    }

    public static void main(String [] args){
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

        String strs[] = {"cir","car"};

        System.out.println(longestCommonPrefix.longestCommonPrefix(strs));
    }
}
