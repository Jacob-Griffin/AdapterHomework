public class ListItemIconAdapter {
    private ListItem item;

    public ListItemIconAdapter(ListItem item) {
        this.item = item;
    }

    public ListItem getItem() {
        return item;
    }

    public ItemIcon getIcon(int diameter) {
        ItemIcon icon = new ItemIcon(item.getValA(), item.getValB(), diameter);
        return icon;
    }
}
