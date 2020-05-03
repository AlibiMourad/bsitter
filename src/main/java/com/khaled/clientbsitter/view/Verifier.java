/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khaled.clientbsitter.view;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class EmailVerifier extends InputVerifier {

    public boolean verify(JComponent input) {
        JTextField tf = (JTextField) input;
        String pass = tf.getText();

        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pass);

        if (matcher.matches()) {
            tf.setBackground(Color.white);
            return true;
        }
        tf.setBackground(Color.red);
        return false;

    }
}

class EmptyVerifier extends InputVerifier {

    public boolean verify(JComponent input) {
        JTextField tf = (JTextField) input;
        String pass = tf.getText();

        if (!pass.isEmpty()) {
            tf.setBackground(Color.white);
            return true;
        }
        tf.setBackground(Color.red);
        return false;
    }
}

class SamePasswdVerifier extends InputVerifier {

    JPasswordField jPasswordField1;

    public SamePasswdVerifier(JPasswordField jPasswordField1) {
        this.jPasswordField1 = jPasswordField1;
    }

    public boolean verify(JComponent input) {
        JTextField tf = (JTextField) input;
        String pass = tf.getText();

        if (pass.equals(this.jPasswordField1.getText())) {
            tf.setBackground(Color.white);
            return true;
        }
        tf.setBackground(Color.red);
        return false;
    }
}

class DegitVerifier8 extends InputVerifier {

    public boolean verify(JComponent input) {
        JTextField tf = (JTextField) input;
        String pass = tf.getText();

        if (pass.isEmpty() || pass.length() != 8) {
            tf.setBackground(Color.red);
            return false;
        }
        try {
            int d = Integer.parseInt(pass);
        } catch (NumberFormatException nfe) {
            tf.setBackground(Color.red);
            return false;
        }
        tf.setBackground(Color.white);
        return true;

    }
}

class DegitVerifier extends InputVerifier {

    public boolean verify(JComponent input) {
        JTextField tf = (JTextField) input;
        String pass = tf.getText();

        if (pass.isEmpty()) {
            tf.setBackground(Color.red);
            return false;
        }
        try {
            int d = Integer.parseInt(pass);
        } catch (NumberFormatException nfe) {
            tf.setBackground(Color.red);
            return false;
        }
        tf.setBackground(Color.white);
        return true;

    }
}

class DoubleVerifier extends InputVerifier {

    public boolean verify(JComponent input) {
        JTextField tf = (JTextField) input;
        String pass = tf.getText();

        if (pass.isEmpty()) {
            tf.setBackground(Color.red);
            return false;
        }
        try {
            double d = Double.parseDouble(pass);
        } catch (NumberFormatException nfe) {
            tf.setBackground(Color.red);
            return false;
        }
        tf.setBackground(Color.white);
        return true;

    }
}

