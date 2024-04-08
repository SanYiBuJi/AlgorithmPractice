package paiduochen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Author: 华为OD联盟(梦想橡皮擦，码莎拉蒂，鸿蒙坚果)
 * Date: 2023/8/2
 * Time: 15:16
 *  Description:
 */

public class OdMain {
    static class Student implements Comparable<Student> {
        private int idx;
        private int high;
        private int weight;

        public Student(int idx, int high, int weight) {
            this.idx = idx;
            this.high = high;
            this.weight = weight;
        }

        @Override
        public int compareTo(Student stu) {
            if (stu.high > this.high) {
                return -1;
            }
            if (stu.weight > this.weight) {
                return -1;
            }
            if (stu.idx > this.idx) {
                return -1;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int count = Integer.parseInt(s.nextLine());
        String[] highStr = s.nextLine().split(" ");
        String[] weightStr = s.nextLine().split(" ");
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            studentList.add(new Student(i + 1, Integer.parseInt(highStr[i]), Integer.parseInt(weightStr[i])));
        }
        Collections.sort(studentList);
        for (int i = 0; i < studentList.size(); i++) {
            System.out.print(studentList.get(i).idx + " ");
        }
    }
}
