package com.gmail.merikbest2015.JavaOOP.homework.lec03.polymorph.practice;

import javax.swing.*;

public class MainTwo {
    public static void main(String[] args) {
        double a;

        for (; ; ) {
            try {
                a = Double.valueOf(JOptionPane.showInputDialog("Input double number"));
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error nuber format.");
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Canceled. Set default value");
                a = 0;
                break;
            }
        }
        System.out.println(a);
    }
}
