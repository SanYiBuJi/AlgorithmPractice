package paiduochen;

import java.util.Scanner;

public class dome1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean[] arr = new boolean[100];
        for (boolean temp :
                arr) {
            temp = false;
        }
        while (in.hasNext()){
            int index = in.nextInt();
            int offset = in.nextInt();
//            for (int i = index; i < index+offset; i++) {
//                if (arr[i]){
//                    temp = true;
//                }
////                else {
////                    System.out.println(-1);
////                }
//            }
            for (int i = index; i < index+offset; i++) {
                arr[i] = true;
            }
        }
        int max = -1;
        int temp = 0;
        int index = 0;
        int index_temp = -1;
        for (int i = 0; i < 100; i++) {
            if(!arr[i]){
                temp++;
                if (index_temp == -1){
                    index_temp = i;
                }
            }else {
                if (max<temp){
                    max = temp;
                    index = index_temp;
                    index_temp = -1;
                }
                temp = 0;
            }
            if (max>= n){
                System.out.println(index);
                return;
            }
        }
        System.out.println(-1);
    }
}
