package dmbpl;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;

public class GraphUsInterf extends JFrame {
	private static final int WIDTH = 600;
	private static final int HEIGHT = 450;
	private JTable table;
	
	public GraphUsInterf() {
		this.setTitle("DamberPol");
		Dimension frameSize = new Dimension(WIDTH, HEIGHT);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		if (frameSize.height > screenSize.height)
			frameSize.height = screenSize.height;
		if (frameSize.width > screenSize.width)
			frameSize.width = screenSize.width;
		setSize(frameSize);
		setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		getContentPane().setLayout(null);
		
		JPanel toolbarPan = new JPanel();
		toolbarPan.setBounds(0, 0, 584, 70);
		getContentPane().add(toolbarPan);
		toolbarPan.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JToolBar toolBar = new JToolBar();
		toolbarPan.add(toolBar);
		
		JPanel tablePan = new JPanel();
		tablePan.setBounds(0, 70, 472, 310);
		getContentPane().add(tablePan);
		tablePan.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		table = new JTable();
		tablePan.add(table);
		
		JPanel btnPan = new JPanel();
		btnPan.setBounds(472, 70, 112, 310);
		getContentPane().add(btnPan);
		btnPan.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Dodaj");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnPan.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Edytuj");
		btnPan.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Usu\u0144");
		btnPan.add(btnNewButton_2);
		
		JPanel infoPan = new JPanel();
		infoPan.setBounds(0, 380, 584, 31);
		getContentPane().add(infoPan);

	}
}
