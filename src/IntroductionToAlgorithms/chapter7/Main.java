package IntroductionToAlgorithms.chapter7;

import lib.utils.utils;

public class Main {
    public static void main(String[] args) {
        int[] array = {10,10,9,9,8,7,5,6,4,3,4,2};
//        int[] array = {9,9,9,9,9,9,9};
        QuickSort quickSort = new QuickSortBasics();
//        QuickSort quickSort = new QuickSortRandomNumberOptimize();
//        QuickSort quickSort = new QuickSort7_1_4();
        quickSort.quickSort(array,0,array.length-1);
        System.out.println(utils.printArray(array));
    }
}
