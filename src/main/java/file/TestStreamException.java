package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestStreamException {

    public static void main(String[] args) {
        File file = null;
        FileInputStream fs = null;
        try {
            //1
            file = new File("StreamTest.txt");
            fs = new FileInputStream(file);
            //2
            byte[] b = new byte[fs.available()];
            fs.read(b);
            System.out.println(new String(b,"gbk"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fs != null) {
                    fs.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
