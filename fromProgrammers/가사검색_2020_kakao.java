import java.util.Arrays;

public class 가사검색_2020_kakao {
	public static void main(String[] args) {
		가사검색_2020_kakao solve = new 가사검색_2020_kakao();
		String[] input1 = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String[] input2 = {"fro??", "????o", "fr???", "fro???", "pro?"};
		System.out.println(Arrays.toString(solve.solution(input1, input2)));
	}

	public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        
        String[] reverseWords = Arrays.copyOf(words, words.length);
        int[][] idxMap = new int[26][2];
        Arrays.sort(words, (o1,o2)->{
        	if(o1.charAt(0) != o2.charAt(0)) {
        		return o1.charAt(0) - o2.charAt(0);
        	} else {
        		return o1.length() - o2.length();
        	}
        });
        Arrays.sort(reverseWords, (o1,o2)->{
        	if(o1.charAt(o1.length()-1) != o2.charAt(o2.length()-1)) {
        		return o1.charAt(o1.length()-1) - o2.charAt(o2.length()-1);
        	} else {
        		return o1.length() - o2.length();
        	}
        });
        
        for(int i=0;i<words.length;i++) {
        	idxMap[words[i].charAt(0)-'a'][0]++;
        	idxMap[reverseWords[i].charAt(reverseWords[i].length()-1)-'a'][1]++;
        }
        int answerIdx = 0;
        for(String query : queries) {
        	boolean isFirst = true;
        	int queryLength = query.length();
        	String findQuery = query.replace("?", "");
        	if(query.charAt(0)=='?') {
        		isFirst = false;
        	}
        	
        	int queryCharVal = query.charAt(isFirst? 0 : query.length()-1)-'a';
        	int idxMapbranch = isFirst? 0 : 1;
        	
        	if(idxMap[queryCharVal][idxMapbranch]!=0) {
        		int startIdx = 0;
        		for(int i=0;i<queryCharVal;i++) {
        			startIdx += idxMap[i][idxMapbranch];
        		}
        		int answerCnt = 0;
        		for(int i = startIdx; i<startIdx+idxMap[queryCharVal][idxMapbranch];i++) {
        			if(isFirst) {
        				if(words[i].length()>queryLength) {
        					break;
        				} else if(words[i].length()<queryLength) {
        					continue;
        				}
        				
    					if(words[i].indexOf(findQuery)==0) {
    						answerCnt++;
    					}
        			} else {
        				if(reverseWords[i].length()!=queryLength) {
        					break;
        				} 
    					if(reverseWords[i].lastIndexOf(findQuery)==queryLength-findQuery.length()) {
    						answerCnt++;
    					}
        			}
        		}
        		answer[answerIdx] = answerCnt;
        	} else {
        		answer[answerIdx] = 0;
        	}
        	answerIdx++;
        }
        
        return answer;
    }
}
