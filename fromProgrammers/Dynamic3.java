package fromProgrammers;

/*
 * Problem URL: https://programmers.co.kr/learn/courses/30/lessons/42895?language=java
 */
public class Dynamic3 {
    public static int solution(int N, int number){
        int answer = bfs(0, number, N);
        if(answer>=8){
            answer =  -1;
        }
        return answer;
    }
    public static int bfs(int depth, int number, int N){
        int cnt = 0;
        int case1=999, case2=999, case3=999, case4=999;
        String strNumber = Integer.toString(number);

        for(int i=0;i<strNumber.length();i++){
            cnt = cnt + ((strNumber.charAt(i)==N+'0')? 1 : 0);
        }
        if(number<0){
            return 999;
        }
        if(depth>8){
            return depth;
        }
        if(cnt==strNumber.length()){
            return depth + strNumber.length();
        }

        case1 = bfs(depth+1, number + N, N);
        case2 = bfs(depth+1, number * N, N);
        if(number - N>=0){
            case3 = bfs(depth+1, number - N, N);
        }
        if(number % N == 0){
            case4 = bfs(depth+1, number / N, N);
        }
        int minValue = Math.min(Math.min(case1, case2), Math.min(case3, case4));
        return minValue;
    }


    public static void main(String[] args) {
        int a = 5;
        int b = 31168;
        int answer = solution(a, b);
        System.out.println(answer);
    }
}
