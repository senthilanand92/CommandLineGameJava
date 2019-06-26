package com.game.application.model;

public abstract class Enemy {
	
	protected Long health;
	protected Long strength;
	protected Long expPoints;
	protected String name;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expPoints == null) ? 0 : expPoints.hashCode());
		result = prime * result + ((health == null) ? 0 : health.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((strength == null) ? 0 : strength.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enemy other = (Enemy) obj;
		if (expPoints == null) {
			if (other.expPoints != null)
				return false;
		} else if (!expPoints.equals(other.expPoints))
			return false;
		if (health == null) {
			if (other.health != null)
				return false;
		} else if (!health.equals(other.health))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (strength == null) {
			if (other.strength != null)
				return false;
		} else if (!strength.equals(other.strength))
			return false;
		return true;
	}
	abstract public void setHealth(Long health);
	abstract public Long getHealth();
	abstract public Long getStrength();
	abstract public Long getExpPoints();
	abstract public void attack(boolean isAttackSuccessful,Player player);
	abstract public void defend(boolean isDefendSuccessful,Player player);
	abstract public void printStats();

}
