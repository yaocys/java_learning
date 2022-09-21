package design_parrterns.bridging;

/**
 * @author yao 2022/9/21
 */
public abstract class RefinedCar extends Car{
    public RefinedCar(Engine engine) {
        super(engine);
    }

    public void drive(){
        this.engine.start();
        System.out.println("Drive " + getBrand() + " car...");
    }

    public abstract String getBrand();
}
