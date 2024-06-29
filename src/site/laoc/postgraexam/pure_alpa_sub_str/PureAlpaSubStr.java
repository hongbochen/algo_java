package site.laoc.postgraexam.pure_alpa_sub_str;

import java.util.HashMap;
import java.util.Map;

public class PureAlpaSubStr {

    public static void main(String args[]){
        findTheLongestPureAlpaSubStr("ABC12D");
    }

    public static String findTheLongestPureAlpaSubStr(String str){

        Map<String,Integer> map = new HashMap<>();

        String ns = str +  str;

        for(int i = 0;i < ns.length();i++){
            char c = ns.charAt(i);

            if(isChater(c) == false){
                continue;
            }

            String tmp = "";

            for(int m = i;m < ns.length();m++){
                if(isChater(ns.charAt(m))){
                    tmp = tmp + ns.charAt(m);
                }else{
                    map.put(tmp,i);
                    break;
                }
            }
        }

        System.out.println(ns);

        return "";
    }

    public static boolean isChater(char c){
        if((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')){
            return true;
        }

        return false;
    }
}
