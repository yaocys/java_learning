package design_parrterns.template_method;

/**
 * @author yaosunique@gmail.com
 * 2023/9/18 16:41
 */
public abstract class CaffeineBeverage {
    final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }
    abstract void brew();
    abstract void addCondiments();
    void boilWater(){}
    void pourInCup(){}
}
