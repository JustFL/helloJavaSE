package net;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MutiClient2 {
    public static void main(String[] args) throws UnknownHostException, IOException {

        Socket socket = new Socket("localhost", 12000);

        OutputStream out = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(out);
        pw.println("i always miss you");
        pw.flush();


        pw.close();
        socket.close();
    }
}
