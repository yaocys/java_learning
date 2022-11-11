package design_parrterns.bridging;

/**
 * @author yao 2022/9/21
 *
 * 桥接模式——抽象与实现分离
 */
public class Test {

    public static void main(String[] args) {
        RefinedCar car = new BossCar(new HybirdEngine());
        car.drive();
    }
}
