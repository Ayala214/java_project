package client;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import server.Place;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;



/**
 *
 * @author student
 */
public class Form extends JFrame {

    static ArrayList<Place> ListPlace;
    public static final String[][] NUMBER_TEXTS = {
            {"26", "27", "28", "29", "30"},
            {"21", "22", "23", "24", "25"},
            {"16", "17", "18", "19", "20"},
            {"11", "12", "13", "14", "15"},
            {"6", "7", "8", "9", "10"},
            {"1", "2", "3", "4", "5"}
    };
    private static PopupMenu mainPanel;
    List<JButton> btnlst;
    static ConnectionServer client;

    public Form(ConnectionServer C) {
        //initComponents();
        client = C;
        this.btnlst = new ArrayList<JButton>();
        ListPlace = client.ReadFromeServer();
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (JButton btn : btnlst) {
                    if (e.getSource().equals(btn)) {
                        if(func(btn.getName()))
                            btn.setBackground(Color.YELLOW);
                    }
                }
            }

            private boolean func(String name) {
                int i, j;
                i = Integer.valueOf(name) / 5;//שורה
                j = Integer.valueOf(name) % 5;//עמודה
                //jPanel1.
                client.WriteToServer(i + ":" + j);
                boolean ok = client.ReadboolFromeServer();
                if (!ok) {
                    JOptionPane.showMessageDialog(null, "מקומך נבחר בהצלחה");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "המקום שנבחר תפוס, בחר מקום אחר");
                    return false;
                }
            }
        };
        int i = 0, j = 0, x = 1;

        JPanel titlePanel = new JPanel();
        setLayout(new GridLayout(5, 6));
        JLabel title = new JLabel("בחר מקום רצוי");
        title.setFont(new Font("Comic Sans", Font.BOLD, 20));
        //title.setSize(12, 12);
        titlePanel.add(title);

        // buttonsPanel.setSize(700, 100);
        getContentPane().add(titlePanel, BorderLayout.BEFORE_FIRST_LINE);

        for (String[] row : NUMBER_TEXTS) {
            JPanel buttonsPanel = new JPanel();
            for (String cell : row) {
                //setSize(500, 500);

                JButton button = new JButton(cell);
                button.setSize(new Dimension(700, 100));
                button.setBounds(345, 200, 300, 150);
                button.setVerticalAlignment(SwingConstants.BOTTOM);
                button.setHorizontalAlignment(SwingConstants.RIGHT);
                button.addActionListener(actionListener);
                button.setText(String.valueOf(x));
                button.setName(String.valueOf(x++-1));
                for (Place item : ListPlace) {
                    if ((item.getI() == i) && (item.getJ() == j)) {
                        if (item.isIfcatch()) {
                            button.setBackground(Color.YELLOW);
                            System.out.println(i + "   " + j);
                        }
                    }
                }

                buttonsPanel.add(button);
                btnlst.add(button);

                j++;
            }
            j = 0;
            i++;
            getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
        }

    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 873, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 469, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


}

// Variables declaration - do not modify//GEN-BEGIN:variables
// End of variables declaration//GEN-END:variables
//}
//}
//}
