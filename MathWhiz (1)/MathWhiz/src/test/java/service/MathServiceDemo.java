package service;

/** Simple test runner (no JUnit needed): run its main method. Covers Task 09 cases. */
public class MathServiceDemo {
    static int pass = 0, fail = 0;

    static void check(String name, boolean ok) {
        System.out.println((ok ? "PASS  " : "FAIL  ") + name);
        if (ok) pass++; else fail++;
    }

    public static void main(String[] args) {
        check("Prime 7 -> 1", MathService.isPrime(7) == 1);
        check("Prime 8 -> 0", MathService.isPrime(8) == 0);
        check("Prime 1 -> 0", MathService.isPrime(1) == 0);
        check("Prime 0 -> 0", MathService.isPrime(0) == 0);
        check("Prime -5 -> 0", MathService.isPrime(-5) == 0);
        check("Prime 2 -> 1", MathService.isPrime(2) == 1);
        check("17 % 5 = 2", MathService.calculateMod(17, 5) == 2);
        check("-17 % 5 = -2", MathService.calculateMod(-17, 5) == -2);
        check("17 % -5 = 2", MathService.calculateMod(17, -5) == 2);
        check("0 % 5 = 0", MathService.calculateMod(0, 5) == 0);
        boolean threw = false;
        try { MathService.calculateMod(10, 0); } catch (IllegalArgumentException e) { threw = true; }
        check("Divisor 0 -> validation error", threw);
        check("sin 30 = 0.5", MathService.isClose(0.5, MathService.calculateSin(30)));
        check("cos 60 = 0.5", MathService.isClose(0.5, MathService.calculateCos(60)));
        check("tan 45 = 1.0", MathService.isClose(1.0, MathService.calculateTan(45)));
        check("tan 90 undefined (NaN)", Double.isNaN(MathService.calculateTan(90)));
        check("tan 270 undefined (NaN)", Double.isNaN(MathService.calculateTan(270)));
        check("sin^2 + cos^2 = 1 at 37 deg",
              MathService.isClose(1.0, Math.pow(MathService.calculateSin(37), 2) + Math.pow(MathService.calculateCos(37), 2)));
        check("All correct -> 10", MathService.calculateScore(true, true, true, true) == 10);
        check("All wrong -> 0", MathService.calculateScore(false, false, false, false) == 0);
        check("Only prime+mod -> 4", MathService.calculateScore(true, true, false, false) == 4);
        check("Only trig -> 6", MathService.calculateScore(false, false, true, true) == 6);
        System.out.println("\nPassed: " + pass + "  Failed: " + fail);
        if (fail > 0) System.exit(1);
    }
}
