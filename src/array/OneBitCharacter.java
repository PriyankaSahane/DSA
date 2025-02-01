package array;
import java.util.Scanner;

public class OneBitCharacter{

    public static boolean isOneBitCharacter(int []  bits){
        int n= bits.length;
        int i= n-2;
        while(i<n-1){
            if(bits[i]==1){
                i+=2;
            }else{
                i++;
            }
        }
        return i==n-1;
    }
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int[] bits={1,0,0};
        System.out.println(isOneBitCharacter(bits));
    }
}
