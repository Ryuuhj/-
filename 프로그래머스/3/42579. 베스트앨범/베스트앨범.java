import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Solution {
   public int[] solution(String[] genres, int[] plays) {
        return IntStream.range(0, genres.length)
                .mapToObj(i -> new Music(i, plays[i], genres[i]))
                .collect(Collectors.groupingBy(Music::getGenre))
                .entrySet().stream() //genre같은 것 끼리 Map 생성 후 반환
                .sorted((a, b) -> sum(b.getValue()) - sum(a.getValue()))
                .flatMap(x -> x.getValue().stream().sorted().limit(2))
                .mapToInt(x -> x.id).toArray();
    }
    
    private int sum(List<Music> value) {
        int answer = 0;
        for (Music music : value) {
            answer += music.played;
        }
        return answer;
    }

    public class Music implements Comparable<Music> {
        private int played;
        private int id;
        private String genre;

        public Music(int id, int played, String genre) {
            this.played = played;
            this.id = id;
            this.genre = genre;
        }

        @Override
        public int compareTo(Music o) {
            if(this.played == o.played) return this.id - o.id;
            return o.played - this.played;
        }
        public String getGenre() {
            return this.genre;
        }
    }
}