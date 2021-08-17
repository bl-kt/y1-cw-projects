package Coursework;

public class SmartPlug implements DisplayName {

    //variables
    private boolean isOn;
    private int roomID;
    private String roomName;
    private int deviceID;
    private int plugID;

    //constructor
    public SmartPlug(int roomID, int deviceID, int plugID){
        this.roomID = roomID;
        this.deviceID = deviceID;
        this.plugID = plugID;
    }

    //getters
    public boolean getIsOn() { return isOn; }

    public int getRoomID() { return roomID; }

    public int getPlugID() {
        return plugID;
    }

    public String getRoomName() {return roomName;}

    //setters
    public void setIsOn(boolean on) { this.isOn = on; }

    public void setRoomID(int roomID) { this.roomID = roomID; }

    public void setDeviceID(int deviceID) { this.deviceID = deviceID; }

    public void setRoomName(String roomName) { this.roomName = roomName; }

    //methods

    public String getDisplayName(){
        return "Plug ID " + plugID + " | Device ID: " + deviceID + " | Room ID: " + roomID + " | Is On: " + isOn;
    }
}


