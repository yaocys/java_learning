package design_parrterns.template_method;

/**
 * @author yaosunique@gmail.com
 * 2023/9/18 16:30
 */
public class Tea {

    void prepareRecipe(){
        boilWater();
        steepTeaBag();
        pourInCup();
        addLemon();
    }

    public void boilWater(){}

    public void steepTeaBag(){}

    public void pourInCup(){}

    public void addLemon(){}
}
