package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SW4195 {
	static int MAX = 100001;
	static int[] parents, levels, sizes;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=0;tc<tcNum;tc++) {
			int n = Integer.parseInt(br.readLine().trim());
			HashMap<String, Integer> list = new HashMap<>();
			parents = new int[MAX];
			levels = new int[MAX];
			sizes = new int[MAX];
			Arrays.fill(levels, 1);
			Arrays.fill(sizes, 1);
			int idx = 1;
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				String name1 = st.nextToken();
				String name2 = st.nextToken();
				if(!list.containsKey(name1)) {
					list.put(name1, idx);
					parents[idx] = idx++;
				}
				if(!list.containsKey(name2)) {
					list.put(name2, idx);
					parents[idx] = idx++;
				}
				grouping(list.get(name1), list.get(name2));
				
				System.out.println(sizes[findParent(list.get(name1))]);
			}
		}
	}
	static void grouping(int idx1, int idx2) {
		int firstP = findParent(idx1);
		int secondP = findParent(idx2);
		if(firstP==secondP) {
			return;
		}
		if(levels[firstP] > levels[secondP]) {
			int temp = firstP;
			firstP = secondP;
			secondP = temp;
		}
		
		parents[firstP] = secondP;
		sizes[secondP] += sizes[firstP];
		
		if(levels[firstP] == levels[secondP]) {
			levels[secondP]++;
		}	
	}
	
	static int findParent(int idx) {
		if(parents[idx]==idx) {
			return idx;
		} else {
			parents[idx] = findParent(parents[idx]);
			return parents[idx];
		}
	}
}
