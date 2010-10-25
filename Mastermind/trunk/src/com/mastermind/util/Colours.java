/**
 * 
 */
package com.mastermind.util;

/**
 * The <code>Colours</code> enum class contains the appropriate constant values for every colour used in the Mastermind game.
 * @author Alan Ly
 * @version 1.0
 */
public enum Colours {
	RED(1),
	GREEN(2),
	BLUE(3),
	YELLOW(4),
	PURPLE(5),
	AQUA(6),
	ORANGE(7),
	PINK(8);
	
	private final int colour;
	
	Colours(int colour) {
		this.colour = colour;
	}
	
	public int colour() {
		return this.colour;
	}
}
