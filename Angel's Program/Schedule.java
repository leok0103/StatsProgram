import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class Schedule {
	private ArrayList<ArrayList> schedule;

	public Schedule() {
		schedule = new ArrayList<ArrayList>();
	}

	public Schedule(String filepath) {
		File file = new File(filepath);
		schedule = new ArrayList<ArrayList>();

		try {
			Scanner scan = new Scanner(file);
			for (int i = 0; i < 6; i++) {
				ArrayList<String> info = new ArrayList<String>();
				while (scan.hasNext()) {
					info.add(scan.next());
				}
				schedule.add(info);
			}
			scan.close();
		} catch (FileNotFoundException e) {

		}
	}

	public ArrayList<String> getMatch(int n) {
		return schedule.get(n - 1);
	}
}
