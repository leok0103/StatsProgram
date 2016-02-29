import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Match_Generator {

	public static void main(String[] args) {
		try {
			String matchFile = "testo.txt";
			File file = new File(matchFile);

			file.delete();

			if (!file.exists()) {
				file.createNewFile();
			}

			Schedule sch = new Schedule("Schedule.txt");
			File main = new File("main.txt");
			Scanner sca = new Scanner(main);
			sca.nextLine();
			int temp = Integer.parseInt(sca.nextLine());
			String[] arr = sch.getMatch(temp);

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			int area1 = (int) (Math.random() * 2);
			int area2 = (int) (Math.random() * 2);
			int area3 = (int) (Math.random() * 2);
			int area4 = (int) (Math.random() * 2);

			for (int i = 0; i < 6; i++) {
				bw.write("Team Number : " + arr[i]);
				bw.newLine();
				bw.write("Auton (2 digits) : " + (int) (Math.random() * 50));
				bw.newLine();
				bw.write("\t<for tens digit, refer to below>");
				bw.newLine();
				bw.write("\tNothing happens 0");
				bw.newLine();
				bw.write("\tReach Defense 1");
				bw.newLine();
				bw.write("\tCross Defense 2");
				bw.newLine();
				bw.write("\tScores Low Goal 3");
				bw.newLine();
				bw.write("\tScores High Goal 4");
				bw.newLine();
				bw.write("\t<for ones digit, refer to below>");
				bw.newLine();
				bw.write("\tNo Crossing 0");
				bw.newLine();
				bw.write("\tPortcullis 1");
				bw.newLine();
				bw.write("\tCheval De Frise 2");
				bw.newLine();
				bw.write("\tMoat 3");
				bw.newLine();
				bw.write("\tRamparts 4");
				bw.newLine();
				bw.write("\tDrawbridge 5");
				bw.newLine();
				bw.write("\tSally Port 6");
				bw.newLine();
				bw.write("\tRock Wall 7");
				bw.newLine();
				bw.write("\tRough Terrain 8");
				bw.newLine();
				bw.write("\tLow Bar 9");
				bw.newLine();
				bw.write("<Teleop>");
				bw.newLine();
				bw.write("High Goals : " + (int) (Math.random() * 15));
				bw.newLine();
				bw.write("Low Goals : " + (int) (Math.random() * 15));
				bw.newLine();
				bw.write("Defenses Crossed - ");
				bw.newLine();

				if (area1 == 0) {
					bw.write("\tPortcullis : " + (int) (Math.random() * 3));
					bw.newLine();
					bw.write("\tCheval de Frise : -1");
					bw.newLine();
				} else {
					bw.write("\tPortcullis : -1");
					bw.newLine();
					bw.write("\tCheval de Frise : " + (int) (Math.random() * 3));
					bw.newLine();
				}

				if (area2 == 0) {
					bw.write("\tMoat : " + (int) (Math.random() * 3));
					bw.newLine();
					bw.write("\tRamparts : -1");
					bw.newLine();
				} else {
					bw.write("\tMoat : -1");
					bw.newLine();
					bw.write("\tRamparts : " + (int) (Math.random() * 3));
					bw.newLine();
				}

				if (area3 == 0) {
					bw.write("\tDrawbridge : " + (int) (Math.random() * 3));
					bw.newLine();
					bw.write("\tSally Port : -1");
					bw.newLine();
				} else {
					bw.write("\tDrawBridge : -1");
					bw.newLine();
					bw.write("\tSally Port : " + (int) (Math.random() * 3));
					bw.newLine();
				}

				if (area4 == 0) {
					bw.write("\tRock Wall : " + (int) (Math.random() * 3));
					bw.newLine();
					bw.write("\tRough Terrain : -1");
					bw.newLine();
				} else {
					bw.write("\tRock Wall : -1");
					bw.newLine();
					bw.write("\tRough Terrain : " + (int) (Math.random() * 3));
					bw.newLine();
				}
				bw.write("\tLow Bar : " + (int) (Math.random() * 3));
				bw.newLine();
				bw.write("Scale / Climb / None (choose 1) : "
						+ (int) (Math.random() * 3));
				if (i != 5) {
					bw.newLine();
					bw.write("----------");
					bw.newLine();
				}
			}

			bw.close();
			sca.close();
			
			if(sch.getMax() < temp) {
				file.delete();
			}
		} catch (IOException e) {

		}
	}
}
