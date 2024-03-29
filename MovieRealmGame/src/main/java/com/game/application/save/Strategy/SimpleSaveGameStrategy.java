package com.game.application.save.Strategy;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.game.application.constants.GameConstants;
import com.game.application.model.GameStateMemento;

public class SimpleSaveGameStrategy implements SaveGameStrategy,GameConstants{
	
	public List<GameStateMemento> loadSavedGamesList(){
		List<GameStateMemento> savedGamesList= new ArrayList<GameStateMemento>();
        InputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        boolean readMore = true;
        try{
        	if(checkForFileExists()){
        	fileInputStream = new FileInputStream(utility.getSaveGameFileName());
            objectInputStream = new ObjectInputStream(fileInputStream);
           while(readMore){
        	   GameStateMemento savedGameMemento = (GameStateMemento) objectInputStream.readObject();
        	   System.out.println("Read Memento:"+savedGameMemento);
              if(savedGameMemento != null)
            	  savedGamesList.add(savedGameMemento);
              else
            	  readMore = false;
           }
        	}
        }
        catch(EOFException e){
        	System.out.println("File read Complete");
        }
        catch (FileNotFoundException exception) {
        	exception.printStackTrace();
        } catch (IOException exception) {
        	exception.printStackTrace();
            try {
                if(objectInputStream != null) objectInputStream.close();
            } catch (Exception exceptionsStream){
            	exceptionsStream.printStackTrace();
            }
        } catch (ClassNotFoundException exception) {
        	exception.printStackTrace();
		}
         
		return savedGamesList;
	}

	public boolean saveGame(GameStateMemento memento) {
		
		 OutputStream outputStream = null;
	     ObjectOutputStream objOutputStream = null;
	     try {
	            if(checkForFileExists())
	            {
	            	outputStream = new FileOutputStream(utility.getSaveGameFileName(),true);
	            	 objOutputStream= new AppendingObjectOutputStream(outputStream);	
	            }
	            else{
	            	outputStream = new FileOutputStream(utility.getSaveGameFileName(),true);
	            	 objOutputStream = new ObjectOutputStream(outputStream);
	            }
	            objOutputStream.writeObject(memento);
	            objOutputStream.flush();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally{
	            try{
	                if(objOutputStream != null) objOutputStream.close();
	            } catch (Exception exception){
	            	exception.printStackTrace();
	            }
	        }
		return false;
	}
	
	private boolean checkForFileExists(){
		
		File fileObj = new File(utility.getSaveGameFileName());
		
		if(fileObj.exists())
			return true;
		
		return false;
	}

}

class AppendingObjectOutputStream extends ObjectOutputStream {

	  public AppendingObjectOutputStream(OutputStream out) throws IOException {
	    super(out);
	  }

	  @Override
	  protected void writeStreamHeader() throws IOException {
	    reset();
	  }

	}
