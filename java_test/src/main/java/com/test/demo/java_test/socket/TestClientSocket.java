package com.test.demo.java_test.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TestClientSocket {

    public static void main(String args[]){

        Socket socket = null;
        OutputStream os = null;
        PrintWriter pw = null;
        InputStream is = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        String info = null;
        Scanner clientScanner = null;
        Scanner serverScanner = null;
        try {
            socket = new Socket("localhost",8888);
            clientScanner = new Scanner(System.in);
            serverScanner = new Scanner(socket.getInputStream());
            os = socket.getOutputStream();

            pw = new PrintWriter(os);

            while (clientScanner.hasNextLine()){
                String clientInfo = clientScanner.nextLine();
                pw.write(clientInfo);
                pw.println();
                pw.flush();
//                socket.shutdownOutput();

                String serverInfo = serverScanner.nextLine();
                System.out.println("服务端说：" + serverInfo);
            }



//            is = socket.getInputStream();
//            inputStreamReader = new InputStreamReader(is);
//            bufferedReader = new BufferedReader(inputStreamReader);
//            while ((info = bufferedReader.readLine()) != null){
//                System.out.println("我是客户端，服务端说：" + info);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(bufferedReader != null){
                    bufferedReader.close();
                }
                if(inputStreamReader != null){
                    inputStreamReader.close();
                }
                if(is != null){
                    is.close();
                }
                if(pw != null){
                    pw.close();
                }
                if(os != null){
                    os.close();
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
            }catch (IOException e1){
                e1.printStackTrace();
            }
        }


    }

}
