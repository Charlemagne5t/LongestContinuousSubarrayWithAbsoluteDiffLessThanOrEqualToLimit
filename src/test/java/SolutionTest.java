import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1() {
        int[] nums = {10,1,2,4,7,2};
        int limit = 5;
        int expected = 4;
        int actual = new Solution().longestSubarray(nums, limit);

        Assert.assertEquals(expected, actual);
    }
}
