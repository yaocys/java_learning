package design_parrterns.command;

/**
 * @author yaosunique@gmail.com
 * 2023/10/15 22:33
 */
public class GarageDoorOpenCommand implements Command{
    GarageDoor garageDoor;
    public GarageDoorOpenCommand(GarageDoor garageDoor){
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.up();
    }
}
