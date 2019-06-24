package com.game.application.save.Strategy;

import java.util.List;

import com.game.application.model.GameStateMemento;

public interface SaveGameStrategy   {
	
	boolean saveGame(GameStateMemento memento);
	List<GameStateMemento> loadSavedGamesList();

}
