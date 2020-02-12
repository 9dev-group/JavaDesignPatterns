package Example;

import java.util.stream.LongStream;

public class FactorialCalculator implements Calculator {
    public long calculate(long n) {
        if (n < 1) { return 0; }
        else if (n < 3) { return n; }

        return LongStream.range(2, n)
                .reduce((x, y) -> x * y)
                .orElse(0);
    }
}
