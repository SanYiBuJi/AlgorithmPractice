package huaweiOD;

import java.util.Objects;
import java.util.Scanner;

public class OD4_MaximanNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] mn = in.nextLine().split(",");
        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);
        String[][] array = new String[m][n];
        for (int i = 0; i < m; i++) {
            array[i] = in.nextLine().split(",");
        }
        System.out.println(MaxManNumber(array,m,n));
    }
    public static int MaxManNumber(String[][] array,int m,int n){
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j].equals("M")){
                    int temp = 0;
                    int count = 1;
                    // 先计算水平方向长度
                    temp = j + 1;
                    while (temp < n && array[i][temp].equals("M")){
                        count++;
                        temp++;
                    }
                    if (max<count){
                        max = count;
                    }
                    // 垂直方向长度
                    temp = i + 1;
                    count = 1;
                    while (temp < m && array[temp][j].equals("M")){
                        count++;
                        temp++;
                    }
                    if (max<count){
                        max = count;
                    }
                    // 对角线方向
                    count = 1;
                    temp = i + 1;
                    int temp2 =  j + 1;
                    while (temp < m && temp2 < n && array[temp][temp2].equals("M")){
                        count++;
                        temp++;
                        temp2++;
                    }
                    if (max<count){
                        max = count;
                    }
                    // 斜对角线
                    count = 1;
                    temp = i - 1;
                    temp2 =  j - 1;
                    while (temp > 0 && temp2 > 0 && array[temp][temp2].equals("M")){
                        count++;
                        temp--;
                        temp2--;
                    }
                    if (max<count){
                        max = count;
                    }
                }
            }
        }
        return max;
    }
}

//import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.util.Arrays;
//        import java.util.stream.IntStream;
//
//public class Main {
//    private static int maxLen;
//
//    private static void solveMethod(int n, int m, char[][] matrix) {
//        final int[][] ACTIONS = {{0, 1}, {1, 0}, {1, 1}, {-1, -1}};
//        IntStream.range(0, n - maxLen)
//                .parallel()
//                .forEach(i -> IntStream.range(0, m - maxLen)
//                        .parallel()
//                        .forEach(j -> Arrays.stream(ACTIONS)
//                                .parallel()
//                                .forEach(action -> find(matrix, action, i, j))));
//        System.out.println(maxLen);
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String[] split = reader.readLine().split(",");
//        int n = Integer.parseInt(split[0]), m = Integer.parseInt(split[1]);
//        char[][] matrix = new char[n][m];
//        for (int i = 0; i < n; ++i) {
//            matrix[i] = reader.readLine().replaceAll(",", "").toCharArray();
//        }
//        solveMethod(n, m, matrix);
//    }
//
//    private static void find(char[][] matrix, int[] action, int r, int c) {
//        int count = 0;
//        while (r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length) {
//            count = (matrix[r][c] == 'M') ? count + 1 : 0;
//            maxLen = Math.max(count, maxLen);
//            r += action[0];
//            c += action[1];
//        }
//    }
//}
//

