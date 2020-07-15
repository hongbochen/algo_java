package site.laoc.longest_palind_rome;

public class LongestPalindrome {

    // babad
    public String longestPalindrome(String s) {
        String fin = "";

        for(int i = 0;i < s.length();i++){
            char a = s.charAt(i);

            int m = i-1;
            int n = i + 1;

            while(m >= 0 && n < s.length()){
                if(s.charAt(m) != s.charAt(n)){
                    //System.out.println(m + "---" + n);
                    String tmp = s.substring(m+1,n);
                    //System.out.println(tmp);
                    if(tmp.length() > fin.length()){
                        fin = tmp;
                    }
                    break;
                }
                m--;
                n++;
            }


            if(m < 0 || n >= s.length()){
                if(s.charAt(m+1) == s.charAt(n-1)){
                    //System.out.println("--"+m + "---" + n);
                    String tmp = s.substring(m+1,n);
                    //System.out.println(tmp);
                    if(tmp.length() > fin.length()){
                        fin = tmp;
                    }
                    //System.out.println(fin);
                }
            }

            if(i+1 < s.length()){
                char b = s.charAt(i+1);

                if(a == b){
                    String tmp = s.substring(i,i+2);
                    //System.out.println(tmp);
                    //System.out.println(fin);
                    if(tmp.length() > fin.length()){
                        fin = tmp;
                    }
                    for(m = i-1,n=i+2;m >=0 && n < s.length();m--,n++){
                        if(s.charAt(m) != s.charAt(n)){
                            String tmp1 = s.substring(m+1,n);
                            //System.out.println(tmp1);
                            if(tmp1.length() > fin.length()){
                                fin = tmp1;
                            }
                            //System.out.println(fin);
                            break;
                        }
                    }

                    if(m < 0 || n >= s.length()){
                        if(s.charAt(m+1) == s.charAt(n-1)){
                            //System.out.println("--"+m + "---" + n);
                            String tmp1 = s.substring(m+1,n);
                            //System.out.println(tmp1);
                            if(tmp1.length() > fin.length()){
                                fin = tmp1;
                            }
                            //System.out.println(fin);
                        }
                    }
                }
            }

        }

        return fin;
    }

    public static void main(String args[]){
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String lng = longestPalindrome.longestPalindrome("babaddtattarrattatddetartrateedredividerb");

        System.out.println(lng);
    }
}
