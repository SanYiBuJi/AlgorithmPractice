package DailyPractice.Day01;

import java.util.Scanner;
import lib.utils.utils;

public class LookForKNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split("]");
        System.out.println(utils.printArrayString(split));
//        int[] array = utils.getRandArray(10);
//        System.out.println(utils.printArray(array));
//        int k = 2;
//        System.out.println(QuickSort(array,k,0,array.length-1));
//        System.out.println(utils.printArray(array));
    }

    public static int QuickSort(int[] array,int k,int l, int r){
        if (l<r){
            int temp = Partition(array,l,r);
            System.out.println("temp:"+temp);
            if (temp == k-1){
                return array[temp];
            }else if (temp < k-1){
                QuickSort(array,k,temp+1,r);
            }else if (temp > k-1){
                QuickSort(array,k,l,temp-1);
            }
        }else {
            return array[l];
        }
        return array[k-1];
    }
    public static int Partition(int[] array,int l,int r){
        int i = l-1;
        if (l<r){
            int x = array[r];
            for (int j = l; j < r; j++ ) {
                if (array[j] >= x){
                    i++;
                    Exchange(array,i,j);
                }
            }
            Exchange(array,i+1,r);
            return i+1;
        }
        return i+1;
    }

    public static void Exchange(int[] array,int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
