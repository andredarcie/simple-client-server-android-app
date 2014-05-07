package com.clienteandroid;

import java.net.Socket;

/**
 * ClienteAndroid - ultima modificação 28/04.
 * @author Andre N. Darcie , Alex Benevides.
 */

public class ConnectionSocket {

	private static ConnectionSocket connection;
	private int porta;
	private String host;
	private Socket socket;
	public static final int CONNECTED = 1;
	public static final int ERROR = 2;
	public static final int SENDING_MESSAGE = 3;
	public static final int DISCONNECTED = 4;
	
	private ConnectionSocket(String host, String porta) {
		this.host = host;
		this.porta = Integer.parseInt(porta);
	}

	// Método que cria Objecto ConnectionSocket
	public static ConnectionSocket createConnection(String host, String porta) {
		connection = new ConnectionSocket(host, porta);
		return connection;
	}

	// Retorna conexão atual
	public static ConnectionSocket getCurentConnection() {
		return connection;
	}

	// Conecta com o Servidor
	public void connect() throws Exception {
		this.socket = new Socket(host, porta);
	}

	// Método para disconectar do Servidor
	public void disconnect() throws Exception {
		socket.close();
	}
}
