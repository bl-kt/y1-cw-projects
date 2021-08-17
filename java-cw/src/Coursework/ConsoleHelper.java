package Coursework;

import java.util.Scanner;

public class ConsoleHelper {

    //output data
    public void outputToConsole(String data) {
        System.out.println(data);
    }

    public static String numberSuffix(int i) {
        int mod100 = i % 100;
        int mod10 = i % 10;
        if(mod10 == 1 && mod100 != 11) {
            return i + "st";
        } else if(mod10 == 2 && mod100 != 12) {
            return i + "nd";
        } else if(mod10 == 3 && mod100 != 13) {
            return i + "rd";
        } else {
            return i + "th";
        }
    }

    //input data

    public String getString(String prompt) {
        Scanner input = new Scanner(System.in);
        outputToConsole(prompt);
        return input.nextLine();
    }

    public int getInt(String prompt) {
        Scanner input = new Scanner(System.in);
        outputToConsole(prompt);
        return input.nextInt();
    }


    //output options

    public void displayOptions(){
        outputToConsole("\nOptions: \n");
        outputToConsole("1 - House level options");
        outputToConsole("2 - Room level options");
        outputToConsole("3 - Plug level options");
        outputToConsole("4 - System level options");
        outputToConsole("\nSelect an option: ");
    }

    public void displayHouseOptions(){
        outputToConsole("\nHOUSE LEVEL OPTIONS\n");
        outputToConsole("1 - Switch all plugs off");
        outputToConsole("2 - Switch all plugs on");
        outputToConsole("\nSelect an option: ");
    }

    public void displayRoomOptions(){
        outputToConsole("\nROOM LEVEL OPTIONS\n");
        outputToConsole("1 - Switch off all plugs in room");
        outputToConsole("2 - Switch on all plugs in a room");
        outputToConsole("3 - Select individual plug and toggle on/off status");
        outputToConsole("\nSelect an option: ");
    }

    public void displayPlugOptions(){
        outputToConsole("\nPLUG LEVEL OPTIONS\n");
        outputToConsole("1 - Switch plug off");
        outputToConsole("2 - Switch plug on");
        outputToConsole("3 - Change attached device");
        outputToConsole("4 - Move plug to a different room");
        outputToConsole("\n Select an option: ");

    }

    public void displaySystemOptions(){
        outputToConsole("\nOptions: \n");
        outputToConsole("1 - Add a new room");
        outputToConsole("2 - Add a new plug");
        outputToConsole("3 - Add new attached device");
        outputToConsole("\nSelect an option: ");
    }

    //display

    public void displayArray(DisplayName[] array) {
        for (int i = 0; i < array.length; i++) {
            outputToConsole(array[i].getDisplayName());
        }
    }

    public void displayRooms(SmartRoom[] rooms){
        outputToConsole("ROOMS AVAILABLE: \n");
        displayArray(rooms);
    }

    public void displayAvailableDevices(AttachedDevice[] availableDevices){
        outputToConsole("These are standard devices that can be attached to the smart plug: \n");
        displayArray(availableDevices);
    }

    public void displaySmartPlugs(SmartPlug[] plugs){
        outputToConsole("The following are the current plugs: \n");
        displayArray(plugs);
    }




}
