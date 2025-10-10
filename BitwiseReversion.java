import java.util.*;
public class BitwiseReversion {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();

            while(t-- > 0){
                int x = sc.nextInt();
                int y = sc.nextInt();
                int z = sc.nextInt();

                if((x & y) == (x & z) && (x & z) == (y & z)){
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }

            }
        }
}
