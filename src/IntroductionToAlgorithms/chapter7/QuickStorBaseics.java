package IntroductionToAlgorithms.chapter7;

public class QuickStorBaseics implements QuickSort{
    @Override
    public void quickSort(int[] array, int l, int r) {
        if (l < r) {
            int temp = Partition(array,l,r);
            quickSort(array,l,temp-1);
            quickSort(array,temp+1,r);
        }
    }

    @Override
    public int Partition(int[] array, int l, int r) {
        int i = l - 1;
        int x = array[r];

        for (int j = l; j < r; j++) {
            if (array[j] >= x){
                i++;
                Exchange(array,i,j);
            }
        }
        Exchange(array,i + 1,r);
        return i+1;
    }

    @Override
    public void Exchange(int[] array,int x ,int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
