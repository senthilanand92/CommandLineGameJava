package com.game.application.utility;

import java.util.List;
import java.util.Scanner;

import com.game.application.exceptions.InvalidInputException;

public class IOUtility {
	
	private static IOUtility instance= null;
	
	public static String OPERATION_SEPERATOR="--------------------";
	
	Scanner input= null;
	
	private IOUtility(){
		this.input=new Scanner(System.in);
	}
	
	public static IOUtility getInstance(){
		if(instance==null){
			instance=new IOUtility();
		}
		return instance;
	}
	
	public String getStringInput() throws InvalidInputException{
		String returnString="";
		try{
			returnString= input.next();
		}
		catch(Throwable t){
			throw new InvalidInputException("Invalid Input");
		}
		
		return returnString;
	}
	
	public void getAnyInput() {
		try{
			input.reset();
			String temp=input.nextLine();
		}
		catch(Throwable t){
			printOutput("An Error has occured");
		}
	}
	
	
	public Integer getIntegerInput() throws InvalidInputException{
		Integer returnInteger=null;
		try{
			while (!input.hasNextInt()) {
				   System.out.println("int, please!");
				   input.nextLine();
				}
		returnInteger=input.nextInt();
		}
		catch(Throwable t){
			throw new InvalidInputException("Invalid Input");
		}
		return returnInteger;
	}
	
	public  void printOutput(String msg){
		
		System.out.println(msg);
	}
	
public  void printOutputWithoutNewLine(String msg){
		
		System.out.print(msg);
	}
	
	public  void printSeperator(){
		
		System.out.println(OPERATION_SEPERATOR);
	}
	
	public  void printCommands(List<String> inGameOptions){
		printOutput("Use one of these commands :");
		printOutputWithoutNewLine("[");
		for(String Option:inGameOptions){
			printOutputWithoutNewLine(" ["+Option+"] ");
		}
		printOutput("]");
		
	}
	
	
	

}
