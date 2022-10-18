package com.yash;
import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JFrame;

class Window extends JFrame {
    private static final long serialVersionUID=-2542001418764869760L;
    public static ArrayList<ArrayList<DataOfSquare>> Grid;
    public static int width =20;
    public static int height=20;
    public Window(){

        Grid =new ArrayList<ArrayList<DataOfSquare>>();
        ArrayList<DataOfSquare> data;

        for(int i=0;i<width;i++){
            data = new ArrayList<DataOfSquare>();
            for(int j=0;j<height;j++){
                DataOfSquare c=new DataOfSquare(2);
                data.add(c);

            }
            Grid.add(data);

        }

        getContentPane().setLayout(new GridLayout(20,20,0,0));
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                getContentPane().add(Grid.get(i).get(j).square);
            }
        }

        //initial position of the snake
        Tuple position = new Tuple(10,10);
        //passing this value to the controller
        ThreadsController c = new ThreadsController(position);
        //game starts
        c.start();

        //Links the window to the keyboardListener.
        this.addKeyListener((KeyListener) new KeyboardListener());

        //Tuple position2 = new Tuple(13,13);
        //ControllerThreads c2 = new ControllerThreads(position2);
        //c2.start();
    }
}
