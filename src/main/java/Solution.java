import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int longestSubarray(int[] nums, int limit) {
        // Deque<Integer> max = new ArrayDeque<>();
        // Deque<Integer> min = new ArrayDeque<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.comparingInt(i -> -nums[i]));
        PriorityQueue<Integer> min = new PriorityQueue<>(Comparator.comparingInt(i -> nums[i]));
        int n = nums.length;
        min.offer(0);
        max.offer(0);
        int res = 1;
        int start = 0;
        for (int i = 1; i < n; i++) {

            min.offer(i);
            max.offer(i);
            while (nums[max.peek()] - nums[min.peek()] > limit) {
                start++;
                while (!max.isEmpty() && max.peek() < start) {
                    max.poll();
                }
                while (!min.isEmpty() && min.peek() < start) {
                    min.poll();
                }
            }
            res = Math.max(res, i - start + 1);
        }

        return res;

    }
}

