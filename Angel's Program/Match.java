import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Match {
	private ArrayList<ArrayList> teamList;
	private boolean check;

	public Match() {
		teamList = new ArrayList<ArrayList>();
	}

	public Match(String filepath) {
		File file = new File(filepath);
		check = file.exists();
		teamList = new ArrayList<ArrayList>();

		try {
			Scanner scan = new Scanner(file);

			for (int i = 0; i < 6; i++) {
				ArrayList<String> info = new ArrayList<String>();
				while (scan.hasNextLine()) {

					String str = scan.nextLine();

					if (str.equals("----------"))
						break;
					if (str.indexOf(":") < 0)
						continue;
					String[] spl = str.split(":");
					info.add(spl[1]);

				}
				for (int j = 0; j < info.size(); j++) {
					for (int k = 0; k < info.get(j).length(); k++) {
						if (info.get(j).substring(k, k + 1).equals(" ")) {
							String rnd;
							rnd = info.get(j).substring(k + 1);
							info.set(j, rnd);
						} else {
							break;
						}
					}
				}
				teamList.add(info);
			}
			scan.close();
		} catch (IOException e) {

		}
	}

	public Match(String filepath, File backup) {
		File file = new File(filepath);
		check = file.exists();
		teamList = new ArrayList<ArrayList>();

		try {
			Scanner scan = new Scanner(file);

			FileWriter fw = new FileWriter(backup.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			for (int i = 0; i < 6; i++) {
				ArrayList<String> info = new ArrayList<String>();
				while (scan.hasNextLine()) {

					String str = scan.nextLine();
					bw.write(str);
					bw.newLine();
					if (str.equals("----------"))
						break;
					if (str.indexOf(":") < 0)
						continue;
					String[] spl = str.split(":");
					info.add(spl[1]);

				}
				for (int j = 0; j < info.size(); j++) {
					for (int k = 0; k < info.get(j).length(); k++) {
						if (info.get(j).substring(k, k + 1).equals(" ")) {
							String rnd;
							rnd = info.get(j).substring(k + 1);
							info.set(j, rnd);
						} else {
							break;
						}
					}
				}
				teamList.add(info);
			}
			scan.close();
			bw.close();
		} catch (IOException e) {

		}

	}

	public boolean check() {
		return check;
	}

	public ArrayList<ArrayList> getTeamInfo() {
		return teamList;
	}

	public void printMatch() {
		for (int i = 0; i < 6; i++) {
			Team temp = new Team((String) teamList.get(i).get(0));
			temp.updateInfo(teamList.get(i));

			String ans = "";
			ans += "Team : " + temp.getName();
			ans += "\nAuton Points : " + temp.getAvgAuton().substring(0, 3);
			ans += "\nDefense Crossed : " + temp.getAutonDef();
			ans += "\nHigh Goals : " + temp.getAvgHG().substring(0, 3);
			ans += "\nLow Goals : " + temp.getAvgLG().substring(0, 3);
			ans += "\nPortcullis : " + temp.getPC().substring(0, 3);
			ans += "\nCheval De Frise : " + temp.getCheval().substring(0, 3);
			ans += "\nMoat : " + temp.getMoat().substring(0, 3);
			ans += "\nRamparts : " + temp.getRampart().substring(0, 3);
			ans += "\nDrawbridge : " + temp.getDB().substring(0, 3);
			ans += "\nSally Port : " + temp.getPortS().substring(0, 3);
			ans += "\nRock Wall : " + temp.getRock().substring(0, 3);
			ans += "\nRough Terrain : " + temp.getRough().substring(0, 3);
			ans += "\nLow Bar : " + temp.getLowB().substring(0, 3);
			ans += "\nScaling : " + temp.getScaling().substring(0, 3) + "\n";

			System.out.println(ans);
		}
	}
}
