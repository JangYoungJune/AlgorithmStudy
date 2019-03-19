package AlgorithmStudy.fromProgrammers;
/*
 * Problem URL: https://programmers.co.kr/learn/courses/30/lessons/42839?language=java
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BruteForce2 {
    public static int solution(String numbers) {
        List<Integer> numberList = new ArrayList<>();
        String[] numberArr = numbers.split("");
        boolean[] useArr = new boolean[numberArr.length];
        for (int i = 0; i < useArr.length; i++) {
            useArr[i] = false;
        }

        for (int i = 0; i < numberArr.length; i++) {
            recursive(numberArr, useArr, "", i + 1, numberList);
        }
        numberList = numberList.stream().distinct().filter(num -> {
            if (num <= 1) {
                return false;
            } else {
                for (int i = 2; i <= (int) Math.sqrt(num); i++) {
                    if (num % i == 0) {
                        return false;
                    }
                }
                return true;
            }
        }).collect(Collectors.toList());


        return numberList.size();
    }

    public static void recursive(String[] num, boolean[] use, String nowNum, int length, List<Integer> store) {
        for (int i = 0; i < num.length; i++) {
            if (nowNum.length() == length) {
                store.add(Integer.parseInt(nowNum));
                break;
            } else if (use[i] == true) {
                continue;
            } else {
                use[i] = true;
                recursive(num, use, nowNum + num[i], length, store);
                use[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String a = "011";
        int answer = solution(a);
        System.out.println(answer);
    }
}
