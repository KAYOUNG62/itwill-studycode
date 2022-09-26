package edu.java.lambda02;

//import edu.java.lambda02.Calculator.Calculable;

public class LambdaMain02 {

    public static void main(String[] args) {

        Calculator adder = new Calculator(1, 2);
//        double result = adder.calculate(new Calculable() {
//            @Override
//            public double calculate(double x, double y) {
//                return x + y;
//            }
//        }); // 익명클래스
        double result = adder.calculate((x, y) -> x + y);
        System.out.println("adder result = " + result); // 3.0

        // 뺄샘을 계산하는 계산기
        Calculator subtracter = new Calculator(1, 2);
        result = subtracter.calculate((x, y) -> x - y);
        System.out.println("subtrater result = " + result);

        // 곱셈을 계산하는 계산기
        Calculator multiplier = new Calculator(1, 2);
//        result = multiplier.calculate(new Calculable() {
//            @Override
//            public double calculate(double x, double y) {
//                return x * y;
//            }
//        });
        result = multiplier.calculate((x, y) -> x * y);
        System.out.println("multiplierr result = " + result);

        // 나눗셈을 계산하는 계산기
        Calculator divier = new Calculator(1, 2);
        result = divier.calculate((x, y) -> x / y);
        System.out.println("divier result = " + result);

        // 두 숫자중에서 더 크거나 같은 수를 찾는 계산기
        Calculator greater = new Calculator(1, 2);
//        result = greater.calculate(new Calculable() {
//            @Override
//            public double calculate(double x, double y) {
//                if (x > y) {
//                    return x;
//                } else {
//                    return y;
//                }
//            }
//        });
        result = greater.calculate((x, y) -> (x >= y) ? x : y);
        System.out.println("greater result = " + result);

        result = greater.calculate((x, y) -> {
            if (x > y) {
                return x;
            } else {
                return y;
            }
        });
    }
}
