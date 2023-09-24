import java.util.Scanner;

class N_Digit_EqualSums
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        System.out.print("Enter the value of sum: ");
        int sum = scanner.nextInt();

        if (n >= 1 && n <= 9 && sum > 0 && sum <= 81) {
            System.out.print("The " + n + "-digit numbers with sum " + sum + " are: ");
            findNdigitNums("", n, sum);
        } else {
            System.out.println("Invalid input. Please ensure that n is between 1 and 9, and sum is <= 81.");
        }
    }

    public static void findNdigitNums(String result, int n, int sum)
    {
        if (n > 0 && sum >= 0)
        {
            char d = '0';
            if (result.equals("")) {    //avoids numbers starting with 0
                d = '1';
            }

            while (d <= '9')
            {
                findNdigitNums(result + d, n - 1, sum - (d - '0'));
                d++;
            }
        }

        // print n-digit numbers
        else if (n == 0 && sum == 0) {
            System.out.print(result + " ");
        }
    }

}
