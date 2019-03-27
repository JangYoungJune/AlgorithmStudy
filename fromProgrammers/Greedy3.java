package AlgorithmStudy.fromProgrammers;
/*
 * Problem URL: https://programmers.co.kr/learn/courses/30/lessons/42860?language=java
 */

public class Greedy3 {
    public static int solution(String name) {
        StringBuilder nameBuilder = new StringBuilder(name);
        String completeName = "";
        for (int i = 0; i < name.length(); i++) {
            completeName += "A";
        }
        int answer = 0;
        int index = 0;
        while (true) {
            answer = answer + Math.min((nameBuilder.charAt(index) - 'A'), ('Z' - nameBuilder.charAt(index) + 1));
            nameBuilder.replace(index, index + 1, "A");
            if (nameBuilder.toString().equals(completeName)) {
                break;
            }
            int rightIndex = (index == nameBuilder.length() - 1) ? 0 : index + 1;
            int rightAdd = 1;
            int leftIndex = (index == 0) ? nameBuilder.length() - 1 : index - 1;
            int leftAdd = 1;
            while (nameBuilder.charAt(rightIndex) == 'A') {
                rightIndex = (rightIndex == nameBuilder.length() - 1) ? 0 : rightIndex + 1;
                rightAdd++;
            }
            while (nameBuilder.charAt(leftIndex) == 'A') {
                leftIndex = (leftIndex == 0) ? nameBuilder.length() - 1 : leftIndex - 1;
                leftAdd++;
            }
            if (leftAdd < rightAdd) {
                index = leftIndex;
                answer += leftAdd;
            } else {
                index = rightIndex;
                answer += rightAdd;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String a = "JAN";
        int answer = solution(a);
        System.out.println(answer);
    }
}
