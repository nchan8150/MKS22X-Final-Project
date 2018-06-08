import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

public class TowerDefenseModel implements ActionListener {

	public static final int TICK_FREQUENCY = 60; // in Hz

	private long currentTick;
	private int points;
	private int totalKills;
	private int totalKillsWhenLevelChanged;
	private int level = 1;
	private boolean paused = false;
	private boolean gameOver = false;
	private Timer tick;
	private Timer update;
	private ArrayList<StateObserver> observers = new ArrayList<StateObserver>();
	private Map map = new Map();
	private ArrayList<Entity> entities = new ArrayList<Entity>();
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private ArrayList<Turret> turrets = new ArrayList<Turret>();	

	
	public boolean isGameOver() {
		return gameOver;
	}

	public void restart() {
		start();
	}
	public void start() {
	
		
		points = 50;
		
		totalKills = 0;
		currentTick = 0;
		totalKillsWhenLevelChanged = 0;
		level = 1;
		paused = false;
		gameOver = false;
		
		if (tick != null)
			tick.stop();
		if (update != null)
			update.stop();
		update = new Timer(1000 / TICK_FREQUENCY, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateStateObservers();
			}
		});
		update.start();
		
		tick = new Timer(1000 / TICK_FREQUENCY, this);
		tick.start();
		
		entities.clear();
		enemies.clear();
		turrets.clear();
		map = new Map();
	}
	
	public void advanceLevel() {
		level++;
	}
	
	
	private void tick() {
		currentTick++;

		for (Entity entity : entities)
			entity.tick();
		for (Turret turret : turrets)
			spawnProjectile(turret.fire(enemies, currentTick));
		for (int i = 0; i < enemies.size(); i++) {
			Enemy enemy = enemies.get(i);
			if (enemy.atBase()) {
				map.getBase().damage();
				enemy.kill();
			}
		}

		interactWithIntersections();
		removeDeadEntities();
		spawnEnemyChance();
		updateLevel();
		
		if (map.getBase().dead()) {
			gameOver();
		}
	}
	
	private void gameOver() {
		gameOver = true;
		pause();
	}

	private void updateLevel() {
		if (totalKills - totalKillsWhenLevelChanged > 30) {
			level++;
			totalKillsWhenLevelChanged = totalKills;
		}
	}

	public int getScore() {
		return totalKills;
	}
	
	public long getCurrentTick() {
		return currentTick;
	}
	
	private int currentEnemyHealth() {
		return (int) ((level * 0.3) + 1);
	}
	
	public void togglePause() {
		if (gameOver)
			return;
		if (paused)
			unpause();
		else
			pause();
	}

	private void pause() {
		tick.stop();
		paused = true;
	}
	private void unpause() {
		tick = new Timer(1000 / TICK_FREQUENCY, this);
		tick.start();
		paused = false;
	}
	
	public void purchase(Purchasable item) throws PurchaseException {
		if (points >= item.getBasePrice()) {
			if (item instanceof Turret) {
				if (map.positionOccupied(item.getPosition()))
					throw new PurchaseException("Square occupied");
				if (addTurret((Turret) item)) {
					points -= item.getValue();
					return;
				}
			}

			throw new PurchaseException();
		}
		throw new PurchaseException("Not enough funds");
	}

	public boolean sell(SquareCoordinate position) {
		if (map.outOfBounds(position) || map.getTurretAt(position) == null)
			return false;

		int value = map.getTurretAt(position).getValue();
		removeTurret(map.getTurretAt(position));
		points += value * 0.2;

		return true;
	}

	private boolean addTurret(Turret turret) {
		if (turret.getX() > Map.COLUMNS - 1)
			return false;
		if (turret.getY() > Map.ROWS - 1)
			return false;
		turrets.add(turret);
		map.setTurret(turret);
		return true;
	}

	private void removeTurret(Turret turret) {
		turrets.remove(turret);
		map.removeTurret(turret);
	}

	public int getPoints() {
		return points;
	}

	private void interactWithIntersections() {
		for (Entity entity : entities) {
			int kills = entity.interactWithIntersections(entities);
			points += kills;
			totalKills += kills;
		}
	}

	private void removeDeadEntities() {
		for (int i = 0; i < entities.size(); i++) {
			if (entities.get(i).isDead()) {
				despawn(entities.get(i));
				i--;
			}
		}
	}

	private void spawnProjectile(Projectile projectile) {
		if (projectile == null)
			return;
		entities.add(projectile);
	}

	private void spawnEnemyChance() {
		spawnEnemyChance(0.01 + (0.002 * level));
	}

	private void spawnEnemyChance(double probability) {
		if (Math.random() <= probability)
			spawnEnemy();
	}

	private void spawnEnemy() {
		Enemy enemy = new Enemy(Enemy.getRandomValidStartingCoordinate(), 3, currentEnemyHealth());
		entities.add(enemy);
		enemies.add(enemy);
	}

	private void despawn(Entity entity) {
		if (entity instanceof Enemy)
			enemies.remove(entity);
		entities.remove(entity);
	}

	public void registerStateObserver(StateObserver observer) {
		observers.add(observer);
	}

	private void updateStateObservers() {
		for (StateObserver observer : observers) {
			observer.stateChanged();
		}
	}

	public Map getMap() {
		return map;
	}

	public List<Entity> getEntities() {
		return entities;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		tick();
	}
}