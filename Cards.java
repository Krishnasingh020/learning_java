import java.io.*;
import java.util.*;

public class Cards{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // read first non-empty line for t
        String line;
        do { line = br.readLine(); } while (line != null && line.trim().isEmpty());
        if (line == null) return;
        int t = Integer.parseInt(line.trim());

        StringBuilder out = new StringBuilder();
        while (t-- > 0) {
            // read n and k
            do { line = br.readLine(); } while (line != null && line.trim().isEmpty());
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            // read s
            do { line = br.readLine(); } while (line != null && line.trim().isEmpty());
            String s = line.trim();

            int cnt0 = 0, cnt1 = 0, cnt2 = 0;
            for (int i = 0; i < k; i++) {
                char c = s.charAt(i);
                if (c == '0') cnt0++;
                else if (c == '1') cnt1++;
                else cnt2++;
            }

            int m = n - k; // how many cards remain
            if (m == 0) {
                // all removed
                for (int i = 0; i < n; i++) out.append('-');
                out.append('\n');
                continue;
            }

            int a = cnt0;
            int b = cnt0 + cnt2;
            int unionL = a;
            int unionR = b + m - 1;   // inclusive
            int interL = b;
            int interR = a + m - 1;   // inclusive

            // build answer
            for (int i = 0; i < n; i++) {
                if (i < unionL || i > unionR) {
                    out.append('-');           // never present
                } else if (interL <= interR && i >= interL && i <= interR) {
                    out.append('+');           // always present
                } else {
                    out.append('?');           // may be present or removed
                }
            }
            out.append('\n');
        }

        System.out.print(out.toString());
    }
}
