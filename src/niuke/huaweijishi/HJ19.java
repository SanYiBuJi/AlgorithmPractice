package niuke.huaweijishi;

import java.util.*;

public class HJ19 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        // List<ErrorClass> errs = new ArrayList<>();
        Queue<ErrorClass> errs = new ArrayDeque<>(8);
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            ErrorClass er = new ErrorClass();
            String[] str = in.nextLine().split(" ");
            if (str.length < 2){
                break;
            }
            String[] path = str[0].split("\\\\");
            String file = path[path.length -1];
            if(file.length() > 16){
                file = file.substring(file.length()-16);
            }
            er.file = file;
            er.index = str[1];
            boolean temp = false;
            for (ErrorClass ec :
                    errs) {
                if (Objects.equals(ec.file, er.file) && Objects.equals(ec.index, er.index)){
                    ec.count++;
                    temp = true;
                    break;
                }
            }
            if (!temp){
//                if (errs.size() == 8){
//                    errs.remove();
//                }
                errs.add(er);

            }
        }
        if (errs.size() > 8){
            Object[] array = errs.toArray();
            for (int i = errs.size() - 8; i < errs.size(); i++) {
                System.out.print(array[i]);
            }
        }else {
            for (ErrorClass ec :
                    errs) {
                System.out.println(ec);
            }
        }
    }
}

class ErrorClass{
    String file;
    String index;
    int count;

    public ErrorClass() {
        this.count = 1;
    }

    @Override
    public String toString() {
        return file + ' ' + index + ' ' + count + "\n" ;
    }
}
