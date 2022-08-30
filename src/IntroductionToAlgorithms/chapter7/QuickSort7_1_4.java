package IntroductionToAlgorithms.chapter7;

/**
 * 修改QuickSort，使得他可以非递增序进行排序
 */
public class QuickSort7_1_4 implements QuickSort{

    @Override
    public void quickSort(int[] array, int l, int r) {
        if (l < r){
            int temp = Partition(array,l,r);
            quickSort(array,l,temp - 1);
            quickSort(array,temp+1,r);
        }
    }

    @Override
    public int Partition(int[] array, int l, int r) {
        if (l == r){
            return l;
        }
        int i = l - 1;
        int j = l;
        int x = array[r];
        for (;j < r;j++){
            if (array[j] > x){
                i++;
                Exchange(array,i,j);
            }
        }
        Exchange(array,i + 1,r);
        return i + 1;
    }

    @Override
    public void Exchange(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
