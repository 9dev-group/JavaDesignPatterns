package Example;

public class Example {
    public static void main(String[] args) {
        Calculator calculator = new CalculatorCache(new FactorialCalculator());

        System.out.println(calculator.calculate(5));
        System.out.println(calculator.calculate(5));

        System.out.println(calculator.calculate(10));
        System.out.println(calculator.calculate(10));
    }
}
