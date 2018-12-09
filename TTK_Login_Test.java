public class TTK_Login_Test {

private static TTK_Login login = new TTK_Login();
private static TTK_Users userList = new TTK_Users();

public static boolean test_checkUsername(){

    Boolean temp = login.checkUsername("tempUsername", userList);

    return temp;
}

public static boolean test_logInUser(){

    Boolean temp = login.logInUser("tempUsername", "tempPassword", userList);

    return temp;
  }
}