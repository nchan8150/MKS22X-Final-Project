import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.net.ssl.SSLContext;
import javax.swing.JRadioButton;

public class TowerDefenseController implements StateObserver, MouseListener, ActionListener, KeyListener {

	private TowerDefenseModel model;
	private TowerDefenseView view;
	private JRadioButton selectedButton;
	private SquareCoordinate selectedSquare = new SquareCoordinate(4, 3);

	public TowerDefenseController(TowerDefenseModel model, TowerDefenseView view) {
		this.model = model;
		this.view = view;
		model.registerStateObserver(this);
		view.addMouseListener(this);
		view.addKeyListener(this);
		view.getStoreButtons().get(0).setSelected(true);
		selectedButton = view.getStoreButtons().get(0);
		for (JRadioButton button : view.getStoreButtons()) {
			button.addActionListener(this);
		}
		view.getNameTextField().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				nameTyped(arg0);
			}
			
		});
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		if (selectedButton == null)
			return;
		if (model.isGameOver())
			return;

		int x = arg0.getX();
		int y = arg0.getY();
		// account for 10px border
		x -= 10;
		y -= 10;
		// each square is 100px side length
		x /= 100;
		y /= 100;

		if (x > Map.COLUMNS)
			return;
		if (y > Map.ROWS)
			return;

		SquareCoordinate position = new SquareCoordinate(x, y);
		attemptPurchase(position);
		
		view.requestFocus();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		selectedButton = ((JRadioButton) arg0.getSource());
		view.requestFocus();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	
	private Purchasable getSelectedItem(SquareCoordinate position) {
		if (selectedButton == null)
			return null;
		switch (selectedButton.getText()) {
		case "[10 points] Basic Turret":
			return (new BasicTurret(position));
		case "[20 points] Circle Turret":
			return (new CircleTurret(position));
		case "[30 points] Aim Turret":
			return (new AimTurret(position));
		case "[50 points] Homing Turret":
			return (new HomingTurret(position));
		default:
			return null;
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();

		if (e.getKeyChar() == 'm')
			model.cheat();
		if (e.getKeyChar() == ' ')
			model.togglePause();
		if (e.getKeyChar() == 'r')
			model.restart();
		if (e.getKeyChar() == 'a')
			model.advanceLevel();
	}
}

