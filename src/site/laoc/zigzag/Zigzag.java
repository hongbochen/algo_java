package site.laoc.zigzag;

// https://www.jianshu.com/p/8b83c6a2eff8
public class Zigzag {
    public static String convert(String s, int numRows) {
        int j = 0;

        if(numRows == 1){
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < numRows;i++){
            j = i;

            while(j < s.length()){
                sb.append(s.charAt(j));

                j = j + 2 * (numRows - i - 1);
                if(i != numRows-1 && i != 0 && j <= s.length()-1){
                    sb.append(s.charAt(j));
                }

                j = j + 2*i;
            }
        }

        return sb.toString();
    }

    public static void main(String args[]){
        String s = "PAYPALISHIRING";
        int nums = 4;

        System.out.println(convert(s,nums));
    }
}
