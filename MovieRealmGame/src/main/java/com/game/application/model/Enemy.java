package com.game.application.model;

public abstract class Enemy {
	
	protected Long health;
	protected Long strength;
	protected Long expPoints;
	protected String name;
	
	abstract public void setHealth(Long health);
	abstract public Long getHealth();
	abstract public Long getStrength();
	abstract public Long getExpPoints();
	abstract public void attack(boolean isAttackSuccessful,Player player);
	abstract public void defend(boolean isDefendSuccessful,Player player);
	abstract public void printStats();

}
