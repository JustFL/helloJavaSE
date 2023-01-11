package base;

import java.util.Arrays;

/**
 * 可变参数
 * 底层就是数组 位置只能在参数列表的最后一个
 * @author summerKiss
 *
 */

class VA{
    public void show(int... args){
        System.out.println(Arrays.toString(args));
        System.out.println(args.length);
    }
}

public class VariableArguments {
    public static void main(String[] args) {
        VA va = new VA();
        va.show(1,2,3);
    }
}
