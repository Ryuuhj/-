import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] adjList = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		int[] toDegree = new int[N+1];
		StringBuilder sb = new StringBuilder();
		
		int from, to;
		
		while(M--> 0) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			adjList[from].add(to);
			toDegree[to]++;
		}
		
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if(toDegree[i]== 0)
				queue.add( i);
		}
		
		while (!queue.isEmpty()) {
			
			int now = queue.poll();
			sb.append(now).append(" ");
			
			for(int next : adjList[now]) {
				if(--toDegree[next] == 0)
					queue.add(next);
			}
		}
		
		System.out.println(sb);

	}

}
