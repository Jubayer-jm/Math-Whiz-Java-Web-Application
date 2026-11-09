package model;

import java.io.Serializable;
import java.util.Random;

/** The four questions of one game (only question inputs are stored, never answers). */
public class GameRound implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String[] FUNCS = {"sin", "cos", "tan"};
    // Angles chosen so tan is always defined
    private static final int[] ANGLES = {0, 30, 45, 60, 120, 135, 150, 180, 210, 225, 240, 300, 315, 330};

    private final int primeNumber;
    private final int modA;
    private final int modB;
    private final String trig1Func;
    private final int trig1Angle;
    private final String trig2Func;
    private final int trig2Angle;

    public GameRound() {
        Random r = new Random();
        primeNumber = 2 + r.nextInt(49);          // 2..50
        modA = 10 + r.nextInt(90);                // 10..99
        modB = 2 + r.nextInt(11);                 // 2..12 (never zero)
        trig1Func = FUNCS[r.nextInt(3)];
        trig1Angle = ANGLES[r.nextInt(ANGLES.length)];
        String f2;
        do { f2 = FUNCS[r.nextInt(3)]; } while (f2.equals(trig1Func));
        trig2Func = f2;
        trig2Angle = ANGLES[r.nextInt(ANGLES.length)];
    }

    public int getPrimeNumber() { return primeNumber; }
    public int getModA() { return modA; }
    public int getModB() { return modB; }
    public String getTrig1Func() { return trig1Func; }
    public int getTrig1Angle() { return trig1Angle; }
    public String getTrig2Func() { return trig2Func; }
    public int getTrig2Angle() { return trig2Angle; }
}
