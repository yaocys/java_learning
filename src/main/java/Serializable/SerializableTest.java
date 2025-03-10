package Serializable;

import java.io.*;

/**
 * @author yaosunique@gmail.com
 * 2024/7/16 16:34
 */
public class SerializableTest {

    public static void main(String[] args) {
        // 测试父类实现序列化则子类不再需要实现
        Child child = new Child(0, "key", 11,null);
        User user = new User("张三",24);
        child.setUser(user);
        FileInputStream inputStream;
        FileOutputStream outputStream;
        ObjectInputStream objectInputStream;
        ObjectOutputStream objectOutputStream;

        try {
            outputStream = new FileOutputStream("test1.txt");
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(child);
            objectOutputStream.close();

            inputStream = new FileInputStream("test1.txt");
            objectInputStream = new ObjectInputStream(inputStream);
            Child childRead = (Child) objectInputStream.readObject();
            System.out.println(childRead);

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
