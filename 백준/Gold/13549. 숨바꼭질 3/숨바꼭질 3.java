import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	final static int INF = Integer.MAX_VALUE;
	static int[] dm = {-1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] minTime = new int[200001];
		
		Arrays.fill(minTime, INF);
		minTime[N] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
		pq.add(new Node(N, 0));
		int next;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(now.time > minTime[now.idx]) continue;
			//순간이동
			next = now.idx * 2;
			if(next >= 0 && next < 200001 && minTime[next] > now.time) {
				minTime[next] = now.time;
				if(next != K)
					pq.add(new Node(next, minTime[next]));
			}
			// 좌 우 이동
			for (int i = 0; i < 2; i++) {
				next = now.idx + dm[i];
					
				if(next >= 0 && next < 200001 && minTime[next] > now.time+1) {
					minTime[next] = now.time + 1;
					if(next != K)
						pq.add(new Node(next, minTime[next]));
				}
			}
			
		}
		
		System.out.println(minTime[K]);
	}
	static class Node{
		int idx, time;
		Node(int idx, int time){
			this.idx = idx;
			this.time = time;
		}
	}
}
