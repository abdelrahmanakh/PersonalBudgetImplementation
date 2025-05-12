public class User {
    int UserID, failedAttempts;
    boolean isLocked;
    String email, phoneNumber, username, password;
   
    User(SignUpRequest request, int ID) {
        username = request.username;
        email = request.email;
        password = request.password;
        phoneNumber = request.phoneNumber;
        failedAttempts = 0;
        UserID = ID;
        isLocked = false;
    }
}
