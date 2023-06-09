package design_parrterns.strategy.login;

/**
 * @author yao 2022/12/8
 */
public class TestLogin {
    public static void main(String[] args) {
        Login login = new AccountLogin();
        login.login();
        login.logout();
        login = new PhoneNumberLogin();
        login.login();
    }
}
