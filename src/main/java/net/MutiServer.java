package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

class ServerThread extends Thread{

    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream in = null;
        BufferedReader br = null;
        try {
            in = socket.getInputStream();
            br = new BufferedReader(new InputStreamReader(in));
            String tmp;
            StringBuffer sb = new StringBuffer();
            while((tmp = br.readLine()) != null) {
                sb.append(tmp);
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            br.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

public class MutiServer {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(12000);

        while(true) {
            Socket socket = serverSocket.accept();
            ServerThread serverThread = new ServerThread(socket);
            serverThread.start();
        }
    }
}
