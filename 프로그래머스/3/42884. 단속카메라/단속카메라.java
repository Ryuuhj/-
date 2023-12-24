import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int cnt = 1;
        ArrayList<Car> arr = new ArrayList<>();
        for(int[] route : routes){
            arr.add(new Car(route[0], route[1]));
        }
        Collections.sort(arr);
        int n = arr.get(0).leave;
        for (Car c : arr) {
            if(c.enter <= n && c.leave >= n) continue;
            n = c.leave;
            cnt++;
        }
        return cnt;
    }

    private class Car implements Comparable<Car> {
        int enter; int leave;

        Car(int e, int l) {
            this.enter = e;
            this.leave = l;
        }

        @Override
        public int compareTo(Car o) {
            if(this.leave < o.leave) return -1;
            else if(this.leave > o.leave) return 1;
            return 0;
        }
    }
}