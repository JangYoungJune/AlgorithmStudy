package fromProgrammers;
/*
 * Problem URL: https://programmers.co.kr/learn/courses/30/lessons/43165
 */
public class FirstSearch1 {
    public static int solution(int[] number, int target){
        return dfs(0, number.length, 0, target, number);
    }
    public static int dfs(int position, int depth, int value, int target, int[] number){
        if(position == depth){
            return (value == target)? 1 : 0;
        } else{
            return dfs(position+1, depth, value+number[position], target, number) + dfs(position+1, depth, value-number[position], target, number);
        }
    }

    public static void main(String[] args) {
        int[] a = {1,1,1,1,1};
        int b = 3;
        int answer = solution(a,b);
        System.out.println(answer);
    }
}
