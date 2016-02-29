import java.util.ArrayList;

public class Team {

	private String name; // Team #

	private int totalAuton; // Calculated Total Auton Score of the Team
	private ArrayList<Integer> listAuton;
	private ArrayList<String> autonDef;

	private int totalHG;
	private ArrayList<Integer> listHG;
	private int totalLG;
	private ArrayList<Integer> listLG;

	private Defense PortC;
	private Defense Cheval;
	private Defense Moat;
	private Defense Rampart;
	private Defense Drawbridge;
	private Defense SallyPort;
	private Defense RockWall;
	private Defense RoughTerrain;
	private Defense LowBar;

	private ArrayList<Integer> listPortC;
	private ArrayList<Integer> listCheval;
	private ArrayList<Integer> listMoat;
	private ArrayList<Integer> listRam;
	private ArrayList<Integer> listDB;
	private ArrayList<Integer> listPortS;
	private ArrayList<Integer> listRock;
	private ArrayList<Integer> listRough;
	private ArrayList<Integer> listLowB;

	private double scaling; // 2 for scaling, 1 for climbing, 0 for nothing
	private ArrayList<Integer> listScaling;

	// for defenses, 2 for good, 1 for doable, 0 for can't

	public Team() {
		name = "";
		totalAuton = 0;
		totalHG = 0;
		totalLG = 0;
		PortC = new Defense("Portcullis");
		Cheval = new Defense("Cheval De Frise");
		Moat = new Defense("Moat");
		Rampart = new Defense("Ramparts");
		Drawbridge = new Defense("Drawbridge");
		SallyPort = new Defense("Sally Port");
		RockWall = new Defense("Rock Wall");
		RoughTerrain = new Defense("Rough Terrain");
		LowBar = new Defense("Low Bar");

		listAuton = new ArrayList<Integer>();
		autonDef = new ArrayList<String>();
		listHG = new ArrayList<Integer>();
		listLG = new ArrayList<Integer>();
		listPortC = new ArrayList<Integer>();
		listCheval = new ArrayList<Integer>();
		listMoat = new ArrayList<Integer>();
		listRam = new ArrayList<Integer>();
		listDB = new ArrayList<Integer>();
		listPortS = new ArrayList<Integer>();
		listRock = new ArrayList<Integer>();
		listRough = new ArrayList<Integer>();
		listLowB = new ArrayList<Integer>();
		listScaling = new ArrayList<Integer>();
	}

	public Team(String nam) {
		name = nam;
		totalAuton = 0;
		totalHG = 0;
		totalLG = 0;
		PortC = new Defense("Portcullis");
		Cheval = new Defense("Cheval De Frise");
		Moat = new Defense("Moat");
		Rampart = new Defense("Ramparts");
		Drawbridge = new Defense("Drawbridge");
		SallyPort = new Defense("Sally Port");
		RockWall = new Defense("Rock Wall");
		RoughTerrain = new Defense("Rough Terrain");
		LowBar = new Defense("Low Bar");

		listAuton = new ArrayList<Integer>();
		autonDef = new ArrayList<String>();
		listHG = new ArrayList<Integer>();
		listLG = new ArrayList<Integer>();
		listPortC = new ArrayList<Integer>();
		listCheval = new ArrayList<Integer>();
		listMoat = new ArrayList<Integer>();
		listRam = new ArrayList<Integer>();
		listDB = new ArrayList<Integer>();
		listPortS = new ArrayList<Integer>();
		listRock = new ArrayList<Integer>();
		listRough = new ArrayList<Integer>();
		listLowB = new ArrayList<Integer>();
		listScaling = new ArrayList<Integer>();
	}

