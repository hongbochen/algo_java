package site.laoc.leetcode.reverse_integer;

public class IntegerReverse {

    public int reverse(int x) {

        if(x < Integer.MIN_VALUE){
            return 0;
        }

        if(x > Integer.MAX_VALUE){
            return 0;
        }

        int tmp = x;
        long bc = 0;

        while(tmp != 0){
            int shang = tmp / 10;
            int yu = tmp % 10;

            bc = bc * 10 + yu;
            tmp = shang;
        }

        if(bc < Integer.MIN_VALUE){
            return 0;
        }

        if(bc > Integer.MAX_VALUE){
            return 0;
        }

        return (int)bc;
    }

    public static void main(String args[]){
        IntegerReverse integerReverse = new IntegerReverse();
        integerReverse.reverse(120);
    }
}
