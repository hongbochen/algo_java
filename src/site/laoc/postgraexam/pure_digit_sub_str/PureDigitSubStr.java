package site.laoc.postgraexam.pure_digit_sub_str;

import java.util.*;

public class PureDigitSubStr {

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

//        int count = Integer.parseInt(scanner.nextLine());
//
//        for(int m = 0; m < count;m++){
//            String tmp = scanner.nextLine();
//            findTheLongestPureDigitSubStr(tmp);
//        }


        String tmp = scanner.nextLine();
        findTheLongestPureDigitSubStr(tmp);
    }

    public static void findTheLongestPureDigitSubStr(String str){

        Map<String,Integer> map = new HashMap<>();

        String ns = str +  str;

        for(int i = 0;i < ns.length();i++){
            char c = ns.charAt(i);

            if(isDigit(c) == false){
                continue;
            }

            String tmp = "";

            for(int m = i;m < ns.length();m++){
                if(isDigit(ns.charAt(m))){
                    tmp = tmp + ns.charAt(m);
                }else{
                    if(map.get(tmp) == null){
                        map.put(tmp,i);
                    }
                    break;
                }
            }
        }


        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue()< o1.getValue() ? 1 : -1;
            }
        });

        String ret = "";
        for(Map.Entry<String,Integer> en : list){
            if(en.getKey().length() > ret.length()){
                ret = en.getKey();
            }
        }

        if(ret.equals("")){
            System.out.println("N");
        }else{
            System.out.println(ret);
        }

    }

    public static boolean isDigit(char c){
        return Character.isDigit(c);
    }
}