	public Team(ArrayList<String> inp) {
		name = inp.get(0);

		listAuton = new ArrayList<Integer>();
		autonDef = new ArrayList<String>();
		listHG = new ArrayList<Integer>();
		listLG = new ArrayList<Integer>();
		listPortC = new ArrayList<Integer>();
		listCheval = new ArrayList<Integer>();
		listMoat = new ArrayList<Integer>();
		listRam = new ArrayList<Integer>();
		listDB = new ArrayList<Integer>();
		listPortS = new ArrayList<Integer>();
		listRock = new ArrayList<Integer>();
		listRough = new ArrayList<Integer>();
		listLowB = new ArrayList<Integer>();
		listScaling = new ArrayList<Integer>();

		String[] inpu = inp.get(1).split(" ");
		for (int i = 0; i < inpu.length; i++) {
			if (inpu[i].equals(""))
				break;
			listAuton.add(Integer.parseInt(inpu[i]));
		}

		inpu = inp.get(2).split(" ");
		for (int i = 0; i < inpu.length; i++) {
			if (inpu[i].equals("") || inp.get(2).equals("CAN'T CROSS ANY DEFENSE"))
				break;
			autonDef.add(inpu[i]);
		}

		inpu = inp.get(3).split(" ");
		for (int i = 0; i < inpu.length; i++) {
			if (inpu[i].equals(""))
				break;
			listHG.add(Integer.parseInt(inpu[i]));
		}

		inpu = inp.get(4).split(" ");
		for (int i = 0; i < inpu.length; i++) {
			if (inpu[i].equals(""))
				break;
			listLG.add(Integer.parseInt(inpu[i]));
		}

		inpu = inp.get(5).split(" ");
		for (int i = 0; i < inpu.length; i++) {
			if (inpu[i].equals(""))
				break;
			listPortC.add(Integer.parseInt(inpu[i]));
		}

		inpu = inp.get(6).split(" ");
		for (int i = 0; i < inpu.length; i++) {
			if (inpu[i].equals(""))
				break;
			listCheval.add(Integer.parseInt(inpu[i]));
		}

		inpu = inp.get(7).split(" ");
		for (int i = 0; i < inpu.length; i++) {
			if (inpu[i].equals(""))
				break;
			listMoat.add(Integer.parseInt(inpu[i]));
		}

		inpu = inp.get(8).split(" ");
		for (int i = 0; i < inpu.length; i++) {
			if (inpu[i].equals(""))
				break;
			listRam.add(Integer.parseInt(inpu[i]));
		}

		inpu = inp.get(9).split(" ");
		for (int i = 0; i < inpu.length; i++) {
			if (inpu[i].equals(""))
				break;
			listDB.add(Integer.parseInt(inpu[i]));
		}

		inpu = inp.get(10).split(" ");
		for (int i = 0; i < inpu.length; i++) {
			if (inpu[i].equals(""))
				break;
			listPortS.add(Integer.parseInt(inpu[i]));
		}

		inpu = inp.get(11).split(" ");
		for (int i = 0; i < inpu.length; i++) {
			if (inpu[i].equals(""))
				break;
			listRock.add(Integer.parseInt(inpu[i]));
		}

		inpu = inp.get(12).split(" ");
		for (int i = 0; i < inpu.length; i++) {
			if (inpu[i].equals(""))
				break;
			listRough.add(Integer.parseInt(inpu[i]));
		}

		inpu = inp.get(13).split(" ");
		for (int i = 0; i < inpu.length; i++) {
			if (inpu[i].equals(""))
				break;
			listLowB.add(Integer.parseInt(inpu[i]));
		}

		inpu = inp.get(14).split(" ");
		for (int i = 0; i < inpu.length; i++) {
			if (inpu[i].equals(""))
				break;
			listScaling.add(Integer.parseInt(inpu[i]));
		}

		totalAuton = SUM(listAuton);
		totalHG = SUM(listHG);
		totalLG = SUM(listLG);
		PortC = new Defense("Portcullis", listPortC);
		Cheval = new Defense("Cheval De Frise", listCheval);
		Moat = new Defense("Moat", listMoat);
		Rampart = new Defense("Ramparts", listRam);
		Drawbridge = new Defense("Drawbridge", listDB);
		SallyPort = new Defense("Sally Port", listPortS);
		RockWall = new Defense("Rock Wall", listRock);
		RoughTerrain = new Defense("Rough Terrain", listRough);
		LowBar = new Defense("Low Bar", listLowB);
		scaling = AVG(listScaling);

	}

