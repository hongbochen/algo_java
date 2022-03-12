package site.laoc.deke;

import java.util.*;

public class ques_86_1 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int nums = Integer.parseInt(scanner.nextLine());
        String ids = scanner.nextLine();
        String scores = scanner.nextLine();

        scanner.close();

        List<Integer> idList = toIntList(ids);
        List<Integer> scoList = toIntList(scores);

        Map<Integer,List<Integer>> map = new HashMap<>();

        for(int i = 0;i < idList.size();i++){
            Integer id = idList.get(i);
            Integer score = scoList.get(i);

            List<Integer> nlist = map.getOrDefault(id,new LinkedList<>());
            nlist.add(score);
            map.put(id,nlist);
        }

        StringBuilder sb = new StringBuilder();

        map.entrySet()
                .stream()
                .filter(x -> x.getValue().size() >= 3)
                .sorted((o1,o2) -> {
                    Integer sum1 = toSum(o1.getValue());
                    Integer sum2 = toSum(o2.getValue());

                    if(sum1.equals(sum2)){
                        return o2.getKey() - o1.getKey();
                    }else{
                        return sum2 - sum1;
                    }
                }).map(Map.Entry::getKey)
                .forEach(x -> sb.append(x).append(","));

        System.out.println(sb.substring(0, sb.length() - 1));
    }

    private static int toSum(List<Integer> list){
        list.sort(Integer::compareTo);

        int sum = 0;
        for(int i = list.size()-1;i >= list.size()-3;i--){
            sum = sum + list.get(i);
        }

        return sum;
    }

    private static List<Integer> toIntList(String str){
        String tmps[] = str.split(",");

        List<String> strLisr = Arrays.asList(tmps);

        List<Integer> intList = new ArrayList<>();

        for(String tmp : strLisr){
            intList.add(Integer.parseInt(tmp));
        }

        return intList;
    }
}
