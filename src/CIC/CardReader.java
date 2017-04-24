/*
CardReader.java defines a module for reading a file with card data
Created: 19 April 2017
Author: Landon Sterk (ljs34)
*/

package CIC;

import javafx.animation.Timeline;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.IOException;

public class CardReader{
  private static String filePath = "/var/log/kiosk/card.log";
  private static File cardLog;
  private static boolean active;


  public static void init() throws IOException{
    if (File.separator.equals("\\")) {
      // OS is Windows or uses Windows - like structure
      filePath = "C:\\Users\\bb36\\AppData\\Roaming\\card.log";
    }
    try{
      cardLog = new File(filePath);
      if (!cardLog.exists()){
        throw new IOException("File " + filePath + " does not exist");
      }
    } catch (NullPointerException npe){
      System.err.println("Huh, somehow the path was empty...");
    }
    System.out.println("Card reader is ready on path " + filePath);
    active = true;
    Home_Controller.checkCardReader.setCycleCount(Timeline.INDEFINITE);
    Home_Controller.checkCardReader.play();
  }


  public static boolean hasID(){
    return (cardLog.length() >= 7);
  }


  public static void setFilePath(String path){
    String old_path = filePath;
    filePath = path;
    try{
      init();
    }
    catch (IOException i){
      System.err.println("Error occurred while changing file path:");
      System.err.println(i);
    }
  }


  public static ArrayList<String> getIDs() throws IOException{
    ArrayList<String> userIDList = new ArrayList<String>();
    BufferedReader reader;
    String userID;
    if (!hasID()){
      // will be an empty ArrayList
      return userIDList;
    }
    try {
      reader = new BufferedReader(new FileReader(cardLog));
    }
    catch (IOException i){
      System.err.println("IOException occurred while initializing Reader:");
      System.err.println(i);
      return userIDList;
    }
    try {
      try {
        userID = reader.readLine();
      }
      catch (IOException i){
        System.err.println("IOException occurred while reading a line:");
        System.err.println(i);
        return userIDList;
      }

      while (userID != null){
        if (userID.length() == 7){
          //System.out.println("Reader userID: <" + userID + ">");
          userIDList.add(userID);
        }
        else {
          //System.out.println("Next line too short, ignoring...");
        }
        try {
          userID = reader.readLine();
        }
        catch (IOException i){
          System.err.println("IOException occurred while reading a line:");
          System.err.println(i);
          return userIDList;
        }
      }


    } finally {
      // System.out.println("Finished reading");

      // done reading, time to clean up
      // could generate IOException here
      reader.close();
      cardLog.delete();
      cardLog.createNewFile();
    }
    return userIDList;
  }


  public static String getLastID() throws IOException{
    if (!hasID()){
      System.out.println("Empty");
      return "";
    }
    // else
    ArrayList<String> userIDList = getIDs();
    System.out.println("Last ID: " + userIDList.get(userIDList.size() - 1));
    return userIDList.get(userIDList.size() - 1);

  }


  public static void main(String[] args){
    System.out.println("Running the CardReader program");
    try{
      init();
    }
    catch (IOException i) {
      System.err.println("ERROR DETECTED ON INIT METHOD");
      System.err.println(i);
    }
    try{
      ArrayList<String> idList = getIDs();
        // else length == 0
        for (String id : idList){
          System.out.println("<" + id + ">");
        }
      }
    catch (Exception e) {
      System.err.println(e);
    }
  }
}