	public int SUM(ArrayList<Integer> a) {
		int ans = 0;
		for (int i = 0; i < a.size(); i++) {
			ans += a.get(i);
		}
		return ans;
	}

	public double AVG(ArrayList<Integer> a) {
		return ((double) SUM(a)) / a.size();
	}

	public double SUM_D(ArrayList<Double> b) {
		double ans = 0;
		for (int i = 0; i < b.size(); i++) {
			ans += b.get(i);
		}
		return ans;
	}

	public double AVG_D(ArrayList<Double> b) {
		return SUM_D(b) / b.size();
	}

	public String getName() {
		return name;
	}

	public void updateInfo(ArrayList<String> newInfo) {
		int n = Integer.parseInt(newInfo.get(1));
		if (n > 20) {
			if (n % 10 == 1 && !autonDef.contains("Portcullis")) {
				autonDef.add("Portcullis");
			} else if (n % 10 == 2 && !autonDef.contains("Cheval_De_Frise")) {
				autonDef.add("Cheval_De_Frise");
			} else if (n % 10 == 3 && !autonDef.contains("Moat")) {
				autonDef.add("Moat");
			} else if (n % 10 == 4 && !autonDef.contains("Ramparts")) {
				autonDef.add("Ramparts");
			} else if (n % 10 == 5 && !autonDef.contains("DrawBridge")) {
				autonDef.add("DrawBridge");
			} else if (n % 10 == 6 && !autonDef.contains("Sally_Port")) {
				autonDef.add("Sally_Port");
			} else if (n % 10 == 7 && !autonDef.contains("Rock_Wall")) {
				autonDef.add("Rock_Wall");
			} else if (n % 10 == 8 && !autonDef.contains("Rough_Terrain")) {
				autonDef.add("Rough_Terrain");
			} else if (n % 10 == 9 && !autonDef.contains("Low_Bar")) {
				autonDef.add("Low_Bar");
			}
			if (n > 40) {
				listAuton.add(20);
				totalAuton += 20;
			} else if (n > 30) {
				listAuton.add(15);
				totalAuton += 15;
			} else {
				listAuton.add(10);
				totalAuton += 10;
			}
		} else if (n >= 10) {
			listAuton.add(2);
			totalAuton += 2;
		} else {
			listAuton.add(0);
		}

		n = Integer.parseInt(newInfo.get(2));
		totalHG += n;
		listHG.add(n);
		n = Integer.parseInt(newInfo.get(3));
		listLG.add(n);
		totalLG += n;

		PortC.avgingout(Integer.parseInt(newInfo.get(4)));
		Cheval.avgingout(Integer.parseInt(newInfo.get(5)));
		Moat.avgingout(Integer.parseInt(newInfo.get(6)));
		Rampart.avgingout(Integer.parseInt(newInfo.get(7)));
		Drawbridge.avgingout(Integer.parseInt(newInfo.get(8)));
		SallyPort.avgingout(Integer.parseInt(newInfo.get(9)));
		RockWall.avgingout(Integer.parseInt(newInfo.get(10)));
		RoughTerrain.avgingout(Integer.parseInt(newInfo.get(11)));
		LowBar.avgingout(Integer.parseInt(newInfo.get(12)));

		scaling = avgingout(scaling, Integer.parseInt(newInfo.get(13)),
				listScaling);

	}

	public double avgingout(double orig, int nuevo, ArrayList<Integer> a) {
		double ans = 0.0;

		ans = (orig * a.size() + (double) nuevo) / (a.size() + 1);
		a.add(nuevo);

		return ans;
	}

	public int getTotalAuton() {
		return totalAuton;
	}

	public String getAvgAuton() {
		double s = ((double) totalAuton) / listAuton.size();
		return String.format("%.2f (%.2f)", s, calcStdDev(s, listAuton));
	}

