package imperative;

import java.util.HashSet;
import java.util.Set;

public class PerfectNumber{

    public enum STATE {ABUNDANT, DEFICIENT, PERFECT};

    public static Set<Integer> divisors(int n){
        Set<Integer> results = new HashSet<Integer>();
        double limit = Math.ceil(Math.sqrt(n));
        int i = 1;
        do{
            if((n % i)==0){
                results.add(i);
                results.add(n/i);
            }
            i++;
        }while(i<=limit);
        return results;
    }

    public static STATE process(int n){
        int sum = 0;
        for(Integer i : PerfectNumber.divisors(n)){
            sum += i;
        }
        sum -= n;
        if(sum == n){return STATE.PERFECT;}
        else if(sum > n){return STATE.ABUNDANT;}
        else return STATE.DEFICIENT;
    }

}
