package org.example.DZ5_1.ChatServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    //region Поля

    /**
     * Серверный сокет
     */
    private final ServerSocket serverSocket;

    //endregion


    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void runServer(){

        try {
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                System.out.println("Подключен новый клиент!");
                ClientManager clientManager = new ClientManager(socket);
                Thread thread = new Thread(clientManager);
                thread.start();
            }
        }
        catch (IOException e){
            closeSocket();
        }

    }

    private void closeSocket(){
        try{
            if (serverSocket != null) serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
