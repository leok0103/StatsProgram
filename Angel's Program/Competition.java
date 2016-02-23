import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Competition extends JFrame implements MouseListener {
	private static final long serialVersionUID = 0;

	private final String matchFile = "testo.txt";
	private final String mainFile = "main.txt";
	private final String scheduleFile = "Schedule.txt";

	private ArrayList<Team> listTeams;

	private int MatchesNos;

	private Schedule sch;
	private boolean rnda;

	public Competition() {
		setTitle("RAID ZERO");
		setSize(2048, 1350);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new FlowLayout());

		listTeams = new ArrayList<Team>();

		try {
			File mainFil = new File(mainFile);
			Scanner compkb = new Scanner(mainFil);
			String s = compkb.nextLine();
			s = compkb.nextLine();
			MatchesNos = Integer.parseInt(s);
			File fille = new File("Matches");
			if (!fille.exists()) {
				fille.mkdir();
				fille.createNewFile();

			}
			fille = new File("Matches\\Match_" + MatchesNos + ".txt");
			MatchesNos++;
			if (!fille.exists()) {
				fille.createNewFile();
			}
			while (compkb.hasNextLine()) {
				ArrayList<String> star = new ArrayList<String>();
				s = compkb.nextLine();
				if (s.equals(""))
					continue;
				String[] ss = s.split(";");
				for (int i = 0; i < ss.length; i++) {
					star.add(ss[i]);
				}
				Team temp = new Team(star);
				listTeams.add(temp);
			}
			compkb.close();

			Match aahuaa = new Match(matchFile, fille);
			rnda = aahuaa.check();
			if (!rnda)
				MatchesNos--;

			ArrayList<ArrayList> matchInfo = aahuaa.getTeamInfo();
			for (int j = 0; j < matchInfo.size(); j++) {
				if (((String) matchInfo.get(j).get(0)).equals(""))
					continue;
				int k;
				for (k = 0; k < listTeams.size(); k++) {
					if (listTeams.get(k).getName()
							.equals(matchInfo.get(j).get(0))) {
						listTeams.get(k).updateInfo(matchInfo.get(j));
						break;
					}
				}
				if (k == listTeams.size()) {
					String na = (String) matchInfo.get(j).get(0);
					Team aa = new Team(na);
					aa.updateInfo(matchInfo.get(j));
					listTeams.add(aa);
				}
			}
		} catch (IOException e) {
			System.out.print("File not Found");
		}

		try {
			File file = new File(mainFile);

			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Team At AtD HG LG PC CF Mo Ra DB SP RW RT LB SC");
			bw.newLine();
			String sn = MatchesNos + "";
			bw.write(sn);
			bw.newLine();
			for (int huehue = 0; huehue < listTeams.size(); huehue++) {
				Team tem = listTeams.get(huehue);
				bw.write(tem.toString());
				bw.newLine();
			}

			file = new File(matchFile);
			file.delete();

			bw.close();
		} catch (IOException e) {
			System.out.println("FILE NOT FOUND");
		}
		addMouseListener(this);

		sch = new Schedule(scheduleFile);

		/*setLayout(new BorderLayout());

		JLabel background = new JLabel(new ImageIcon("Analysis_Program.png"));

		add(background);

		background.setLayout(new FlowLayout());

		JLabel l1 = new JLabel("Here is a button");
		JButton b1 = new JButton("I am a button");

		background.add(l1);
		background.add(b1);*/
		
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon("Analysis_Program.png")));
		setLayout(new FlowLayout());
		JLabel l1=new JLabel("Here is a button");
		JButton b1=new JButton("I am a button");
		add(l1);
		add(b1);
		// Just for refresh :) Not optional!
		setSize(399,399);
		setSize(400,400);
		
		try {
		setContentPane(new JLabel (new ImageIcon(ImageIO.read(new File("Analysis_Program.png")))));
		} catch (IOException e) {
			
		}

	}

	public void paint(Graphics g) {
		/*if (updated) {
			ImageIcon ii = new ImageIcon(
					"C:\\Users\\17112499\\Analysis_Program.png");
			JLabel lable = new JLabel(ii);
			getContentPane().add(lable);
			add(lable);
			updated = false;
		}*/
		try {
			TimeUnit.MILLISECONDS.sleep(50);
		} catch (InterruptedException e) {
		}
		repaint();
	}

	public ArrayList<Team> getTeams() {
		return listTeams;
	}

	public void print6teams(int n) {
		String temPath = "Matches\\Match_" + n + ".txt";
		Match temp = new Match(temPath);
		temp.printMatch();
	}

	public void print6teams_Defenses(int n) {
		ArrayList<String> ts = sch.getMatch(n);
		for (int i = 0; i < listTeams.size(); i++) {
			for (int j = 0; j < ts.size(); j++) {
				if (ts.get(j).equals(listTeams.get(i).getName())) {
					System.out.println("Team Name : "
							+ listTeams.get(i).getName());
					System.out.println(listTeams.get(i).sortOutWorst() + "\n");
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		JFrame idk = new Competition();
		/*String path = "Analysis_Program.png";
		File fi = new File(path);
		BufferedImage image = ImageIO.read(fi);
		JLabel label = new JLabel(new ImageIcon(image));
		idk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		idk.getContentPane().add(label);
		idk.setSize(1018, 705);
		idk.setLocation(200, 200);
		idk.setVisible(true);*/
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getX() > 1600) {
			Pre_Match pm = new Pre_Match();
			String fn = JOptionPane.showInputDialog("Enter Team # : ");
			System.out.println(pm.getClaimedDefenses(fn));
		} else if (e.getX() > 1200) {
			String fn = JOptionPane
					.showInputDialog("Enter Match # to see their defense_crossing status : ");
			print6teams_Defenses(Integer.parseInt(fn));
		} else if (e.getX() > 800) {
			String fn = JOptionPane
					.showInputDialog("Enter Match # to see what happened : ");
			print6teams(Integer.parseInt(fn));
		} else if (e.getX() > 400) {
			String fn = JOptionPane.showInputDialog("Enter Team # : ");
			for (int i = 0; i < listTeams.size(); i++) {
				if (listTeams.get(i).getName().equals(fn)) {

					System.out.print(listTeams.get(i).avgs());
					/*
					 * JFrame ha =
					 * 
					 * new JFrame();
					 * ha.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					 * ha.setLayout(new FlowLayout());
					 * lab.setText(listTeams.get(i).avgs());
					 * getContentPane().add(lab);
					 */

					getContentPane().setLayout(new FlowLayout());
					JLabel label = new JLabel("Text-Only Label");
					label.setFont(new Font("Serif", Font.PLAIN, 36));
					getContentPane().add(label);
					setVisible(true);

					break;
				}
				if (i == listTeams.size() - 1) {
					System.out.println("TEAM NOT FOUND");
					break;
				}
			}
		} else if (e.getX() > 0) {
			Table gui = new Table(getTeams());
			gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			gui.setSize(1800, 1000);
			gui.setVisible(true);
			gui.setTitle("Team Data");
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

}