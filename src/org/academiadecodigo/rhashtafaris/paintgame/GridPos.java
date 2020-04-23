package org.academiadecodigo.rhashtafaris.paintgame;

public class GridPos {

    private int col;
    private int row;

    public GridPos(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    // suma las veces que sea necesario (posicion logica)
    public void moveTo(int col, int row){
        this.col += col;
        this.row += row;
    }

    @Override
    public String toString() {
        return "GridPos{" +
                "col=" + col +
                ", row=" + row +
                '}';
    }
}
