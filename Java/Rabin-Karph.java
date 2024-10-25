import java.util.ArrayList;
import java.util.List;

public class SuspiciousPointsFinder {
    private String text;
    private String pattern;
    private int q;
    private int d;

    public SuspiciousPointsFinder(String text, String pattern, int q) {
        this.text = text;
        this.pattern = pattern;
        this.q = q;
        this.d = 10;
    }

    public List<Integer> findSuspiciousPoints() {
        int n = text.length();
        int m = pattern.length();
        int hashPattern = 0;
        int hashText = 0;

        // Calculate initial hashes for pattern and first window of text
        for (int i = 0; i < m; i++) {
            hashPattern = (hashPattern * d + Character.getNumericValue(pattern.charAt(i))) % q;
            hashText = (hashText * d + Character.getNumericValue(text.charAt(i))) % q;
        }

        List<Integer> suspiciousPoints = new ArrayList<>();

        // Start comparing the hashes
        for (int i = 0; i <= n - m; i++) {
            if (hashText == hashPattern) {
                // Check for exact match
                if (text.substring(i, i + m).equals(pattern)) {
                    suspiciousPoints.add(i);
                }
            }

            // Recalculate hash for next window of text
            if (i < n - m) {
                int digitPrev = Character.getNumericValue(text.charAt(i));
                int digitNext = Character.getNumericValue(text.charAt(i + m));
                hashText = (hashText - digitPrev * (int) Math.pow(d, m - 1)) * d + digitNext;
                hashText = (hashText % q + q) % q;
            }
        }

        return suspiciousPoints;
    }

    public static void main(String[] args) {
        String T = "31415926535";
        String P = "26";
        int q = 11;

        SuspiciousPointsFinder finder = new SuspiciousPointsFinder(T, P, q);
        List<Integer> suspiciousPoints = finder.findSuspiciousPoints();
        List<Integer> patternPositions = new ArrayList<>();

        // Find pattern positions using built-in function as a check
        for (int i = 0; i < T.length() - P.length() + 1; i++) {
            if (T.startsWith(P, i)) {
                patternPositions.add(i);
            }
        }

        System.out.println("Suspicious points: " + suspiciousPoints);
        System.out.println("Pattern positions: " + patternPositions);
    }
}
