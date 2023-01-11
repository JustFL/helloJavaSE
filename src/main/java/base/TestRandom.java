package base; /**
 * 随机数
 * @author summerKiss
 *
 */

import java.util.Random;

public class TestRandom {
    public static void main(String[] args) {
        Random r = new Random();

        //int范围内产生随机数
        int n1 = r.nextInt();
        System.out.println(n1);

        //限定范围内产生随机数
        int n2 = r.nextInt(5);
        System.out.println(n2);

        System.out.println(TestRandom.anyRandom(23, 45));
    }

    public static int anyRandom(int lower,int upper) {
        //因为random函数是[)所以需要+1
        int n = (int)(Math.random()*(upper-lower+1)+lower);
        return n;
    }

}
