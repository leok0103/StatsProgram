import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class Match {
	private ArrayList<ArrayList> teamList;

	public Match() {
		teamList = new ArrayList<ArrayList>();
	}

	public Match(String filepath) {
		File file = new File(filepath);
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
		} catch (FileNotFoundException e) {

		}

	}

	public ArrayList<ArrayList> getTeamInfo() {
		return teamList;
	}
}
