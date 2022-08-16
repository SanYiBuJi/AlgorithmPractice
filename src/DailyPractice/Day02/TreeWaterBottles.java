package DailyPractice.Day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TreeWaterBottles {
    public static void  main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        ArrayList<String> s = new ArrayList<String>();
        try{
            str = br.readLine();
            while( !"0".equals(str)){
                s.add(str);
                str = br.readLine();
            }
        }catch(IOException e){
            throw e;
        }
        if (s.size() == 0){
            System.out.println("");
        }
        for (String str1:
             s) {
            Integer n = Integer.valueOf(str1);
            System.out.println(getTreeWaterBottles(n));;
        }

    }

    public static Integer getTreeWaterBottles(Integer n){
        Integer count = 0;
        if (n != 0 && n >= 3){
            Integer temp = n/3;
            Integer remainder = n%3;
            count = temp + getTreeWaterBottles( temp+remainder);
        }else if (n == 2){
            return 1;
        }else {
            return 0;
        }
        return count;
    }
}
