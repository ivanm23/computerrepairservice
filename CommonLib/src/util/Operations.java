/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Ivan
 */
public interface Operations {

    public static final int OPERATION_LOGIN = 1;

    public static final int OPERATION_GET_SERVICES = 2;

    public static int OPERATION_GET_CLIENTS = 3;
    public static int OPERATION_GET_LAST_CLIENT_ID = 4;
    public static int OPERATION_ADD_CLIENT = 5;
    public static int OPERATION_UPDATE_CLIENT = 6;
    public static int OPERATION_DELETE_CLIENT = 7;
    public static int OPERATION_GET_CLIENT_BY_ID = 15;

    public static int OPERATION_ADD_COMPONENT = 8;
    public static int OPERATION_GET_COMPONENTS = 9;
    public static int OPERATION_GET_LAST_COMPONENT_ID = 12;
    public static int OPERATION_GET_CONFIGURATION_COMPONENTS=16;

    public static int OPERATION_SAVE_CONFIGURATION = 10;
    public static int OPERATION_GET_LAST_CONFIGURATION_ID = 11;

    public static int OPERATION_SAVE_CONFIGURATION_ITEM = 13;
    public static int OPERATION_GET_CONFIGURATIONS = 14;
    public static int OPERATION_SAVE_SERVICE=17;
    public static int OPERATION_GET_LAST_SERVICE_ID=18;
    public static int OPERATION_DELETE_ITEM=19;
    public static int OPERATION_GET_LAST_ITEM_ID=20;
    public static int OPERATION_ADD_ITEM=21;
    public static int OPERATION_UPDATE_CONFIGURATION_PRICE=22;
    

}
