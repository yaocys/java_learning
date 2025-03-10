import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

import java.util.ArrayList;

public class TempTest {

    public static void main(String[] args) {
        JSONObject json = new JSONObject();
        json.put("key",new ArrayList<>());
        System.out.println(json.toJSONString());
    }
}
