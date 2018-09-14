package fr.superprof.model;

public abstract class Item {

    private Boolean visibility;
    private Boolean found;
    private Cell cell;

    public Item(Cell cell) {
        this.cell = cell;
        this.visibility = true;
        this.found = false;
    }

    public Integer getVisibility(){
        return null;
    }

    public Boolean isHidden(){
        return !this.visibility;
    }

    public Boolean isFound(){
        return this.found;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void setVisibility(Boolean visibility) {
        this.visibility = visibility;
    }

    public void setFound(Boolean found) {
        this.found = found;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }
}
