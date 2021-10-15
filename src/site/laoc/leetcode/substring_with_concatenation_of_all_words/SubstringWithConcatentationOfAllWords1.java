package site.laoc.leetcode.substring_with_concatenation_of_all_words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatentationOfAllWords1 {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ansList = new ArrayList<>();

        if(s.length() < 1 || words.length < 1)
            return ansList;

        HashMap<String,Integer> keys = new HashMap<>();

        for(int i = 0;i < words.length;i++){
            if(keys.containsKey(words[i])){
                keys.put(words[i],keys.get(words[i]) + 1);
            }else{
                keys.put(words[i],1);
            }
        }

        int len = words[0].length();

        for(int i = 0;i <= s.length() - words.length * len;i++){
            int from = i;

            String str = s.substring(from, from + len);
            int cnt = 0;

            while(keys.containsKey(str) && keys.get(str) > 0){
                cnt++;
                keys.put(str,keys.get(str) - 1);

                from = from + len;

                if(from + len > s.length()){
                    break;
                }

                str = s.substring(from,from + len);
            }

            if(cnt == words.length){
                ansList.add(i);
            }

            if(cnt > 0){
                keys.clear();
                for(int j = 0;j < words.length;j++){
                    if(keys.containsKey(words[j])){
                        keys.put(words[j],keys.get(words[j]) + 1);
                    }else{
                        keys.put(words[j],1);
                    }
                }
            }

        }

        return ansList;
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
        SubstringWithConcatentationOfAllWords1 test = new SubstringWithConcatentationOfAllWords1();

        String[] words = {"dhvf","sind","ffsl","yekr","zwzq","kpeo","cila","tfty","modg","ztjg","ybty","heqg","cpwo","gdcj","lnle","sefg","vimw","bxcb"};
        String s = "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel";

        List<Integer> bcs = test.findSubstring(s,words);
        printList(bcs);
    }
}
