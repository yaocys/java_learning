package design_parrterns.bridging;

/**
 * @author yao 2022/9/21
 */
public class BossCar extends RefinedCar{

    public BossCar(Engine engine) {
        super(engine);
    }

    @Override
    public String getBrand() {
        return "Boss";
    }
}
