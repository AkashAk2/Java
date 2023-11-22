import java.util.*;

/**
 * The RandomNumberGenerator class generates random numbers.
 * It uses the java.util.Random class to produce random integers.
 * @author Akash Balakrishnan
 * @version 1.0
 */
public class RandomNumberGenerator
{
    /**
     * Generates a random number within the specified range.
     * @param maxNumber The upper bound of the random number range.
     * @return Returns a randomly generated integer.
     */
    public int generateRandomNumber(int maxNumber)
    {
        Random random = new Random();
        int randomNumber = random.nextInt(maxNumber);
        // System.out.println(randomNumber);
        return randomNumber;
    }
}
