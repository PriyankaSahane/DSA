package bitmanipulation;
import java.util.Scanner;
//Binary Gap
public class LeetCode_868 {

    //Brute force apprach
    public int binaryGap(int n) {
        int ans = 0; // Initialize with 0 instead of Integer.MIN_VALUE
        String res = "";

        // Convert n to binary manually
        while (n > 0) {
            res = (n % 2) + res;  // Prepend to maintain correct order
            n = n / 2;
        }

        int i = 0, j = 0;
        while (i < res.length()) {  // Fixed loop condition (should be '<' instead of '<=')
            if (res.charAt(i) == '1') {
                j = i + 1;
                while (j < res.length()) {
                    if (res.charAt(j) == '1') {
                        ans = Math.max(ans, j - i);
                        i = j; // Move i to the new 1's position
                        break;  // Prevent unnecessary iterations
                    }
                    j++;
                }
            }
            i++;
        }

        return ans;
    }


    //Optimal Solution
    public int binaryGap1(int n) {
            String binary = Integer.toBinaryString(n); // Convert n to binary
            int prev = -1; // Stores the previous index of '1'
            int maxDistance = 0;

            for (int i = 0; i < binary.length(); i++) {
                if (binary.charAt(i) == '1') {
                    if (prev != -1) {
                        maxDistance = Math.max(maxDistance, i - prev);
                    }
                    prev = i; // Update previous index of '1'
                }
            }
            return maxDistance;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();

        LeetCode_868 solution = new LeetCode_868();
        //int result = solution.binaryGap(n);
        int result2 = solution.binaryGap1(n);
        System.out.println("Longest distance between adjacent 1's: " + result2);
        sc.close();
    }

}
