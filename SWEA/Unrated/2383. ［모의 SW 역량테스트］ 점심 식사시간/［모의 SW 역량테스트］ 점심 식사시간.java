import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int N, pCnt, minTime; //map 길이, 사람 총 명수
    static int[][] map;
    static ArrayList<Person> people; //사람 정보
    static Stair[] stairs; //계단 정보
    static PriorityQueue<Person> waitQ; //계단 할당 전 대기하고 있는 사람들
    static ArrayDeque<Person>[] onStairs; //계단 위에 올라가 있는 사람들
    static HashSet<Person> temp = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            people = new ArrayList<>();
            stairs = new Stair[2]; //계단 값 저장할 배열
            onStairs = new ArrayDeque[2];
            minTime = Integer.MAX_VALUE;

            for (int i = 0; i < 2; i++) {
                onStairs[i] = new ArrayDeque<>();
            }

            int sIdx = 0, k;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    k = Integer.parseInt(st.nextToken());
                    if(k == 1)
                        people.add(new Person(i, j));
                    else if(k > 1)
                        stairs[sIdx++] = new Stair(i, j, k);
                }
            }
            pCnt = people.size();

            //계단 정보 할당
            setStairIdx(0);
            sb.append("#").append(tc).append(" ").append(minTime).append("\n");
        }
        System.out.println(sb);
    }

    private static void setStairIdx(int idx) {
        if(idx == pCnt){
            //정보 바탕으로 시뮬레이션
            minTime = Math.min(minTime, simulation());
            return;
        }

        //1번 계단에 배정
        people.get(idx).stairIdx = 0;
        people.get(idx).eTime = Math.abs(people.get(idx).x - stairs[0].x) + Math.abs(people.get(idx).y - stairs[0].y)+1;
        setStairIdx(idx+1);
        people.get(idx).stairIdx = 1;
        people.get(idx).eTime = Math.abs(people.get(idx).x - stairs[1].x) + Math.abs(people.get(idx).y - stairs[1].y)+1;
        setStairIdx(idx+1);
    }

    private static int simulation() {
        waitQ = new PriorityQueue<>(people); //먼저 계단에 들어가는 순서대로 정렬

        int time = 1;
        int remainCnt = people.size();
        Person p = null;

        while(true){
            //현재 시간에서 기존 계단에서 나올 사람 뺌
            for(ArrayDeque<Person> queue : onStairs){
                int len = queue.size();
                for (int i = 0; i < len; i++) {
                    p = queue.poll();
                    if(p.outTime <= time) continue; //제거
                    queue.offer(p);
                }
            }
            //마지막 남은 사람까지 제거한 경우
            if(onStairs[0].isEmpty() && onStairs[1].isEmpty() && remainCnt == 0) 
                return time;

            //대기하는 사람 중 조건에 맞는 사람 넣음
            temp.clear();
            while (!waitQ.isEmpty() && waitQ.peek().eTime <= time){
                p = waitQ.poll();

                Stair stair = stairs[p.stairIdx];
                if(onStairs[p.stairIdx].size() < 3) {
                    p.outTime = time + stair.length;
                    onStairs[p.stairIdx].add(p);
                    remainCnt--;
                }else
                    temp.add(p);
            }
            waitQ.addAll(temp);
            time++;
        }

    }

    static class Person implements Comparable<Person> {
        int x, y;
        int stairIdx;
        int eTime; //계단 도착 시간 + 1
        int outTime; //계단에서 나가는 시간 (계단 들어간 시간 + 계단 길이)
        Person(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Person o) {
            return Integer.compare(this.eTime, o.eTime);
        }
    }
    
    static class Stair {
        int x, y; //좌표
        int length; //길이
        Stair(int x, int y, int length) {
            this.x = x;
            this.y = y;
            this.length = length;
        }
    }
}
