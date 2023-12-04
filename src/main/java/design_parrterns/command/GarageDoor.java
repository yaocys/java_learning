package design_parrterns.command;

/**
 * @author yaosunique@gmail.com
 * 2023/10/15 22:31
 */
public class GarageDoor {
    public void up(){
        System.out.println("up");
    }
    public void down(){
        System.out.println("down");
    }
    public void stop(){
        System.out.println("stop");
    }
    public void lightOn(){
        System.out.println("light on");
    }
    public void lightOff(){
        System.out.println("light off");
    }
}
