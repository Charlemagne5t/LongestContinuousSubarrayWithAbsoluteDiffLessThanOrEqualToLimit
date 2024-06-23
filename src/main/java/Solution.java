import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();

        int n = nums.length;
        min.offerFirst(0);
        max.offerFirst(0);
        int res = 1;
        int start = 0;

        for(int i = 1; i < n;i++) {
            if(nums[i] <= nums[min.peekFirst()]){
                min.offerFirst(i);
            }else {
                while(!min.isEmpty() && (min.peekLast() < start || nums[min.peekLast()] >= nums[i])) {
                    min.pollLast();
                }
                min.offerLast(i);
            }

            if(nums[i] >= nums[max.peekFirst()]){
                max.offerFirst(i);
            }else {
                while(!max.isEmpty() && (max.peekLast() < start || nums[max.peekLast()] <= nums[i])) {
                    max.pollLast();
                }
                max.offerLast(i);
            }
            while (nums[max.peekFirst()] - nums[min.peekFirst()] > limit) {
                start++;
                while(!min.isEmpty() && min.peekFirst() < start) {
                    min.pollFirst();
                }
                while(!max.isEmpty() && max.peekFirst() < start ) {
                    max.pollFirst();
                }
            }
            res = Math.max(res, i - start + 1);

        }

        return res;

    }
}
