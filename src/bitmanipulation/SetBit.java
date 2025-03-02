package bitmanipulation;

import java.util.Scanner;

public class SetBit {
    public static void printBinary(int n){
        for(int i=10; i>=0; --i){
            System.out.print((n>>i)&1);
        }
        System.out.println();
    }
    public static void main(String[] args){
     Scanner sc= new Scanner(System.in);
     int a= sc.nextInt();
     printBinary(a);
     int i=3; //position to check i'th bit is set or not
     if((a& (1<<i)) !=0) {
         System.out.println("Bit is set"); //if ith bit is 1

         System.out.println("bit after un setting bit");
         printBinary( a & (~(1<<i))); // ~ it provides inversion of given number
     }else{
         System.out.println("Bit is not set");// if ith bit is 0

         // logic to set bit
         System.out.println("bit after setting bit");
         printBinary( a | (1<<i));
     }

     /* logic to taggle the number
     printBinary( a^ (1<<i));
      */

        /*logic to count set bit
        int cnt=0;
        for(int i=3i; i>=0; --i){
        if((a & (1<<i) !=0)
        {
        cnt++;
        }
        }

         */
    }
}
