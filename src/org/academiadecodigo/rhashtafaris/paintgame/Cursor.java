package org.academiadecodigo.rhashtafaris.paintgame;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Cursor implements KeyboardHandler {

    private Rectangle box;
    private GridPos posBox;
    private Grid myGrid;
    private Cell cell;

    public Cursor(GridPos posBox, Grid myGrid) {
        this.box = new Rectangle(Grid.PADDING, Grid.PADDING, Grid.CELL_SIZE, Grid.CELL_SIZE);
        this.posBox = posBox;
        box.setColor(Color.BLUE);
        box.fill();
        this.myGrid = myGrid;
        init();
    }

    public void init() {
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(right);
        keyboard.addEventListener(left);
        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(space);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                moveRight();
                break;
            case KeyboardEvent.KEY_LEFT:
                moveLeft();
                break;
            case KeyboardEvent.KEY_DOWN:
                moveDown();
                break;
            case KeyboardEvent.KEY_UP:
                moveUp();
                break;
            case KeyboardEvent.KEY_SPACE:
                spaceDelete();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void moveRight() {
        if (posBox.getCol() < myGrid.getCols() - 1) {
            posBox.moveTo(1, 0);
            box.translate(Grid.CELL_SIZE, 0);
            System.out.println(posBox.toString());
        }
    }

    public void moveLeft() {
        if (posBox.getCol() > 0) {
            posBox.moveTo(-1, 0);
            box.translate(-Grid.CELL_SIZE, 0);
            System.out.println(posBox.toString());
        }

    }

    public void moveUp() {
        if (posBox.getRow() > 0) {
            posBox.moveTo(0, -1);
            box.translate(0, -Grid.CELL_SIZE);
            System.out.println(posBox.toString());
        }
    }

    public void moveDown() {
        if (posBox.getRow() < myGrid.getRows() - 1) {
            posBox.moveTo(0, 1);
            box.translate(0, Grid.CELL_SIZE);
            System.out.println(posBox.toString());
        }
    }

    public void spaceDelete() {
        Cell cell = myGrid.findCellByPos(posBox);
        cell.paint();


    }
}
