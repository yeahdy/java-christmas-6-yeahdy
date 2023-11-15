package utils;

import constants.ErrorCodeConstant;

public class PrintUtils {

    public static void println(String message){
        System.out.println(message);
    }
    public static void print(String message){
        System.out.print(message);
    }
    public static void printf(String formatMessage, Object args){
        System.out.printf("%n"+formatMessage+"%n",args);
    }
    public static void errorPrint(String errorMessage){
        System.out.println(ErrorCodeConstant.ERROR + errorMessage);
    }

    public static void replacePrintf(String message, String replaceMessage){
        System.out.printf(message,replaceMessage);
    }

}
