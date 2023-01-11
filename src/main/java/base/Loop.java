package base;

public class Loop {

    public static void main(String[] args) {

        //先条件判断 然后执行循环体 直到条件不满足
        int x = 0;
        while(x < 5) {
            System.out.print(x);
            x++;
        }

        System.out.println();

        //先执行一次循环体 再进行判断
        int y = 0;
        do {
            System.out.print(y);
            y++;
        }while(y < 5);

        System.out.println();

        //continue 结束本次循环体的执行 进行下一次条件判断
        //break 结束本次循环
        //return 结束方法体
        a:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(j == 3) {
                    break a;//结束外层循环
                }
                System.out.println("i:"+i+" j:"+j);
            }
        }

    }

}