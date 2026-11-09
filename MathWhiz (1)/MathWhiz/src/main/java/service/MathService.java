package service;

/** Reusable maths functions. All answers are calculated, never stored. */
public class MathService {

    public static final double TOLERANCE = 0.01;

    /** Returns 1 if prime, otherwise 0. Numbers below 2 are not prime. */
    public static int isPrime(int number) {
        if (number < 2) return 0;
        for (int i = 2; (long) i * i <= number; i++) {
            if (number % i == 0) return 0;
        }
        return 1;
    }

    /** Returns a % b. Throws IllegalArgumentException when the divisor is zero. */
    public static int calculateMod(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Validation error: divisor must not be zero.");
        }
        return a % b;
    }

    public static double calculateSin(double degree) {
        return Math.sin(Math.toRadians(degree));
    }

    public static double calculateCos(double degree) {
        return Math.cos(Math.toRadians(degree));
    }

    /** Returns NaN where tangent is undefined (90, 270, ... degrees). */
    public static double calculateTan(double degree) {
        double d = ((degree % 180) + 180) % 180;
        if (Math.abs(d - 90) < 1e-9) return Double.NaN;
        return Math.tan(Math.toRadians(degree));
    }

    /** Dispatch by name: "sin", "cos" or "tan". */
    public static double calculateTrig(String function, double degree) {
        switch (function) {
            case "sin": return calculateSin(degree);
            case "cos": return calculateCos(degree);
            case "tan": return calculateTan(degree);
            default: throw new IllegalArgumentException("Unknown function: " + function);
        }
    }

    /** Decimal comparison with tolerance. */
    public static boolean isClose(double expected, double actual) {
        if (Double.isNaN(expected) || Double.isNaN(actual)) return false;
        return Math.abs(expected - actual) <= TOLERANCE;
    }

    /** Scoring: Q1=2, Q2=2, Q3=3, Q4=3 (max 10). */
    public static int calculateScore(boolean primeCorrect, boolean modCorrect,
                                     boolean trig1Correct, boolean trig2Correct) {
        int totalScore = 0;
        if (primeCorrect) totalScore += 2;
        if (modCorrect)   totalScore += 2;
        if (trig1Correct) totalScore += 3;
        if (trig2Correct) totalScore += 3;
        return totalScore;
    }
}
