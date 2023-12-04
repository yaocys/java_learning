package design_parrterns.template_method;

/**
 * @author yaosunique@gmail.com
 * 2023/9/18 16:25
 */
public class Coffee {
    /**
     * 这是整体的冲泡步骤，每个具体的方法有单独的实现
     */
    void prepareRecipe(){
        boilWater();
        brewCoffeeGrinds();
        pourInCup();
        addSugarAndMilk();
    }

    public void boilWater(){}

    public void brewCoffeeGrinds(){}

    public void pourInCup(){}

    public void addSugarAndMilk(){}
}
