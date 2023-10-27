// Java program to find (a^b) % MOD
// where a and b may be very large
// and represented as strings.
import java.util.*;

public class GFG
{

    static long MOD = (long) (1e9 + 7);

    // Returns modulo exponentiation for two numbers
    // represented as long long int. It is used by
    // powerStrings(). Its complexity is log(n)
    static long powerLL(long x, long n)
    {
        long result = 1;
        while (n > 0)
        {
            if (n % 2 == 1)
            {
                result = result * x % MOD;
            }
            n = n / 2;
            x = x * x % MOD;
        }
        return result;
    }

    // Returns modulo exponentiation for
    // two numbers represented as strings.
    // It is used by powerStrings()
    static long powerStrings(String sa, String sb, String m)
    {
        // We convert strings to number
        long a = 0, b = 0;

        // calculating a % MOD
        for (int i = 0; i < sa.length(); i++)
        {
            a = (a * 10 + (sa.charAt(i) - '0')) %
                    MOD;
        }

        // calculating b % (MOD - 1)
        for (int i = 0; i < sb.length(); i++)
        {
            b = (b * 10 + (sb.charAt(i) - '0')) %
                    (MOD - 1);
        }

        // Now a and b are long long int. We
        // calculate a^b using modulo exponentiation
        return powerLL(a, b);
    }

    // Driver code
    public static void main(String[] args)
    {

        // As numbers are very large
        // that is it may contains upto
        // 10^6 digits. So, we use string.
        String sa = "263480513527187359186491375342256711811356461375746" +
                "1179350849231283926775814832835051359568314125503106258670" +
                "248538326389661406031065399148933498305975063815695004435054" +
                "646392718449351502197579689154090333301790919146133725759085067" +
                "539836588323927344773245054124839765232232718660934732802301115" +
                "5354089466890404209328084301579060547627017150588155745490002927" +
                "6594304039259536671124270844436782535761365523568348883316364514" +
                "95287366541224137902125627778997616487896401343998547123197114916" +
                "54360427793499064321250145653141282909149823556063016798336402812" +
                "3623758694889310592132871723010303126477187979118780857522959153",
                sb = "154126910401868712874406216044334838177112188492975585495142539" +
                        "248741472442554284207212680711392430514843837697336919511786" +
                        "54558535257914635048433977408944890101088566786031529260491891" +
                        "85272300069295649812539481168535475381307505959829090615818108" +
                        "75436258110877453036414116910656811990473340767875147146985309",
        m = "";
        System.out.println(powerStrings(sa, sb,m));
    }
}

// This code is contributed by Rajput-JI

