package exercise1.model;

public class SortOrder {

    private final int sortBy;
    private final int sortOrder;

    public SortOrder(int sortBy, int sortOrder) {
        this.sortBy = sortBy;
        this.sortOrder = sortOrder;
    }

    public int getSortBy() {
        return sortBy;
    }

    public int getSortOrder() {
        return sortOrder;
    }
}