import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Greedy1 {
    public static int solution(int n, int[] lost, int[] reserve){
        int answer = 0;
        List<Integer> lostTemp = Arrays.stream(lost).boxed().sorted().collect(Collectors.toList());
        List<Integer> reserveTemp = Arrays.stream(reserve).boxed().sorted().collect(Collectors.toList());
        List<Integer> duplicateList = lostTemp.stream().filter(i->reserveTemp.indexOf(i)>=0).collect(Collectors.toList());
        answer = n - lost.length + duplicateList.size();

        List<Integer> lostList = lostTemp.stream().filter(i->duplicateList.indexOf(i)<0).collect(Collectors.toList());
        List<Integer> reserveList = reserveTemp.stream().filter(i->duplicateList.indexOf(i)<0).collect(Collectors.toList());

        while(!lostList.isEmpty() && !reserveList.isEmpty()){
            int lostSize = lostList.get(0);
            int reserveSize = reserveList.get(0);
            if(lostSize==reserveSize-1 || lostSize==reserveSize || lostSize==reserveSize+1){
                answer++;
                lostList.remove(0);
                reserveList.remove(0);
            } else{
                if(lostSize>reserveSize){
                    reserveList.remove(0);
                } else{
                    lostList.remove(0);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int a = 5;
        int[] b = {2,3};
        int[] c = {3,4};
        int answer = solution(a,b,c);
        System.out.println(answer);
    }
}
