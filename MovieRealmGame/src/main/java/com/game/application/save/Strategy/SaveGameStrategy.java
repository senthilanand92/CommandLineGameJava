package com.game.application.save.Strategy;

import java.util.List;

import com.game.application.model.GameStateMemento;
import com.game.application.utility.IOUtility;

public interface SaveGameStrategy   {
	IOUtility utility=IOUtility.getInstance();
	
	boolean saveGame(GameStateMemento memento);
	List<GameStateMemento> loadSavedGamesList();

}
