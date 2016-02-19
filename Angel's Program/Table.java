import java.awt.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Table extends JFrame implements MouseListener {

    private static final long serialVersionUID = 0;

    private JTable table;
    private Object[][] data;
    private AbstractTableModel render;
    private String[] columnNames = { "Team#", "Total", "Avg Auton", "Avg HG",
            "Avg LG", "Portcullis", "CDF", "Moat", "Rampart", "Drawbridge",
            "Sally Port", "Rock Wall", "Rough Terrain", "Low Bar", "Scaling" };

    public Table(ArrayList<Team> teams) {
        setLayout(new FlowLayout());

        data = new Object[teams.size()][15];

        for (int i = 0; i < data.length; i++) {
            data[i][0] = teams.get(i).getName();
            data[i][1] = teams.get(i).getTotal() + "";
            data[i][2] = teams.get(i).getAvgAuton();
            data[i][3] = teams.get(i).getAvgHG();
            data[i][4] = teams.get(i).getAvgLG();
            data[i][5] = teams.get(i).getPC();
            data[i][6] = teams.get(i).getCheval();
            data[i][7] = teams.get(i).getMoat();
            data[i][8] = teams.get(i).getRampart();
            data[i][9] = teams.get(i).getDB();
            data[i][10] = teams.get(i).getPortS();
            data[i][11] = teams.get(i).getRock();
            data[i][12] = teams.get(i).getRough();
            data[i][13] = teams.get(i).getLowB();
            data[i][14] = teams.get(i).getScaling();
        }

        render = new idkwhatimdoingkappa(data, columnNames);
        //render.

        table = new JTable(render);

        table.setRowHeight(50);

        table.setFont(new Font("Serif", Font.PLAIN, 20));
        table.setPreferredScrollableViewportSize(new Dimension(1750, 900));
        table.setFillsViewportHeight(true);

        table.getTableHeader().setPreferredSize(new Dimension(1000, 50));
        table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 15));
        table.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        table.getTableHeader().addMouseListener(this);

    }

    public void sortingAtoZ(int index) {
        if (index > 1 && index < 5 || index == 14) {
            for (int i = 0; i < data.length - 1; i++) {
                for (int j = i + 1; j < data.length; j++) {
                    String[] a = ((String) data[i][index]).split(" ");
                    String[] b = ((String) data[j][index]).split(" ");
                    double a1 = Double.parseDouble(a[0]);
                    double b1 = Double.parseDouble(b[0]);
                    if (b1 > a1) {
                        Object[] temp = data[i];
                        data[i] = data[j];
                        data[j] = temp;
                    }
                }
            }
        } else if (index < 2) {
            for (int i = 0; i < data.length - 1; i++) {
                for (int j = i + 1; j < data.length; j++) {
                    int a1 = Integer.parseInt(((String)data[i][index]));
                    int b1 = Integer.parseInt(((String) data[j][index]));
                    if (b1 > a1 && index != 0) {
                        Object[] temp = data[i];
                        data[i] = data[j];
                        data[j] = temp;
                    } else if (b1 < a1 && index == 0) {
                        Object[] temp = data[i];
                        data[i] = data[j];
                        data[j] = temp;
                    }
                }
            }
        } else if (index > 4 && index < 14) {
            int numNA = 0;
            for (int i = 0; i < data.length - 1; i++) {
            	while(((String) data[i][index]).equals("N/A") && i+numNA < data.length) {
            		 Object[] temp = data[data.length-1 - numNA];
                     data[data.length - numNA-1] = data[i];
                     data[i] = temp;
                     numNA++;
            	}
                for (int j = i + 1; j < data.length; j++) {
                    while(((String) data[j][index]).equals("N/A") && j+numNA < data.length){
                        Object[] temp = data[data.length-1 - numNA];
                        data[data.length - numNA-1] = data[j];
                        data[j] = temp;
                        numNA++;
                    }
                    if(((String) data[j][index]).equals("N/A") && j+numNA >= data.length) {
                        break;
                    }
                    String[] a = ((String) data[i][index]).split(" ");
                    String[] b = ((String) data[j][index]).split(" ");
                    double a1 = Double.parseDouble(a[0]);
                    double b1 = Double.parseDouble(b[0]);
                    if (b1 > a1) {
                        Object[] temp = data[i];
                        data[i] = data[j];
                        data[j] = temp;
                    }
                }
            }
        }
        render.fireTableDataChanged();
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getX() < 120) {
            sortingAtoZ(0);
        } else if (e.getX() < 235) {
            sortingAtoZ(1);
        } else if (e.getX() < 350) {
            sortingAtoZ(2);
        } else if (e.getX() < 467) {
            sortingAtoZ(3);
        } else if (e.getX() < 585) {
            sortingAtoZ(4);
        } else if (e.getX() < 700) {
            sortingAtoZ(5);
        } else if (e.getX() < 817) {
            sortingAtoZ(6);
        } else if (e.getX() < 935) {
            sortingAtoZ(7);
        } else if (e.getX() < 1050) {
            sortingAtoZ(8);
        } else if (e.getX() < 1167) {
            sortingAtoZ(9);
        } else if (e.getX() < 1285) {
            sortingAtoZ(10);
        } else if (e.getX() < 1400) {
            sortingAtoZ(11);
        } else if (e.getX() < 1515) {
            sortingAtoZ(12);
        } else if (e.getX() < 1635) {
            sortingAtoZ(13);
        } else if (e.getX() < 1750) {
            sortingAtoZ(14);
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
