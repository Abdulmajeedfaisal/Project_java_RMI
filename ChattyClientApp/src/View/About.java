package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Vector;

import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class About extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public Timer timer;
	private int y = 1000,x=0;
	private Vector<String> text;
	private Vector<Image> img;
	
	public About() {
		
		img = new Vector<>();
		
		img.add(Manager.getImg("img/background13.jpg"));
		img.add(Manager.getImg("img/60a5fbdf32727.png"));
		img.add(Manager.getImg("img/fac_eng.jpg"));
		img.add(Manager.getImg("img/contact_us.png"));
		
		text = new Vector<>();

		text.add("               ** About Us **");
		text.add(" ");
		text.add("Superising the enginer : Khawla Al-Hajj");
		text.add("project : RMI chat application");
		text.add("The work of engineers");
		text.add("");
		text.add("1-Arafat Khalil"); //
		text.add("2-Abdulmajeed Faisal ");
//		text.add("");
		text.add("3-Marwan Mohammed");
		text.add("Department of information technology");

		text.add("");
		text.add("                                                 - - - -");
		text.add("");
//		
		timer = new Timer(7, null);
		timer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				action();
			}
		});
		timer.start();

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				x=(getRootPane().getWidth()-940)/2-70;
				repaint();
			}
			@Override
			public void componentHidden(ComponentEvent e) {
				timer.stop();
				y=880;
			}

			@Override
			public void componentShown(ComponentEvent e) {
				timer.start();
			}
		});
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);// clear and repaint
		x=(getRootPane().getWidth()-940)/2-70;
		g.drawImage(img.get(0), 0, 0,getRootPane().getWidth(), getRootPane().getHeight(), this);
		g.drawImage(img.get(1), 780+x, y - 300, 164, 164, this);											
		g.drawImage(img.get(2), 50+x, y - 300, 138, 170, this);
		g.drawImage(img.get(3), 320+x, y + 200 + 17 * 38, 186*2, 230*2, this);
		
		g.setFont(new Font("Broadway", Font.ITALIC, 24));
		g.setColor(Color.WHITE);
		g.drawString("Taiz University", 190 + 50+x, y - 230);
		g.drawString("College of Engineering and Information ", 190 + 50+x, y - 200);

		int l = 0;
		
		for (String t : text) {
			if (l == 0 || l == 19 * 38)
				g.setFont(new Font("Broadway", Font.ITALIC, 60)); 								
			else
				g.setFont(new Font("World of Water", Font.LAYOUT_NO_START_CONTEXT, 30)); // Font.HANGING_BASELINE
			if ((y + l) > 380 && (y + l) < 410) {
				g.setColor(Color.white);
			}
			g.drawString(t, 50+x, y + l); // g.drawString(text.get(0), 50, y);
			g.setColor(Color.black);
			l += 38;
		}	
	}


	private void action() {
		y--;
		repaint();
		if (y <= -2100)
			y = 1000;
		repaint();
	}
}
