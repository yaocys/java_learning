package Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author yaosunique@gmail.com
 * 2024/7/16 16:41
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Child extends Father implements Serializable {
    private Integer gender;

    public Child(Integer gender, String key, Integer value, User user) {
        super(value, key, user);
        this.gender = gender;
    }

    public String toString() {
        return super.toString() + "child：" + gender;
    }
}
