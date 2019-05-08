package aviator.demo.test.qlexpress;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.InstructionSet;

public class QLExpressDemoMain {
    static ExpressRunner runner = new ExpressRunner();
    
    static {
        try {
            runner.addOperatorWithAlias("如果", "if", null);
            runner.addOperatorWithAlias("则", "then", null);
            runner.addOperatorWithAlias("否则", "else", null);
            runner.addOperatorWithAlias("循环", "for", null);
            runner.addOperatorWithAlias("等于", "=", null);
            runner.addOperatorWithAlias("加", "+", null);
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
    public static void main(String[] args) throws Exception {
        
        //context.put("a", 1);
        //context.put("b", 2);
        for (int i = 0; i < 200; i++) {
            Thread thread = new Thread(() -> {
                try {
                    handle();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            },"thread-" + i);
            thread.start();
        }
    }
    
    private static void handle() throws Exception{
        DefaultContext<String, Object> context = new DefaultContext<>();
        List<Integer> list = test(Integer.valueOf(Thread.currentThread().getName().replace("thread-", "")));
        System.out.println(Thread.currentThread().getName() + "  列表数据:" + JSONObject.toJSONString(list));
        context.put("list", list);
        String exp = "int sum = 0;" +
                "for(i = 0;i<list.size();i++){" +
                "sum = sum + list.get(i);" +
                "}" +
                "return sum;";
        System.out.println(Thread.currentThread().getName() + ":" + runner.execute(exp,context,null,false,false,null));
    }
    
    private static List<Integer> test(int i) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(i);
        list.add(i);
        list.add(i);
        
        return list;
    } 
}   
