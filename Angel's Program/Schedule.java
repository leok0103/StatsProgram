import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class Schedule {
	private ArrayList<String[]> schedule;

	public Schedule() {
		schedule = new ArrayList<String[]>();
	}

	public Schedule(String filepath) {
		File file = new File(filepath);
		schedule = new ArrayList<String[]>();

		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String[] info = new String[6];
				for (int i = 0; i < 6; i++) {
					info[i] = scan.next();

				}
				schedule.add(info);
			}
			scan.close();
		} catch (FileNotFoundException e) {

		}
	}

	public String[] getMatch(int n) {
		if (n > 0 && n < schedule.size()) {
			return schedule.get(n - 1);
		}
		return null;
	}

	public int getMax() {
		return schedule.size();
	}
}
