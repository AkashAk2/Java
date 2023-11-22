import java.util.*;

/**
 * Represents a location where whales can be observed.
 * This class stores information about the whales present in the location.
 * @author Akash Balakrishnan
 * @version 1.0
 */
public class Location
{
    // Attributes to store information about whales in the location
    private String coast;
    private int numOfAdultWhales;
    private int numberOfCalves;
    private int totalWhales;
    private int humpbackCount;
    private int humpBackCalves;
    private int migaloo;
    private int minkeCalves;
    private int minkeCount;
    private int southerRightCount;
    private int southerRightCalves;
    private int blueCount;
    private int blueCalves;
    private int orcaCount;
    private int orcaCalves;
    private int injuredWhalesCount;
    private RandomNumberGenerator rd;
    private boolean isMigaloooSighted;
    private ArrayList<Whale> whaleList;
    private Observer observer;

    // Default constructor initializes the attributes
    public Location()
    {
        coast = "Unknown";
        numOfAdultWhales = 0;
        numberOfCalves = 0;
        totalWhales = 0;
        migaloo = 0;
        humpbackCount = 0;
        minkeCount = 0;
        southerRightCount = 0;
        blueCount = 0;
        orcaCount = 0;
        injuredWhalesCount = 0;
        isMigaloooSighted = false;
        whaleList = new ArrayList<Whale>();
        rd = new RandomNumberGenerator();
        observer = new Observer();
    }

    /**
     * Display information about the location.
     */
    public void display()
    {
        System.out.println("The name of the coast is: " + coast);
        System.out.println(whaleList.toString());
    }

    // Getter methods

    /**
     * Getter method for the coast attribute.
     * @return Returns a String representing the coast of the location.
     */
    public String getCoast()
    {
        return coast;
    }

    /**
     * Getter method for Blue whale calves count.
     * @return Returns an integer representing the count of Blue whale calves.
     */
    public int getBlueCalves()
    {
        return blueCalves;
    }

    /**
     * Getter method for Blue whale count.
     * @return Returns an integer representing the count of Blue whales.
     */
    public int getBlueCount()
    {
        return blueCount;
    }

    /**
     * Getter method for injured whales count.
     * @return Returns an integer representing the count of injured whales.
     */
    public int getInjuredWhalesCount()
    {
        return injuredWhalesCount;
    }

    /**
     * Getter method for Migaloo count.
     * @return Returns an integer representing the count of Migaloo whales.
     */
    public int getMigalooCount()
    {
        return migaloo;
    }

    /**
     * Getter method for Migaloo sighting status.
     * @return Returns a boolean indicating whether Migaloo whales are sighted.
     */
    public boolean getMigalooSighting()
    {
        return isMigaloooSighted;
    }

    /**
     * Getter method for minke calves count.
     * @return Returns an integer representing the count of Minke whale calves.
     */
    public int getMikeCalves()
    {
        return minkeCalves;
    }

    /**
     * Getter method for minke count.
     * @return Returns an integer representing the count of Minke whales.
     */
    public int getMikeCount()
    {
        return minkeCount;
    }

    /**
     * Getter method for the list of whales.
     * @return Returns an ArrayList of Whale objects representing the whales in the location.
     */
    public ArrayList<Whale> getWhaleList()
    {
        return whaleList;
    }

    /**
     * Getter method for Orca calves count.
     * @return Returns an integer representing the count of Orca whale calves.
     */
    public int getOrcaCalves()
    {
        return orcaCalves;
    }

    /**
     * Getter method for Orca count.
     * @return Returns an integer representing the count of Orca whales.
     */
    public int getOrcaCount()
    {
        return orcaCount;
    }

    /**
     * Getter method for Southern Right whale calves count.
     * @return Returns an integer representing the count of Southern Right whale calves.
     */
    public int getSouthernRightCalves()
    {
        return southerRightCalves;
    }

    /**
     * Getter method for Southern Right whale count.
     * @return Returns an integer representing the count of Southern Right whales.
     */
    public int getSouthernRightCount()
    {
        return southerRightCount;
    }

    /**
     * Getter method for the total number of whales.
     * @return Returns an integer representing the total number of whales.
     */
    public int getNumOfWhales()
    {
        return totalWhales;
    }

    /**
     * Getter method for the number of Humpback whales.
     * @return Returns an integer representing the count of Humpback whales.
     */
    public int getNumOfHumpbacks()
    {
        return humpbackCount;
    }

    /**
     * Getter method for humpback calves count.
     * @return Returns an integer representing the count of Humpback whale calves.
     */
    public int getHumpbackCalves()
    {
        return humpBackCalves;
    }

    // Setter methods

    /**
     * Setter method for the coast attribute.
     * @param coast is a string representing the new coast of the location.
     * @return Returns nothing.
     */
    public void setCoast(String coast)
    {
        this.coast = coast;
    }

    /**
     * Setter method for Humpback count.
     * @param num is an integer representing the value to be added to Humpback count.
     * @return Returns nothing.
     */
    public void setHumpBack(int num)
    {
        humpbackCount += num;
    }

    /**
     * Setter method for injured whales count.
     * @param injuredWhalesCount is an integer representing the new count of injured whales.
     * @return Returns nothing.
     */
    public void setInjuredWhalesCount(int injuredWhalesCount)
    {
        this.injuredWhalesCount = injuredWhalesCount;
    }

