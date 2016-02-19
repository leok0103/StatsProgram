import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JOptionPane;

public class Competition extends JFrame implements MouseListener {
	private static final long serialVersionUID = 0;

	private final String matchFile = "test.txt";
	private final String mainFile = "main.txt";
	private final String scheduleFile = "schedule.txt";

	private ArrayList<Team> listTeams;

	private boolean updated = true;

	private JTable table;
	private JLabel lab;

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
		} catch (FileNotFoundException e) {
			System.out.print("File not Found");
		}

		Match aahuaa = new Match(matchFile);

		ArrayList<ArrayList> matchInfo = aahuaa.getTeamInfo();
		for (int j = 0; j < matchInfo.size(); j++) {
			if (((String) matchInfo.get(j).get(0)).equals(""))
				continue;
			int k;
			for (k = 0; k < listTeams.size(); k++) {
				if (listTeams.get(k).getName().equals(matchInfo.get(j).get(0))) {
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
		try {
			File file = new File(mainFile);

			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw); // bw.write(content); //
			bw.write("Team At AtD HG LG PC CF Mo Ra DB SP RW RT LB SC");
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
		lab = new JLabel();

		Schedule sch = new Schedule(scheduleFile);
	}

	public void paint(Graphics g) {
		if (updated) {

			updated = false;
		}
		try {
			TimeUnit.MILLISECONDS.sleep(50);
		} catch (InterruptedException e) {
		}
		repaint();
	}

	public ArrayList<Team> getTeams() {
		return listTeams;
	}

	public static void main(String[] args) {
		Competition idk = new Competition();
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getX() > 400) {
			String fn = JOptionPane.showInputDialog("Enter Team #:");
			for (int i = 0; i < listTeams.size(); i++) {
				if (listTeams.get(i).getName().equals(fn)) {
					/*
					 * System.out.print(listTeams.get(i).avgs()); JFrame ha =
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