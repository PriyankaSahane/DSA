package string;
import java.util.*;
public class LeetCode_28 {




    public int strstr(String haystack, String needle) {

        //Brute force
        /*Naive Pattern Searching
The naive method checks each position
in the text to see if the pattern matches. While simple, it’s inefficient for long texts.
     */
        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i < n - m; i++) {
            if (haystack.substring(i, i + m) == needle) {
                return i;
            }
        }
        return -1;

    }



        //Better approach
        /*Knuth-Morris-Pratt (KMP) Algorithm
KMP improves performance by avoiding redundant comparisons using a “partial match” table.

Steps:

Build the LPS (Longest Prefix Suffix) table for the pattern.
Use the LPS table to skip unnecessary comparisons in the string.*/

    static void constructLPS(String pat, int[] lps){
        int len=0;
        lps[0]=0;
        int i=1;
        while(i<pat.length()){
            if (pat.charAt(i)==pat.charAt(len)){
                len++;
                lps[i]= len;
                i++;
            }else{
                if(len != 0){
                    len=lps[len-1];
                }else{
                    lps[i]=0;
                    i++;
                }
            }
        }
    }

    public int strstrKPS_Algo(String haystack, String needle){
        int n= haystack.length();
        int m= needle.length();

        int lps[]=new int[m];
        constructLPS(needle, lps);


        int i=0;
        int j=0;



        while(i<n){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
                if(j==m){
                    return m-j;
                    //j=lps[j-1];
                }
            }else{
                if(j!=0){
                    j=lps[j-1];
                }else{
                    i++;
                }
            }
        }
        /*int i=0;
        for(int j=0; j<needle.length(); j++){
            if(haystack.charAt(i) == needle.charAt(j+1)){
                j++;
            }
        }*/

        return -1;
    }
    
    //optimal Solution
    //Rabin karp algo
    /*

    // d is the number of characters in the input alphabet
    public final static int d = 256;

    /* pat -> pattern
        txt -> text
        q -> A prime number
    */
    /*static void search(String pat, String txt, int q)
    {
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for txt
        int h = 1;

        // The value of h would be "pow(d, M-1)%q"
        for (i = 0; i < M - 1; i++)
            h = (h * d) % q;

        // Calculate the hash value of pattern and first
        // window of text
        for (i = 0; i < M; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= N - M; i++) {

            // Check the hash values of current window of
            // text and pattern. If the hash values match
            // then only check for characters one by one
            if (p == t) {
                /* Check for characters one by one
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j))
                        break;
                }

                // if p == t and pat[0...M-1] = txt[i, i+1,
                // ...i+M-1]
                if (j == M)
                    System.out.println(
                            "Pattern found at index " + i);
            }

            // Calculate hash value for next window of text:
            // Remove leading digit, add trailing digit
            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h)
                        + txt.charAt(i + M))
                        % q;

                // We might get negative value of t,
                // converting it to positive
                if (t < 0)
                    t = (t + q);
            }
        }

     */

    public static void main(String[] args){

        Scanner sc= new Scanner(System.in);
        String inputString= sc.nextLine();
        String findSubString= sc.nextLine();

        LeetCode_28 obj= new LeetCode_28();
        int result= obj.strstrKPS_Algo(inputString, findSubString);
        System.out.println(result);
        //return result;
    }





}
