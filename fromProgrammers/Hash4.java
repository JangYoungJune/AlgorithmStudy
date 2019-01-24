package fromProgrammers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
  * problem URL: https://programmers.co.kr/learn/courses/30/lessons/42578
  * */
public class Hash4 {
    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, HashMap<Integer, Integer>> musicMap = new HashMap<>();
        HashMap<String, Integer> genreTotalPlays = new HashMap<>();
        List<Integer> answerList = new ArrayList<>();
        for(int i=0;i<genres.length;i++) {
        	if(musicMap.containsKey(genres[i])) {
        		genreTotalPlays.put(genres[i], genreTotalPlays.get(genres[i])+plays[i]);
        		if(musicMap.get(genres[i]).size()==2) {
        			int maxKey = -1, maxValue = -1;
        			for(Map.Entry<Integer, Integer> item : musicMap.get(genres[i]).entrySet()) {
        				if(maxKey==-1) {
        					maxKey = item.getKey();
        					maxValue = item.getValue();
        				} else {
        					if(maxValue > item.getValue()) {
        						maxKey = item.getKey();
        					} else if(maxValue == item.getValue()) {
        						maxKey = (maxKey < item.getKey())? item.getKey() : maxKey;
        					}
        				}
        			}
        			int compareValue = musicMap.get(genres[i]).get(maxKey);
        			if(compareValue < plays[i]) {
        				musicMap.get(genres[i]).remove(maxKey);
        				musicMap.get(genres[i]).put(i, plays[i]);
        			}
        		} else {
        			musicMap.get(genres[i]).put(i, plays[i]);
        		}
        	} else {
        		genreTotalPlays.put(genres[i], plays[i]);
        		musicMap.put(genres[i], new HashMap<Integer, Integer>());
        		musicMap.get(genres[i]).put(i, plays[i]);
        	}
        }
        List<String> list = new ArrayList<>();
        list.addAll(genreTotalPlays.keySet());
        Collections.sort(list, new Comparator<String>(){
        	public int compare(String o1, String o2) {
        		Object v1 = genreTotalPlays.get(o1);
        		Object v2 = genreTotalPlays.get(o2);
        		return ((Comparable)v2).compareTo(v1);
        	}
        });
        Iterator it = list.iterator();
        
        while(it.hasNext()) {
        	String genre = (String)it.next();
        	HashMap<Integer,Integer> tempMusicMap = musicMap.get(genre);
        	int readyKey = -1, readyValue = -1;
        	for(Map.Entry<Integer, Integer> item : tempMusicMap.entrySet()) {
            	if(readyKey == -1) {
            		readyKey = item.getKey();
            		readyValue = item.getValue();
            	} else {
            		int firstKey, secondKey;
            		if(readyValue > item.getValue()) {
            			firstKey = readyKey;
            			secondKey = item.getKey();
            		} else if(readyValue == item.getValue()) {
            			firstKey = (readyKey>item.getKey())? item.getKey() : readyKey;
            			secondKey = (readyKey>item.getKey())? readyKey : item.getKey();
            		} else {
            			firstKey = item.getKey();
            			secondKey = readyKey;
            		}
            		answerList.add(firstKey);
            		answerList.add(secondKey);
            	}
            }
        	if(tempMusicMap.size()==1) {
        		answerList.add(readyKey);
        	}
        }
        return answerList.stream().mapToInt(i->i).toArray();
    }

    public static void main(String args[]) {
        String[] a = {"classic", "pop", "classic", "pop", "classic", "classic"};
        int[] b = {400, 600, 150, 2500, 500, 500};
        
        int[] answer = solution(a, b);
        for(int i=0; i<answer.length; i++) {
        	System.out.print(answer[i]);
        }
        
    }
}
