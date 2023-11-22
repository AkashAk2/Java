import java.util.*;
import java.io.*;

/**
 * The SeasonObservations class processes observations from a file.
 * It reads data from a file, validates and converts it to a structured format.
 * @author Akash Balakrishnan
 * @version 1.0
 */
public class SeasonObservations
{
    // Attribute to store file data as strings
    private ArrayList<String> fileData;

    // Attribute to store whale observation data as integer arrays
    private ArrayList<int[]> whaleIntList;

    /**
     * Default constructor initializes the attributes.
     */
    public SeasonObservations()
    {
        fileData = new ArrayList<String>();
        whaleIntList = new ArrayList<int[]>();
    }

    /**
     * Getter method for the fileData attribute.
     * @return Returns the ArrayList of file data.
     */
    public ArrayList<String> getFileData()
    {
        return fileData;
    }

    /**
     * Reads observations from a file and populates the fileData attribute.
     * Throws an exception for empty lines in the file.
     */
    public void readFile()
    {
        try
        {
            File observation = new File("seasonObservations.txt");
            Scanner read = new Scanner(observation);

            while(read.hasNext())
            {
                String fileLine = read.nextLine();

                if(fileLine != null && fileLine.length() > 0)
                {
                    fileData.add(fileLine);
                }
                else
                {
                    throw new IllegalArgumentException("Empty Line");
                }
            }
        }
        catch(FileNotFoundException exception)
        {
            System.out.println("File not found!");
        }
    }

    /**
     * Converts the fileData into a structured ArrayList of integer arrays.
     * Parses each line of the fileData and converts it to an integer array.
     * @return Returns an ArrayList of integer arrays representing whale observations.
     */
    public ArrayList<int[]> convertStrList()
    {
        int[] lineOneInt = new int[11];
        int[] lineTwoInt = new int[11];
        int[] lineThreeInt = new int[11];
        int[] lineFourInt = new int[11];

        String[] lineOneStr = fileData.get(0).split(",");
        String[] lineTwoStr = fileData.get(1).split(",");
        String[] lineThreeStr = fileData.get(2).split(",");
        String[] lineFourStr = fileData.get(3).split(",");

        for(int i = 0; i < 11; i++)
        {
            try
            {
                lineOneInt[i] = Integer.parseInt(lineOneStr[i]);
                lineTwoInt[i] = Integer.parseInt(lineTwoStr[i]);
                lineThreeInt[i] = Integer.parseInt(lineThreeStr[i]);
                lineFourInt[i] = Integer.parseInt(lineFourStr[i]);
            }
            catch (NumberFormatException nfException)
            {
                System.out.println("Number format exception occurred!!!");
            }
        }

        whaleIntList.add(lineOneInt);
        whaleIntList.add(lineTwoInt);
        whaleIntList.add(lineThreeInt);
        whaleIntList.add(lineFourInt);

        return whaleIntList;
    }
}
