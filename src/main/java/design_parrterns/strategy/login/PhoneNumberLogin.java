package design_parrterns.strategy.login;

import design_parrterns.strategy.register.MailRegister;
import design_parrterns.strategy.register.PhoneRegister;

/**
 * 手机号码登录
 * @author yao 2022/12/8
 */
public class PhoneNumberLogin extends Login{

    public PhoneNumberLogin(){
        register = new PhoneRegister();
    }

    @Override
    void login() {
        System.out.println("使用手机号码验证码登录");
    }
}
