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
            while(scan.hasNextLine()) {
                ArrayList<String> info = new ArrayList<String>();
                for(int i =0; i<6; i++) {
                    info.add(scan.next());

                }
                schedule.add(info);
            }
            scan.close();
        } catch (FileNotFoundException e) {

        }
    }

    public ArrayList<String> getMatch(int n) {
        if(n>0 && n<schedule.size())
            return schedule.get(n - 1);
        return null;
    }
    
    public int getMax() {
    	return schedule.size();
    }
}
