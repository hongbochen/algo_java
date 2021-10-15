package site.laoc.leetcode.implement_strstr;

public class ImplementStrSte {

    public int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }

        if(needle.length() > haystack.length()){
            return -1;
        }

        int index = -1;
        int nlen = needle.length();

        for(int i = 0;i < haystack.length();i++){
            char c = haystack.charAt(i);

            if(c == needle.charAt(0)){
                index = i;

                int j = 0;
                for(j = nlen-1;j >= 0  && j+index < haystack.length() && j + index >= 0;j--){
                    if(haystack.charAt(j+index) != needle.charAt(j)){
                        break;
                    }
                }

                if(j == -1){
                    break;
                }else{
                    index = -1;
                }
            }
        }

        return index;
    }

    public static void main(String args[]){
        ImplementStrSte implementStrSte = new ImplementStrSte();

        String haystack = "hello";
        String neddle = "ll";

        int index = implementStrSte.strStr(haystack,neddle);
        System.out.println(index);
    }
}
