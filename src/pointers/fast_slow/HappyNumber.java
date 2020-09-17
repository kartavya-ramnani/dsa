package pointers.fast_slow;

// Any number will be called a happy number if,
// after repeatedly replacing it with a number equal to the sum of the square of all of its digits,
// leads us to number ‘1’. All other (not-happy) numbers will never reach ‘1’.
// Instead, they will be stuck in a cycle of numbers which does not include ‘1’.
public class HappyNumber {

    public static boolean isHappyNumber(int num) {
        int slow = num, fast = num;
        do {
            slow = calculateSquaredSum(slow);
            fast = calculateSquaredSum(calculateSquaredSum(fast));
        } while (slow != fast);
        return slow == 1;
    }

    private static int calculateSquaredSum(int num) {
        int sum = 0, digit;
        while (num > 0) {
            digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        int input = 23;
        boolean response = HappyNumber.isHappyNumber(input);
        System.out.println("Response : " + response);
        input = 12;
        response = HappyNumber.isHappyNumber(input);
        System.out.println("Response : " + response);
    }

}
