package Assignment01;

public class fibonacci {

    long fib(long n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

}
