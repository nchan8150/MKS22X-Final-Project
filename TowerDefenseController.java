import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

