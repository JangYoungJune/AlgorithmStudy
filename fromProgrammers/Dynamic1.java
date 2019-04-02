package fromProgrammers;

public class Dynamic1 {
    public static long solution(int N){
        long answer = 0;
        long[] numberArr = new long[N+1];
        for(int i=0;i<numberArr.length;i++){
            numberArr[i] = (i==0||i==1)? 1 : numberArr[i-1] + numberArr[i-2];
        }
        answer = (numberArr[numberArr.length-1]*2) + (numberArr[numberArr.length-2]*2);

        return answer;
    }

    public static void main(String[] args) {
        int a = 5;
        long answer = solution(a);
        System.out.println(answer);
    }
}
