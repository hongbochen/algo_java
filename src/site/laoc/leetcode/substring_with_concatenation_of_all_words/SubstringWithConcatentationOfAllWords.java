package site.laoc.leetcode.substring_with_concatenation_of_all_words;

import java.util.ArrayList;
import java.util.List;


/**
 * 先求全排列，再匹配，超时
 */
public class SubstringWithConcatentationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> bcList = new ArrayList<>();

        int[] wordins = new int[words.length];

        for(int i = 1;i <= words.length;i++){
            wordins[i-1] = i;
        }

        List<String> all = new ArrayList<>();
        orderList(words,all,wordins,0);

        //printStrList(all);
        System.out.println("全排列完成");

        int len = all.get(0).length();

        for(int i = 0; i < s.length();i++){
            if(i + len > s.length()){
                break;
            }


            String tmp = s.substring(i,i+len);

            boolean has = false;
            for(String tt : all){
                if(tmp.equals(tt)){
                    has = true;
                }
            }

            if(has == true){
                bcList.add(i);
            }
        }

        return bcList;
    }

    private void orderList(String[] words, List<String> list,int[] wordins, int index){
        if(index >= wordins.length){
            String tmp = "";
            for(int i = 0;i < wordins.length;i++){
                //System.out.print(wordins[i] + " ");
                tmp = tmp + words[wordins[i]-1];
            }
            list.add(tmp);
            //System.out.println();
        }else{
            for(int i = index;i < wordins.length;i++){
                swap(wordins,index,i);
                orderList(words,list,wordins,index+1);
                swap(wordins,index,i);
            }
        }
    }

    private void swap(int[] arr,int index1,int index2){
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static void printStrList(List<String> list){
        for(String i : list){
            System.out.print(i+ " ");
        }

        System.out.println();
    }

    public static void printList(List<Integer> list){
        for(Integer i : list){
            System.out.print(i+ " ");
        }

        System.out.println();
    }

    public static void main(String args[]){
        SubstringWithConcatentationOfAllWords test = new SubstringWithConcatentationOfAllWords();

        String[] words = {"dhvf","sind","ffsl","yekr","zwzq","kpeo","cila","tfty","modg","ztjg","ybty","heqg","cpwo","gdcj","lnle","sefg","vimw","bxcb"};
        String s = "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel";

        List<Integer> bcs = test.findSubstring(s,words);
        printList(bcs);
    }
}
