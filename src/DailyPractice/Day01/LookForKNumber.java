package DailyPractice.Day01;

import java.util.Scanner;

public class LookForKNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = null;
        int k = 0;
        System.out.println(QuickSort(array,k,0,array.length-1));
    }

    public static int QuickSort(int[] array,int k,int l, int r){
        if (l<r){
            int temp = Partition(array,l,r);
            if (temp == k){
                return array[temp];
            }else if (temp < k){
                QuickSort(array,k,temp+1,r);
            }else if (temp > k){
                QuickSort(array,k,l,temp-1);
            }
        }else {
            return array[l];
        }
    }
    public static int Partition(int[] array,int l,int r){
        if (l<r){
            int maxIndex = l;
            int minIndex = r;
            for (int i = r; i > l; ) {
                if (array[minIndex]<array[maxIndex]){
                    minIndex--;
                }
            }

        }
        return 0;
    }
}
