package org.academiadecodigo.rhashtafaris.paintgame;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {

    private GridPos pos;
    private Rectangle box;
    private boolean isPainted;

    public Cell(GridPos pos) {
        this.pos = pos;
        this.box = new Rectangle((pos.getCol() * Grid.CELL_SIZE)+ Grid.PADDING,(pos.getRow() * Grid.CELL_SIZE)+ Grid.PADDING, Grid.CELL_SIZE, Grid.CELL_SIZE);
        init();
    }

    private void init(){
        box.setColor(Color.BLACK);
        box.draw();
    }


    public void paint() {
        if(!isPainted){
            changeColor();
            //box.setColor(Color.GREEN);
            box.fill();
            isPainted = true;
            return;
        }
        box.setColor(Color.BLACK);
        box.draw();
        isPainted = false;
    }

    private void changeColor(){
        int random = (int) (Math.random()*6);
        switch (random){
            case 0:
                box.setColor(Color.BLUE);
                break;
            case 1:
                box.setColor(Color.RED);
                break;
            case 2:
                box.setColor(Color.PINK);
                break;
            case 3:
                box.setColor(Color.ORANGE);
                break;
            case 4:
                box.setColor(Color.GREEN);
                break;
            case 5:
                box.setColor(Color.YELLOW);
                break;
        }
    }

}
