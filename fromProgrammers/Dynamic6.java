package fromProgrammers;

public class Dynamic6 {
    public static int solution(int[] money){
        /*
        * 고민해봐야 하는것
        * 1. 맨 처음의 시작 - 처음에 참 > 마지막 안된다 / 처음에 거짓 > 마지막 될 수 있다.
         * 2. 한칸 넘기 VS 두칸 넘기
         * 2-1. 현재 값 + i-2(현재값 채택 + 한칸 넘기)
         * 2-2. i-1(두칸넘기 / 채택 후 다음값)
        */
        int size = money.length;
        int lastPosition = size-1;
        int[] moneyArr1 = new int[size];
        int[] moneyArr2 = new int[size];
        // moneyArr1 = OX
        moneyArr1[0] = money[0];
        moneyArr1[1] = money[0];
        // moneyArr2 = XO
        moneyArr2[0] = 0;
        moneyArr2[1] = money[1];

        for(int i=2;i<size;i++){
            if(i != size-1){
                moneyArr1[i] = Math.max(moneyArr1[i-1], moneyArr1[i-2]+money[i]);
            } else{
                moneyArr1[i] = moneyArr1[i-1];
            }
            moneyArr2[i] = Math.max(moneyArr2[i-1], moneyArr2[i-2]+money[i]);
        }
        return Math.max(moneyArr1[lastPosition], moneyArr2[lastPosition]);

        /*
        int resultSize = money.length+2;
        int[] result1 = new int[resultSize];
        int[] result2 = new int[resultSize];
        result1[1] = 0;
        result1[2] = money[0];
        result2[2] = 0;
        result2[3] = money[1];
        int cmax = 0;
        for(int i=1;i<money.length-1;i++){
            result1[i+2] = Math.max(money[i]+result1[i], money[i]+result1[i-1]);
            cmax = Math.max(cmax, result1[i+2]);
        }
        for(int i=2;i<money.length;i++){
            result2[i+2] = Math.max(money[i]+result2[i], money[i]+result2[i-1]);
            cmax = Math.max(cmax, result2[i+2]);
        }
        return cmax;

        //ref: https://chaibin0.tistory.com/entry/%EB%8F%84%EB%91%91%EC%A7%88
        */
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,1};
        int answer = solution(a);
        System.out.println(answer);
    }
}
