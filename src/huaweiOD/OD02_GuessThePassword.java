package huaweiOD;

import java.util.*;

public class OD02_GuessThePassword {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] dirs = in.nextLine().split(",");
        int minLength = in.nextInt();
        List<Integer> dire = new ArrayList<>();
        for (String dir : dirs) {
            dire.add(Integer.parseInt(dir));
        }
        Collections.sort(dire);
        List<List<Integer>> passwordList = new ArrayList<>();
        for (Integer init :
                dire) {
            List<List<Integer>> list = new ArrayList<>();
            for (List<Integer> passwd :
                    passwordList) {
                list.add(new ArrayList<>(passwd));
            }
            passwordList.add(Collections.singletonList(init));
//            if (list.size())
            for (List<Integer> pr :
                    list) {
                if (!pr.isEmpty()){
                    pr.add(init);
                    passwordList.add(pr);
                }
            }
        }
        System.out.println(passwordList);
        List<String> passwordListString = new ArrayList<>();
        passwordList = passwordList.stream().filter(passd->passd.size() >= minLength).distinct().toList();
        for (List<Integer> passd :
                passwordList) {
            String paswdstr = "";
            for (int i = 0; i < passd.size(); i++) {
                paswdstr = paswdstr + passd.get(i);
                if (i != passd.size() -1){
                    paswdstr += ",";
                }
            }
            passwordListString.add(paswdstr);
        }
        Collections.sort(passwordListString);
        for (String pass :
                passwordListString) {
            System.out.println(pass);
        };
    }
}
//
//import java.util.*;
//public class Main {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String[] numStrings = scanner.nextLine().split(",");
//        int n = Integer.parseInt(scanner.nextLine());
//
//        List<List<Integer>> combinations = new ArrayList<>();
//        Arrays.sort(numStrings);
//
//        for (int i = n; i <= numStrings.length; i++) {
//            generateCombinations(numStrings, i, 0, new ArrayList<>(), combinations);
//        }
//
//        if (!combinations.isEmpty()) {
//            for (List<Integer> combination : combinations) {
//                StringBuilder sb = new StringBuilder();
//                for (int num : combination) {
//                    sb.append(num).append(",");
//                }
//                String combinationString = sb.toString();
//                System.out.println(combinationString.substring(0,
//                        combinationString.length() - 1));
//            }
//        } else {
//            System.out.println("None");
//        }
//    }
//
//    private static void generateCombinations(String[] numStrings, int k, int start,
//                                             List<Integer> current, List<List<Integer>> combinations) {
//        if (k == 0) {
//            combinations.add(new ArrayList<>(current));
//            return;
//        }
//
//        for (int i = start; i <= numStrings.length - k; i++) {
//            current.add(Integer.parseInt(numStrings[i]));
//            generateCombinations(numStrings, k - 1, i + 1, current, combinations);
//            current.remove(current.size() - 1);
//        }
//    }
//}
//
