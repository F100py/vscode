package ColoringBook;
import java.awt.Color;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import DrawingLib.drawing.DrawingFrame;
import DrawingLib.drawing.KeyInterceptor.KeyHook;
import DrawingLib.drawing.MouseInterceptor.MouseHook;
import DrawingLib.drawing.Drawing;

public class Program {
    
    /**
     * Global static fields for the Drawing object being worked on
     * and the DrawingFrame containing and displaying it.
     */
    private static Drawing _drawing;
    private static DrawingFrame _frame;
    
    /**
     * Demonstrates a simple alteration to the drawing:
     * On a square section of the image, from top-left: (40,30) to bottom-right (140, 130)
     * replace the dark pixels with yellow and the bright pixels with yellow.
     */
    public static void paint() throws InterruptedException {
        for(int x = 40; x < 140; x++) {
            if (x == 90) {
                _frame.stop();
            }
            for (int y = 30; y < 130; y++) {
                _frame.step(1);
                Color c = _drawing.getPixel(x, y);
                if (_drawing.isDarkPixel(x, y)) {
                    _drawing.setPixel(x, y, c.brighter());
                } else {
                    _drawing.setPixel(x, y, c.darker());
                }
            }
        }
    }
    
    public static void recurseway(int x,int y, Color c){
        _drawing.setPixel(x, y, c);
        for (int i = 0; i<8; i++){
            int[] temp = getNeighbor(x, y, i);
            if (_drawing.isValidPixel(temp[0],temp[1])&&_drawing.isBrightPixel(temp[0],temp[1])&&!(_drawing.getPixel(temp[0], temp[1]).equals(c))){
                recurseway(temp[0], temp[1], c);
            }
        }
    }
    public static void stackWay(int x, int y, Color c) throws InterruptedException{
        _drawing.setPixel(x, y, c);
        @SuppressWarnings({ "rawtypes", "unchecked" })
        Stack<DrawTask> Tasks = new Stack();
        DrawTask t = new DrawTask(x, y, c);
        Tasks.push(t);
        while(!Tasks.isEmpty()){
            DrawTask d = Tasks.pop();
            for (int i = 0; i<8; i++){
                int[] temp = getNeighbor(d._x, d._y, i);
                if (_drawing.isValidPixel(temp[0],temp[1])&&_drawing.isBrightPixel(temp[0],temp[1])&&!(_drawing.getPixel(temp[0], temp[1]).equals(c))){
                    _frame.step(1/3);
                    _drawing.setPixel(temp[0],temp[1],d._c);
                    Tasks.push(new DrawTask(temp[0],temp[1],c));
                    _frame.repaint();
                }
            }
        }
    }
    @SuppressWarnings("unchecked")
    public static void queueWay(int x, int y, Color c) throws InterruptedException{
        _drawing.setPixel(x, y, c);
        @SuppressWarnings("rawtypes")
        Queue<DrawTask> Tasks = new LinkedList();
        DrawTask t = new DrawTask(x, y, c);
        Tasks.add(t);
        while(!Tasks.isEmpty()){
            DrawTask d = Tasks.remove();
            for (int i = 0; i<8; i++){
                int[] temp = getNeighbor(d._x, d._y, i);
                if (_drawing.isValidPixel(temp[0],temp[1])&&_drawing.isBrightPixel(temp[0],temp[1])&&!(_drawing.getPixel(temp[0], temp[1]).equals(c))){
                    _frame.step(1/3);
                    _drawing.setPixel(temp[0],temp[1],d._c);
                    Tasks.add(new DrawTask(temp[0],temp[1],c));
                    _frame.repaint();
                }
            }
        }
    }
    public static int[] getNeighbor(int x, int y, int p){
        int[] temp = new int[2];
        switch (p){
            case 0: {
                temp[0] = x-1;
                temp[1] = y+1;
                break;
            }
            case 1: {
                temp[0] = x;
                temp[1] = y+1;
                break;
            }
            case 2: {
                temp[0] = x+1;
                temp[1] = y+1;
                break;
            }
            case 3: {
                temp[0] = x+1;
                temp[1] = y;
                break;                
            }
            case 4: {
                temp[0] = x+1;
                temp[1] = y-1;
                break;
            }
            case 5: {
                temp[0] = x;
                temp[1] = y-1;
                break;
            }
            case 6: {
                temp[0] = x-1;
                temp[1] = y-1;
                break;
            }
            case 7: {
                temp[0] = x-1;
                temp[1] = y;
                break;
            }                
        }
        return temp;
    }


    static int t;
    public static MouseHook _onMouseClick = (mouseEvent) -> {
        if (t=='S')
            stackWay(_frame.getCanvasX(mouseEvent), _frame.getCanvasY(mouseEvent),new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));
        if (t=='R')
            recurseway(_frame.getCanvasX(mouseEvent), _frame.getCanvasY(mouseEvent),new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));
        if (t=='Q')
            queueWay(_frame.getCanvasX(mouseEvent), _frame.getCanvasY(mouseEvent),new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));
    };

    public static KeyHook _onKeyClick = (KeyHook) -> {
        t = KeyHook.getKeyCode();
    };
    /**
     * Main entry point in the program:
     * Initializes the static Drawing (_drawing) with an image of your choice,
     * then initializes the static DrawingFrame (_frame) loading into it the new drawing.
     * Subsequently the frame is opened on the screen then the drawing is painted upon
     * and displayed as it is being modified before the program terminates. 
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Welcome to the Coloring Festival!");
        
        // pick a drawing -- correct the path to point to the drawing of your choice
        _drawing = Drawing.read("Unit2\\ColoringBook\\drawings\\bird.jpg");
        
        // put it in a frame
        _frame = new DrawingFrame(_drawing);
        
        // put the frame on display and stop to admire it.
        _frame.open();
        
        // make some change to the drawing, then stop for applause.
        
        // setup a hook such that we know where we're clicking
        _frame.setKeyPressedHook('S', _onKeyClick);
        _frame.setKeyPressedHook('Q', _onKeyClick);
        _frame.setKeyPressedHook('R', _onKeyClick);
        _frame.setMouseClickedHook(_onMouseClick);

        
        // the show is over.

        
        System.out.println("Well done, goodbye!");
    }
}
