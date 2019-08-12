package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW7964 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcNum = Integer.parseInt(br.readLine().trim());
        for(int tc=1;tc<=tcNum;tc++){
            String[] str = br.readLine().trim().split(" ");
            int N = Integer.parseInt(str[0]);
            int D = Integer.parseInt(str[1]);
            String[] arrStr = br.readLine().trim().split(" ");
            int answer = 0;
            int size = 0;
            for(int i=0;i<N;i++){
                if(Integer.parseInt(arrStr[i])-0 == 0){
                    size++;
                } else{
                    answer += size/D;
                    size = 0;
                }
            }
            answer += size/D;
            System.out.println(String.format("#%d %d", tc, answer));
        }

    }
}
