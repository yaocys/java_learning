package design_parrterns.strategy.register;

/**
 * @author yao 2022/12/8
 */
public class PhoneRegister implements Register {
    @Override
    public void register() {
        System.out.println("使用手机号码注册");
    }
}
