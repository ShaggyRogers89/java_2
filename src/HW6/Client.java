package HW6;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client {

    public static void main(String[] args) throws IOException {
        ServerSocket server = null;
        Socket socket = null;
        Scanner scanner = new Scanner(System.in);


        try {
            socket = new Socket("localhost", 8188);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            System.out.println("Подключен к серверу");

            Thread threadRead = new Thread(() -> {
                try {
                    while (true) {
                        System.out.println("Скажите что-нибудь серверу: ");
                        out.writeUTF(scanner.nextLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            threadRead.start();

            while (true) {
                String msg = in.readUTF();
                if (msg.equals("/end")) {
                    System.out.println("Сервер отключился");
                    out.writeUTF("/end");
                    break;
                } else {
                    System.out.println("Сервер пишет:" + msg);
                }
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}