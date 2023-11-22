/**
 * @author Akash Balakrishnan
 * @version 1.0
 * NumberGenerator class generates a random number between a range.
 */
import java.lang.Math;

public class NumberGenerator
{
    private int minimum;
    private int maximum;
    private int randomNumber;

    // Non Default constructor
    public NumberGenerator()
    {
        minimum = 0;
        maximum = 0;
    }

    /**
     * Non Default constructor
     * @param newMin is an integer value represents minimum range.
     * @param newMax is an integer value represents maximum range.
     * @return Returns nothing.
     */
    public NumberGenerator(int newMin, int newMax)
    {
        minimum = newMin;
        maximum = newMax;
    }

    /**
     * Accessor Method getMinimum() called to get the minimum value.
     * @return Returns integer value minimum range.
     */
    public int getMinimum()
    {
        return minimum;
    }

    /**
     * Accessor Method getMaximum() called to get the maximum value.
     * @return Returns integer value maximum range.
     */
    public int getMaximum()
    {
        return maximum;
    }

    /**
     * Accessor Method getRandom() called to get the random number.
     * @return Returns integer value random number.
     */
    public int getRandom()
    {
        return randomNumber;
    }

    /**
     * generateRandom() method used to generate a random number between a range.
     * @param minimum is an integer value represents minimum range.
     * @param maximum is an integer value represents maximum range.
     * @return Returns nothing.
     */
    public void generateRandom(int minimum, int maximum)
    {
        this.minimum = minimum;
        this.maximum = maximum;
        //using Math.random() to genereate a random number
        double random = Math.random() * (maximum - minimum + 1) + minimum;
        int temp = (int) random;
        randomNumber = temp;
    }

    /**
     * Mutator Method setMinimum() called to set the minimum value.
     * @param minimum an integer value of minimum range.
     @ returns Returns nothing.
     */
    public void setMinimum(int minimum)
    {
        this.minimum = minimum;
    }

    /**
     * Mutator Method setMaximum() called to set the maximum value.
     * @param maximum an integer value of maximum range.
     @ returns Returns nothing.
     */
    public void setMaximum(int maximum)
    {
        this.maximum = maximum;
    }
}
