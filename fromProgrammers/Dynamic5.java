package fromProgrammers;
/*
 * Problem URL:https://programmers.co.kr/learn/courses/30/lessons/42896
 *
 * 1. 언제든지 왼쪽 카드만 통에 버릴 수도 있고 왼쪽 카드와 오른쪽 카드를 둘 다 통에 버릴 수도 있다. 이때 얻는 점수는 없다.
 * 2. 오른쪽 카드에 적힌 수가 왼쪽 카드에 적힌 수보다 작은 경우에는 오른쪽 카드만 통에 버릴 수도 있다. 오른쪽 카드만 버리는 경우에는 오른쪽 카드에 적힌 수만큼 점수를 얻는다.
 * 3. (1)과 (2)의 규칙에 따라 게임을 진행하다가 어느 쪽 더미든 남은 카드가 없다면 게임이 끝나며 그때까지 얻은 점수의 합이 최종 점수가 된다.
 */

public class Dynamic5 {
    static int[][] cardCase;

    public static int solution(int[] left, int[] right){
        cardCase = new int[left.length][right.length];
        for(int i=0;i<left.length;i++){
            for(int j=0;j<right.length;j++){
                cardCase[i][j] = -1;
            }
        }
        return recursive(left, right, 0, 0);
    }

    public static int recursive(int[] left, int[] right, int leftIndex, int rightIndex){
        if(leftIndex>=left.length || rightIndex>=right.length){
            return 0;
        }
        if(cardCase[leftIndex][rightIndex]!=-1){
            return cardCase[leftIndex][rightIndex];
        }
        cardCase[leftIndex][rightIndex] = Math.max(recursive(left, right, leftIndex+1, rightIndex), recursive(left, right, leftIndex + 1, rightIndex + 1));
        if(left[leftIndex]>right[rightIndex]){
            cardCase[leftIndex][rightIndex] = Math.max(cardCase[leftIndex][rightIndex], right[rightIndex] + recursive(left, right,leftIndex, rightIndex+1));
        }
        return cardCase[leftIndex][rightIndex];
    }


    public static void main(String[] args) {
        int[] a = {3,2,5};
        int[] b = {2,4,1};
        int answer = solution(a, b);
        System.out.println(answer);
    }
}
