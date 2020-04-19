package ProblemsIn_Java.Uva;

public class Example {
    public static void main(String [] args){
        long a = 0;

        long b = 8;

        long c = 30;

        a = a | (1<<b);
        a = a | (1<<c);
        System.out.println(a);
        System.out.println(Long.toBinaryString(a));
    }
}
