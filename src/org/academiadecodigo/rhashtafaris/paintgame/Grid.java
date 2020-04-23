package org.academiadecodigo.rhashtafaris.paintgame;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {
    public static final int PADDING = 10;
    public static final int CELL_SIZE = 10;

    private Rectangle rectangle;
    private int cols;
    private int rows;
    private Cell[][] cells;

    public Grid(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
    }

    public void init(){
        this.rectangle = new Rectangle(PADDING,PADDING,cols*CELL_SIZE,rows*CELL_SIZE);
        rectangle.draw();
        cells = CellFactory.generateCells(this);
        Cursor cursor = new Cursor(new GridPos(0,0), this);
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public Cell findCellByPos(GridPos pos){

        return cells[pos.getCol()][pos.getRow()];

    }
}
