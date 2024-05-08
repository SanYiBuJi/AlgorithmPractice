package niuke.huaweijishi;

import java.util.*;
import java.util.stream.Collectors;

public class HJ25 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int lLength = in.nextInt();
        int[] lArr = new int[lLength];
        for(int i=0;i<lLength;i++){
            lArr[i] = in.nextInt();
        }
        int rLength = in.nextInt();
        List<Integer> rList = new ArrayList<>();
        for(int i = 0;i<rLength;i++){
            rList.add(in.nextInt());
        }
        rList = rList.stream().distinct().sorted().collect(Collectors.toList());
        fun(lArr,rList);

    }
    public static void fun(int[] l,List<Integer> r){
//        Map<String,List> map = new HashMap<>();
        List<KVMap> kvlist = new ArrayList<>();
        int count = 0;
        for (Object o : r) {
            String ri = o.toString();
            List<KV> li = new ArrayList<>();
            for (int j = 0; j < l.length; j++) {
                if (String.valueOf(l[j]).contains(ri)) {
                    KV kv = new KV(String.valueOf(j), String.valueOf(l[j]));
                    li.add(kv);
                }
            }
            if (li.size()>0){
                KVMap kvMap = new KVMap();
                kvMap.Ri = ri;
                kvMap.list = li;
                kvMap.length = li.size();
                kvlist.add(kvMap);
                count+=2;
                count+=kvMap.length*2;
            }
        }
        System.out.print(count);
        for (KVMap kmp :
                kvlist) {
            System.out.print(","+kmp.toString());
        }
    }
}

class KV{
    String index;
    String value;

    public KV(String index, String value) {
        this.index = index;
        this.value = value;
    }
}
class KVMap{
    int length;
    String Ri;
    List<KV> list;

    @Override
    public String toString() {
        StringBuilder sub = new StringBuilder();
        sub.append(Ri).append(",").append(length * 2);
        for (KV kv :
                list) {
            sub.append(",").append(kv.index).append(",").append(kv.value);
        }
        return sub.toString();
    }
}
