package design_parrterns.strategy.login;

import design_parrterns.strategy.register.Register;

/**
 * 登录类顶级父类
 * @author yao 2022/12/8
 */
public abstract class Login {

    Register register;

    /**
     * 不亲自处理注册逻辑，而是委托给接口对象
     */
    public void performRegister(){
        register.register();
    }

    /**
     * 登录
     */
    abstract void login();

    /**
     * 注销
     */
    void logout(){
        System.out.println("用户注销，退出登录");
    }
}