    /**
     * Setter method for Migaloo count.
     * @param num is an integer representing the value to be added to Migaloo count.
     * @return Returns nothing.
     */
    public void setMigaloo(int num)
    {
        migaloo += num;
    }

    /**
     * Setter method for Migaloo sighting status.
     * @param value is a boolean indicating the sighting status of Migaloo whales.
     * @return Returns nothing.
     */
    public void setIsMigalooSighted(boolean value)
    {
        isMigaloooSighted = value;
    }

    /**
     * Setter method for observer's name.
     * @param name is a string representing the name of the observer.
     * @return Returns nothing.
     */
    public void setObserverName(String name)
    {
        observer.setName(name);
    }

    // Other methods

    /**
     * Generate whales with random characteristics.
     * @return Returns nothing.
     */
    public void generateWhales()
    {
        int numberOfWhales = rd.generateRandomNumber(10);
        numOfAdultWhales += numberOfWhales;
        for(int j = 0; j < numberOfWhales; j++)
        {
            Whale whale = new Whale();
            int injuryDeciderNumber = rd.generateRandomNumber(100) + 1;
            int migalooDeciderNumber = rd.generateRandomNumber(100) + 1;
            int calfInjuryDecider = rd.generateRandomNumber(100) + 1;
            int calfDeciderNumber = rd.generateRandomNumber(2);
            int migalooNumber = 1;
            int directionNumber = rd.generateRandomNumber(2);
            boolean isWhaleInjured = false;
            boolean isCalfThere = false;
            boolean isCalfInjured = false;
            String directionTravelling = "";

            // Setting species of whale using the random numbers
            String species = identifySpecies();
            whale.setSpeciesOfWhale(species);
            if(injuryDeciderNumber <= 10)
            {
                injuredWhalesCount += 1;
                isWhaleInjured = true;
            }

            if(isMigaloooSighted == true)
            {
                whale.setSpeciesOfWhale("Migaloo");
            }
            else
            {
                isWhaleInjured = false;
            }

            if(directionNumber == 0)
            {
                directionTravelling += "North";
            }
            else if(directionNumber == 1)
            {
                directionTravelling += "South";
                if(calfDeciderNumber == 0)
                {
                    isCalfThere = false;
                }
                else if(calfDeciderNumber == 1)
                {
                    isCalfThere = true;
                    numberOfCalves += 1;
                    if(calfInjuryDecider <= 10)
                    {
                        injuredWhalesCount += 1;
                        isCalfInjured = true;
                    }
                }
            }

            if(isCalfThere == true)
            {
                if(species.equals("HumpBack"))
                {
                    humpBackCalves += 1;
                }
                else if(species.equals("Minke"))
                {
                    minkeCalves += 1;
                }
                else if(species.equals("Southern Right"))
                {
                    southerRightCalves += 1;
                }
                else if(species.equals("Blue"))
                {
                    blueCalves += 1;
                }
                else if(species.equals("Orca"))
                {
                    orcaCalves += 1;
                }
            }

            whale.setLocationSeen(coast);
            whale.setDirectionOfTravel(directionTravelling);
            whale.setIsCalfAccompanied(isCalfThere);
            whale.setIsInjured(isWhaleInjured);
            whale.setIsCalfInjured(isCalfInjured);
            whaleList.add(whale);
        }
        totalWhales = numOfAdultWhales + numberOfCalves;
    }

    /**
     * Generate a random number.
     * @return Returns an integer representing the generated random number.
     */
    public int randomNum()
    {
        return rd.generateRandomNumber(100) + 1;
    }

    /**
     * Identify the species of a whale based on random numbers.
     * @return Returns a String representing the species of the whale.
     */
    public String identifySpecies()
    {
        int speciesDeciderNumber = rd.generateRandomNumber(100) + 1;
        if(speciesDeciderNumber <= 50)
        {
            humpbackCount += 1;
            return "HumpBack";
        }
        else if(speciesDeciderNumber > 50 && speciesDeciderNumber <=75)
        {
            minkeCount += 1;
            return "Minke";
        }
        else if(speciesDeciderNumber > 75 && speciesDeciderNumber <=95)
        {
            southerRightCount += 1;
            return "Southern Right";
        }
        else if(speciesDeciderNumber > 95 && speciesDeciderNumber <=98)
        {
            blueCount += 1;
            return "Blue";
        }
        else
        {
            orcaCount += 1;
            return "Orca";
        }
    }

    /**
     * Getter method for an array containing counts of different whale species.
     * @return Returns an array of integers representing the counts of different whale species.
     */
    public int[] getWhaleCounts()
    {
        int[] whalesArr = new int[11];
        whalesArr[0] = humpbackCount;
        whalesArr[1] = humpBackCalves;
        whalesArr[2] = minkeCount;
        whalesArr[3] = minkeCalves;
        whalesArr[4] = southerRightCount;
        whalesArr[5] = southerRightCalves;
        whalesArr[6] = blueCount;
        whalesArr[7] = blueCalves;
        whalesArr[8] = orcaCount;
        whalesArr[9] = orcaCalves;
        whalesArr[10] = migaloo;
        return whalesArr;
    }
}
