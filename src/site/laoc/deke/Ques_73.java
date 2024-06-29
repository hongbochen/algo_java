package site.laoc.deke;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/*

    给出一个只包含字母的字符串,
    不包含空格,统计字符串中各个子字母(区分大小写)出现的次数,
    并按照字母出现次数从大到小的顺序输出各个字母及其出现次数
    如果次数相同,按照自然顺序排序,且小写字母在大写字母之前

    输入描述:
      输入一行仅包含字母的字符串

    输出描述:
      按照字母出现次数从大到小的顺序输出各个字母和字母次数,
      用英文分号分割,
      注意末尾的分号
      字母和次数中间用英文冒号分隔

    示例:
        输入: xyxyXX
        输出:x:2;y:2;X:2;
    说明:每个字符出现的次数为2 故x排在y之前
    而小写字母x在大写X之前

    示例2:
        输入:
         abababb
        输出:
            b:4;a:3
        说明:b的出现个数比a多 故排在a前
     */
public class Ques_73 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        scanner.close();

        HashMap<Character,Integer> map = new HashMap();

        for(int i = 0;i < line.length();i++){
            char c = line.charAt(i);

            if(map.containsKey(c)){
                continue;
            }

            int sums = 0;
            for(int j = i;j < line.length();j++){
                if(line.charAt(j) == c){
                    sums++;
                }
            }

            map.put(c,sums);
        }

        //
      List<Map.Entry<Character,Integer>> list =  map.entrySet().stream().sorted((o1, o2)->{
            int v1 = o1.getValue();
            int v2 = o2.getValue();

            int l1 = o1.getKey();
            int l2 = o2.getKey();

            if(v1 == v2){
                return l1 - l2;
            }else{
                return v2 - v1;
            }
        }).collect(Collectors.toList());

        System.out.println(list);
    }
}
