package paiduochen;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static String distributeElements(int N, int K, List<List<Integer>> lists) {
        List<List<String>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());
        for (List<Integer> lst : lists) {
            int i = 0;
            for (int element : lst) {
                List<String>  res = result.get(i);
                res.add(String.valueOf(element));
                i = (i + 1) % N;
                if (result.get(i).size() == K) {
                    i = (i + 1) % N;
                }
            }
        }
        int index = 0;
        int i = 0;
        while (result.get(i).size() < K){

        }
        return result.stream().flatMap(List::stream).collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        scanner.nextLine();
        List<List<Integer>> lists = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) break;
            List<Integer> lst = Arrays.stream(line.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            lists.add(lst);
        }
        System.out.println(distributeElements(N, K, lists));
    }
}

