package Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yaosunique@gmail.com
 * 2024/7/16 16:39
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class User implements Serializable {
    private String name;
    public Integer age;
}
