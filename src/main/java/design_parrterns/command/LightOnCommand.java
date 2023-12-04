package design_parrterns.command;

/**
 * 命令对象将接收者和具体的动作封装
 * @author yaosunique@gmail.com
 * 2023/10/15 22:21
 */
public class LightOnCommand implements Command{
    Light light;
    public LightOnCommand(Light light){
        this.light = light;
    }
    @Override
    public void execute() {
        light.on();
    }
}
