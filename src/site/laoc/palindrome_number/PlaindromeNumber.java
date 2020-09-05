package site.laoc.palindrome_number;

public class PlaindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }

        int value = 0;

        int temp = x;
        int extra = 0;

        do{
            int xx = temp;
            temp = xx / 10;
            extra = xx % 10;
            value = value * 10 + extra;

            //System.out.println(value);
        }while(temp != 0);

        if(value == x){
            return true;
        }

        return false;
    }

    public boolean isPalindrome1(int x) {
        String temp = "" + x;

        String newX = "";

        int length = temp.length();
        for(int i = length - 1;i >=0; i--){
            newX = newX + temp.charAt(i);
        }

        if(newX.equals(temp)){
            return true;
        }

        return false;
    }

    public static void main(String[] args){
        PlaindromeNumber plaindromeNumber = new PlaindromeNumber();
        System.out.println(plaindromeNumber.isPalindrome(-121));
    }
}
