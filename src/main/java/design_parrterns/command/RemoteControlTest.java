package design_parrterns.command;

/**
 * 测试类就是命令模式的用户
 * @author yaosunique@gmail.com
 * 2023/10/15 22:25
 */
public class RemoteControlTest {
    public static void main(String[] args) {
        // 遥控器是一个调用者，会传入一个命令对象，可以用来发出请求
        SimpleRemoteControl remoteControl = new SimpleRemoteControl();
        Light light = new Light();// 电灯对象，请求的接收者
        GarageDoor garageDoor = new GarageDoor();
        // 创建一个命令，并将接收者传递给它
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        GarageDoorOpenCommand garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor);

        remoteControl.setCommand(lightOnCommand);
        remoteControl.buttonWasPressed();
        remoteControl.setCommand(garageDoorOpenCommand);
        remoteControl.buttonWasPressed();
    }
}
