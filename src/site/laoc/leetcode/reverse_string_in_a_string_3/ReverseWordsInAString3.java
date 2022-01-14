package site.laoc.leetcode.reverse_string_in_a_string_3;

public class ReverseWordsInAString3 {

    public String reverseWords(String s) {
        String tmps[] = s.split(" ");
        StringBuffer sb = new StringBuffer();

        for(int i = 0;i < tmps.length;i++){
            String tmp = tmps[i];
            for(int j = tmp.length()-1;j >= 0;j--){
                sb.append(tmp.charAt(j));
            }

            if(i < (tmps.length-1)){
                sb.append(" ");
            }
        }

        return sb.toString();
    }


    public static void main(String args[]){
        ReverseWordsInAString3 reverseWordsInAString3 = new ReverseWordsInAString3();

        String str = reverseWordsInAString3.reverseWords("Let's take LeetCode contest");

        System.out.println(str);
    }

}
