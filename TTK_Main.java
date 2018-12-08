import java.util.Scanner;

public class TTK_Main {
  private static String currentUsername = "Guest";
  private static String optionSelect = "";
  private static Scanner scan = new Scanner(System.in);
  //private static TTK_Users userList = new TTK_Users();
  //private static TTK_Login loginMethods = new TTK_Login();
  //private static TTK_Create createMethods = new TTK_Create();
  private static boolean goLean = true;

  public String getCurrentUsername(){
    return currentUsername;
  }
  public void setCurrentUsername(String aName){
    currentUsername = aName;
  }
  public String getOptionSelect(){
    return optionSelect;
  }
  public void setOptionSelect(String anOption){
    optionSelect = anOption;
  }
  public boolean getGoLean(){
    return goLean;
  }

  //methods above this line are meant for testing purposes only

  public static void welcomeLine() {
    System.out.println("Welcome " + currentUsername + "! ");
  }
  public static void optionList() {
    if(currentUsername.equals("Guest")){
      System.out.println("Enter Login to log in as a user or Create to register a new user");
    } else {
      System.out.println("Enter Logout to log out and return to guest status or Create to register a new user");
    }
    optionSelect = scan.next().toLowerCase();
  }

  public static boolean optionLogin() {
    if(currentUsername.equals("Guest")){
      //if current name is guest that means you are not currently logged in
      System.out.println("please enter your username.");
      String tempUsername = scan.next();
        if(true) {
//      if(loginMethods.checkUsername(tempUsername, userList)) {                     //METODCALL FOR TTK_LOGIN HERE
        //checks that the username exists in our userList and, if so, asks for the password)
        System.out.println("please enter your password.");
        String tempPassword = scan.next();
          if(true) {
//        if(loginMethods.logInUser(tempUsername, tempPassword, userList)) {         //METODCALL FOR TTK_LOGIN HERE
          //login succeeded, printing welcome message.
          currentUsername = tempUsername;
          welcomeLine();
          return true;
        } else {
          //login failed due to wrong password
          System.out.println("That was the wrong password. ");
          return false;
        }
      } else {
        //username does not exist in our userList
        System.out.println("That username was not found in the database. ");
        return false;
      }
    } else {
      //if you got here, you are already logged in
      System.out.println("You are already logged in. ");
      return false;
    }
  }

  public static boolean optionLogout() {
    if(currentUsername.equals("Guest")) {
      System.out.println("You are not currently logged in.");
      return false;
    } else {
      currentUsername = "Guest";
      System.out.println("You are now logged out");
      welcomeLine();
      return true;
    }
  }

  public static boolean optionCreate() {
    System.out.println("Please enter the new username: ");
    String newUsername = scan.next();
      if(false) {
//    if(!createMethods.checkUsername(newUsername, userList)) {                              //METHOD CALL FOR TTK_Create HERE
      //checks that the user does not already exists
      System.out.println("Please enter the new user's password");
      String newPassword = scan.next();
        if(true) {
//      if(createMethods.createUser(newUsername, newPassword, userList)) {                   //METHOD CALL FOR TTK_Create HERE
        System.out.println("New user" + newUsername + "has been created!");
        return true;
      } else {
        System.out.println("Sorry, for some reason we could not create the new user!");
        return false;
      }
    } else {
      System.out.println("Sorry, that username already exists. ");
      return false;
    }
  }

  public static boolean optionHandle() {
    boolean goodOption = true;
    boolean problemDidNotOccur = true;
    if(optionSelect.contains("login")){
      problemDidNotOccur = optionLogin();
    } else if (optionSelect.contains("logout")) {
      problemDidNotOccur = optionLogout();
    } else if (optionSelect.contains("create")) {
        problemDidNotOccur = optionCreate();
    } else if (optionSelect.contains("quit") || optionSelect.contains("exit")) {
      goLean = false;
      problemDidNotOccur = true;
    } else {
      //go here if none of the accepted keywords were given by the user.
      goodOption = false;
      System.out.println("That was not one of the options available, please try again. ");
    }
    if(goodOption){
      return problemDidNotOccur;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    welcomeLine();
    while (goLean) {
      optionList();
      optionHandle();
    }
  }
}
