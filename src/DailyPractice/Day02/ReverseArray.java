package DailyPractice.Day02;
// https://www.nowcoder.com/questionTerminal/bb06495cc0154e90bbb18911fd581df6
public class ReverseArray {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,0};
        System.out.println(getReverseArray(array,0,array.length - 1));
    }

    public static int getReverseArray(int[] array,int l,int r){
        if (l == r){
            return 0;
        }
        int mid = (l + r)/ 2;
        return getReverseArray(array,l,mid) + getReverseArray(array,mid + 1,r) + mergeSortRecursion(array,l,mid,r);
    }

    public static int mergeSortRecursion(int[] array,int l,int mid,int r){
        int[] tempArray = new int[r - l + 1];
        int index = 0;
        int i = l;
        int j = mid + 1;
        int count = 0;

        while (i <= mid && j<= r){
            if (array[i] <= array[j]){
                tempArray[index++] = array[i++];
            }else {
                // 当前一个数组元素大于后一个数组元素时，累加逆序对
                // s[i] > s[j] 推导出 s[i]...s[mid] > s[j]
                count += mid - i + 1;
                tempArray[index++] = array[j++];
            }
        }
        while (i <= mid){
            tempArray[index++] = array[i++];
        }
        while (j <= r){
            tempArray[index++] = array[j++];
        }
        for (int value : tempArray) {
            array[l++] = value;
        }
        return count;
    }
}
