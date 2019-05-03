package fromProgrammers;
/*
 * Problem URL: https://programmers.co.kr/learn/courses/30/lessons/43164
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FirstSearch4 {
    static boolean[] useTicket;
    static String[][] ticketInfo;
    static List<String> answerList;
    public static String[] solution(String[][] tickets){
        ticketInfo = tickets;
        useTicket = new boolean[ticketInfo.length];
        answerList = new ArrayList<>();
        Stack<String> temp = new Stack<>();
        temp.push("ICN");
        dfs("ICN", temp, 0);
        return answerList.stream().toArray(String[]::new);
    }
    public static void dfs(String start, Stack<String> cand, int cnt){
        if(cnt==ticketInfo.length){
            if(answerList.isEmpty()){
                answerList.addAll(cand);
            } else{
                String ansStr = String.join(",", answerList);
                String candStr = String.join(",", cand);
                if(ansStr.compareTo(candStr)>0){
                    answerList.clear();
                    answerList.addAll(cand);
                }
            }
        }
        for(int i=0;i<ticketInfo.length;i++){
            String startName = ticketInfo[i][0];
            String endName = ticketInfo[i][1];
            if(useTicket[i]==false && startName.equals(start)){
                useTicket[i] = true;
                cand.push(endName);
                dfs(endName, cand, cnt+1);
                useTicket[i] = false;
                cand.pop();
            }
        }
    }



    public static void main(String[] args) {
        String[][] a ={{"ICN", "JFK"}, {"ICN", "IAD"}, {"IAD", "ICN"}};
        String[] answer = solution(a);
        for(String ans : answer){
            System.out.print(ans+" ");
        }
    }
}
