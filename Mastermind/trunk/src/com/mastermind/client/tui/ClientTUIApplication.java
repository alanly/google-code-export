/**
 * Contains all the classes that are use to present a text-based interactive user interface.
 */
package com.mastermind.client.tui;

/**
 * @author Alan Ly
 * @version 1.0
 */
public class ClientTUIApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create a new TextInterface
		TextInterface tui = new TextInterface();
		
		// Try to run the interface; if exception encountered, simply display the message.
		try{
			tui.run();
		} catch (Exception e) {
			System.err.println("\nError: " + e.getMessage());
		}

	}

}