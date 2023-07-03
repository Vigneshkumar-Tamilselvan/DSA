/*
 * package selfLearn;
 * 
 * import java.util.HashMap; import java.util.Map; import org.junit.Test;
 * 
 * public class Rough_Work {
 * 
 * @Test public void test_01() { int[] nums = { 8, 7, 2, 5, 3, 1 }; int target =
 * 10; pairOfGivenSum(nums, target); }
 * 
 * private void pairOfGivenSum(int[] nums, int target) {
 * 
 * Map<Integer, Integer> map = new HashMap<>(); for (int i = 0; i < nums.length;
 * i++) { int value = target - nums[i];
 * 
 * if (map.containsKey(value)) { map.put(nums[i], i)
 * 
 * }
 * 
 * else map.put(nums[i], i);
 * 
 * }
 */