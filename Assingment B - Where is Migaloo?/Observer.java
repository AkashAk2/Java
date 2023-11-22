/**
 * The Observer class represents an observer who can observe a location.
 * An observer has a name and can display their name.
 * @author Akash Balakrishnan
 * @version 1.0
 */
public class Observer
{
    // Attribute to store the name of the observer
    private String name;

    /**
     * Default constructor initializes the name attribute to "Unknown".
     */
    public Observer()
    {
        name = "Unknown";
    }

    /**
     * Parameterized constructor to set the name of the observer.
     * @param newName A string representing the new name of the observer.
     */
    public Observer(String newName)
    {
        name = newName;
    }

    /**
     * Display method prints the name of the observer to the console.
     */
    public void display()
    {
        System.out.println("The name of the observer is: " + name);
    }

    /**
     * Getter method for the name attribute.
     * @return Returns a string representing the name of the observer.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Setter method for the name attribute.
     * @param name A string representing the new name of the observer.
     */
    public void setName(String name)
    {
        this.name = name;
    }
}
