package lib.utils;

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
}
