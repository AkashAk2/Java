/**
 * @author Akash Balakrishnan
 * @version 1.0
 */
import java.util.*;
import java.lang.Math;

/**
 * Game class contains all the functions to run a numble game.
 */
public class Game
{
    private Player player1;
    private Player player2;
    private int secretNumber;
    private int minRange;
    private int maxRange;
    private NumberGenerator randomNumber;
    private boolean isGameOver;
    private boolean isChanceOver;
    private boolean isRoundOver;
    private boolean hasComputerGuessed;
    private boolean hasComputerAbandoned;
    private boolean hasPlayerGuessed;
    private boolean hasPlayerAbandoned;

    // Default constructor
    public Game()
    {
        player1 = new Player();
        player2 = new Player();
        randomNumber = new NumberGenerator();
        secretNumber = 0;
        minRange = 1;
        maxRange = 100;
        isGameOver = false;
        isChanceOver = false;
        isRoundOver = false;
        hasComputerAbandoned = false;
        hasComputerGuessed = false;
        hasPlayerAbandoned = false;
        hasPlayerGuessed = false;
    }

    /**
     * Non Default constructor
     * @param player1 is an object of the Class Player and one of the players of this game.
     * @param player2 is an object of the Class Player and one of the players of this game.
     * @param randomNum is an object of the Class NumberGenerator and used to genereate random numbers
     * @param secretNumber is an integer contains a random number for the game.
     * @param minRange is an integer representing the minimum value for each round
     * @param maxRange is an integer representing the maximum value for each round
     * @param isGameOver is a boolean value representing is game over or not
     * @param isChanceOver is a boolean representing is chance over for each player player after attempt
     * @param isRoundOver is a boolean representing completion of one round.
     * @param hasComputerAbandoned is a boolean representing whether the computer abandoned the round or not.
     * @param hasComputerGuessed is a boolean representing whether the computer guessed the secret number or not.
     * @param hasPlayerAbandoned is a boolean representing whether the player abandoned the round or not.
     * @param hasPlayerGuessed is a boolean representing whether the player guessed the round or not.
     */
    public Game(Player player1, Player player2, NumberGenerator randomNumber, int secretNumber, int minRange, int maxRange, boolean isGameOver, boolean isChanceOver, boolean isRoundOver, boolean hasComputerAbandoned, boolean hasComputerGuessed, boolean hasPlayerAbandoned, boolean hasPlayerGuessed)
    {
        this.player1 = player1;
        this.player2 = player2;
        this.randomNumber = randomNumber;
        this.secretNumber = secretNumber;
        this.minRange = minRange;
        this.maxRange = maxRange;
        this.isGameOver = isGameOver;
        this.isChanceOver = isChanceOver;
        this.isRoundOver = isRoundOver;
        this.hasComputerAbandoned = hasComputerAbandoned;
        this.hasComputerGuessed = hasComputerGuessed;
        this.hasPlayerAbandoned = hasPlayerAbandoned;
        this.hasPlayerGuessed = hasPlayerGuessed;
    }

    /** 
     * ComputerAbandonGenerator() Method used to generate a random number for the computer to abandon the round.
     * @return Integer value of range from 1 to 20.
     */
    public int computerAbandonGenerator()
    {
        //Using genereate random function a random number is generated from the range 1 to 20.
        randomNumber.generateRandom(1,20);
        int abandonTurn = randomNumber.getRandom();
        return abandonTurn;
    }

