public class BruteForce4 {
    public static int[] solution(int brown, int red){
        int[] answer = new int[2];
        int totalPanel = brown + red;
        for(int i=1; i<=Math.sqrt(totalPanel);i++){
            if(totalPanel%i==0){
                int nowSide = i;
                int otherSide = totalPanel/i;
                if((nowSide-2) * (otherSide-2) == red){
                    answer[0] = otherSide;
                    answer[1] = nowSide;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int a = 24;
        int b = 24;
        int[] answer = solution(a,b);
        for(int i : answer){
            System.out.printf(i+" ");
        }
    }
}
