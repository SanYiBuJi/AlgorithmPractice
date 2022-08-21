package DailyPractice.Day01;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import lib.utils.utils;

public class LookForKNumber {
    static int count = 0;
    public static void main(String[] args) {
        List<String> data = utils.getData("C:\\Users\\sanyi\\Desktop\\test.txt");
        int[] array = utils.ListToArrayOfInt(data);
//        System.out.println(utils.printArray(array));
        int k = 47359;
//        System.out.println(QuickSort(array,k,0,array.length-1));
//        System.out.println(utils.printArray(array));
        QuickSort(array,k,0,array.length-1);
//        System.out.println(utils.printArray(array));
    }

    public static void QuickSort(int[] array,int k,int l, int r){
//        System.out.println(count++);
        if (l<r){
            int temp = Partition(array,l,r);
//            QuickSort(array,k,l,temp-1);
//            QuickSort(array,k,temp+1,r);
            System.out.println("temp:"+temp);
            if (temp == k-1 || temp == -1){
                return;
            }else if (temp < k-1){
                System.out.println("l:"+(temp+1)+";r:"+r);
                QuickSort(array,k,temp+1,r);
            }else if (temp > k-1){
                System.out.println("l:"+l+";r:"+(temp-1));
                QuickSort(array,k,l,temp-1);
            }
        }
    }
    public static int Partition(int[] array,int l,int r){
        int ra = (int)(l + Math.random() * (r - l + 1));
        Exchange(array, r, ra);

        int i = l-1;

        if (l<r){
            int x = array[r];
            for (int j = l; j < r; j++ ) {
                if (array[j] > x){
                    i++;
                    Exchange(array,i,j);
                }
            }
            Exchange(array,i+1,r);
            return i+1;
        }
        return -1;
    }

    public static void Exchange(int[] array,int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
