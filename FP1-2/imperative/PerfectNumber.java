package imperative;

import java.util.Set;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class PerfectNumber {

    public enum STATE {ABUNDANT, DEFICIENT, PERFECT};

    public static Set<Integer> divisors(int n) {
        int limit = (int) Math.ceil(Math.sqrt(n));
        Set<Integer> results = IntStream
                .rangeClosed(1, limit)
                .filter(i -> (n % i) == 0)
                .boxed()
                .flatMap(i -> Stream.of(i, n / i))
                .collect(Collectors.toSet());

        return results;
    }

    public static STATE process(int n){

        Function<Integer, STATE> stateDefine = strm -> Optional.of(strm)
                .filter(i -> i == n)
                .map(i -> STATE.PERFECT)
                .orElse(STATE.ABUNDANT);

        Set<Integer> divisors = PerfectNumber.divisors(n);
        STATE result = divisors
                .stream()
                .filter(i -> i != n)
                .reduce((a, b) -> a + b)
                .filter(i -> i >= n)
                .map(stateDefine)
                .orElse(STATE.DEFICIENT);

        return result;
    }
}


