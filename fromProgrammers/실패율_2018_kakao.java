import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class 실패율_2018_kakao {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(4, new int[]{4,4,4,4,4})));
	}
	public static int[] solution(int N, int[] stages) {
		int[] now = new int[N+2];
		HashMap<Integer, Double> clear = new HashMap<>();
		for(int stage : stages) {
			now[stage]++;
		}
		int size = stages.length;
		for(int i=1;i<=N;i++) {
			if(size==0) {
				clear.put(i, 0.0);
				continue;
			}
			clear.put(i, (double)now[i]/(double)size);
			size -= now[i];
		}
		List<Integer> list = new ArrayList<>();
		list.addAll(clear.keySet());
		Collections.sort(list, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				Object v1 = clear.get(o1);
				Object v2 = clear.get(o2);
				return ((Comparable)v2).compareTo(v1);
			}
		});
		return list.stream().mapToInt(i->(int)i).toArray();
	}
}
