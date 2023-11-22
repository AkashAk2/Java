import java.io.*;
import java.util.ArrayList;

/**
 * The WhaleWatching class represents a simulation of whale watching at different locations.
 * It keeps track of whale observations, updates counts, and provides a summary.
 * @author Akash Balakrishnan
 * @version 1.0
 */
public class WhaleWatching {
    private Location[] location = new Location[4];
    private ArrayList<String> textFileData;
    private ArrayList<int[]> updatedWhaleList;
    private SeasonObservations observation;
    private int[] wwld;
    private int mostDesirableLocation;

    /**
     * Default constructor for WhaleWatching class.
     */
    public WhaleWatching() {
        location = new Location[4];
        textFileData = new ArrayList<String>();
        updatedWhaleList = new ArrayList<int[]>();
        observation = new SeasonObservations();
        wwld = new int[4];
        mostDesirableLocation = 0;
    }

    /**
     * Main method to run the WhaleWatching simulation.
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        WhaleWatching ww = new WhaleWatching();
        ww.watchingSimulation();
        ww.updateWhaleCount();
        ww.writeToFile();
        ww.menu();
        ww.summary();
    }

    /**
     * Adds two arrays element-wise.
     * @param arr1 First array.
     * @param arr2 Second array.
     * @return New array with elements being the sum of corresponding elements from arr1 and arr2.
     */
    public static int[] arrAddition(int[] arr1, int[] arr2) {
        int lengthOfArr = arr1.length;
        int[] addedArr = new int[lengthOfArr];
        for (int i = 0; i < lengthOfArr; i++) {
            addedArr[i] = arr1[i] + arr2[i];
        }
        return addedArr;
    }

    /**
     * Calculates Whale Watching Desirability Factor (WWLD).
     * @param totalAdults Total number of adult whales.
     * @param totalCalves Total number of whale calves.
     * @param totalRareWhales Total number of rare whales.
     * @param migalooNum Number of Migaloo whales.
     * @return Calculated WWLD.
     */
    public int calculateWWLD(int totalAdults, int totalCalves, int totalRareWhales, int migalooNum) {
        return totalAdults + (2 * totalCalves) + (4 * totalRareWhales) + (10 * migalooNum);
    }

    /**
     * Creates a file for updated whale observations.
     */
    public void createFile() {
        try {
            File myFile = new File("seasonObservationsUpdated.txt");
            if (myFile.createNewFile()) {
                System.out.println("File created!");
            } else {
                System.out.println("File is already existing!!!");
            }
        } catch (IOException ex) {
            System.out.println("Error occurred during file creation!");
        }
    }

    /**
     * Displays the menu and results of the whale watching simulation.
     */
    public void menu() {
        System.out.println("Welcome to Whale watching simulation :)");
        for (int i = 0; i < location.length; i++) {
            displayWatchingSimulation(i);
        }
    }

    /**
     * Reads observations from a file and converts them to an ArrayList of int arrays.
     */
    public void readFile() {
        try {
            File observation = new File("seasonObservations.txt");
            Scanner read = new Scanner(observation);
            while (read.hasNext()) {
                String fileLine = read.nextLine();
                {
                    if (fileLine != null && fileLine.length() > 0) {
                        fileData.add(fileLine);
                    } else {
                        throw new IllegalArgumentException("Empty Line");
                    }
                }
            }
        } catch (FileNotFoundException exception) {
            System.out.println("File not found!");
        }
    }

    /**
     * Updates whale counts by adding simulated counts and observed counts.
     */
    public void updateWhaleCount() {
        int len = location.length;
        int[][] simulatedWhaleArr = new int[len][];
        observation.readFile();
        ArrayList<int[]> observationTextData = observation.convertStrList();

        for (int i = 0; i < len; i++) {
            simulatedWhaleArr[i] = location[i].getWhaleCounts();
        }

        ArrayList<int[]> simulatedIntList = new ArrayList<int[]>();
        for (int[] arr : simulatedWhaleArr) {
            simulatedIntList.add(arr);
        }

        int[] finalArrOne = new int[11];
        int[] finalArrTwo = new int[11];
        int[] finalArrThree = new int[11];
        int[] finalArrFour = new int[11];

        finalArrOne = arrAddition(simulatedIntList.get(0), observationTextData.get(0));
        finalArrTwo = arrAddition(simulatedIntList.get(1), observationTextData.get(1));
        finalArrThree = arrAddition(simulatedIntList.get(2), observationTextData.get(2));
        finalArrFour = arrAddition(simulatedIntList.get(3), observationTextData.get(3));

        updatedWhaleList.add(finalArrOne);
        updatedWhaleList.add(finalArrTwo);
        updatedWhaleList.add(finalArrThree);
        updatedWhaleList.add(finalArrFour);
    }

