import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class TowerDefenseView extends JFrame {

	public final int WIDTH = 1280;
	public final int HEIGHT = 720;

	private GamePanel gamePanel;
	private ControlPanel controlPanel;

	private TowerDefenseModel model;
	private ArrayList<JRadioButton> storeButtons = new ArrayList<JRadioButton>();
	private long purchaseErrorMessageShown;
	private SquareCoordinate selectedSquare;

	public TowerDefenseView() {

		gamePanel = new GamePanel();
		controlPanel = new ControlPanel();
		gamePanel.setPreferredSize(new Dimension(WIDTH - 260, HEIGHT));
		controlPanel.setPreferredSize(new Dimension(260, HEIGHT));

		this.add(gamePanel, BorderLayout.WEST);
		this.add(controlPanel, BorderLayout.EAST);

		this.setSize(1280, 720);
		this.setTitle("Tower Defense");
		this.setResizable(false);
		this.setVisible(true);
		
		this.requestFocus();
	}

	public void setState(TowerDefenseModel model) {
		this.model = model;
		if (model.getCurrentTick() - purchaseErrorMessageShown > 4000 / model.TICK_FREQUENCY)
			clearPurchaseErrorMessage();
	}

