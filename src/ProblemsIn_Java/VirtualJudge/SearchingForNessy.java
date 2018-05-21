package ProblemsIn_Java.VirtualJudge;

import java.util.Scanner;

public class SearchingForNessy {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0)
        System.out.println((int)((in.nextLong()/3)*(in.nextLong()/3)));
    }
}
