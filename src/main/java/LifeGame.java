import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LifeGame extends JFrame{
	private final World world;
	public final Thread mainThread;

	public LifeGame(int rows,int columns)
	{
		world=new World(rows, columns);
		mainThread = new Thread(world);
		mainThread.start();

		add(world);
	}
	public static void main(String[]args)
	{
		LifeGame frame=new LifeGame(40, 50);
		
		JMenuBar menu=new JMenuBar();
		frame.setJMenuBar(menu);
		
		JMenu options =new JMenu("Options");
		menu.add(options);
		
		JMenuItem arrow=options.add("Arrow");
		arrow.addActionListener(frame.new ArrowActionListener());
		JMenuItem square=options.add("Square");
		square.addActionListener(frame.new SquareActionListener());

		JMenu control=new JMenu("control");
		menu.add(control);

		JMenuItem wait=control.add("Stop");
		wait.addActionListener(frame.new waitActionListener());
		JMenuItem slower=control.add("Slower");
		slower.addActionListener(frame.new fasterActionListener());
		JMenuItem faster=control.add("Faster");
		faster.addActionListener(frame.new slowerActionListener());


		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1007,859);
		frame.setTitle("生命游戏");
		frame.setVisible(true);
		frame.setResizable(false);


//		JMenu wait = new JMenu("Wait");
//		menu.add(wait);
//		wait.addActionListener(frame.new waitActionListener());
	}
	class ArrowActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			world.setArrow();
		}
	}
	class SquareActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			world.setSquare();
		}
	}

	class waitActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			world.setFlag();
		}
	}

	class slowerActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			world.slower();
		}
	}

	class fasterActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			world.faster();
		}
	}
}
