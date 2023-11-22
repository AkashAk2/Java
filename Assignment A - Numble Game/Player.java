/**
 * @author Akash Balakrishnan
 * @version 1.0
 * Player class contains information about the player.
 */
public class Player
{
    private String name;
    private int guess;
    private int score;

    // Default constructor 
    public Player()
    {
        name = "Unknown";
        guess = 0;
        score = 0;
    }

    /**
     * Non Default constructor
     * @param newName is a string represents player name.
     * @param newGuess is an integer represents player guess.
     * @param newScore is an integer represents player score.
     */
    public Player(String newName, int newGuess, int newScore)
    {
        name = newName;
        guess = newGuess;
        score = newScore;
    }

    /**
     * Accessor Method getName.
     * @return Returns String value player name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Accessor Method getGuess.
     * @return Returns integer value player guess.
     */
    public int getGuess()
    {
        return guess;
    }

    /**
     * Accessor Method getScore.
     * @return Returns integer value player score.
     */
    public int getScore()
    {
        return score;
    }

    /**
     * Mutator Method setName.
     * @param String name of the player.
     * @return Returns nothing.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Mutator Method setGuess.
     * @param int guess of the player.
     * @return Returns nothing.
     */
    public void setGuess(int guess)
    {
        this.guess = guess;
    }

    /**
     * Mutator Method setScore.
     * @param int score of the player.
     * @return Returns nothing.
     */
    public void setScore(int scoreAwarded)
    {
        score = score + scoreAwarded;
    }
}
