import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        Queue<Truck> queue = new LinkedList<>();
        int idx = 0, nw = 0;
        Set<Integer> leaveTime = new HashSet<>();
        while (idx < truck_weights.length) {
            if (leaveTime.contains(time) && !queue.isEmpty()) {
                nw -= queue.poll().weight;
                leaveTime.remove(time);

            } else if ((queue.size() == bridge_length || nw + truck_weights[idx] > weight)&& !queue.isEmpty()) {
                time = queue.peek().enteredTime + bridge_length;
            }else {
                nw += truck_weights[idx];
                queue.add(new Truck(idx, truck_weights[idx], time));
                leaveTime.add(time + bridge_length);
                time++;idx++;
            }
        }
        return time + bridge_length;
    }

    private class Truck {
        int idx;
        int weight;
        int enteredTime;

        public Truck(int idx, int weight, int enteredTime) {
            this.idx = idx;
            this.weight = weight;
            this.enteredTime = enteredTime;
        }
    }
}