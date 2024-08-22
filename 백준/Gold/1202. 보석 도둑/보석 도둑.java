import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, K, len = 100000001;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		ArrayList<Jewel> jewels = new ArrayList<>();
		ArrayList<Integer> bags = new ArrayList<>();
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			jewels.add(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		for (int i = 0; i < K; i++) {
			bags.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(bags);
		Collections.sort(jewels);
		
		long total = 0;
		int start = 0;
		PriorityQueue<Jewel> pq = new PriorityQueue<>(new Comparator<Jewel>() {

			@Override
			public int compare(Jewel o1, Jewel o2) {
				return o1.price == o2.price ? o1.weight - o2.weight : o2.price - o1.price ;
			}
		});
		
		int idx = 0;
		//가방 앞에서부터 탐색하며 넣을 수 있는 보석 넣음
		for(int bag : bags) {
			
			while(idx < jewels.size() && jewels.get(idx).weight <= bag) {
				pq.add(jewels.get(idx++));
			}
			//제일 가치 높은거 뽑음
			if(!pq.isEmpty())
				total += (long) pq.poll().price;
		} 
		
		System.out.println(total);
	}
	
	static class Jewel implements Comparable<Jewel>{
		int price, weight;
		Jewel(int weight, int price){
			this.price = price;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Jewel o) {
			return this.weight == o.weight ? o.price - this.price : this.weight - o.weight;
		}
	}
}
