import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.util.ArrayList;

public class ListPanel extends JPanel {
    private int diameter = 30;
    private ArrayList<ListItem> mList = null;

    public ListPanel(String title) {
        super();
        mList = new ArrayList<ListItem>();
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED), title));
    }

    public ListPanel(String title, ArrayList<ListItem> list) {
        this(title);
        addItems(list);
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
        repaint();
    }

    public void addItems(ArrayList<ListItem> list) {
        mList = (ArrayList<ListItem>) list.clone();
        for (ListItem item : mList)
            add(new JLabel(new ListItemIconAdapter(item).getIcon(diameter)));
    }
}