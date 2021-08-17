package Coursework;

public class SmartHome {

    //variables
    public AttachedDevice[] availableDevices;
    public SmartRoom[] rooms;
    public SmartPlug[] plugs;

    public SmartHome(int homeSize, int plugAmount){
        rooms = new SmartRoom[homeSize];
        plugs = new SmartPlug[plugAmount];
        populateAvailableDevices();
    }

    //populate
    public void populateRooms(ConsoleHelper util) {
        for (int i = 1; i <= rooms.length; i++) {
            rooms[i-1] = createRoom(util, i);
        }
    }

    public SmartRoom createRoom(ConsoleHelper util, int number){
        String roomName = util.getString("Please provide a name for your " + util.numberSuffix(number) + " room: ");
        return new SmartRoom(number,roomName);
    }


    public void populatePlugs(ConsoleHelper util, int plugAmount){
        for(int i = 0; i < plugAmount; i++){
            plugs[i] = createPlug(util,i+1, i);
        }
    }

    public SmartPlug createPlug(ConsoleHelper util, int PlugID, int number){
        util.displayRooms(rooms);
        int roomID = util.getInt("\nUsing the above list, please select the room for this plug (" +(number+1) + ") (integer only):");

        util.displayAvailableDevices(availableDevices);
        int deviceID = util.getInt("\nUsing the above list, please select the device to attach to the smart plug (integer only):");
        return new SmartPlug(roomID, deviceID, PlugID);
    }


    public void populateAvailableDevices(){
        availableDevices = new AttachedDevice[5];
        availableDevices[0] = new AttachedDevice("Lamp",1);
        availableDevices[1] = new AttachedDevice("TV", 2);
        availableDevices[2] = new AttachedDevice("Computer",3);
        availableDevices[3] = new AttachedDevice("Phone Charger",4);
        availableDevices[4] = new AttachedDevice("Heater",5);
    }

    public AttachedDevice createDevice(ConsoleHelper util, int deviceID){
        String deviceName = util.getString("Please provide a name for your new device: ");
        return new AttachedDevice(deviceName, deviceID);
    }

    //append
    public void appendPlug(ConsoleHelper util){
        SmartPlug[] newPlugs = new SmartPlug[plugs.length+1];

        for (int i = 0; i < plugs.length; i++){
            newPlugs[i] = plugs[i];
        }

        newPlugs[newPlugs.length-1] = createPlug(util, newPlugs.length,newPlugs.length-1);
        plugs = newPlugs;

    }

    public void appendRoom(ConsoleHelper util){
        SmartRoom[] newRooms = new SmartRoom[rooms.length+1];

        for (int i = 0; i < rooms.length; i++){
            newRooms[i] = rooms[i];
        }

        newRooms[newRooms.length-1] = createRoom(util, newRooms.length);
        rooms = newRooms;
    }

    public void appendDevice(ConsoleHelper util){
        AttachedDevice[] NewAvailableDevices = new AttachedDevice[availableDevices.length+1];

        for (int i = 0; i < availableDevices.length; i++){
            NewAvailableDevices[i] = availableDevices[i];
        }

        NewAvailableDevices[NewAvailableDevices.length-1] = createDevice(util, NewAvailableDevices.length);
        availableDevices = NewAvailableDevices;
    }

    //home options
    public void turnHouseOff(int plugAmount){
        for(int  i = 0; i< plugAmount; i++){
            plugs[i].setIsOn(false);
        }
    }

    public void turnHouseOn(int plugAmount){
        for(int  i = 0; i< plugAmount; i++){
            plugs[i].setIsOn(true);
        }
    }

    //room options
    public void turnRoomOff(int selectedRoom, int plugAmount){
        for(int  i = 0; i< plugAmount; i++){
            if(plugs[i].getRoomID() == selectedRoom){
                plugs[i].setIsOn(false);
            }
        }
    }

    public void turnRoomOn(int selectedRoom, int plugAmount){
        for(int  i = 0; i< plugAmount; i++){
            if(plugs[i].getRoomID() == selectedRoom){
                plugs[i].setIsOn(true);
            }
        }
    }

    public void toggleSelectedPlug(int selectedPlug, int plugAmount){
        for(int  i = 0; i< plugAmount; i++){
            if(plugs[i].getPlugID() == selectedPlug){
                plugs[i].setIsOn(!plugs[i].getIsOn());
            }
        }
    }

    //plug options
    public void turnPlugOff(int selectedPlug, int plugAmount){
        for(int  i = 0; i< plugAmount; i++){
            if(plugs[i].getPlugID() == selectedPlug){
                plugs[i].setIsOn(false);
            }
        }
    }

    public void turnPlugOn(int selectedPlug, int plugAmount){
        for(int  i = 0; i< plugAmount; i++){
            if(plugs[i].getPlugID() == selectedPlug){
                plugs[i].setIsOn(true);
            }
        }
    }

    public void changeAttachedDevice(int selectedPlug, int plugAmount, int newDevice){
        for(int  i = 0; i< plugAmount; i++){
            if(plugs[i].getPlugID() == selectedPlug){
                plugs[i].setDeviceID(newDevice);
            }
        }
    }

    public void changeRoom(int selectedPlug, int plugAmount, int newRoom){
        for(int  i = 0; i< plugAmount; i++){
            if(plugs[i].getPlugID() == selectedPlug){
                plugs[i].setRoomID(newRoom);
            }
        }
    }



}
