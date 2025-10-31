import java.util.Scanner;

public class StringMatchingComparison {

    // Naive String Matching Algorithm
    public static void naiveSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        System.out.print("Naive Matches at index: ");
        boolean found = false;

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j))
                    break;
            }
            if (j == m) {
                System.out.print(i + " ");
                found = true;
            }
        }
        if (!found) System.out.print("No match found");
        System.out.println();
    }

    // Rabin-Karp Algorithm
    public static void rabinKarpSearch(String text, String pattern, int prime) {
        int n = text.length();
        int m = pattern.length();
        int d = 256; // number of characters in input alphabet
        int p = 0;   // hash value for pattern
        int t = 0;   // hash value for text
        int h = 1;
        boolean found = false;

        // The value of h would be "pow(d, m-1) % prime"
        for (int i = 0; i < m - 1; i++)
            h = (h * d) % prime;

        // Calculate the hash value of pattern and first window of text
        for (int i = 0; i < m; i++) {
            p = (d * p + pattern.charAt(i)) % prime;
            t = (d * t + text.charAt(i)) % prime;
        }

        System.out.print("Rabin-Karp Matches at index: ");
        // Slide the pattern over text
        for (int i = 0; i <= n - m; i++) {
            if (p == t) {
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    System.out.print(i + " ");
                    found = true;
                }
            }

            // Calculate hash value for next window
            if (i < n - m) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % prime;
                if (t < 0)
                    t = (t + prime);
            }
        }
        if (!found) System.out.print("No match found");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Text: ");
        String text = sc.nextLine();

        System.out.println("Enter Pattern: ");
        String pattern = sc.nextLine();

        // Naive String Matching
        long startNaive = System.nanoTime();
        naiveSearch(text, pattern);
        long endNaive = System.nanoTime();
        double naiveTime = (endNaive - startNaive) / 1e6;

        // Rabin-Karp String Matching
        long startRK = System.nanoTime();
        rabinKarpSearch(text, pattern, 101);
        long endRK = System.nanoTime();
        double rkTime = (endRK - startRK) / 1e6;

        System.out.println("\nExecution Time:");
        System.out.printf("Naive Algorithm: %.4f ms\n", naiveTime);
        System.out.printf("Rabin-Karp Algorithm: %.4f ms\n", rkTime);

        sc.close();
    }
}
