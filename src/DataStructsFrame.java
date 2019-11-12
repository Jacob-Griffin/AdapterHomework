import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class DataStructsFrame extends JFrame {
    public DataStructsFrame(String title, int[][] numbers) {
        super(title);

        final JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        final ArrayList<ListItem> list = arrayToList(numbers);

        final ListPanel unorderedList = new ListPanel("Unordered List");
        unorderedList.setDiameter(75);
        unorderedList.addItems(list);

        final ListPanel orderedList = new ListPanel("Ordered List");
        orderedList.setDiameter(100);

        JButton sortButton = new JButton("Sort List");
        sortButton.setSize(30, 10);
        sortButton.setAlignmentX(CENTER_ALIGNMENT);

        final JLabel inputLabel = new JLabel("Add New Items:");
        final JTextField input = new JTextField();
        JButton addButton = new JButton("Add Value(s)");

        sortButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Collections.sort(list);

                //Clean the list before adding stuff
                orderedList.removeAll();
                orderedList.addItems(list);

                //Refresh the view manually because unordered list might still be there
                panel.removeAll();
                panel.add(orderedList);
                panel.add(sortButton);
                panel.add(inputLabel);
                panel.add(input);
                panel.add(addButton);

                pack();
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Read the input
                String str = input.getText();

                //Comma-Separate the values
                String[] terms = str.split(",");

                //Read the comma separated values in pairs
                for (int i = 0; i < terms.length; i += 2) {
                    //parse each pair as a valA,valB
                    int valA = Integer.parseInt(terms[i]);
                    int valB = Integer.parseInt(terms[i + 1]);
                    //make a new item and add it to the list
                    list.add(new ListItem(valA, valB));
                }

                //Empty the input box
                input.setText("");

                //Reset the unordered list with the new values
                unorderedList.removeAll();
                unorderedList.addItems(list);

                //Refresh the view manually because ordered list might still be there
                panel.removeAll();
                panel.add(unorderedList);
                panel.add(sortButton);
                panel.add(inputLabel);
                panel.add(input);
                panel.add(addButton);

                pack();
            }
        });

        panel.add(unorderedList);
        panel.add(sortButton);
        panel.add(inputLabel);
        panel.add(input);
        panel.add(addButton);

        pack();
        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private ArrayList<ListItem> arrayToList(int[][] numbers) {
        ArrayList<ListItem> list = new ArrayList<ListItem>();

        for (int[] pair : numbers) {
            ListItem item = new ListItem(pair[0], pair[1]);
            list.add(item);
        }

        return list;
    }
}
