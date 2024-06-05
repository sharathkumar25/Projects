package practice;

public class Test {

	public static void main(String[] args) {
		int n = 10; // Change this value to print a different number of terms
        int firstTerm = 0, secondTerm = 1;

        System.out.println("Fibonacci Series (First " + n + " terms):");
            for (int i = 1; i <= n; ++i) {
                System.out.print(firstTerm + " ");

                // Compute the next term in the series
                int nextTerm = firstTerm + secondTerm;
                firstTerm = secondTerm;
                secondTerm = nextTerm;
            }
        }
}

      
   