    /**
     * ComputerTurn() method is called during each turn after the player played.
     * @param No parameters passed.
     * @return Returns nothing.
     */
    public void computerTurn()
    {
        generateCompGuess(minRange,maxRange);
        int tempGuess = player2.getGuess();
        System.out.println(" *** It's Computer's turn. *** ");
        System.out.println("-------------------------------");
        //if guess is correct then a message will be displayed and the booleans isRoundOver, isChanceOver and hasComputerGuessed are set to true.
        if(tempGuess == secretNumber)
        {
            System.out.println("Hurray! the computer guessed the number correctly ;)");
            System.out.println("Computer's guess is: " + tempGuess);
            System.out.println("The secret number is: " + secretNumber);
            isRoundOver = true;
            isChanceOver = true;
            hasComputerGuessed = true;
        }
        // If the guess is greater than secret number a message will be displayed and the range is altered.
        else if(tempGuess > secretNumber)
        {
            System.out.println("Computer's guess wrong. The Computer's guess is greater than the secret number.");
            System.out.println("Computer's guess is: " + tempGuess + "\n");
            System.out.println("Range minimum comp rand: " + minRange);
            randomNumber.setMaximum(tempGuess);
            maxRange = tempGuess;
            System.out.println("Range maximum comp rand: " + maxRange + "\n");
            isChanceOver = true;
            hasComputerGuessed = false;
        }
        // If the guess is lesser than the secret number the range is reduced along with a message.
        else if(tempGuess < secretNumber)
        {
            System.out.println("Computer's guess wrong. The Computer's guess is lesser than the secret number.");
            System.out.println("Computer's guess is: " + tempGuess + "\n");
            randomNumber.setMinimum(tempGuess);
            minRange = tempGuess;
            System.out.println("Minimum range of computer's guess: " + minRange);
            System.out.println("Maximum range of computer's guess: " + maxRange + "\n");
            isChanceOver = true;
            hasComputerGuessed = false;
        }
    }

