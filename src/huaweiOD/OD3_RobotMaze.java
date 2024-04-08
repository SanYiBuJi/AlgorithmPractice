package huaweiOD;

import java.util.Scanner;

public class OD3_RobotMaze {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] array = new int[m][n];
        int number = in.nextInt();
        for (int i = 0; i < number; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            array[x][y] = -1;
        }
        mazeRun(array,0,0);
        int countB = 0;
        int countA = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == -2){
                    countB++;
                }else if (array[i][j] == 0){
                    countA++;
                }
            }
        }
        System.out.println(countB);
        System.out.println(countA);

    }
    public static void mazeRun(int[][] array, int x, int y){
        if (array[x][y] == -1){
            return;
        }
        if (x < array.length - 1){
            mazeRun(array,x + 1,y);
        }
        if (y < array[0].length - 1){
            mazeRun(array,x,y + 1);
        }
        if (y + 1 == array[x].length){
            array[x][y] = 1;
            return;
        }
        if (array[x][y +1] == -1 && x == array.length - 1 ){
            array[x][y] = -2;
            return;
        }
        if (array[x][y + 1] == -1 && array[x + 1][y] == -2){
            array[x][y] = -2;
            return;
        }
       array[x][y] = 1;
    }
}

//import java.util.HashSet;
//        import java.util.Objects;
//        import java.util.Scanner;
//        import java.util.Set;
//
//public class Main {
//    static int xLength;
//    static int yLength;
//
//    static class CheckModel {
//        int x;
//        int y;
//
//        public CheckModel(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(x, y);
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (o == this)
//                return true;
//            if (o == null || getClass() != o.getClass())
//                return false;
//            CheckModel check = (CheckModel) o;
//            return x == check.x && y == check.y;
//        }
//
//    }
//
//    private static void findItOut(int x, int y, Set<CheckModel> wallSet, Set<CheckModel> checkSet,
//                                  Set<CheckModel> finishSet) {
//
//        if (yLength - 1 == y && xLength - 1 == x) {
//            finishSet.add(new CheckModel(x, y));
//        }
//
//        if (yLength <= y|| x >= xLength) {
//            return;
//        }
//
//        checkSet.add(new CheckModel(x, y));
//        // 北方向
//        if (!wallSet.contains(new CheckModel(x, y + 1))) {
//            findItOut(x, y + 1, wallSet, checkSet, finishSet);
//        } else {
//            finishSet.add(new CheckModel(x, y));
//        }
//        // 东方向
//        if (!wallSet.contains(new CheckModel(x + 1, y))) {
//            findItOut(x + 1, y, wallSet, checkSet, finishSet);
//        } else {
//            finishSet.add(new CheckModel(x, y));
//        }
//    }
//
//    public static void main(String[] args) {
//        try {
//            Scanner s = new Scanner(System.in);
//            xLength = s.nextInt();
//            yLength = s.nextInt();
//            int size = s.nextInt();
//            int[][] values = new int[size][2];
//            for (int i = 0; i < size; ++i) {
//                values[i][0] = s.nextInt();
//                values[i][1] = s.nextInt();
//            }
//            int trapCount = 0;
//            int invalidCount = 0;
//            Set<CheckModel> wallHashSet = new HashSet<>();
//            for (int[] wall : values) {
//                wallHashSet.add(new CheckModel(wall[0], wall[1]));
//            }
//            Set<CheckModel> checksHashSet = new HashSet<>();
//            Set<CheckModel> finishHashSet = new HashSet<>();
//
//            findItOut(0, 0, wallHashSet, checksHashSet, finishHashSet);
//
//            invalidCount = xLength * yLength - checksHashSet.size() - wallHashSet.size();
//
//            for (CheckModel model : finishHashSet) {
//                Set<CheckModel> checksT = new HashSet<>();
//                Set<CheckModel> finishT = new HashSet<>();
//                findItOut(model.x, model.y, wallHashSet, checksT, finishT);
//                if (!finishT.contains(new CheckModel(xLength - 1, yLength - 1))) {
//                    trapCount++;
//                }
//            }
//
//            System.out.print(trapCount + " " + invalidCount);
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("input error");
//        }
//    }
//}

