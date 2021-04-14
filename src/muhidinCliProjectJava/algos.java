package muhidinCliProjectJava;

class algos
{
    // Recursive function to return gcd of a and b
    static int __gcd(int a, int b)
    {
        return b == 0 ? a : __gcd(b, a % b);

    }
    static int digitGCD(int n)
    {
        int gcd = 0;
        while (n > 0)
        {
            gcd = __gcd(n % 10, gcd);

            // If at point GCD becomes 1,
            // return it
            if (gcd == 1)
                return 1;

            n = n / 10;
        }
        return gcd;
    }

    // Driver code
    public static void main (String[] args)
    {
        int n = 1;
        System.out.print(digitGCD(n));
    }
}