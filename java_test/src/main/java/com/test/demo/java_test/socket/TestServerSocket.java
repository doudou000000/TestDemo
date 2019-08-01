package com.test.demo.java_test.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TestServerSocket {

    public static void main(String args[]){

        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader = null;
        String info = null;
        OutputStream os = null;
        PrintWriter pw = null;
        Scanner clientScanner = null;
        Scanner serverScanner = null;
        try {
            //创建ServerSocket对象
            serverSocket = new ServerSocket(8888);
            //等待客户端的连接
            socket = serverSocket.accept();
            //获取客户端信息
            is = socket.getInputStream();
            clientScanner = new Scanner(is);

            serverScanner = new Scanner(System.in);
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            while (clientScanner.hasNextLine()){
                String clientInfo = clientScanner.nextLine();
                System.out.println("客户端说：" + clientInfo);
//                socket.shutdownInput();
                String serverInfo = serverScanner.nextLine();
                pw.write(serverInfo);
                pw.println();
                pw.flush();

            }


//            inputStreamReader = new InputStreamReader(is);
//            bufferedReader = new BufferedReader(inputStreamReader);
//            while ((info = bufferedReader.readLine()) != null){
//                System.out.println("我是服务端，客户端说：" + info);
//            }
//            socket.shutdownInput();
//            os = socket.getOutputStream();
//            pw = new PrintWriter(os);
//            pw.write("欢迎你来");
//            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(pw != null){
                    pw.close();
                }
                if(os != null){
                    os.close();
                }
                if(bufferedReader != null){
                    bufferedReader.close();
                }
                if(inputStreamReader != null){
                    inputStreamReader.close();
                }
                if(is != null){
                    is.close();
                }
                if(clientScanner != null){
                    clientScanner.close();
                }
                if(serverScanner != null){
                    serverScanner.close();
                }
                if(socket != null){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

}
