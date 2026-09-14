
import java.util.Scanner;

class invalidusername extends Exception {

    invalidusername() {
        super();
    }

    invalidusername(String msg) {
        super(msg);
    }
}

class invalidpassword extends Exception {

    invalidpassword() {
        super();
    }

    invalidpassword(String msg) {
        super(msg);
    }
}

class accountlocked extends Exception {

    accountlocked() {
        super();
    }

    accountlocked(String msg) {
        super(msg);
    }
}

class login {

    static int loginattempt = 0;

    String user;
    String password;

    login(String u, String p) {
        user = u;
        password = p;
    }

    void checkuser(String u) throws invalidusername {
        if (!u.equals(user)) {
            throw new invalidusername("Invalid username");
        }
    }

    void checkpass(String p) throws invalidpassword {
        if (!p.equals(password)) {
            throw new invalidpassword("Invalid password");
        }
    }
}

public class q6 {

    public static void main(String[] args) {

        int maxattempt = 3;

        login a = new login("ABCD", "1234");

        try {

            Scanner sc = new Scanner(System.in);

            while (login.loginattempt < maxattempt) {

                try {

                    System.out.println("Enter username");
                    String user = sc.nextLine();

                    a.checkuser(user);

                    System.out.println("Enter password");
                    String pass = sc.nextLine();

                    a.checkpass(pass);

                    System.out.println("Login successful!");
                    break;

                } catch (invalidusername e) {

                    login.loginattempt++;
                    System.out.println(e.getMessage());

                } catch (invalidpassword e) {

                    login.loginattempt++;
                    System.out.println(e.getMessage());
                }
            }

            if (login.loginattempt >= maxattempt) {
                throw new accountlocked("Your account is locked now");
            }

        } catch (accountlocked e) {

            System.out.println(e.getMessage());

        } finally {

            System.out.println("Thank You for using our platform");
        }
    }
}