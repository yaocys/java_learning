package design_parrterns.strategy.login;

import design_parrterns.strategy.register.MailRegister;

/**
 * 账号密码登录
 * @author yao 2022/12/8
 */
public class AccountLogin extends Login {

    public AccountLogin(){
        register = new MailRegister();
    }

    @Override
    public void login() {
        System.out.println("使用账号密码登录");
    }
}
