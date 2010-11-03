/**
 * 
 */
package com.mastermind.util;

/**
 * Contains the constant values that are necessary for the general functionality of the <strong>Mastermind</strong> game. Constants are universal between client and server units.
 * 
 * @author Alan Ly
 * @version 1.0
 */
public class GameConstants {
	
	/**
	 * The constant value that specifies the length of the answer values, as in the number of colours representing the answer at a specific time.
	 */
	public static final int ANSWER_LENGTH = 4;
	
	/**
	 * The constant value that specifies the length of the byte buffer that is used to communicate between the client and server.
	 */
	public static final int BUFFER_LENGTH = 5;
	
	/**
	 * The constatn value that specifies the maximum number of guesses before the player loses the game.
	 */
	public static final int MAX_NUM_OF_GUESSES = 10;

}