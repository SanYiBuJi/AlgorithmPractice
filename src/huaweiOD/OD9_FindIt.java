package huaweiOD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OD9_FindIt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        in.nextLine();
        char[] w = in.nextLine().toCharArray();
        char[][] matrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            matrix[i] = in.nextLine().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (findIt(matrix,w,i,j,new boolean[n][m],0)){
                    System.out.println(i+1 + " " + (j+1));
                    return;
                }
            }
        }
        System.out.println("NO");
    }
    public static boolean findIt(char[][] matrix,char[] w,int x,int y, boolean[][] stats,int wt){
        if (wt == w.length){
            return true;
        }
        if (matrix[x][y] != w[wt] || stats[x][y]){
            return false;
        }else {
            stats[x][y] = true;
            if (y+1<matrix[x].length){
                if (!stats[x][y + 1]){
//                    System.out.println("向右");
                    if (findIt(matrix,w,x,y+1,stats,wt+1)){
                        return true;
                    }
                }
            }
            if ( y >= 1 ){
                if (!stats[x][y -1]){
//                    System.out.println("向左");
                    if (findIt(matrix,w,x,y-1,stats,wt+1)){
                        return true;
                    }
                }
            }
            if ( x < matrix.length -1 ){
                if (!stats[x+1][y]){
//                    System.out.println("向上");
                    if (findIt(matrix,w,x+1,y,stats,wt+1)){
                        return true;
                    }
                }
            }
            if ( x >= 1){
                if ( !stats[x-1][y]){
//                    System.out.println("向下");
                    if (findIt(matrix,w,x-1,y,stats,wt+1)){
                        return true;
                    }
                }
            }

            stats[x][y] = false;
            return false;
        }
    }
}
//
//主函数：
//        读取矩阵大小 M 和 N
//        读取要查找的字符串 W
//        创建字符矩阵 matrix
//        逐行读取输入，将每一行转换为字符数组，并存储在 matrix 中
//        调用 solveMethod 方法解决问题
//        打印结果
//
//        查找方法 find：
//        如果当前字符不匹配，返回 false
//        如果已经匹配到字符串的最后一个字符，返回 true
//        标记当前位置为已访问
//        定义四个方向的偏移量
//        遍历四个方向：
//        计算新的坐标 newx 和 newy
//        如果新坐标合法且未被访问过：
//        递归调用 find 方法
//        如果递归调用返回 true，返回 true
//        回溯，将当前位置标记为未访问
//        返回 false
//
//        解决方法 solveMethod：
//        获取矩阵的行数 h 和列数 w
//        创建布尔类型的二维数组 visited，用于标记位置是否已访问
//        遍历矩阵中的每个位置：
//        调用 find 方法进行查找
//        如果找到匹配的字符串，返回当前位置的坐标
//        没有找到匹配的字符串，返回 "NO"

//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        // 读取矩阵大小
//        String line = scanner.nextLine().trim();
//        int M = Integer.parseInt(line.split(" ")[0]);
//        int N = Integer.parseInt(line.split(" ")[1]);
//
//        // 读取要查找的字符串
//        String W = scanner.nextLine().trim();
//
//        // 读取矩阵
//        char[][] matrix = new char[N][M];
//        for (int i = 0; i < N; i++) {
//            String row = scanner.nextLine().trim();
//            matrix[i] = row.toCharArray();
//        }
//
//        // 调用求解方法
//        String res = solveMethod(matrix, W);
//        System.out.println(res);
//    }
//
//    // 查找方法
//    private static boolean find(char[][] board, boolean[][] visited, int x, int y,
//                                String s, int k) {
//        // 如果当前字符不匹配，返回 false
//        if (board[x][y] != s.charAt(k)) {
//            return false;
//        }
//        // 如果已经匹配到字符串的最后一个字符，返回 true
//        else if (k == s.length() - 1) {
//            return true;
//        }
//
//        // 标记当前位置为已访问
//        visited[x][y] = true;
//
//        // 定义四个方向的偏移量
//        int[][] dic = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//
//        // 遍历四个方向
//        for (int[] dir : dic) {
//            int newx = x + dir[0];
//            int newy = y + dir[1];
//
//            // 如果新坐标合法且未被访问过
//            if (newx >= 0 && newx < board.length && newy >= 0 && newy < board[0].length) {
//                if (!visited[newx][newy]) {
//                    // 递归调用查找方法
//                    boolean flag = find(board, visited, newx, newy, s, k + 1);
//                    if (flag) {
//                        return true;
//                    }
//                }
//            }
//        }
//
//        // 回溯，将当前位置标记为未访问
//        visited[x][y] = false;
//        return false;
//    }
//
//    private static String solveMethod(char[][] board, String word) {
//        int h = board.length;
//        int w = board[0].length;
//        boolean[][] visited = new boolean[h][w];
//
//        // 遍历矩阵中的每个位置
//        for (int i = 0; i < h; i++) {
//            for (int j = 0; j < w; j++) {
//                // 调用查找方法
//                boolean flag = find(board, visited, i, j, word, 0);
//                if (flag) {
//                    // 如果找到匹配的字符串，返回位置坐标
//                    return (i + 1) + " " + (j + 1);
//                }
//            }
//        }
//
//        // 没有找到匹配的字符串
//        return "NO";
//    }
//}