    /**
     * Displays the results of whale watching simulation for a specific location.
     * @param locationNumber Index of the location to display.
     */
    public void displayWatchingSimulation(int locationNumber) {
        Scanner input = new Scanner(System.in);
        String observerName = "";
        int[] temp = updatedWhaleList.get(locationNumber);
        int numOfAdults = temp[0] + temp[2] + temp[4] + temp[6] + temp[8];
        int numOfCalves = temp[1] + temp[3] + temp[5] + temp[7] + temp[9];
        int numOfRareWhales = temp[6] + temp[7] + temp[8] + temp[9];

        wwld[locationNumber] = calculateWWLD(numOfAdults, numOfCalves, numOfRareWhales, temp[10]);

        System.out.println("Enter your name: ");
        observerName = input.nextLine();
        location[locationNumber].setObserverName(observerName);

        System.out.println("\n ---------------- " + location[locationNumber].getCoast() + " ----------------\n");
        System.out.println("Total number of whales sighted (including calves): " + location[locationNumber].getNumOfWhales());

        if (location[locationNumber].getMigalooSighting()) {
            System.out.println("Migaloo is sighted in this location! Details are below.");
        }

        System.out.println(location[locationNumber].getWhaleList().toString());
        System.out.println("\nThe Whale Watching Desirability Factor for " + location[locationNumber].getCoast() + " is: " + wwld[locationNumber] + "\n");
    }

    /**
     * Writes updated whale observations to a file.
     */
    public void writeToFile() {
        createFile();
        try {
            FileWriter writer = new FileWriter("seasonObservationsUpdated.txt");
            for (int i = 0; i < updatedWhaleList.size(); i++) {
                String str = "";
                int[] temp = updatedWhaleList.get(i);
                for (int j = 0; j < temp.length; j++) {
                    str += Integer.toString(temp[j]);
                    if (j != 10) {
                        str += ",";
                    }
                }
                writer.append(str + " \n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error while writing!!");
        }
    }

    /**
     * Calculates and displays the summary of whale observations.
     */
    public void summary() {
        System.out.println("############### Observation Summary ###############\n");
        for (int i = 0; i < location.length; i++) {
            int totalHumpback = location[i].getNumOfHumpbacks() + location[i].getHumpbackCalves();
            int totalHumpbackCalves = location[i].getHumpbackCalves();
            int totalMinke = location[i].getMikeCount() + location[i].getMikeCalves();
            int totalMinkeCalves = location[i].getMikeCalves();
            int totalSouthernRight = location[i].getSouthernRightCount() + location[i].getSouthernRightCalves();
            int totalSouthernRightCalves = location[i].getSouthernRightCalves();
            int totalBlue = location[i].getBlueCount() + location[i].getBlueCalves();
            int totalBlueCalves = location[i].getBlueCalves();
            int totalOrca = location[i].getOrcaCount() + location[i].getOrcaCalves();
            int totalOrcaCalves = location[i].getOrcaCalves();
            int totalInjuredWhales = location[i].getInjuredWhalesCount();

            System.out.println("\nThe location is: " + location[i].getCoast());
            String[] speciesNames = {"HumpBack", "Minke", "Southern Right", "Blue", "Orca"};
            int[] adultWhaleCounts = {totalHumpback, totalMinke, totalSouthernRight, totalBlue, totalOrca};
            int[] calvesCount = {totalHumpbackCalves, totalMinkeCalves, totalSouthernRightCalves, totalBlueCalves, totalOrcaCalves};
            highestWWLD();

            for (int j = 0; j < speciesNames.length; j++) {
                System.out.println("\n------------- " + speciesNames[j] + " -------------");
                System.out.println("Total number of whales found are: " + adultWhaleCounts[j]);
                System.out.println("Total number of calves found are: " + calvesCount[j]);
            }

            System.out.println("Total number of injured whales is: " + totalInjuredWhales);
        }

        System.out.println("\nThe most desirable location to view whales is: " + location[mostDesirableLocation].getCoast());
    }

    /**
     * Finds the location with the highest WWLD.
     */
    public void highestWWLD() {
        mostDesirableLocation = 0;
        int temp = wwld[0];
        for (int i = 1; i < location.length; i++) {
            if (wwld[i] > temp) {
                temp = wwld[i];
                mostDesirableLocation = i;
            }
        }
    }
}
