package rodias.jl.testing;

/**
 * Optimized solution for checking if a number is prime and an anagram.
 * This solution uses a optimized algorithm for checking if a number is prime. 
 * While checking for anagrams first in order to prevent expensive prime calculations.
 * This could further be optimized if we use the Fermat primality test in order to reduce the time complexity. This in turn could further reduce the time complexity while reducing the precission.
 */
public class PrimesPalindromChecker {

    public static boolean isPrimePalindrom(int num) {
        return PalindromChecker.isPalindrom(num) && Primes.isPrime(num);
    }

    public static boolean isPrimePalindromFast(int num) {
        return PalindromChecker.isPalindrom(num) && Primes.isPrimeFermat(num,100);
    }

    public static int[] findThreePrimesAndPalindromes(int start, int target) {

        int[] result = new int[target];
        int index = 0;
        int i = start;
        while( index < target ) { 

            if(isPrimePalindrom(i++)){
                result[index++] = i - 1;
            }
            
        }
        return result;
        
    }
    
}



class Primes {
    public static boolean isPrime(int num) {

        if(num < 2 ) { return false; }
        if(num == 2) { return true; }
        
        int sqrt = (int)Math.sqrt(num);
        for(int i = 3; i < sqrt; i+=2) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static boolean isPrimeFermat(int num, int precision) {

        for( int p = 0; p < precision ; p++) {
            if (!checkFermat(num, p)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkFermat(int num, int a) {

        // Fermat's little theorem: a^(p-1) === 1 (mod p) for all primes p > 2.
        // In this case, we just need to check for the first few values.
        return Math.pow(a, num - 1) % num == 1;
    }
}

class PalindromChecker {
    public static boolean isPalindrom(int num){

        String numString = String.valueOf(num);
        // micro optimization: checking only half of the string.
        // for shits and giggles.
        for (int i = 0; i < numString.length() >> 1; i++) {
            
            if(numString.charAt(i) != numString.charAt(numString.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
