package site.laoc.leetcode.atoi;

public class Atoi {

    public int myAtoi(String str) {

        // 空格定义
        char space = ' ';
        int startIndex = 0;
        Long value = 0l;
        int mul = 1;

        // 1、首先进行前面空格筛查
        for(int i = 0;i < str.length();i++){
            char c = str.charAt(i);

            if(c == space){
                if(startIndex != 0){
                    return mul * value.intValue();
                }
                continue;
            }

            if((value == 0 && c == '-') || (value == 0 && c == '+')){
                if(i-1 >= 0 && str.charAt(i-1) != space){
                    return 0;
                }

                if(i+1 > str.length()-1){
                    return 0;
                }else{
                    char tp = str.charAt(i+1);
                    if(tp < '0' || tp > '9'){
                        return 0;
                    }else{
                        if(c == '-'){
                            mul = -1;
                        }else{
                            mul = 1;
                        }
                    }
                }
                continue;
            }

            if(value == 0 && (c < '0' || c > '9')){
                return 0;
            }


            if(value != 0 && (c < '0' || c > '9')){
                break;
            }


            int val = c-48;
            value = value * 10 + val;
            if(mul > 0){
                if(value > Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
            }else{
                if(mul * value < mul * Integer.MIN_VALUE){
                    return mul * Integer.MIN_VALUE;
                }
            }
            startIndex++;
        }


        if(mul > 0){
            if(value > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
        }else{
            if(mul * value < mul * Integer.MIN_VALUE){
                return mul * Integer.MIN_VALUE;
            }
        }

        return mul * value.intValue();
    }

    public static void main(String[] args){
        Atoi atoi = new Atoi();
        int value = atoi.myAtoi("0-1");
        System.out.println(value);
    }
}
