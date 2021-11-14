import java.util.Arrays;
import java.util.Scanner;
public class SieveOfEratosthenes {

    public static boolean[] sieveOfEratosthenes(int n) {
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes, true);
        for(int i = 2; i*i <= n; i++) {
            //if primes[i] is not changed, then it is a prime
            if(primes[i]) {
                //update all multiples of i
                for(int j = i*i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }
        return primes;
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Enter a positive upper bound greater than 1: ");
        Scanner in = new Scanner(System.in);
        int upperBound = in.nextInt(); //get user input
        boolean[] primes = sieveOfEratosthenes(upperBound);
        System.out.println("All prime numbers smaller than or equal to " + upperBound);
        //print all prime numbers
        for(int i = 2; i <= upperBound; i++) {
            if(primes[i]) {
                System.out.println(i);
            }
        }
        in.close();
    }

}
 