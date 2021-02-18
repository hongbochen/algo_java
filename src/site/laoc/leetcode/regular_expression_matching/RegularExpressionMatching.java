package site.laoc.leetcode.regular_expression_matching;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        int sIndex = 0;
        for(int i = 0;i < p.length();i++){

            char m = p.charAt(i);

            char target = '1';
            if(m == '*'){
                if(i == 0){
                    return false;
                }else{
                    target = p.charAt(i-1);
                    if(target == '.'){
                        if(i + 1 < p.length()){
                            return false;
                        }else{
                            return true;
                        }
                    }else{
                        //System.out.println("target: " + target);
                        for(; sIndex < s.length();sIndex++){
                            char tmp = s.charAt(sIndex);
                            if(tmp != target){
                               // System.out.println("sIndex: " + sIndex);
                                //System.out.println("i == " + i);
                                break;
                            }
                        }

                    }
                }
            }else if(m == '.'){
                char tmp = s.charAt(sIndex);
                //System.out.println("next");
                sIndex++;
            }else{
                if(i != p.length()-1){
                    if(p.charAt(i+1) == '*' && i == 0){
                        //System.out.println("next");
                        sIndex++;
                    }else{
                        char tmp = s.charAt(sIndex);
                        if(tmp != m){
                            //System.out.println("false");
                            return false;
                        }
                        //System.out.println("next");
                        sIndex++;
                    }
                }else{
                    if(sIndex >= s.length()){
                        return false;
                    }

                    char tmp = s.charAt(sIndex);
                    if(tmp != m){
                        //System.out.println("false");
                        return false;
                    }
                    //System.out.println("next");
                    sIndex++;
                }

            }
        }

        if(sIndex != s.length()){
            //System.out.println(false);
            return false;
        }

        return true;
    }

    public static void main(String [] args){

        RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();

        String s = "ab";
        String p = ".*c";

        boolean matching = regularExpressionMatching.isMatch(s,p);
        System.out.println(matching);
    }
}
