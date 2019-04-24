public class Factorial
{
    public static void main(String[] args)
    {
        int num1 = 2;
        int num2 = 4;
        int num3 = 5;
        System.out.println(factorial(num1));
        System.out.println(factorial(num2));
        System.out.println(factorial(num3));
    }
    public static int factorial(int num)
    {
        int result = 1;
        for(int i = 1; i <= num; i++)
        {
            result *= i;
        }
        return result;
    }
}
