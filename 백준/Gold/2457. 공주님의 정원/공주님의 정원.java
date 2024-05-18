import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    //피는 날짜, 지는 날짜에 월+일 형태로 기록해 단순하게 비교 가능하게 함
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //꽃 개수
        Flower[] flowers = new Flower[N];
        for (int i = 0; i < N; i++) {
            flowers[i] = new Flower(br.readLine().split(" "));
        }
        Arrays.sort(flowers);

        int preLastDate = 301;
        int endDate = 1201;

        int startIdx = 0;
        int tmpMax = 0;
        int cnt = 0;

        while (preLastDate < endDate) { //지금까지 꽃 중 마지막으로 지는 날짜 >= 12월 1일 면 끝
            boolean newFlower = false;
            for (int i = startIdx; i < N; i++){
                //남은 꽃 중 제일 일찍 피는 꽃도 preLastDate보다 뒤인 경우 탐색 끝
                if(preLastDate < flowers[i].start)
                    break;
                //preLastDate <= flowers[i].start -> 남은 꽃들 중 preLastDate 전에 피면서
                //tmpMax 갱신 -> 가장 오래 지속되는 꽃 선택
                if (tmpMax < flowers[i].end) {
                    newFlower = true;
                    tmpMax = flowers[i].end;
                    startIdx = i+1;
                }
            }
            //마지막으로 갱신된 꽃을 목록에 넣음 + 그 꽃의 end값으로 지는 시간 갱신
            if(newFlower){
                cnt++;
                preLastDate = tmpMax;
            }else //끝까지 봐도 추가로 들어갈 꽃 없음
                break;
        }
        //마지막 꽃이 11월 30일까지 피어있지 않은 경우
        if(preLastDate < endDate)
            System.out.println(0);
        else
            System.out.println(cnt);

    }

    private static class Flower implements Comparable<Flower>{
        int start; int end;

        Flower(String[] days) {
            this.start = Integer.parseInt(days[0]) * 100 + Integer.parseInt(days[1]);
            this.end = Integer.parseInt(days[2]) * 100 + Integer.parseInt(days[3]);
        }
        //정렬 기준 1.피는 날짜 ASC 2.지는 날짜 DESC => 지속기간 긴 + 피는 기준 오름차순 정렬
        @Override
        public int compareTo(Flower o){
            if(this.start > o.start) return 1;
            else if(this.start < o.start) return -1;
            else{
                if(this.end < o.end) return 1;
                else if(this.end == o.end) return 0;
            }
            return -1;
        }
    }
}
