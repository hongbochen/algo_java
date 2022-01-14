package site.laoc.leetcode.reverse_string;

public class ReverseString {

    public void reverseString(char[] s) {
        for(int i = 0,j = s.length-1;i <= j;i++,j--){
            swap(s,i,j);
        }
    }

    private void swap(char[] s,int i,int j){
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    public static void printArray(char[] s){
        for(int i = 0;i < s.length;i++){
            System.out.print(s[i] + " ");
        }

        System.out.println();
    }

    public static void main(String args[]){
        ReverseString reverseString = new ReverseString();

        char[] s = {'h','e','l','l','o'};

        reverseString.reverseString(s);

        printArray(s);
    }
}
