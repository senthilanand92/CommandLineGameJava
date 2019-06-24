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

import com.game.application.GameConstants;
import com.game.application.model.GameStateMemento;

public class SimpleSaveGameStrategy implements SaveGameStrategy,GameConstants{
	
	public List<GameStateMemento> loadSavedGamesList(){
		List<GameStateMemento> savedGamesList= new ArrayList<GameStateMemento>();
        InputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        boolean readMore = true;
        try{
        	fileInputStream = new FileInputStream(saveFileName);
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
        catch(EOFException e){
        	System.out.println("File read Complete");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            try {
                if(objectInputStream != null) objectInputStream.close();
            } catch (Exception ex){
                 
            }
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
         
		return savedGamesList;
	}

	public boolean saveGame(GameStateMemento memento) {
		
		 OutputStream ops = null;
	     ObjectOutputStream objOutputStream = null;
	     try {
	            if(checkForFileExists())
	            {
	            	 ops = new FileOutputStream(saveFileName,true);
	            	 objOutputStream= new AppendingObjectOutputStream(ops);	
	            }
	            else{
	            	 ops = new FileOutputStream(saveFileName,true);
	            	 objOutputStream = new ObjectOutputStream(ops);
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
	            } catch (Exception ex){
	                 
	            }
	        }
		return false;
	}
	
	private boolean checkForFileExists(){
		
		File fileObj = new File(saveFileName);
		
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
	    // do not write a header, but reset:
	    // this line added after another question
	    // showed a problem with the original
	    reset();
	  }

	}
