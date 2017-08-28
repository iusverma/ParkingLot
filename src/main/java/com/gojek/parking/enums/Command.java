package com.gojek.parking.enums;
/**
 * Enumeration for handling commands for parking lot
 */
public enum Command {

    /* create_parking_lot command*/
    CREATE_PARKING_LOT("create_parking_lot"), 

    /* park command*/
    PARK("park"),

    /* leave command*/
    LEAVE("leave"),

    /* status command*/
    STATUS("status"),

    /* registration_numbers_for_cars_with_colour command*/
    REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR("registration_numbers_for_cars_with_colour"),

    /* slot_numbers_for_cars_with_colour command*/
    SLOT_NUMBERS_FOR_CARS_WITH_COLOUR("slot_numbers_for_cars_with_colour"),

    /* slot_number_for_registration_number command*/
    SLOT_NUMBERS_FOR_REGISTRATION_NUMBER("slot_number_for_registration_number");
    
    private String key;
    
    Command(String commandKey) {
        this.key = commandKey;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    
    public String toString(){
        return key;
    }
}