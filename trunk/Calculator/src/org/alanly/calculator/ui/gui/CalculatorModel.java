/**
 * Contains the coding that will handle the front-end interface and logic.
 */
package org.alanly.calculator.ui.gui;

import java.util.Observable;

import org.alanly.calculator.logic.CalculatorInputHandler;

/**
 * The <code>CalculatorModel</code> is responsible for managing the relationship between viewers and the controller.
 * 
 * @author Alan Ly
 * @version 1.0
 */
public class CalculatorModel extends Observable {
	
	private CalculatorInputHandler inputHandler;
	private String outputString;
	
	/**
	 * Creates a <code>CalculatorModel</code> with an initial observed string of <strong>null</strong>.
	 */
	public CalculatorModel() {
		this("0");
		System.out.println("getOutput() = " + this.inputHandler.getOutput());
	}
	
	/**
	 * Creates a <code>CalculatorModel</code> with an initial observed string value specified via parameter.
	 * 
	 * @param initialValue the initial value to be observed
	 */
	public CalculatorModel(String initialValue) {
		super();
		this.inputHandler = new CalculatorInputHandler();
		this.setInput(initialValue);
	}
	
	/**
	 * Sets the input value from the controller and notifies the <code>Observer</code> of the resulting output.
	 * 
	 * @param inputValue the new string value to be observed
	 */
	public void setInput(String inputValue) {
		// Process new Observed value
		this.inputHandler.keyInput(inputValue);
		
		// Get the result and set the observed string
		this.outputString = this.inputHandler.getOutput();
		
		// Notify all Observers
		this.setChanged();
		this.notifyObservers(this.outputString);
	}
	
	/**
	 * Gets the output string of the model being observed.
	 * 
	 * @return the output value being observed
	 */
	public String getOutput() {
		return this.outputString;
	}

}