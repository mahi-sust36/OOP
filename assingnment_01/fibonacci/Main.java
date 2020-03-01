package Assignment01;

//import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        fibonacci fibo=new fibonacci();
        
        Scanner input = new Scanner(System.in) ;
        long n = input.nextLong() ;
        
        for(int i=0; i<=n; i++)
        {
            System.out.println(fibo.fib(i));
            //System.out.printf("%ld  " +fibo.fib(i));
        }
            
        
    }
    
}
