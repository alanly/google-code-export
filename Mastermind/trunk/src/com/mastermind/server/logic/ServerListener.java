/**
 * 
 */
package com.mastermind.server.logic;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.mastermind.server.util.ConsoleUtilities;

/**
 * The <code>ServerListener</code> class listens for and handles client connections to the Mastermind server. 
 * @author Alan Ly
 * @version 1.0
 */
public class ServerListener {
    
    /**
     * Specifies the default listening port as 30,000.
     */
    private static final int DEFAULT_LISTENING_PORT = 30000;
    
    private int listeningPort;
    private boolean listenForConnection;
    
    /**
     * Create a <code>ServerListener</code> with the default listening port to listen for and handle client connections to the Mastermind server.
     */
    public ServerListener() {
	this(DEFAULT_LISTENING_PORT);
    }
    
    /**
     * Create a <code>ServerListener</code> with a specified listening port to listen for and handle client connections to the Mastermind server.
     * @param listeningPort the port on which to listen to for client connections
     */
    public ServerListener(int listeningPort) {
	super();
	this.listeningPort = listeningPort;
    }
    
    /**
     * Gets the current listening port number of the server.
     * @return the port number to listen on
     */
    public int getListeningPort() {
	return this.listeningPort;
    }
    
    /**
     * Sets the current listening port number of the server.
     * @param listeningPort the port number to listen on
     */
    public void setListeningPort(int listeningPort) {
	this.listeningPort = listeningPort;
    }
    
    /**
     * Starts listening for connections from clients on the appropriate listening port.
     * 
     * When a client connects, a <code>Socket</code> reference is created for the client and a new <code>ServerThread</code> is created to handle the client.
     * @throws IOException thrown when a socket is unable to be opened
     */
    public void startListening() throws IOException {
	ServerSocket serverSocket = null;
	Socket clientSocket = null;
	
	// Opens a ServerSocket on the port specified by the 'listeningPort' variable
	try {
	    serverSocket = new ServerSocket(this.listeningPort);
	    
	    // Enable server to listen for connection
	    this.listenForConnection = true;
	    
	    // Print out listening header for status
	    System.out.println("[" + ConsoleUtilities.generateTimeStamp() + "] Server listening on port " + this.listeningPort + "...");
	    
	    // Run loop while condition is true to listen for clients
	    while(this.listenForConnection) {
		// Get client connection
		clientSocket = serverSocket.accept();
		
		// Print status message for client connection
		System.out.println("[" + ConsoleUtilities.generateTimeStamp() + "] Client connection from " + clientSocket.getInetAddress().getHostName());
		
		// Create a ServerThread
		ServerThread serverThread = new ServerThread(clientSocket);
		
		// Start handling client
		serverThread.startThread();
	    }
	} catch(IOException ioe) {
	    // Throw new IOException with the appropriate message
	    throw new IOException("Unable to open server socket on port " + this.listeningPort);
	} finally {
	    // Close the client socket if necessary
	    if(clientSocket.isConnected())
		clientSocket.close();
	    
	    // Close the server socket if necessary
	    if(!serverSocket.isClosed())
		serverSocket.close();
	}
    }
    
    public void stopListening() {
	this.listenForConnection = false;
    }
    
}
