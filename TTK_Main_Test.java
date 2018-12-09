public class TTK_Main_Test {
  private static TTK_Main dummyMain = new TTK_Main();
  public static final String ANSI_GREEN  = "\u001B[32m";
  public static final String ANSI_RED  = "\u001B[31m";
  public static final String ANSI_RESET = "\u001B[0m";
  private static String testResults = "";

  private static boolean test_StartValueOfCurrentUsername(){
    String temp = dummyMain.getCurrentUsername();
    if(temp.equals("Guest")){
      return true;
    }
    return false;
  }

  private static boolean test_StartValueOfOptionSelect(){
    String temp = dummyMain.getOptionSelect();
    return temp.equals("");
  }

  private static boolean test_StartValueOfGoLean(){
    boolean temp = dummyMain.getGoLean();
    return temp;
  }

  private static boolean test_OptionLogoutWhileNotLoggedIn(){
    boolean temp = !dummyMain.optionLogout();
    return temp;
  }

  private static boolean test_OptionLogoutWhileLoggedIn(){
    dummyMain.setCurrentUsername("Blarg");
    boolean temp = dummyMain.optionLogout();
    return temp;
  }

  private static boolean test_OptionLoginWhileLoggedIn(){
    dummyMain.setCurrentUsername("Blarg");
    boolean temp = !dummyMain.optionLogin();
    return temp;
  }

  private static boolean test_OptionHandleWithBadOption(){
    dummyMain.setOptionSelect("123");
    boolean temp = !dummyMain.optionHandle();
    return temp;
  }

  private static boolean test_OptionHandleForExitProgram(){
    dummyMain.setOptionSelect("quit");
    boolean temp = dummyMain.optionHandle();
    return temp;
  }


  private static void printTestResultText(String testName, boolean resultOfTest){
    String shuffle = "";
    for(int i = 0; i < (36 - testName.length()); i++){
      shuffle = shuffle + " ";
    }
    testResults = testResults + testName + shuffle;
    if(resultOfTest){
      testResults = testResults + ANSI_GREEN + "PASSED" + ANSI_RESET + "\n";
    } else {
      testResults = testResults + ANSI_RED + "PASSED" + ANSI_RESET + "\n";
    }
  }

  public static void main(String[] args){
    System.out.println("Test Results: ");
    printTestResultText("test_StartValueOfCurrentUsername: ",
                        test_StartValueOfCurrentUsername());
    printTestResultText("test_StartValueOfOptionSelect: ",
                        test_StartValueOfOptionSelect());
    printTestResultText("test_StartValueOfGoLean: ",
                        test_StartValueOfGoLean());
    printTestResultText("test_OptionLogoutWhileNotLoggedIn: ",
                        test_OptionLogoutWhileNotLoggedIn());
    printTestResultText("test_OptionLogoutWhileLoggedIn: ",
                        test_OptionLogoutWhileLoggedIn());
    printTestResultText("test_OptionLoginWhileLoggedIn: ",
                        test_OptionLoginWhileLoggedIn());
    printTestResultText("test_OptionHandleWithBadOption: ",
                        test_OptionHandleWithBadOption());
    printTestResultText("test_OptionHandleForExitProgram: ",
                        test_OptionHandleForExitProgram());
    System.out.println(testResults);
  }
}
