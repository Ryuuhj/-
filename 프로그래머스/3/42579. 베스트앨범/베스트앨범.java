import java.util.*;
class Solution {
    static HashMap<Integer, List<Music>> musicByGenre = new HashMap<>(); //재생횟수를 장르 고유 인덱스로 사용
    static Map<String, Integer> genreCnt;
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> ans = new ArrayList<>();
        genreCnt = countGenrePlay(genres, plays);
        makeMusicList(genres, plays);
        //총 재생 횟수 내림차순 정렬
        List<Integer> cntList = new ArrayList<>(genreCnt.values());
        cntList.sort(Collections.reverseOrder());
        for (int key : cntList) {
            if(musicByGenre.get(key).size() == 1) {
                ans.add(musicByGenre.get(key).get(0).idx); continue;
            }
            Collections.sort(musicByGenre.get(key));
            musicByGenre.get(key).subList(0, 2).forEach(m -> ans.add(m.idx));
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    private void makeMusicList(String[] genres, int[] plays) {
        for (int i = 0; i < plays.length; i++) {
            int totalCnt = genreCnt.get(genres[i]);
            if (!musicByGenre.containsKey(totalCnt)) {
                musicByGenre.put(totalCnt, new ArrayList<>());
            }
            musicByGenre.get(totalCnt).add(new Music(i, plays[i]));
        }
    }

    private Map<String, Integer> countGenrePlay(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (!map.containsKey(genres[i])) {
                map.put(genres[i], plays[i]);
                continue;
            }
            map.put(genres[i], map.get(genres[i]) + plays[i]);
        }
        return map;
    }

    class Music implements Comparable<Music> {
        int idx;
        int playCnt;

        public Music(int idx, int playCnt) {
            this.idx = idx;

            this.playCnt = playCnt;
        }

        @Override
        public int compareTo(Music o) {
            if(this.playCnt > o.playCnt) return -1;
            else if(this.playCnt < o.playCnt) return 1;
            else {
                if(this.idx < o.idx) return -1;
                else if(this.idx > o.idx) return 1;
            }
            return 0;
        }
    }
}