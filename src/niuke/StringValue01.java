package niuke;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
class Stv{
    int length;
    int value;
}
public class StringValue01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        char[] cstr = s.toCharArray();
        // 处理两边的长串
        int l = 0;
        Stv ls = new Stv();
        int r = n -1 ;
        Stv rs = new Stv();
        for (; l < n - 1; l++) {
            if (cstr[l] != cstr[l+1]){
                ls.length = l + 1;
                ls.value = cstr[l];
                break;
            }
            if ((l == n-2) && (cstr[l] == cstr[l+1])){
                System.out.println(func(n));
                return;
            }
        }
        for (; r > 0; r--) {
            if (cstr[r] != cstr[r-1]){
                rs.length = n - r ;
                rs.value = cstr[r];
                break;
            }
        }
        int a1=0,a0 = 0;
        for(int i = l +1; i < r;i++){
            char c = cstr[i];
            if(c == '0'){
                a0++;
            }else{
                a1++;
            }
        }
        int max = 0;
        char t = '-';
        if( a1 > a0){
            max = a1;
            t = '1';
        }else{
            max = a0;
            t = '0';
        }
        int sum = -1;
        if (t == ls.value){
            ls.length += max;
            max = -1;
        } else if (t == rs.value) {
            rs.length += max;
            max = -1;
        }
        if (max == -1){
            sum = func(ls.length)+func(rs.length);
        }else {
            sum = func(ls.length) + func(max) + func(rs.length);
        }
        System.out.println(sum);
        // while (in.hasNext()) { // 注意 while 处理多个 case
        //     // int a = in.nextInt();
        //     // int b = in.nextInt();
        //     // System.out.println(a + b);
        //     array[temp] = in.next();
        // }
    }
    public static int func(int length){
        int temp = 1;
        int sum = temp;
        for(int i = 1; i < length;i++){
            temp = temp + 1;
            sum = sum + temp;
        }
        return sum;
    }
}