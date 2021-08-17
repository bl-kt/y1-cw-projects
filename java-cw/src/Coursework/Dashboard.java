package Coursework;

public class Dashboard {

    public static void main(String[] args){

        //build helper
        ConsoleHelper util = new ConsoleHelper();

        //build smart home
        int homeSize = util.getInt("How many rooms are in the property?");
        int plugAmount = util.getInt("How many smart plugs do you wish to install across the property?");
        var home = new SmartHome(homeSize, plugAmount);

        //populate rooms
        home.populateRooms(util);

        //populate plugs
        home.populatePlugs(util, plugAmount);
        util.displaySmartPlugs(home.plugs);

        //display options
        int continueEditing = util.getInt("\nDo you want to view the console options? 0 = No, 1 = Yes");

        while (continueEditing == 1){

            util.displayOptions();
            int consoleOptions = util.getInt("");

            switch(consoleOptions){
                //house
                case 1:
                    util.displayHouseOptions();
                    consoleOptions = util.getInt("");

                    switch(consoleOptions){
                        //off
                        case 1:
                            home.turnHouseOff(plugAmount);
                            util.displaySmartPlugs(home.plugs);
                            break;

                        //on
                        case 2:
                            home.turnHouseOn(plugAmount);
                            util.displaySmartPlugs(home.plugs);
                            break;
                    }
                    break;

                //room
                case 2:
                    util.displayRooms(home.rooms);
                    int selectedRoom = util.getInt("\nSelect a room (integer only): ");
                    util.displayRoomOptions();
                    consoleOptions = util.getInt("");

                    switch(consoleOptions){

                        //off
                        case 1:
                            home.turnRoomOff(selectedRoom, plugAmount);
                            util.displaySmartPlugs(home.plugs);
                            break;

                        //on
                        case 2:
                            home.turnRoomOn(selectedRoom, plugAmount);
                            util.displaySmartPlugs(home.plugs);
                            break;

                        //select
                        case 3:
                            util.displaySmartPlugs(home.plugs);
                            int selectedPlug = util.getInt("\nSelect a plug (integer only): ");
                            home.toggleSelectedPlug(selectedPlug, plugAmount);
                            util.displaySmartPlugs(home.plugs);
                            break;

                    }
                    break;

                //plug
                case 3:
                    util.displayPlugOptions();
                    consoleOptions = util.getInt("");
                    switch(consoleOptions){

                        //off
                        case 1:
                            util.displaySmartPlugs(home.plugs);
                            int selectedPlug = util.getInt("\nSelect a plug (integer only): ");
                            home.turnPlugOff(selectedPlug, plugAmount);
                            util.displaySmartPlugs(home.plugs);
                            break;

                        //on
                        case 2:
                            util.displaySmartPlugs(home.plugs);
                            selectedPlug = util.getInt("\nSelect a plug (integer only): ");
                            home.turnPlugOn(selectedPlug, plugAmount);
                            util.displaySmartPlugs(home.plugs);
                            break;

                        //change device
                        case 3:
                            util.displaySmartPlugs(home.plugs);
                            selectedPlug = util.getInt("Select a plug (integer only): ");
                            util.displayAvailableDevices(home.availableDevices);
                            int newDevice = util.getInt("\nEnter the ID of the device you wish to switch to (integer only): ");
                            home.changeAttachedDevice(selectedPlug, plugAmount, newDevice);
                            util.displaySmartPlugs(home.plugs);
                            break;

                        //change room
                        case 4:
                            util.displaySmartPlugs(home.plugs);
                            selectedPlug = util.getInt("\nSelect a plug (integer only): ");
                            util.displayRooms(home.rooms);
                            int newRoom = util.getInt("Enter the ID of the room you wish to switch to (integer only)");
                            home.changeRoom(selectedPlug, plugAmount, newRoom);
                            util.displaySmartPlugs(home.plugs);
                            break;

                    }
                    break;

                //system
                case 4:
                    util.displaySystemOptions();
                    consoleOptions = util.getInt("");
                    switch(consoleOptions){
                        case 1:
                            home.appendRoom(util);
                            util.displayRooms(home.rooms);
                            break;

                        case 2:
                            home.appendPlug(util);
                            util.displaySmartPlugs(home.plugs);
                            break;

                        case 3:
                            home.appendDevice(util);
                            util.displayAvailableDevices(home.availableDevices);
                            break;

                    }
                    break;



            }
            continueEditing = util.getInt("\nDo you continue editing? 0 = No, 1 = Yes");
        }
    }


}
