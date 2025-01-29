import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;

import test.PrimesPalindromChecker;

public class Entry {

    private static final int START = 10_000_001;

    private static int[] EXPECTED = PrimesPalindromChecker.findThreePrimesAndPalindromes(START, 3);

    public static void main(String[] args) {

        final AtomicBoolean finished = new AtomicBoolean(false);
        final PrimePalindromSolver solver = new PrimePalindrom();
        final Terminator t = new Terminator(finished);
        t.start();

        final int[] actual = timed(solver::getPrimePalindroms, finished);

        executeChecks(actual, EXPECTED);
    }

    private static int[] timed(Supplier<int[]> f, AtomicBoolean finished) {
        LocalTime start = LocalTime.now();
        int[] actual = f.get();
        LocalTime end = LocalTime.now();
        System.out.println("EXECUTION TIME: " + Duration.between(start, end).toMillis() + " ms");
        finished.set(true);
        return actual;
    }

    private static void executeChecks(int[] actual, int[] expected) {
        for (int i = 0; i < actual.length; i++) {
            if (expected[i] != actual[i]) {
                System.out.println("ERROR: Expected " + expected[i] + " but got " + actual[i]);
                return;
            }
            System.out.println("SUCCESS: Prime Palindrom " + (i + 1) + ": " + actual[i]);
        }
        System.out.println("EXPECTED: " + java.util.Arrays.toString(expected));
        System.out.println("ACTUAL: " + java.util.Arrays.toString(actual));
    }
}

class Terminator extends Thread {

    public Terminator(AtomicBoolean finished) {

        super(() -> {
            try {
                Thread.sleep(1000);
                if (!finished.get()) {
                    System.out.println("FAIL: computation took to long Terminating...");
                    System.exit(0);
                }
            } catch (InterruptedException _ignore) {
                // ignore
            }
        });
    }
}

interface PrimePalindromSolver {
    int[] getPrimePalindroms();
}

/**
 * Todo: Move to different module and provide as a service.
 */
class PrimePalindrom implements PrimePalindromSolver {

    /**
     * Gesucht sind drei aufeinanderfolgende Zahlen (a, b, c) die ein
     * Primzahlenpalindrom bilden. Diese Zahlen sollen mindestens 8 stellig sein.
     * 
     * Eine Zahl Z ist eine Primzahl genau dann wenn die Teilermenge T := {1, p}
     * genau zwei Teiler enthällt.
     * 
     * Unter einem Palindrom versteht man ein Wort oder Zeichenkette, die von vorne
     * sowie von hinten gleich gelesen wird.
     * Beispiel: "madam", "deed", "level", "12321"
     * 
     * Schritt 1: Es wird eine Methode zum Prüfen, ob eine Zahl eine Primzahl ist,
     * implementiert.
     * Schritt 2: Es wird eine Methode zum Prüfen, ob eine Zahl ein Palindrom ist,
     * implementiert.
     * Schritt 3: Es wird eine Methode zum suchen die drei aufeinanderfolgenden
     * Zahlen, die eine Primzahl und ein Palindrom sind, implementiert
     * 
     * @param num
     * @return
     * @throws InterruptedException
     */
    public int[] getPrimePalindroms() {

        return null;
    }
}