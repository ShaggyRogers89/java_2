package HW6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {
    private static int PORT = 8188;

    public static void main(String[] args) throws IOException {
        ServerSocket server = null;
        Socket socket = null;
        Scanner scanner = new Scanner(System.in);

        try {
            server = new ServerSocket(PORT);
            System.out.println("Сервер запущен");

            socket = server.accept();
            System.out.println("Клиент подключился");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Thread threadRead = new Thread(() -> {
                try {
                    while (true) {
                        System.out.println("Скажите что-нибудь клиенту: ");
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
                    System.out.println("Клиент отключился");
                    out.writeUTF("/end");
                    break;
                } else {
                    System.out.print("Клиент пишет: " + msg);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
