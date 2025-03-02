package bitmanipulation;


import java.util.Scanner;

//Decimal to binary conversion
public class Example1 {

    public static String reverse(String str){
        String res="";
        char ch;
        for(int i=0; i<str.length(); i++){
            ch= str.charAt(i);
            res=ch+res;
        }
        return res;
    }

    //TC = O(log2(n)), SC = O(log2(n))
    public static String convert2Binary(int n){
     String res="";
      while(n>0){
          if(n%2==1){
              res+='1';

          }else{
              res+='0';

          }
          n=n/2;
      }
      res=reverse(res);
      return res;
    }
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);

        int input= sc.nextInt();

        System.out.println("Given Decimal number is: " + input+" And it's binary equivalent " +convert2Binary(input));


    }
}
