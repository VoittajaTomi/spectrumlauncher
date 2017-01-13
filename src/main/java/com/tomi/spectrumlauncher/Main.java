/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tomi.spectrumlauncher;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.ComboBox;
import com.googlecode.lanterna.gui2.DefaultWindowManager;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.LinearLayout;
import static com.googlecode.lanterna.gui2.LinearLayout.Alignment.End;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.TextBox;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.regex.Pattern;

public class Main {

    public static void main(final String[] args) throws IOException {
        // Setup terminal and screen layers
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        screen.startScreen();

        Panel mainPanel = new Panel();

        mainPanel.setLayoutManager(new LinearLayout());
        mainPanel.addComponent(new Label("Spectrum_Launcher"));
        mainPanel.addComponent(new EmptySpace());
        // Create panel to hold components
        Panel panel = new Panel();
        mainPanel.addComponent(panel);
        panel.setLayoutManager(new LinearLayout());

        final Label lblFilename = new Label("");
        final BasicWindow window = new BasicWindow();
        panel.addComponent(new Label("Filename: "));
        panel.addComponent(lblFilename);

        panel.addComponent(new Label("Num 2"));
        final TextBox txtField = new TextBox().addTo(panel);

        panel.addComponent(new EmptySpace(new TerminalSize(0, 0)));
        
        // https://github.com/mabe02/lanterna/blob/master/docs/examples/gui/action_list_box.md

        new Button("Action x", new Runnable() {
            @Override
            public void run() {
                lblFilename.setText(args[0]);

            }
        }).addTo(panel);
        
        new Button("Close", new Runnable(){
            @Override
            public void run(){
                System.exit(0);
            }
        }).addTo(panel);

        // Create window to hold the panel

        window.setComponent(mainPanel);

        // Create gui and start gui
        MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));
        gui.addWindowAndWait(window);

    }

}
