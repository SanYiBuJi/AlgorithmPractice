package niuke.huaweijishi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HJ3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        List<Integer> list = new ArrayList<>();
        while(in.hasNextInt()){
            list.add(in.nextInt());
        }
        list = list.stream().distinct().sorted().collect(Collectors.toList());
        for (Integer i :
                list) {
            System.out.println(i);
        }
    }
}
