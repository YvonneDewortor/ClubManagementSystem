 package Person.Player;

import Person.Person;

import java.util.ArrayList;

public class Player extends Person {

    private String playerPosition;
    private int jerseyNumber;
    private int yearSigned;
    private int yearContractEnds;
    private long playerID;
    private String contractStatus;
    private HealthStatus healthState;
    private boolean captain = false;
    private boolean assCaptain = false;
    private boolean thirdCaptain = false;

    public static int numberOfPlayers = 0;

    public static int[] usedJerseyNumbers = new int[100];
    public static int numberOfCaptains = 0;
    public static ArrayList<Player> teamCaptains = new ArrayList<>(3);

    public static int numberOfAssCaptains = 0;
    public static int numberOfThirdCaptains = 0;


    public Player() {
        numberOfPlayers ++;
    }

    public Player(String name, long playerID) {
        super(name);
        this.playerID = playerID;
        numberOfPlayers++;
    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {

        if(usedJerseyNumbers[jerseyNumber] == jerseyNumber){
            System.out.println("Jersey Number is taken");
        }else {
            this.jerseyNumber = jerseyNumber;
            usedJerseyNumbers[jerseyNumber] = jerseyNumber;
        }
    }

    public int getYearSigned() {
        return yearSigned;
    }

    public void setYearSigned(int yearSigned) {
        this.yearSigned = yearSigned;
    }

    public int getYearContractEnds() {
        return yearContractEnds;
    }

    public void setYearContractEnds(int yearContractEnds) {
        this.yearContractEnds = yearContractEnds;
    }

    public long getPlayerID() {
        return playerID;
    }

    public void setPlayerID(long playerID) {
        this.playerID = playerID;
    }

    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }

    /**
     * Returns the health status of a player in percentage.
     * @return returns an int from 0 to 100;
     */
    public int getHealthState() {
        int value = 0;
        switch (healthState){
            case Injured:
                value = 20;
                break;
            case Not_fully_fit:
                value = 50;
                break;
            case Fit:
                value = 70;
                break;
            case Fully_fit:
                value = 100;
                break;
        }
        return value;
    }

    /**
     * Sets the fitness status of Player.
     * @param status input 0 or 1 for injured, 2 for Not fully fit, 3 or 4 for fit and 5 for fully fit.
     */
    public void fitnessStatus(int status){
        switch (status){
            case 0:
                this.healthState = HealthStatus.Injured;
                break;
            case 1:
                this.healthState = HealthStatus.Injured;
                break;
            case 2:
                this.healthState = HealthStatus.Not_fully_fit;
                break;
            case 3:
                this.healthState = HealthStatus.Fit;
                break;
            case 4:
                this.healthState = HealthStatus.Fit;
                break;
            case 5:
                this.healthState = HealthStatus.Fully_fit;
                break;
                default:
                    System.out.println("Please provide a number between 0 - 5, with 5 being Fully fit");
                    break;
        }

    }


    public boolean isCaptain() {
        return captain;
    }

    /**
     * Makes a player the captain of the team.
     * @param whichCaptain take int 1 to change main captain, 2 to change assistant captain; 3 to change third captain.
     */
    public void makeCaptain(int whichCaptain){
        switch (whichCaptain){
            case 1:
                if(numberOfCaptains == 0){
                    this.captain = true;
                    numberOfCaptains = 1;
                    teamCaptains.add(0,this);
                }else {
                    numberOfCaptains = 0;
                    teamCaptains.get(0).captain = false;
                    this.captain = true;
                    numberOfCaptains = 1;
                    teamCaptains.add(0,this);
                }
                break;
            case 2:
                if(numberOfAssCaptains == 0) {
                    this.assCaptain = true;
                    numberOfAssCaptains = 1;
                    teamCaptains.add(1,this);
                }else {
                    numberOfAssCaptains = 0;
                    teamCaptains.get(1).assCaptain = false;
                    this.assCaptain = true;
                    numberOfAssCaptains = 1;
                    teamCaptains.add(1,this);
                }
                break;
            case 3:
                if(numberOfThirdCaptains == 0) {
                    this.thirdCaptain = true;
                    numberOfThirdCaptains = 1;
                    teamCaptains.add(2,this);
                }else {
                    numberOfThirdCaptains = 0;
                    teamCaptains.get(2).thirdCaptain = false;
                    this.thirdCaptain = true;
                    numberOfThirdCaptains = 1;
                    teamCaptains.add(2,this);
                }
                break;
            default:
                System.out.println("Please specify \n1 for main captain; \n2 for Assistant captain; \nor 3 for third Captain.\n");
                break;

        }

    }

    /**
     * Prints the details of the captain of the team.
     * @return returns a string.
     */
    public static String myCaptains(int whichCap){
        Player cap;
        String output = "";
        switch (whichCap){
            case 1:
                if(numberOfCaptains == 0){
                    output = "No captain found";
                }else {
                    cap = teamCaptains.get(0);
                    output = cap.playerDetails();
                }
                break;
            case 2:
                if(numberOfAssCaptains == 0){
                    output = "No assistant captain found";
                }else {
                    cap = teamCaptains.get(1);
                    output = cap.playerDetails();
                }
                break;
            case 3:
                if(numberOfThirdCaptains == 0){
                    output = "No third captain found";
                }else {
                    cap = teamCaptains.get(2);
                    output = cap.playerDetails();
                }
            break;
            default:
                System.out.println("Please specify \n1 for main captain; \n2 for Assistant captain; \nor 3 for third Captain.\n");
                break;
        }
        return output;
    }

    public static int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public boolean isAssCaptain() {
        return assCaptain;
    }


    public boolean isThirdCaptain() {
        return thirdCaptain;
    }



    public String playerDetails() {
        return
                this.personDetails() +
                "Player ID: " + playerID + "\n" +
                "Player's Position: " + playerPosition + "\n" +
                "Jersey Number: " + jerseyNumber + "\n" +
                "Year Signed: " + yearSigned + "\n" +
                "Contract Ends In: " + yearContractEnds + "\n" +
                "Contract Status: " + contractStatus + "\n" +
                "Health Status: " + healthState + "\n";
    }



    public static void main(String[] args) {
        Player me = new Player("Francis",16502021);
        Player me2 = new Player("Joe",1648021);
        System.out.println(me.isCaptain());
        me.makeCaptain(1);
        System.out.println(me.isCaptain());
        me2.makeCaptain(2);

        System.out.println(myCaptains(1));

        System.out.println(myCaptains(2));

        me2.makeCaptain(1);
        System.out.println(myCaptains(1));

        System.out.println(getNumberOfPlayers());
    }
}
