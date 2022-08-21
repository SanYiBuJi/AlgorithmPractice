package IntroductionToAlgorithms.chapter7;

public interface QuickSort {
    abstract void quickSort(int[] array, int l, int r);
    abstract int Partition(int[] array,int l,int r);
    abstract void Exchange(int[] array, int x, int y);
}
