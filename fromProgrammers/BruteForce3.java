import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BruteForce3 {
    public static int solution(int[][] baseball){
        List<Integer> possibleList = new ArrayList<>();
        for(int i=1;i<=9;i++){
            for(int j=1;j<=9;j++){
                if(j==i){
                    continue;
                }
                for(int k=1;k<=9;k++){
                    if(k==i || k==j){
                        continue;
                    }
                    possibleList.add((i*100) + (j*10) + k);
                }
            }
        }

        for(int[] round : baseball){
            String[] numberSet = Integer.toString(round[0]).split("");
            int questionStrike = round[1];
            int questioBall = round[2];

            possibleList = possibleList.stream().filter(num->{
                String[] listNum = num.toString().split("");
                int findStrike=0, findBall=0;
                //find the number of strike
                for(int i=0;i<numberSet.length;i++){
                    if(numberSet[i].equals(listNum[i])){
                        findStrike++;
                    }
                }
                //find the number of ball
                for(int i=0;i<numberSet.length;i++){
                    if(Integer.toString(num).indexOf(numberSet[i])>=0 && !numberSet[i].equals(listNum[i])){
                        findBall++;
                    }
                }
                return (findStrike==questionStrike && findBall == questioBall)? true : false;
            }).collect(Collectors.toList());

        }

        return possibleList.size();
    }
    public static void main(String[] args) {
        int[][] a = {{123,1,1},{356,1,0},{327,2,0},{489,0,1}};
        int answer = solution(a);
        System.out.println(answer);
    }
}
