import java.util.*;

public class MexPartition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] freq = new int[101];
            
            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                freq[num]++;
            }
            
            int x = 0;
            while (freq[x] >= 1) x++;
            
            int y = 0;
            while (freq[y] >= 2) y++;
            
            System.out.println(x + y);
        }
        sc.close();
    }
}