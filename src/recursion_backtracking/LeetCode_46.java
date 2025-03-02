package recursion_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Pemutations
public class LeetCode_46 {


    /*
    Swap-Based Backtracking:
Idea:

Swap elements in place to generate permutations.
This method avoids using extra space for the path.

Time Complexity:

O(n!): No extra copying of lists like the previous method.
Space Complexity:

O(n): for recursion stack.
     */
    private void recusivePermute(int index, int[] arr, List<List<Integer>> ans){

        if(index== arr.length){
            //copy array into result list
            List<Integer> ds= new ArrayList<>();
            for(int i=0; i< arr.length; i++){
                ds.add(arr[i]);
            }
            ans.add(new ArrayList<>(ds));
            return ;
        }
        for(int i=index; i<arr.length; i++){
            swap(arr,i,index);
            recusivePermute(index+1,arr,ans);
            swap(arr,i,index);
        }

    }
    private void swap(int arr[],int a, int b){
        int t= arr[a];
        arr[a]=arr[b];
        arr[b]=t;
    }
    public List<List<Integer>> permute(int[] nums){

        List<List<Integer>> resultList= new ArrayList<>() ;
        recusivePermute(0,nums,resultList);

        return resultList;
    }

//Using backtracking (DFS)
/*
Idea:

Recursively build permutations by swapping elements.
Explore every possibility by choosing an element, adding it to a temporary list, and then moving on to the next choice.
Algorithm:

Start with an empty path (tempList).
Add elements to the path one by one.
If the path reaches the size of nums, add it to the result.
Backtrack by removing the last element and exploring other options.

Time Complexity:

O(n! * n):
n! for generating all permutations.
n for copying each permutation to the result list.
Space Complexity:

O(n): to store the current path.
 */
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int num : nums) {
                if (tempList.contains(num)) continue; // Skip already used elements
                tempList.add(num);
                backtrack(result, tempList, nums);
                tempList.remove(tempList.size() - 1); // Backtrack
            }
        }
    }



    //Iterative (Heap's Algo)
    /*
    Idea:

Generate permutations iteratively, swapping elements systematically.
Efficient for generating permutations in-place.

Time Complexity:

O(n!): Iterative generation of permutations.
Space Complexity:

O(n): for result storage
     */

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        result.add(toList(nums));

        int n = nums.length;
        int[] c = new int[n];
        int i = 0;

        while (i < n) {
            if (c[i] < i) {
                if (i % 2 == 0) {
                    swap(nums, 0, i);
                } else {
                    swap(nums, c[i], i);
                }
                result.add(toList(nums));
                c[i]++;
                i = 0;
            } else {
                c[i] = 0;
                i++;
            }
        }
        return result;
    }

    private List<Integer> toList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return list;
    }


    public static void main(String args[]){
        LeetCode_46 obj= new LeetCode_46();
        int[] input_array= new int[]{1,2,3};
        List < List < Integer >> ls = obj.permute(input_array);
        System.out.println("All Permutations are");
        for (int i = 0; i < ls.size(); i++) {
            for (int j = 0; j < ls.get(i).size(); j++) {
                System.out.print(ls.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
