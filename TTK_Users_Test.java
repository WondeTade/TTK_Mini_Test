package TTK_Project;

import java.util.ArrayList;

public class TTK_Users_Test {
    
    private static String userName;
    private static String password ;
    private static TTK_Users users = new TTK_Users();
    private static ArrayList<TTK_Users> userList = new ArrayList<>();
    
    public static final String ANSI_RED    = "\u001B[31m";
    public static final String ANSI_GREEN  = "\u001B[32m";
    public static final String ANSI_RESET  = "\u001B[0m";
  
    private static boolean test_addUserList(){
        users.addUserList(userName, password);
    return true;
    }
    private static boolean test_checkUserName(){
         users.checkUserName(userName);
    return true;
    }
    private static boolean test_checkPassword(){
        users.checkPassword(password);
    return true;
    }
    private static boolean test_allowLogin(){
        users.allowLogin(userName, password);
    return true;
    }
    private static boolean test_getUsersUserName(){
        users.getUsersUserName(0);
    return true;
    }
    
    private static void printResultMethod(){
      int totalAmountOfErros = 0;
      String [] resultNameArray = {"addUserList Method", "checkUserName Method",
                                   "checkPassword Method", "allowLogin Method"};
      boolean [] resultArray = {test_addUserList(), test_checkUserName(),
                                test_checkPassword(), test_allowLogin(),
                                test_getUsersUserName()};
      for (int i = 0; i < resultArray.length; i++){
          if(resultArray[i] == true){
      System.out.printf("%-30s"+ANSI_GREEN+"%s%n"+ANSI_RESET,resultNameArray[i], "PASSED");
    } else {
      System.out.printf("%-30s"+ANSI_RED+"%s%n"+ANSI_RESET,resultNameArray[i], "FAILED");
      totalAmountOfErros++;
    }
          
      }
       System.out.println("Total amount of errors: "+totalAmountOfErros);
    }
    public static void main(String[] a) {
        printResultMethod();
  }

}
