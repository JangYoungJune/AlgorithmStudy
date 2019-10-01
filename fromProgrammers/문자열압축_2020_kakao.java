public class 문자열압축_2020_kakao {
	public static void main(String[] args) {
		문자열압축_2020_kakao solve = new 문자열압축_2020_kakao();
		System.out.println(solve.solution("abcabcdede"));
	}

	public int solution(String s) {
        int answer = s.length();
        for(int i=1;i<=s.length()/2;i++) {
        	int zipSize = 0;
        	int zipCnt = 0;
        	int idx = 0;
        	String pre = "";
        	while(idx<s.length()) {
        		String splitStr = null;
        		if(idx+i>=s.length()) { // 딱 맞거나, 넘어감
        			splitStr = s.substring(idx);
        			if(idx+i>s.length()) {
        				zipSize+=pre.length();
        				if(zipCnt>1) {
        					zipSize+=String.valueOf(zipCnt).length();
        				}
        				zipSize+=splitStr.length();
        			} else {
        				if(splitStr.equals(pre)) {
            				zipCnt++;
            			} else {
            				zipSize += pre.length();
            				if(zipCnt>1) {
            					zipSize+=String.valueOf(zipCnt).length();
            				}
            				pre = splitStr;
            				zipCnt = 1;
            			}
        				zipSize += pre.length();
        				if(zipCnt>1) {
        					zipSize+=String.valueOf(zipCnt).length();
        				}
        			}
        		} else { // 안넘어감
        			splitStr = s.substring(idx, idx+i);
        			if(splitStr.equals(pre)) { // 같다
        				zipCnt++;
        			} else { // 다르다
        				zipSize += pre.length();
        				if(zipCnt>1) {
        					zipSize+=String.valueOf(zipCnt).length();
        				}
        				pre = splitStr;
        				zipCnt = 1;
        			}
        		}
        		idx+= i;
        	}
        	
        	if(answer>zipSize) {
        		answer = zipSize;
        	}
        }
        return answer;
	}
}
