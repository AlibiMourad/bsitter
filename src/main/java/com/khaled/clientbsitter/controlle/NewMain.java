/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khaled.clientbsitter.controlle;

import com.khaled.clientbsitter.model.Parents;
import com.khaled.clientbsitter.model.Sitter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moura
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ParentsControlle parentsControlle = new ParentsControlle();
        try {
            List<Parents> listParents = parentsControlle.getAllParents();
        } catch (Exception ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }

        SitterControlle sitterControlle = new SitterControlle();
        try {
            List<Sitter> listSitters = sitterControlle.getAllSitters();
        } catch (Exception ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