	public String getListAuton() {
		String output = "";
		for (int i = 0; i < listAuton.size(); i++) {
			output += listAuton.get(i);
			if (i != listAuton.size() - 1)
				output += " ";
		}
		return output;
	}

	public int getTotalHG() {
		return totalHG;
	}

	public String getAvgHG() {
		double s = ((double) totalHG) / listHG.size();
		return String.format("%.2f (%.2f)", s, calcStdDev(s, listHG));
	}

	public String getListHG() {
		String output = "";
		for (int i = 0; i < listHG.size(); i++) {
			output += listHG.get(i);
			if (i != listHG.size() - 1)
				output += " ";
		}
		return output;
	}

	public int getTotalLG() {
		return totalLG;
	}

	public String getAvgLG() {
		double s = ((double) totalLG) / listLG.size();
		return String.format("%.2f (%.2f)", s, calcStdDev(s, listLG));
	}

	public String getListLG() {
		String output = "";
		for (int i = 0; i < listLG.size(); i++) {
			output += listLG.get(i);
			if (i != listLG.size() - 1)
				output += " ";
		}
		return output;
	}

	public String getPC() {
		if (PortC.getAvg().equals("N/A"))
			return PortC.getAvg();
		return PortC.getAvg() + String.format(" (%s)", PortC.calcStdDev());
	}

	public String getCheval() {
		if (Cheval.getAvg().equals("N/A"))
			return Cheval.getAvg();
		return Cheval.getAvg() + String.format(" (%s)", Cheval.calcStdDev());
	}

	public String getMoat() {
		if (Moat.getAvg().equals("N/A"))
			return Moat.getAvg();
		return Moat.getAvg() + String.format(" (%s)", Moat.calcStdDev());
	}

	public String getRampart() {
		if (Rampart.getAvg().equals("N/A"))
			return Rampart.getAvg();
		return Rampart.getAvg() + String.format(" (%s)", Rampart.calcStdDev());
	}

	public String getDB() {
		if (Drawbridge.getAvg().equals("N/A"))
			return Drawbridge.getAvg();
		return Drawbridge.getAvg()
				+ String.format(" (%s)", Drawbridge.calcStdDev());
	}

	public String getPortS() {
		if (SallyPort.getAvg().equals("N/A"))
			return SallyPort.getAvg();
		return SallyPort.getAvg()
				+ String.format(" (%s)", SallyPort.calcStdDev());
	}

	public String getRock() {
		if (RockWall.getAvg().equals("N/A"))
			return RockWall.getAvg();
		return RockWall.getAvg()
				+ String.format(" (%s)", RockWall.calcStdDev());
	}

	public String getRough() {
		if (RoughTerrain.getAvg().equals("N/A"))
			return RoughTerrain.getAvg();
		return RoughTerrain.getAvg()
				+ String.format(" (%s)", RoughTerrain.calcStdDev());
	}

	public String getLowB() {
		if (LowBar.getAvg().equals("N/A"))
			return LowBar.getAvg();
		return LowBar.getAvg() + String.format(" (%s)", LowBar.calcStdDev());
	}

	public String getScaling() {
		return String.format("%.2f (%.2f)", scaling,
				calcStdDev(scaling, listScaling));
	}

	public String getListScaling() {
		String output = "";
		for (int i = 0; i < listScaling.size(); i++) {
			output += listScaling.get(i);
			if (i != listScaling.size() - 1)
				output += " ";
		}
		return output;
	}

	public String getAutonDef() {
		String output = "";
		if (autonDef.size() == 0)
			return "CAN'T CROSS ANY DEFENSE";
		for (int i = 0; i < autonDef.size(); i++) {
			output += autonDef.get(i);
			if (i != autonDef.size() - 1)
				output += " ";
		}
		return output;
	}

