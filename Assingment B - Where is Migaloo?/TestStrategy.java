/**
 * The TestStrategy class contains methods to test the functionalities of the Whale class.
 * @author Akash Balakrishnan
 * @version 1.0
 */
public class TestStrategy
{
    /**
     * Test method 1 uses the default constructor of Whale.
     * It creates a whale instance and displays its information.
     */
    public void testMethodOne()
    {
        Whale whaleOne = new Whale();
        whaleOne.display();
    }

    /**
     * Test method 2 uses the non-default constructor and accessor methods of Whale.
     * It creates a whale instance with specified attributes, accesses its information, and displays it.
     */
    public void testMethodTwo()
    {
        Whale whaleTwo = new Whale("South", false, false, true, "Jervis Bay", "Minke");
        whaleTwo.getDirectionOfTravel();
        whaleTwo.getIsThereACalf();
        whaleTwo.getIsCalfInjured();
        whaleTwo.getIsInjured();
        whaleTwo.getLocationSeen();
        whaleTwo.getSpeciesOfWhale();
        whaleTwo.display();
    }

    /**
     * Test method 3 uses the non-default constructor and mutator methods of Whale.
     * It creates a whale instance with default attributes, modifies its attributes using mutators, and displays it.
     */
    public void testMethodThree()
    {
        Whale whaleThree = new Whale();
        whaleThree.setDirectionOfTravel("West");
        whaleThree.setIsCalfAccompanied(false);
        whaleThree.setIsCalfInjured(true);
        whaleThree.setIsInjured(false);
        whaleThree.setLocationSeen("XYZ");
        whaleThree.setSpeciesOfWhale("White Shark");
        whaleThree.display();
    }

    /**
     * The main method creates an instance of TestStrategy and tests each method.
     * It demonstrates the use of different constructors, accessor methods, and mutator methods.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args)
    {
        TestStrategy test = new TestStrategy();
        System.out.println("\nTest method 1 uses the default constructor");
        test.testMethodOne();
        System.out.println("\nTest method 2 uses the non-default constructor and accessor methods");
        test.testMethodTwo();
        System.out.println("\nTest method 3 uses the non-default constructor and mutator methods");
        test.testMethodThree();
    }
}
