package Coursework;

public class SmartRoom implements DisplayName {

    //variables
    private int roomID;
    private String name;

    //constructor
    public SmartRoom(int ID, String name){

        this.roomID = ID;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //display
    public String getDisplayName(){
       return String.format("%s - %s", roomID, name);
    }

}
