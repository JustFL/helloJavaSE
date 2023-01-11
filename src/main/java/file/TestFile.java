package file;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
/**
 * File类既可以对文件进行操作 也可以对文件夹进行操作
 * */
public class TestFile {

    //递归显示一个文件夹中的所有文件和子文件夹中的所有文件
    public void show(String path) {
        File filepath = new File(path);
        if (filepath.isFile()) {
            System.out.println(filepath.getAbsolutePath());
        }else if(filepath.isDirectory()) {
            File[] files = filepath.listFiles();
            for(File f : files) {
                if (f.isFile()) {
                    System.out.println(f.getName());
                }
                else if (f.isDirectory()) {
                    System.out.println("目录名字是："+f.getName());
                    show(f.getAbsolutePath());
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        /**
         * 文件操作
         * */
        //这里的pathname可以写绝对路径 也可以写相对路径 相对路径就是相对于这个项目的路径
        File file = new File("FileTest.txt");

        //判断文件或者文件夹是否存在
        System.out.println(file.exists());

        //判断是否是文件
        System.out.println(file.isFile());

        //创建文件
        file.createNewFile();

        //路径和文件名
        System.out.println(file.getName());
        System.out.println(file.getPath());//相对于这个项目的路径
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getParent());

        //是否可读可写
        System.out.println(file.canRead());
        System.out.println(file.canWrite());

        //最后一次修改的时间
        long modify_time = file.lastModified();
        System.out.println(DateFormat.getDateInstance().format(new Date(modify_time)));

        //获取文件内容的字节数
        System.out.println(file.length());

        //删除
        file.delete();

        /**
         * 目录操作
         * */
        System.out.println("----------文件夹-------------");
        //这里的pathname可以写绝对路径 也可以写相对路径 相对路径就是相对于这个项目的路径
        File path = new File("FileTestfolder");

        //判断文件或者文件夹是否存在
        System.out.println(path.exists());

        //判断是否是文件夹
        System.out.println(path.isDirectory());

        //创建文件夹
        path.mkdir();

        //级联创建文件夹
        path.mkdirs();

        //获取目录下的所有的文件和文件夹的名称 String形式
        String[] str = path.list();
        for (String s : str) {
            System.out.println(s);
        }

        //使用文件过滤器
        System.out.println("------------文件过滤器String形式------------------");
        String[] str1 = path.list(new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith("java");
            }
        });
        //文件过滤器lambda写法
        str1 = path.list((dir,name)->name.endsWith("java"));
        Arrays.stream(str1).forEach(System.out::println);

        //获取目录下的所有的文件和文件夹的名称 File形式
        System.out.println("------------文件过滤器File形式------------------");
        File[] files = path.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                System.out.println(f.getPath());
            } else {
                System.out.println(f.getName());
            }
        }

        //删除文件夹
        path.delete();

        new TestFile().show("E:\\Japan");
    }

}
