import java.util.ArrayList;

public class Defense {

	private String name;
	private ArrayList<Integer> list;
	private String Avg;

	public Defense() {
		name = "";
		list = new ArrayList<Integer>();
		Avg = "";
	}

	public Defense(String n) {
		name = n;
		list = new ArrayList<Integer>();
		Avg = "";
	}

	public Defense(String n, ArrayList<Integer> a) {
		name = n;
		list = a;
		calcAVG();
	}

	public void avgingout(int n) {
		if (n >= 0) {
			list.add(n);
			calcAVG();
		}
	}

	public void calcAVG() {
		int temp, i;
		temp = i = 0;
		for (i = 0; i < list.size(); i++) {
			temp += list.get(i);
		}
		if (i == 0) {
			Avg = "";
		} else {
			Avg = (double) temp / list.size() + "";
		}
	}

	public String getList() {
		String output = "";
		for (int i = 0; i < list.size(); i++) {
			output += list.get(i);
			if (i != list.size() - 1)
				output += " ";
		}
		return output;
	}

	public String getAvg() {
		if (Avg.equals(""))
			return "N/A";
		return String.format("%.2f", Double.parseDouble(Avg));
	}

	public boolean haveCompleted() {
		if (list.size() == 0)
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public String calcStdDev() {
		if (Avg.equals(""))
			return "";
		double mean = Double.parseDouble(Avg);
		ArrayList<Double> stdDev = new ArrayList<Double>();
		for (int i = 0; i < list.size(); i++) {
			double n = (list.get(i) - mean) * (list.get(i) - mean);
			stdDev.add(n);
		}
		double meanOfSqr = AVG_D(stdDev);
		double sqrtOfAbove = Math.sqrt(meanOfSqr);
		return String.format("%.2f", sqrtOfAbove);
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

}
