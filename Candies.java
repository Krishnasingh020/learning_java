import java.util.Scanner;

public class Candies {
    public static int min_Candies(int n){
        int candies = n;
        int count = 0;
        if(candies % 3 == 0){
            return 0;
        }
        while(candies % 3 != 0){
            candies++;
            count++;
        }
        return count;
        
    }
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            int n = sc.nextInt();
            System.out.println(min_Candies(n));
        }
        sc.close();
    }
}
