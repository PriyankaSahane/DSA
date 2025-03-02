package recursion_backtracking;
import java.util.*;


//Subset II problem: array with duplicate elements and provide unique subset of array
public class LeetCode_90 {

        public static void main(String[] args) {
            int[] nums = {1, 2, 2}; // Test case
            List<List<Integer>> result = subsetsWithDup(nums);
            System.out.println(result);
        }

        public static List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums); // Sort to handle duplicates
            List<List<Integer>> resultList = new ArrayList<>();
            backtrack(nums, 0, new ArrayList<>(), resultList);
            return resultList;
        }

        private static void backtrack(int[] nums, int start, List<Integer> temp, List<List<Integer>> resultList) {
            resultList.add(new ArrayList<>(temp)); // Add current subset

            for (int i = start; i < nums.length; i++) {
                // Skip duplicates
                if (i > start && nums[i] == nums[i - 1]) {
                    continue; // Skip this element if it's a duplicate
                }

                // Include nums[i]
                temp.add(nums[i]);
                backtrack(nums, i + 1, temp, resultList); // Recursive call for next elements
                temp.remove(temp.size() - 1); // Backtrack — remove last element added
            }
        }

}
