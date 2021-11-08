
package com.mikhail_golovackii.javacore.chapter22;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class WriteServer {
    public static int serverPort = 998;
    public static int clientPort = 999;
    public static int bufferSize = 1024;
    public static DatagramSocket datagramSocket;
    public static byte buffer[] = new byte[bufferSize];
    
    public static void TheServer() throws Exception{
        int pos = 0;
        
        while(true){
            int c = System.in.read();
            
            switch(c){
                case -1:
                    System.out.println("Сервер завершает сеанс связи");
                    datagramSocket.close();
                    return;
                case '\r':
                    break;
                case '\n':
                    datagramSocket.send(new DatagramPacket(buffer, pos, InetAddress.getLocalHost(), clientPort));
                    pos = 0;
                    break;
                default:
                    buffer[pos++] = (byte) c;
            }
        }
    }
    
    public static void TheClient() throws Exception{
        while(true){
            DatagramPacket p = new DatagramPacket(buffer, buffer.length);
            datagramSocket.receive(p);
            System.out.println(new String(p.getData(), 0, p.getLength()));
        }
    }
    
    public static void main(String args[]) throws Exception{
        if(args.length == 1){
            datagramSocket = new DatagramSocket(serverPort);
            TheServer();
        }
        else{
            datagramSocket = new DatagramSocket(clientPort);
            TheClient();
        }
    }
}
