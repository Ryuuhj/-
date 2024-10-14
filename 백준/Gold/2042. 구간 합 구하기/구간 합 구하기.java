import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] tree;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		
		//1. 노드 개수 n을 바탕으로 k 구한 후, 트리 배열 크기 >> 2^(k+1)
		int len = N, depth = 0;
		while(len != 0) {
			len /= 2;
			depth++;
		}
		int size = (int) Math.pow(2, depth+1);
		tree = new long[size];
		
		//리프 노드에 원본 데이터 입력 (리프 노드 시작위치 : 2^k 인덱스부터 시작)
		int idx = size/2;
		for (; idx < size/2+N; idx++) {
			tree[idx] = Long.parseLong(br.readLine());
		}
		
		//리프노드를 제외한 나머지 노드 값 채움 (역순으로) (구간합 이용) : A[n] = A[2n] + A[2n+1]
		for (int i = size-1; i > 1; i--) {
			tree[i/2] += tree[i]; 
		}
		
		int pad = (int) Math.pow(2,  depth)-1;
		
		for (int i = 0; i < M+K; i++) {
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(a.equals("1")) {
				//주어진 질의 인덱스를 세그먼트 트리의 리프 노드에 해당하는 인덱스로 변경 : index + 2^k - 1
				b += pad; //b번째 값을 c로 바꾸고 -> 연쇄적으로 거슬러 올라오며 업데이트
				long diff = c - tree[b];
				tree[b] = c;
				//부모 노드로 이동해가며 변경해줌
				while(b > 1) {
					b /= 2;
					tree[b] += diff;
				}
	
			}else if(a.equals("2")) {
				// b ~ c까지 구간함 구하기 =>
				long sum = 0;
				int start = b + pad;
				int end = (int) c + pad;
				
				while (start <= end) {					
					if(start % 2 == 1)  //해당 노드만 범위 포함, 형제/부모노드 포함하지 않고 다음 노드부터
						sum += tree[start];
					if(end % 2 == 0) //끝나는 범위는 왼쪽 노드일 경우 해당 노드만 포함, 부모 배제
						sum += tree[end];
					start = (start+1)/2;
					end = (end-1)/2;
				}
				sb.append(sum).append("\n");	
			}
		}
		System.out.println(sb);
	}
}
