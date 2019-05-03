package fromProgrammers;
/*
 * Problem URL: https://programmers.co.kr/learn/courses/30/lessons/43163?language=java
 */
import java.util.Arrays;

public class FirstSearch3 {
    static String[] wordSet;
    static boolean[]  useWord;
    static int answer = Integer.MAX_VALUE;

    public static int solution(String begin, String target, String[] words) {
        wordSet = words;
        useWord = new boolean[words.length];

        boolean isNone = Arrays.stream(words).noneMatch((str)->str.equals(target));
        if(isNone){
            return 0;
        }

        for(int i=0;i<useWord.length;i++){ //initialize
            useWord[i] = false;
        }
        bfs(begin, target, 0);

        return answer;
    }
    public static void bfs(String now, String target, int depth){
        if(now.equals(target)){
            answer = (answer>depth)? depth : answer;
        }
        for(int i=0;i<wordSet.length;i++){
            int diffCnt = 0;
            int diffIdx = -1;
            int changeCnt = 0;
            for(int j=0;j<now.length();j++){
                if(now.charAt(j)!=wordSet[i].charAt(j)){
                    diffCnt++;
                    diffIdx = j;
                }
            }
            if(diffCnt==1 && useWord[i]==false){
                useWord[i]=true;
                bfs(wordSet[i], target, depth+1);
                useWord[i]=false;
            }
        }
    }
    public static void main(String[] args) {
        String a = "hit";
        String b = "cog";
        String[] c= {"hot","dot", "dog","lot", "log"};
        int answer = solution(a,b,c);
        System.out.println(answer);
    }
}
