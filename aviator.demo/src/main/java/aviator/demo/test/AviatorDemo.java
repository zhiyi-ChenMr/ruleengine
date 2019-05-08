package aviator.demo.test;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.googlecode.aviator.AviatorEvaluator;

public class AviatorDemo {
    
    public static void main(String[] args) {  
        String expression = "a + b + c";  
  
        Map<String, Object> params = new HashMap<>();  
        params.put("a", 1);  
        params.put("b", 2);  
        params.put("c", 3);  
  
        long result = (long) AviatorEvaluator.execute(expression, params);  
  
        System.out.printf("result : " + result);  
    }
    
    private void test(String key, Map<String, Object> map) {
        
    }
}  
