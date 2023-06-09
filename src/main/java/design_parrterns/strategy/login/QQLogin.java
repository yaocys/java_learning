package design_parrterns.strategy.login;

/**
 * @author yao 2022/12/8
 */
public class QQLogin extends Login{
    @Override
    void login() {
        System.out.println("调用QQ的认证服务登录");
    }
}
