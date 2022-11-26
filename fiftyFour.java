//263. Ugly Number
//Logic : Every number can be represented by product of primes
//If they can be represented by product of 2,3 and 5 then the number becomes 1 upon prime factorization using only 2,3 and 5 or else it does not become until it gets factorized by primes apart from 2,3 and 5

public class fiftyFour {
    public boolean isUgly(int n) {            
        while(n>1){
            
            if(n%2 == 0)
                n/=2;
            else if(n%3 == 0)
                n/=3;
            else if(n%5 == 0)
                n/=5;
            else
                break;
        }
        if(n == 1)
            return true;
        return false;

    } 
}
