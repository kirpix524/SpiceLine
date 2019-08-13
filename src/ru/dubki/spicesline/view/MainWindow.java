package ru.dubki.spicesline.view;

import ru.dubki.spicesline.controller.interfaces.ControlCenterGUIInterface;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    final ControlCenterGUIInterface controlCenter;
    private JPanel bottomMenu;

    //
    private final Dimension PREFERRED_SIZE_BOTTOM_MENU = new Dimension(1, 60);
    private final String DEFAULT_CAPTION = "Тараканьи бега";
    private final int DEFAULT_X = 50;
    private final int DEFAULT_Y = 100;
    private final int DEFAULT_WIDTH = 1200;
    private final int DEFAULT_HEIGHT = 500;
    private final String CAPTION_BUTTON_EXIT="Выход";
    private final String CAPTION_BUTTON_MOVE="Двигать конвейер";

    //


    public MainWindow(ControlCenterGUIInterface controlCenter) {
        if (controlCenter==null) {
            throw new IllegalArgumentException("control center must not be null");
        }
        this.controlCenter=controlCenter;
        setTitle(DEFAULT_CAPTION);
        setBounds(DEFAULT_X, DEFAULT_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setResizable(true);
        initMenusAndPanels();
        setVisible(true);
    }

    private void initMenusAndPanels() {
        bottomMenu = getBottomMenu();
        this.add(bottomMenu, BorderLayout.SOUTH);
        //
        JPanel mainMenu = getMainMenu();
        bottomMenu.add(mainMenu, "mainMenu");
        //
        ((CardLayout) bottomMenu.getLayout()).show(bottomMenu, "mainMenu");
    }

    private JPanel getBottomMenu() {
        JPanel bottom = new JPanel(new CardLayout());
        bottom.setPreferredSize(PREFERRED_SIZE_BOTTOM_MENU); //
        return bottom;
    }

    private JPanel getMainMenu() {
        JPanel mainMenu = new JPanel(new GridLayout());
        JButton buttonStartRace = new JButton(CAPTION_BUTTON_MOVE);
        buttonStartRace.addActionListener(e -> {
            controlCenter.moveAllConveyors();
        });
        mainMenu.add(buttonStartRace);
        //
        JButton buttonExit = new JButton(CAPTION_BUTTON_EXIT);
        buttonExit.addActionListener(e -> {
            System.exit(0);
        });
        mainMenu.add(buttonExit);
        //
        return mainMenu;
    }
}
