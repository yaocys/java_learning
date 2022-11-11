package design_parrterns.bridging;

/**
 * @author yao 2022/9/21
 */
public abstract class Car {
    // 引用Engine:
    protected Engine engine;

    // 桥接一个引擎类作为构造函数
    public Car(Engine engine) {
        this.engine = engine;
    }

    public abstract void drive();
}
