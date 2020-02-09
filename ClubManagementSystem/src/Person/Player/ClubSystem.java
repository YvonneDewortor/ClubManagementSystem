package Person.Player;

import Person.Management.ClubManagement;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

public class ClubSystem extends Application {

    public static String clubName = "";
    public static String formation = "";

    private static ArrayList<ClubManagement> clubAdmins = new ArrayList<>();

    private static ArrayList<ClubManagement> clubBoard = new ArrayList<>();

    private static ArrayList<ClubManagement> technicalTeam = new ArrayList<>();

    private static ArrayList<ClubManagement> medicalTeam = new ArrayList<>();

    public static void addAdmin(ClubManagement anAdmin){
        clubAdmins.add(anAdmin);
    }
    public static void removeAdmin(ClubManagement anAdmin){
        clubAdmins.remove(anAdmin);
    }

    public static void addToBoard(ClubManagement anAdmin){
        clubBoard.add(anAdmin);
    }
    public static void removeFromBoard(ClubManagement anAdmin){
        clubBoard.remove(anAdmin);
    }





    /**
     * An arraylist of the players in the team.
     */
    public static ArrayList<Player> clubPlayers = new ArrayList<>();


    /**
     * A heap of the team's first eleven for a match and the substitutes available.
     */
    public static HashMap<Integer, Player> firstEleven = new HashMap<>(11);
    public static HashMap<Integer, Player> substitutes = new HashMap<>(5);


    /**
     * Adds a player to the football team.
     * @param aPlayer play to be added to the team.
     */
    public static void addPlayerToClub(Player aPlayer){
        clubPlayers.add(aPlayer);
    }

    /**
     * Removes a player from the club.
     * @param aPlayer player to be removed.
     */
    public static void removePlayerFromClub(Player aPlayer){
        clubPlayers.remove(aPlayer);
    }



    /**
     * Assigns the captain of a team to a player.
     * @param aPlayer the player to be made captain.
     * @param whichCap input 1 to make player main captain, 2 to make player assistant captain or 3 to make player third captain.
     */
    public static void makeCaptain(Player aPlayer, int whichCap){
        switch (whichCap){
            case 1:
                aPlayer.makeCaptain(1);
                break;
            case 2:
                aPlayer.makeCaptain(2);
                break;
            case 3:
                aPlayer.makeCaptain(3);
                break;
                default:
                    System.out.println("Please specify \n1 for main captain; \n2 for Assistant captain; \nor 3 for third Captain.\n");
                    break;
        }
    }


    /**
     * This changes the captain of the team.
     * @param whichCaptain input 1 to make player main captain, 2 to make player assistant captain or 3 to make player third captain.
     * @param aplayer new player to be made captain.
     */
    public static void changeCaptain(int whichCaptain, Player aplayer){
        aplayer.makeCaptain(whichCaptain);
    }


    /**
     * Prints all the players in the team.
     */
    public static void namesOfAllPlayers(){
        for (Player ply: clubPlayers){
            System.out.println(ply.getName());
        }
    }


    /**
     * Prints the first eleven and substitutes for a match, with the jersey numbers and positions of the players.
     */
    public static void teamSheetforMatch(){
        System.out.println("*****First Eleven*****");
        for (Player ply: firstEleven.values()){
            System.out.println("Name: " + ply.getName() + "\nJersey number: " + ply.getJerseyNumber() + "\nPlayer''s Position: " + ply.getPlayerPosition());
        }

        System.out.println("*****Substitutes*****");
        for (Player ply: substitutes.values()){
            System.out.println("Name: " + ply.getName() + "\nJersey number: " + ply.getJerseyNumber() + "\nPlayer''s Position: " + ply.getPlayerPosition());
        }
    }



    /*public static void showFormation(){


        JFrame jf = new JFrame();
        jf.setTitle(clubName + " Formation");
        jf.setSize(500,500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

        JButton btn;
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints bag = new GridBagConstraints();


        btn = new JButton("Btn1");
        bag.gridx = 0;
        bag.gridy = 0;
        panel.add(btn,bag);

        btn = new JButton("Btn2");
        bag.fill = GridBagConstraints.HORIZONTAL;
        bag.weightx = 0.5;
        bag.gridy = 1;
        bag.gridx = 1;
        panel.add(btn,bag);
    }
*/

    /**
     * Adds player to the first eleven list. Prints an error is player is already in the list, is injured or does not have a jersey number.
     * @param aPlayer player to be added to list.
     */
    public static void addPlayerToFirstEleven(Player aPlayer){

        if(firstEleven.size() < 11) {
            if (aPlayer.getJerseyNumber() > 0 && aPlayer.getHealthState() >= 50 && !firstEleven.containsValue(aPlayer)) {
                firstEleven.put(aPlayer.getJerseyNumber(), aPlayer);
            }
            if (firstEleven.containsValue(aPlayer)) {
                System.out.println("Player is already in the list");
            }
            if (aPlayer.getJerseyNumber() < 1) {
                System.out.println(aPlayer.getName() + " is not eligible to play without a valid jersey number, Please provide his number.");
            }

            if (aPlayer.getHealthState() < 30) {
                System.out.println(aPlayer.getName() + " can't play because he is injured, please field a fit player");
            }


        }else {
            System.out.println("You already have all players for the match");
        }
    }

    /**
     * Removes player from firs eleven list. Prints an error if player is not available in the list.
     * @param aPlayer player to be removed from the list.
     */
    public static void removePlayerFromFirstEleven(Player aPlayer){
        if(firstEleven.size()<5) {
            if (firstEleven.containsValue(aPlayer)) {
                firstEleven.remove(aPlayer.getJerseyNumber(), aPlayer);
            } else {
                System.out.println("Player is not available in first eleven");
            }
        }else {
            System.out.println("You've reached the maximum number of substitutes for the match");
        }
    }

    /**
     * removes player from substitutes list. Prints an error if player is not available in the list.
     * @param aPlayer player to be removed from the list.
     */
    public static void removePlayerFromSubstitues(Player aPlayer){
        if(substitutes.containsValue(aPlayer)){
            substitutes.remove(aPlayer.getJerseyNumber(),aPlayer);
        }else{
            System.out.println("Player is not available in substitutes list");
        }
    }

    /**
     * Adds a player to substitutes list.
     * @param aPlayer player to be added to list.
     */
    public static void addPlayerToSubstitutes(Player aPlayer){
        if(aPlayer.getJerseyNumber() > 0 && aPlayer.getHealthState() >= 50 ){
            substitutes.put(aPlayer.getJerseyNumber(),aPlayer);
        }else if(aPlayer.getJerseyNumber() < 1) {
            System.out.println(aPlayer.getName()+" is not eligible to be a substitute without a valid jersey number, Please provide his number.");
        }else if (aPlayer.getHealthState()<30) {
            System.out.println(aPlayer.getName() + " can't play because he is injured, please add a fit player instead");
        }
    }



    public static void main(String[] args) {

        launch(args);
       /*Player me = new Player("Francis",16502021);
        Player me2 = new Player("Joe",1648021);


        addPlayerToClub(me);
        addPlayerToClub(me2);

        namesOfAllPlayers();

        makeCaptain(me,1);
        makeCaptain(me,1);
        */


       /*System.out.println(me.isCaptain());
        me.makeCaptain();
        System.out.println(me.isCaptain());
        me2.makeAssCaptain();

        System.out.println(myCaptain());

        System.out.println(myAssCaptain());

        changeCaptain(1,me2);
        System.out.println(myCaptain());

        System.out.println(getNumberOfPlayers());
        */
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
