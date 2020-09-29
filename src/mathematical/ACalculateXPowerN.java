package mathematical;

// Given two integers x and n, write a function to compute x^n. We may assume that x and n are small and overflow doesn’t happen.
// Assuming x and n to be positive integers.
public class ACalculateXPowerN {

    // In this approach, we will be calculating recursively x^(n/2) and we store it and
    // if n is even then we just multiply them else we multiple them and with x.
    // Linear Time Complexity and constant space
    public static int calculate(int x, int n) {
        // simple boundary condition out of the way
        if (x <= 1 || n == 1) {
            return x;
        }

        if (n == 0) {
            return 1;
        }

        int temp = calculate(x, n / 2);

        return n % 2 == 0 ? temp * temp : x * temp * temp;
    }

    public static void main(String[] args) {
        System.out.println("Power : " + calculate(7, 2));
        System.out.println("Power : " + calculate(2, 11));
        System.out.println("Power : " + calculate(2, 0));
        System.out.println("Power : " + calculate(1, 1));
    }

}
