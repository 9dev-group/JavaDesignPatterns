package Example;

import java.util.HashMap;
import java.util.Map;

public class CalculatorCache implements Calculator {
    private Calculator calculator;
    private Map<Long, Long> cache = new HashMap<>();

    CalculatorCache(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public long calculate(long n) {
        Long value = cache.get(n);

        if(value == null) {
            value = calculator.calculate(n);
            cache.put(n, value);
        } else {
            System.out.println("Cache used");
        }
        return value;
    }
}
