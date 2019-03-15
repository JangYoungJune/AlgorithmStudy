package AlgorithmStudy.fromProgrammers;

import java.util.Arrays;

/*
 * problem URL: https://programmers.co.kr/learn/courses/30/lessons/42747?language=java
 * */
public class Sort3 {
    public static int solution(int[] citations) {
        /*
         * 어떤 과학자가 발표한 논문 n편 중,
         * h번 이상 인용된 논문이 h편 이상이고
         * 나머지 논문이 h번 이하 인용되었다면 h가 이 과학자의 H-Index입니다.
         * */
        int answer = 0;
        int i, startIdx, endIdx;
        int maxLength = citations.length;
        Arrays.sort(citations);
        for (i = 0; i < maxLength; i++) {
            if ((citations[i] <= maxLength - i) && (citations[i] >= i)) {
                continue;
            } else {
                break;
            }
        }
        startIdx = (i != 0) ? citations[i - 1] : 0;
        endIdx = citations[i];
        for (int j = startIdx; j <= endIdx; j++) {
            if ((j <= ((j == startIdx) ? maxLength - i + 1 : maxLength - i)) && (j >= i - 1)) {
                answer = j;
                continue;
            } else {
                break;
            }
        }
        return answer;
    }

    public static void main(String args[]) {
        int[] a = {0, 1000, 1000, 1000};

        int answer = solution(a);
        System.out.println(answer);
    }
}
