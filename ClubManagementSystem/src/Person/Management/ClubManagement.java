package Person.Management;

import Person.Person;

public class ClubManagement extends Person {

    private String position;
    private long employeeID;
    private static int numberOfNonPlayers = 0;

    public ClubManagement() {
        numberOfNonPlayers++;
    }

    public ClubManagement(String name, String position, long employeeID) {
        super(name);
        this.position = position;
        this.employeeID = employeeID;
        numberOfNonPlayers++;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }

    public static int getNumberOfNonPlayers() {
        return numberOfNonPlayers;
    }

    public String employeeDetails() {
        return this.personDetails() +
                "Position: " + position + "\n" +
                "Employee ID number: " + employeeID + "\n";
    }
}
