package dmbpl;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// GraphUsInterf gui = new GraphUsInterf();
		// gui.setVisible(true);
		// gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ConnectSql conn = new ConnectSql();
		conn.getConnection();

	}

}
