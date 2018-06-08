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