	public String avgs() {
		return "Average Autonomous Score : " + getAvgAuton()
				+ "\nAverage High Goals : " + getAvgHG()
				+ "\nAverage Low Goals : " + getAvgLG() + "\nPortcullis : "
				+ getPC() + "\nCheval De Frise : " + getCheval() + "\nMoat : "
				+ getMoat() + "\nRampart : " + getRampart()
				+ "\nDraw Bridge : " + getDB() + "\nSally Port : " + getPortS()
				+ "\nRock Wall : " + getRock() + "\nRough Terrain : "
				+ getRough() + "\nLow Bar : " + getLowB() + "\nScaling : "
				+ getScaling() + "\nDefenses crossed during the autonomous : "
				+ getAutonDef();
	}

	public String sortOutWorst() {
		ArrayList<Defense> known = new ArrayList<Defense>();
		ArrayList<Defense> unknown = new ArrayList<Defense>();

		if (PortC.haveCompleted())
			known.add(PortC);
		else
			unknown.add(PortC);

		if (Cheval.haveCompleted())
			known.add(Cheval);
		else
			unknown.add(Cheval);

		if (Moat.haveCompleted())
			known.add(Moat);
		else
			unknown.add(Moat);

		if (Rampart.haveCompleted())
			known.add(Rampart);
		else
			unknown.add(Rampart);

		if (Drawbridge.haveCompleted())
			known.add(Drawbridge);
		else
			unknown.add(Drawbridge);

		if (SallyPort.haveCompleted())
			known.add(SallyPort);
		else
			unknown.add(SallyPort);

		if (RockWall.haveCompleted())
			known.add(RockWall);
		else
			unknown.add(RockWall);

		if (RoughTerrain.haveCompleted())
			known.add(RoughTerrain);
		else
			unknown.add(RoughTerrain);

		if (LowBar.haveCompleted())
			known.add(LowBar);
		else
			unknown.add(LowBar);

		for (int i = 0; i < known.size() - 1; i++) {
			for (int j = i + 1; j < known.size(); j++) {
				Defense temp = known.get(i);
				if (Double.parseDouble(temp.getAvg()) > Double
						.parseDouble(known.get(j).getAvg())) {
					temp = known.get(j);
					known.set(j, known.get(i));
					known.set(i, temp);
				}
			}
		}

		String ouput = "Ones they can't cross (in order) : ";
		for (int k = 0; k < known.size(); k++) {
			ouput += known.get(k).getName();
			if (k != known.size() - 1)
				ouput += ", ";
		}
		ouput += "\nOnes they haven't crossed (were not available during match) : ";
		for (int l = 0; l < unknown.size(); l++) {
			ouput += unknown.get(l).getName();
			if (l != unknown.size() - 1)
				ouput += ", ";
		}
		return ouput;
	}

	public double calcStdDev(double mean, ArrayList<Integer> a) {
		ArrayList<Double> stdDev = new ArrayList<Double>();
		for (int i = 0; i < a.size(); i++) {
			double n = (a.get(i) - mean) * (a.get(i) - mean);
			stdDev.add(n);
		}
		double meanOfSqr = AVG_D(stdDev);
		double sqrtOfAbove = Math.sqrt(meanOfSqr);
		return sqrtOfAbove;
	}

	public int totalScaling() {
		int ans = 0;
		for (int a = 0; a < listScaling.size(); a++) {
			if (listScaling.get(a) == 2)
				ans += 15;
			else if (listScaling.get(a) == 1)
				ans += 5;
		}
		return ans;
	}

	public int getTotal() {
		return (totalHG * 5) + (totalLG * 2) + totalAuton + totalScaling();
	}

	public double getAvgTotal() {
		return (double) getTotal() / listHG.size();
	}

	public String toString() {
		return name + ";" + getListAuton() + ";" + getAutonDef() + ";"
				+ getListHG() + ";" + getListLG() + ";" + PortC.getList() + ";"
				+ Cheval.getList() + ";" + Moat.getList() + ";"
				+ Rampart.getList() + ";" + Drawbridge.getList() + ";"
				+ SallyPort.getList() + ";" + RockWall.getList() + ";"
				+ RoughTerrain.getList() + ";" + LowBar.getList() + ";"
				+ getListScaling();
	}
}