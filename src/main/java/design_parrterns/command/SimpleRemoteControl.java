package design_parrterns.command;

/**
 * @author yaosunique@gmail.com
 * 2023/10/15 22:23
 */
public class SimpleRemoteControl {
    Command slot;
    public SimpleRemoteControl(){}

    public void setCommand(Command command){
        slot = command;
    }

    public void buttonWasPressed(){
        slot.execute();
    }
}