    /**
     * isInputEmpty is method checks the user input empty or not.
     * @param String value entered by the user.
     * @return Boolean value represents is string empty or not.
     */
    public boolean isInputEmpty(String userInput)
    {
        if(userInput.trim().length() == 0)
        {
            System.out.println("Name cannot be blank! Please try again. :(");
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * isInputWithinRange is a method validates is the user input length within the range or not.
     * @param String value entered by the user.
     * @param Integer value represents maximum range. 
     * @return Boolean value of the validation of user input.
     */
    public boolean isInputWithinRange(String userInput,int maximum)
    {
        if(userInput.length() > maximum + 1)
        {
            System.out.println("Name should not be more than 8 characters :(\n Try again!");
            return false;
        }
        else
        {
            return true;
        }
    }

    /**
     * gamePlay() method represents the logic of the Numble Game.
     * @param No parameters passed.
     * @return Returns nothing.
     */
    public void gamePlay()
    {
        int rounds = 4;
        int guessChances = 3;
        int totalChancesInARound = 6;
        int playerScore = 0;
        int computerScore = 0;
        int counter = 0;
        // Looping until isGameOver is true.
        while(!isGameOver)
        {
            // For loop for 4 rounds
            for(int i = 1; i <= rounds; i++ )
            {
                generateSecret();
                int abandonGameIndicator = computerAbandonGenerator();
                System.out.println("-------------------- Round " + i +" --------------------\n");
                Player startPlayer = randomFirstRound();
                minRange = 1;
                maxRange = 100;
                // For loop for 6 turns
                for(int j = 1; j <= totalChancesInARound; j++)
                {
                    counter += 1;
                    //Player starting the game
                    if(startPlayer == player1)
                    {
                        if(j == 1 || j == 3 || j == 5)
                        {
                            playerTurn();
                            if(j == 1 && hasPlayerGuessed)
                            {
                                //player1.setScore(18);
                                playerScore += 18;
                                break;
                            }
                            else if (j == 3 && hasPlayerGuessed)
                            {
                                //player1.setScore(8);
                                playerScore += 8;
                                break;
                            }
                            else if(j == 5 && hasPlayerGuessed)
                            {
                                //player1.setScore(2);
                                playerScore += 3;
                                break;
                            }
                            else if(j == 1 && hasPlayerAbandoned)
                            {
                                int tempScore = 18;
                                computerScore += tempScore;
                                System.out.println(player1.getName() + " has abandoned this round. Computer have been awarded " + tempScore + " for this round.");
                                break;
                            }
                            else if(j == 3 && hasPlayerAbandoned)
                            {
                                int tempScore = 8;
                                computerScore += tempScore;
                                System.out.println(player1.getName() + " has abandoned this round. Computer have been awarded " + tempScore + " for this round.");
                                break;
                            }
                            else if(j == 5 && hasPlayerAbandoned)
                            {
                                int tempScore = 3;
                                computerScore += tempScore;
                                System.out.println(player1.getName() + " has abandoned this round. Computer have been awarded " + tempScore + " for this round.");
                                break;
                            }
                            // else
                            // {
                            //     player1.setScore(0);
                            // }
                        }
                        else if(j == 2 || j == 4 || j == 6)
                        {
                            computerTurn();
                            if(j == 2 && hasComputerGuessed)
                            {
                                //player2.setScore(12);
                                computerScore += 12;
                                break;
                            }
                            else if (j == 4 && hasComputerGuessed)
                            {
                                //player2.setScore(5);
                                computerScore += 5;
                                break;
                            }
                            else if(j == 6 && hasComputerGuessed)
                            {
                                // player2.setScore(3);
                                computerScore += 3;
                                isRoundOver = true;
                                break;
                            }
                            else if(j == 2 && counter == abandonGameIndicator)
                            {
                                int tempScore = 12;
                                playerScore += tempScore;
                                System.out.println("Computer abandoned this round. You have been awarded " + tempScore + " for this round.");
                                hasComputerAbandoned = true;
                                break;
                            }
                            else if(j == 4 && counter == abandonGameIndicator)
                            {
                                int tempScore = 5;
                                playerScore += tempScore;
                                System.out.println("Computer abandoned this round. You have been awarded " + tempScore + " for this round.");
                                hasComputerAbandoned = true;
                                break;
                            }
                            else if(j == 6 && counter == abandonGameIndicator)
                            {
                                int tempScore = 2;
                                playerScore += tempScore;
                                System.out.println("Computer abandoned this round. You have been awarded " + tempScore + " for this round.");
                                hasComputerAbandoned = true;
                                break;
                            }
                                
                            // else
                            // {
                            //      System.out.println("\nThe secret number is: " + secretNumber);
                            // }
                        }
                        if(counter % 6 == 0)
                        {
                            System.out.println("\nThe secret number is: " + secretNumber);
                        }
                    }
                    //Computer starting the game
                    else if(startPlayer == player2)
                    {
                        if(j == 1 || j == 3 || j == 5)
                        {
                            computerTurn();
                            if(j == 1 && hasComputerGuessed)
                            {
                                // player2.setScore(18);
                                computerScore += 18;
                                break;
                            }
                            else if (j == 3 && hasComputerGuessed)
                            {
                                // player2.setScore(8);
                                computerScore += 8;
                                break;
                            }
                            else if(j == 5 && hasComputerGuessed)
                            {
                                // player2.setScore(3);
                                computerScore += 3;
                                break;
                            }
                            else if(j == 1 && counter == abandonGameIndicator)
                            {
                                int tempScore = 18;
                                playerScore += tempScore;
                                System.out.println("Computer abandoned this round. You have been awarded " + tempScore + " for this round.");
                                hasComputerAbandoned = true;
                                break;
                            }
                            else if(j == 3 && counter == abandonGameIndicator)
                            {
                                int tempScore = 8;
                                playerScore += tempScore;
                                System.out.println("Computer abandoned this round. You have been awarded " + tempScore + " for this round.");
                                hasComputerAbandoned = true;
                                break;
                            }
                            else if(j == 5 && counter == abandonGameIndicator)
                            {
                                int tempScore = 3;
                                playerScore += tempScore;
                                System.out.println("Computer abandoned this round. You have been awarded " + tempScore + " for this round.");
                                hasComputerAbandoned = true;
                                break;
                            }
                        }
                        else if(j == 2 || j == 4 || j == 6)
                        {
                            playerTurn();
                            if(j == 2 && hasPlayerGuessed)
                            {
                                // player1.setScore(12);
                                playerScore += 12;
                                break;
                            }
                            else if (j == 4 && hasPlayerGuessed)
                            {
                                // player1.setScore(5);
                                playerScore += 5;
                                break;
                            }
                            else if(j == 6 && hasPlayerGuessed)
                            {
                                // player1.setScore(2);
                                playerScore += 2;
                                isRoundOver = true;
                                break;
                            }
                            else if(j == 2 && hasPlayerAbandoned)
                            {
                                int tempScore = 12;
                                computerScore += tempScore;
                                System.out.println(player1.getName() + " has abandoned this round. Computer have been awarded " + tempScore + " for this round.");
                                break;
                            }
                            else if(j == 4 && hasPlayerAbandoned)
                            {
                                int tempScore = 5;
                                computerScore += tempScore;
                                System.out.println(player1.getName() + " has abandoned this round. Computer have been awarded " + tempScore + " for this round.");
                                break;
                            }
                            else if(j == 6 && hasPlayerAbandoned)
                            {
                                int tempScore = 2;
                                computerScore += tempScore;
                                System.out.println(player1.getName() + " has abandoned this round. Computer have been awarded " + tempScore + " for this round.");
                                break;
                            }

                        }                   
                    }
                    // Calculating player and computer differences to award closest guess score.
                    if(j == 6 && (!hasPlayerGuessed && !hasComputerGuessed))
                        {
                            int playerGuess = player1.getGuess();
                            int computerGuess = player2.getGuess();
                            int playerDifference;
                            int computerDifference;
                            boolean scoreAwarded = false;
                            if(!scoreAwarded)
                                {
                                    if(secretNumber > playerGuess)
                                    {
                                        playerDifference = secretNumber - playerGuess;
                                    }
                                    else
                                    {
                                        playerDifference = playerGuess - secretNumber;
                                    }

                                    if(secretNumber > computerGuess)
                                    {
                                        computerDifference = secretNumber - computerGuess;
                                    }
                                    else
                                    {
                                        computerDifference = computerGuess - secretNumber;
                                    }

                                    if(playerDifference > computerDifference)
                                    {
                                        computerScore += 1;
                                        System.out.println("\nThe secret number is: " + secretNumber);
                                        System.out.println("Computer's guess is " + player2.getGuess() + " and it is closest to the secret number. So 1 point is added to computer.");
                                        scoreAwarded = true;
                                    }
                                    else if(computerDifference > playerDifference)
                                    {
                                        playerScore += 1;
                                        System.out.println("\nThe secret number is: " + secretNumber);
                                        System.out.println(player1.getName() + "'s guess is " + player1.getGuess() + " and it is closest to the secret number. So 1 point is added to " + player1.getName());
                                        scoreAwarded = true;
                                    }
                                    else
                                    {
                                        System.out.println("\nThe secret number is: " + secretNumber);
                                        System.out.println("No score is awarded to both the players");
                                        scoreAwarded = true;
                                    }
                                }
                        }
                    }
                System.out.println("\n---------- Scores ------------");
                System.out.println(player1.getName() + "'s score at the end of round " + i + " is: " + playerScore);
                System.out.println("Computer's score at the end of round " + i + " is: " + computerScore);
                System.out.println("------------------------------\n");
                if(i == 4)
                    isGameOver = true;
            }
        }
    }

    /**
     * generateCompGuess is a method calculates computer guess from a range of min and max values.
     * @param minimum is an integer holds minimum value of the range.
     * @param maximum is an integer holds maximum value of the range.
     * @return Returns nothin.
     */
    public void generateCompGuess(int minimum, int maximum)
    {
        int temp = 0;
        boolean flag = false;
        while(!flag)
        {
            randomNumber.generateRandom(minimum, maximum);
            temp = randomNumber.getRandom();
            if(temp <= maximum)
            {
                flag = true;
                player2.setGuess(temp);
            }
            
            else
            {
                flag = false;
            }
        } 
    }

    /**
     * getPlayerGuessInput method allows the player to enter the input and validate it.
     * @param No parameters passed.
     * @return Returns nothing.
     */
    public void getPlayerGuessInput()
    {
        Scanner input = new Scanner(System.in);
        //System.out.println("Enter your guess: ");
        int number;
        boolean gFlag = false;
        while(!gFlag)
        {
            System.out.println("Enter your guess: ");
            if(input.hasNextInt())
            {
                number = input.nextInt();
                // If entered number is 999 then the game is abandoned.
                if(number == 999)
                {
                    hasPlayerAbandoned = true;
                    break;
                }
                else if(number > 100 || number < 0)
                {
                    System.out.println("The number should be within the range 1 to 100!");
                }
                else
                {
                    player1.setGuess(number);
                    gFlag = true;
                    break;
                }
            }

            else
            {
                System.out.println("Please enter numbers only!");
                input.nextLine();
                gFlag = false;
            }
        }
        
    }

    /**
     * getPlayerNameInput method allows the player to enter the name and validate it.
     * @param No parameters passed.
     * @return Returns nothing.
     */
    public void getPlayerNameInput()
    {
        Scanner input = new Scanner(System.in);
        boolean nFlag = false;
        while(!nFlag) 
        {
            System.out.println("Please enter your name below to start the game :)");
            String name = input.nextLine();
            if(isInputEmpty(name) == false && isInputWithinRange(name, 8) == true)
            {
                System.out.println("Hello " + name + "! It's great to have you.\n");
                player1.setName(name);
                nFlag = true;
                break;
            }
            else
            {
                nFlag = false;
            }
        }
    }

    /**
     * generateSecret is a method calculates secret number to guess from a range of min and max values.
     * @param No parameters passed.
     * @return Returns nothin.
     */
    public void generateSecret()
    {
        int temp = 0;
        boolean flag = false;
        while(!flag)
        {
            randomNumber.generateRandom(1,100);
            temp = randomNumber.getRandom();
            if(temp <= randomNumber.getMaximum())
            {
                secretNumber = temp;
                flag = true;
            }

            else
            {
                flag = false;
            }
        }
    }

    /**
     * Main method is called to run this program.
     */
    public static void main(String[] args)
    {
        Game game = new Game();
        game.welcome();
        game.getPlayerNameInput();
        game.gamePlay();
        System.out.println("---------------- Game Over ---------------");
    }

    /**
     * playerTurn() method is called during each turn after the computer played.
     * @param No parameters passed.
     * @return Returns nothing.
     */
    public void playerTurn()
    {
        System.out.println(" *** It's your turn. *** ");
        System.out.println("-------------------------");
        getPlayerGuessInput();
        int tempPlayerGuess = player1.getGuess();
        if(player1.getGuess() == secretNumber)
        {
            System.out.println("Hurray! You've guessed the number correctly ;)");
            System.out.println("Your guess is: " + tempPlayerGuess);
            System.out.println("The secret number is: " + secretNumber);
            isRoundOver = true;
            isChanceOver = true;
            hasPlayerGuessed = true;
        }
        else if(hasPlayerAbandoned)
        {
            System.out.println("Round Abandoned!");
        }
        else if(tempPlayerGuess > secretNumber)
        {
            System.out.println("Sorry! Your guess is greater than the secret number :(\n");
            maxRange = player1.getGuess();
            isChanceOver = true;
            hasPlayerGuessed = false;
        }
        else if(tempPlayerGuess < secretNumber)
        {
            System.out.println("Sorry! Your guess is lesser than the secret number :(\n");
            minRange = player1.getGuess();
            isChanceOver = true;
            hasPlayerGuessed = false;
        }
    }

    /**
     * randomFirstRound() method is returns a player randomly to start the game.
     * @param No parameters passed.
     * @return Returns Player class objects player1 or player2 randomly.
     */
    public Player randomFirstRound()
    {
        Player[] players = {player1, player2};
        int maximum = 2;
        int minimum = 1;
        double randomNum = Math.random() * (maximum - minimum + 1) + minimum;
        int chosenPlayer = (int)randomNum;
        System.out.println("Please wait while randomly choosing who is starting the round. \n.\n.\n.");
        if(chosenPlayer == 1)
        {
            System.out.println("\n######  You are starting the game.  ######\n");
            return players[0];
        }
        else 
        {
            System.out.println("\n######  Computer is starting the game.  ######\n");
            return players[1];
        }  
    }

    /**
     * welcome method displays game menu
     * @param No parameters passed.
     * @return Returns nothing.
     */
    public void welcome()
    {
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("\t\t\tWelcome to the Numble Game!");
        System.out.println("You can play by just entering your name below, remember you are playing against a computer.");
        System.out.println("--------------------------------------------------------------------------------------\n");
    }
    
}
