package lib.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class utils {
    public static int[] getRandArray(int log){
        int[] result = new int[log];
        for (int i = 0; i < log; i++) {
            result[i] = i;
        }
        for (int i = 0; i < log; i++) {
            int random = (int) (log * Math.random());
            int temp = result[i];
            result[i] = result[random];
            result[random] = temp;
        }
        return result;
    }
    public static String printArray(int[] array){
        String str = "";
        for (int i = 0; i < array.length; i++) {
            if (i == 0){
                str += "[";
            }
            str += array[i];
            if (i == array.length-1){
                str += "]";
            }else {
                str += ",";
            }
        }
        return str;
    }
    public static String printArrayString(String[] array){
        String str = "";
        for (int i = 0; i < array.length; i++) {
            if (i == 0){
                str += "[";
            }
            str += array[i];
            if (i == array.length-1){
                str += "]";
            }else {
                str += ",";
            }
        }
        return str;
    }
    public static List<String> getData(String path) {
        List<String> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        try (
                FileReader fileReader = new FileReader(path);
                BufferedReader bf = new BufferedReader(fileReader)
        ) {
            //每次读取的长度
            int length = 0;
            char[] buffer = new char[20];
            while ((length = (bf.read(buffer))) != -1) {
                if (length <= 0) {
                    continue;
                }
                //注意只能处理length个，否则会多算，因为bf.read(buffer)如果读取数量小于buffer的大小，那么length后面的也不会覆盖
                for (int i = 0; i < length; i++) {
                    char c = buffer[i];
                    switch (c) {
                        case '[':
                            break;
                        case ',':
                        case ']':
                            //加入list
                            list.add(stringBuilder.toString());
                            //清空stringBuilder
                            stringBuilder.setLength(0);
                            break;
                        default:
                            //加入stringBuilder
                            stringBuilder.append(c);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return list;
    }
    public static int[] ListToArrayOfInt(List<String> list){
        int lent = list.size();
        int[] array = new int[lent];
        int index = 0;

        for (String s :
                list) {
            array[index] = Integer.valueOf(s);
            index++;
        }

        return array;
    }
}
