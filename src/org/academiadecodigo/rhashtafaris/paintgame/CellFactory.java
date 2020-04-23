package org.academiadecodigo.rhashtafaris.paintgame;

public class CellFactory {

    public static Cell[][] generateCells(Grid mygrid){
        int cols = mygrid.getCols();
        int rows = mygrid.getRows();
        Cell[][] cells = new Cell[cols][rows];

        for (int i = 0; i<cols; i++){
            for (int j = 0; j<rows; j++){
                cells[i][j] = new Cell(new GridPos(i,j));
            }
        }

        return cells;
    }
}
