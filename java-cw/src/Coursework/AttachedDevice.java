package Coursework;

public class AttachedDevice implements DisplayName {

    //variables
    private String deviceName;
    private int deviceID;

    //constructor
    public AttachedDevice(String deviceName, int deviceID) {
        this.deviceName = deviceName;
        this.deviceID = deviceID;
    }

    public String getDisplayName(){
        return String.format("%s - %s", deviceID, deviceName);
    }

}
