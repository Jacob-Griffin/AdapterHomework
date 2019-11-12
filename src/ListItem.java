public class ListItem implements Comparable<ListItem> {
    private int valA;
    private int valB;

    public ListItem(int valA, int valB) {
        this.valA = valA;
        this.valB = valB;
    }

    public int getValA() {
        return valA;
    }

    public int getValB() {
        return valB;
    }

    @Override //add a comparator so collections.sort() will work
    public int compareTo(ListItem o) {
        if (valA > o.getValA()) {
            return 1;
        } else if (valA == o.getValA()) {
            return 0;
        } else {
            return -1;
        }
    }
}

