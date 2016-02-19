import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Schedule_Generator {

	public static void main(String[] args) {
		try {
			String matchFile = "Schedule.txt";
			File file = new File(matchFile);

			file.delete();

			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < 20; i++) {
				bw.write((int) (Math.random() * 40) + " "
						+ (int) (Math.random() * 40) + " "
						+ (int) (Math.random() * 40) + " "
						+ (int) (Math.random() * 40) + " "
						+ (int) (Math.random() * 40) + " "
						+ (int) (Math.random() * 40));
				bw.newLine();
			}

			bw.close();
		} catch (IOException e) {

		}
	}
}
