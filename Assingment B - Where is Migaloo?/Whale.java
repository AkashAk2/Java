/**
 * The Whale class represents information about a whale, including its characteristics and location.
 * @author Akash Balakrishnan
 * @version 1.0
 */
public class Whale
{
    // Attributes to store information about the whale
    private String directionOfTravel;
    private boolean isCalfAccompanied;
    private boolean isCalfInjured;
    private boolean isInjured;
    private String locationSeen;
    private String speciesOfWhale;

    /**
     * Default constructor initializes attributes with default values.
     */
    public Whale()
    {
        directionOfTravel = "Unknown";
        isCalfAccompanied = false;
        isCalfInjured = false;
        isInjured = false;
        locationSeen = "Unknown";
        speciesOfWhale = "Unknown";
    }

    /**
     * Parameterized constructor to set values based on input parameters.
     * @param directionOfTravel The direction of travel of the whale.
     * @param isCalfAccompanied Indicates whether a calf is accompanied.
     * @param isCalfInjured Indicates whether the calf is injured.
     * @param isInjured Indicates whether the whale is injured.
     * @param locationSeen The location where the whale was spotted.
     * @param speciesOfWhale The species of the whale.
     */
    public Whale(String directionOfTravel, boolean isCalfAccompanied, boolean isCalfInjured, boolean isInjured, String locationSeen, String speciesOfWhale)
    {
        this.directionOfTravel = directionOfTravel;
        this.isCalfAccompanied = isCalfAccompanied;
        this.isCalfInjured = isCalfInjured;
        this.isInjured = isInjured;
        this.locationSeen = locationSeen;
        this.speciesOfWhale = speciesOfWhale;
    }

    /**
     * Display information about the whale.
     */
    public void display()
    {
        System.out.println("The direction of travel is: " + directionOfTravel);
        System.out.println("Is there a calf: " + isCalfAccompanied);
        System.out.println("Is the calf injured: " + isCalfInjured);
        System.out.println("Is the whale injured: " + isInjured);
        System.out.println("The whale was spotted in: " + locationSeen);
        System.out.println("The species of the whale is: " + speciesOfWhale);
    }

    /**
     * Getter method for the directionOfTravel attribute.
     * @return Returns the direction of travel.
     */
    public String getDirectionOfTravel()
    {
        return directionOfTravel;
    }

    /**
     * Getter method for the isCalfAccompanied attribute.
     * @return Returns true if there is a calf accompanied, false otherwise.
     */
    public boolean getIsThereACalf()
    {
        return isCalfAccompanied;
    }

    /**
     * Getter method for the isInjured attribute.
     * @return Returns true if the whale is injured, false otherwise.
     */
    public boolean getIsInjured()
    {
        return isInjured;
    }

    /**
     * Getter method for the locationSeen attribute.
     * @return Returns the location where the whale was spotted.
     */
    public String getLocationSeen()
    {
        return locationSeen;
    }

    /**
     * Getter method for the speciesOfWhale attribute.
     * @return Returns the species of the whale.
     */
    public String getSpeciesOfWhale()
    {
        return speciesOfWhale;
    }

    /**
     * Getter method for the isCalfInjured attribute.
     * @return Returns true if the calf is injured, false otherwise.
     */
    public boolean getIsCalfInjured()
    {
        return isCalfInjured;
    }

    /**
     * Setter method for the directionOfTravel attribute.
     * @param directionOfTravel The new direction of travel.
     */
    public void setDirectionOfTravel(String directionOfTravel)
    {
        this.directionOfTravel = directionOfTravel;
    }

    /**
     * Setter method for the isCalfAccompanied attribute.
     * @param isCalfAccompanied Indicates whether there is a calf accompanied.
     */
    public void setIsCalfAccompanied(boolean isCalfAccompanied)
    {
        this.isCalfAccompanied = isCalfAccompanied;
    }

    /**
     * Setter method for the isInjured attribute.
     * @param isInjured Indicates whether the whale is injured.
     */
    public void setIsInjured(boolean isInjured)
    {
        this.isInjured = isInjured;
    }

    /**
     * Setter method for the isCalfInjured attribute.
     * @param isCalfInjured Indicates whether the calf is injured.
     */
    public void setIsCalfInjured(boolean isCalfInjured)
    {
        this.isCalfInjured = isCalfInjured;
    }

    /**
     * Setter method for the locationSeen attribute.
     * @param locationSeen The new location where the whale was spotted.
     */
    public void setLocationSeen(String locationSeen)
    {
        this.locationSeen = locationSeen;
    }

    /**
     * Setter method for the speciesOfWhale attribute.
     * @param speciesOfWhale The new species of the whale.
     */
    public void setSpeciesOfWhale(String speciesOfWhale)
    {
        this.speciesOfWhale = speciesOfWhale;
    }

    /**
     * Override the toString method to provide a formatted string representation of the Whale object.
     * @return Returns a formatted string representation of the Whale object.
     */
    @Override
    public String toString()
    {
        return "\nThe species of the whale is: " + speciesOfWhale + "\nThe whale was spotted in: " + locationSeen +
                "\nThe direction of travel is: " + directionOfTravel + "\nIs there a calf: " + isCalfAccompanied
                + "\nIs the whale injured: " + isInjured + "\nIs the calf injured: " + isCalfInjured + "\n";
    }
}
