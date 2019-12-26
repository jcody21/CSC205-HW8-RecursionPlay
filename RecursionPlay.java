
/**
 * @description: This program demonstrates recursion.
 * 
 * @author: John Cody
 * @date: 0219.02.27
*/

public class RecursionPlay {
   
    public static final int BASEN_ERRNO = -1;
    
    public static void main(String[] argv) {
      countdown(10);
      int[] x = { 8, 16, 128, 2048, Short.MAX_VALUE, Integer.MAX_VALUE };
      for (int i = 0; i < x.length; i++) {
         System.out.print(x[i] + " reversed: "); 
         reverse_digits(x[i]);
         System.out.println();
      }
      System.out.println(sum(x, 0, 0));
      basen(512, 6);
      basen(314, 8);
      basen(49, 5);
      basen(10101, 2);
   }

   public static void basen(int n, int b) {
      int ans = basen(n /*number*/, b /*base*/, 
                      1 /*beginning placevalue*/, 
                      0 /*beginning answer*/);
      if (ans == BASEN_ERRNO)
         System.out.println(n + " is not a valid base-" + b + " number");
      else
         System.out.println(n + " base-" + b + " = " + ans + " base-10");
   }

   
   private static void countdown(int n) {
       if (n==0)
           System.out.println("BLAST OFF!");
       else {
           System.out.print(n + "...");
           countdown(n-1);
       }
   }

   private static void reverse_digits(int n) {
       if(n>0) {
           System.out.print(n%10);
           reverse_digits(n/10);
       }
   }

   private static long sum(int[] x, int x_i, long total) {
       if(x_i < x.length) {
           total += x[x_i]; 
           return sum(x, x_i+1, total);
       }
       else 
           return total;
   }

   public static int basen(int number, int base, int placevalue, int answer) {
      if (number == 0) 
         return answer;
      int digit = number % 10;
      if (digit >= base) 
         return BASEN_ERRNO;
      answer += digit*Math.pow(base, placevalue-1); 
      number /= 10;
      placevalue++;
      return basen(number, base, placevalue, answer);
   }

}