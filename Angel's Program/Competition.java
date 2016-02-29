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

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

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
		setSize(1018, 705);
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

		try {
			setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(
					"Analysis_Program.png")))));
		} catch (IOException e) {

		}

		BackgroundPanel pan = new BackgroundPanel();

		JPanel panel = new JPanel();
		panel.setOpaque(false);

		pan.add(panel);

		add(pan);
		setVisible(true);

	}

	public void paint(Graphics g) {
	}

	public ArrayList<Team> getTeams() {
		return listTeams;
	}

	public String print6teams(int n) {
		String temPath = "Matches\\Match_" + n + ".txt";
		Match temp = new Match(temPath);
		return temp.printMatch();
	}

	public String print6teams_Defenses(int n) {
		String ans = "";
		String[] ts = sch.getMatch(n);

		for (int i = 0; i < ts.length; i++) {
			for (int j = 0; j < listTeams.size(); j++) {
				if (ts[i].equals(listTeams.get(j).getName())) {
					ans += "Team " + listTeams.get(j).getName() + " :: \n"
							+ listTeams.get(j).sortOutWorst() + "\n\n";
				}
			}
		}
		return ans;
	}

	public String print6teams_Defenses2(int n) {
		String ans = "";
		String[] ts = sch.getMatch(n);
		Team[] tes = new Team[6];

		for (int i = 0; i < ts.length; i++) {
			for (int j = 0; j < listTeams.size(); j++) {
				if (ts[i].equals(listTeams.get(j).getName())) {
					tes[i] = listTeams.get(j);
					System.out.println(tes[i].getName() + " "
							+ tes[i].getAvgTotal());
				}
			}
		}

		for (int a = 0; a < tes.length - 1; a++) {
			for (int b = 0; b < tes.length; b++) {
				if (tes[a].getAvgTotal() > tes[b].getAvgTotal()) {
					Team temp = tes[a];
					tes[a] = tes[b];
					tes[b] = temp;
				}
			}
		}

		for (int x = 0; x < tes.length; x++) {
			ans += tes[x].getName() + " ";
		}
		return ans;

	}

	public static void main(String[] args) throws IOException {
		JFrame idk = new Competition();

	}

	public void mouseClicked(MouseEvent e) {
		if (e.getY() < 655 && e.getY() > 565) {
			if (e.getX() > 370 && e.getX() < 465) { // Pre_Match
				Pre_Match pm = new Pre_Match();
				String fn = JOptionPane.showInputDialog("Enter Team # : ");
				if (fn != null) {
					JFrame temp = new JFrame("Pre_Match Defense Info on Team "
							+ fn);
					temp.setVisible(true);
					temp.setSize(900, 900);

					String str = pm.getClaimedDefenses(fn);

					JLabel lab = new JLabel(str, SwingConstants.CENTER);
					lab.setFont(new Font("Courier", Font.PLAIN, 20));
					lab.setAlignmentX(0);
					lab.setAlignmentY(0);

					temp.add(lab);
				}
			} else if (e.getX() > 255 && e.getX() < 355) { // Match_Defenses
				String fn = JOptionPane
						.showInputDialog("Enter Match # to see their defense_crossing status : ");
				if (fn != null) {
					JFrame temp = new JFrame("Team " + fn + " ");
					temp.setVisible(true);
					temp.setSize(900, 900);

					String str = "<html>"
							+ print6teams_Defenses(Integer.parseInt(fn)) + "\n"
							+ print6teams_Defenses2(Integer.parseInt(fn));
					while (str.indexOf("\n") >= 0) {
						str = str.substring(0, str.indexOf("\n")) + "<br/>"
								+ str.substring(str.indexOf("\n") + 1);
					}
					str += "</html><div style = 'text-align: center;'>";

					JLabel lab = new JLabel(str, SwingConstants.CENTER);
					lab.setFont(new Font("Courier", Font.PLAIN, 20));
					lab.setAlignmentX(0);
					lab.setAlignmentY(0);

					temp.add(lab);
				}
			} else if (e.getX() > 475 && e.getX() < 575) { // Match_Search
				String fn = JOptionPane
						.showInputDialog("Enter Match # to see what happened : ");

				JFrame temp = new JFrame("Match " + fn + " Status");

				String str = "<html>" + print6teams(Integer.parseInt(fn));
				while (str.indexOf("\n") >= 0) {
					str = str.substring(0, str.indexOf("\n")) + "<br/>"
							+ str.substring(str.indexOf("\n") + 1);
				}
				str += "</html>";

				JLabel lab = new JLabel(str, SwingConstants.CENTER);
				lab.setFont(new Font("Courier", Font.PLAIN, 20));
				
				JScrollPane pan = new JScrollPane(lab);
				pan.getVerticalScrollBar().setUnitIncrement(16);

				temp.getContentPane().add(pan);

				temp.setVisible(true);
				temp.setSize(900, 900);
			} else if (e.getX() > 150 && e.getX() < 245) { // Team Search
				String fn = JOptionPane.showInputDialog("Enter Team # : ");
				if (fn != null) {
					for (int i = 0; i < listTeams.size(); i++) {
						if (listTeams.get(i).getName().equals(fn)) {

							JFrame temp = new JFrame("Team " + fn + " Status");
							temp.setVisible(true);
							temp.setSize(900, 900);

							String str = "<html>" + listTeams.get(i).avgs();
							while (str.indexOf("\n") >= 0) {
								str = str.substring(0, str.indexOf("\n"))
										+ "<br/>"
										+ str.substring(str.indexOf("\n") + 1);
							}
							str += "</html><div style = 'text-align: center;'>";

							JLabel lab = new JLabel(str, SwingConstants.CENTER);
							lab.setFont(new Font("Courier", Font.PLAIN, 20));
							lab.setAlignmentX(0);
							lab.setAlignmentY(0);

							temp.add(lab);
							break;
						}
						if (i == listTeams.size() - 1) {
							JFrame temp = new JFrame("Team Search");
							temp.setVisible(true);
							temp.setSize(900, 900);

							JLabel lab = new JLabel("TEAM NOT FOUND",
									JLabel.CENTER);
							lab.setFont(new Font("Courier", Font.PLAIN, 30));
							lab.setAlignmentX(0);
							lab.setAlignmentY(0);

							temp.add(lab);
							break;
						}
					}
				}
			} else if (e.getX() > 35 && e.getX() < 135) { // Team Data
				Table gui = new Table(getTeams());
				gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				gui.setSize(1800, 1000);
				gui.setVisible(true);
				gui.setTitle("Team Data");
			}
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