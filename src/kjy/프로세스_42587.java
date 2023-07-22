package kjy;

import java.util.Collections;
import java.util.PriorityQueue;

public class 프로세스_42587 {
    public int solution(int[] priorities, int location) {
        // PQ 역순으로 생성
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            pq.offer(priorities[i]);
        }

        int answer = 0;
        while(!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == pq.peek()) {
                    if (i == location) {
                        return ++answer;
                    }
                    ++answer;
                    pq.poll();
                }
            }
        }

        return answer;
    }
}
