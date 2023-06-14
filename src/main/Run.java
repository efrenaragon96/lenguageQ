/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import javax.swing.JFileChooser;
import visitor.InterpreteVisitor;
import visitor.TraductorVisitor;

/**
 *
 * @author juanluis
 */
public class Run {

    public static void main(String[] args) throws Exception {
//        String currentDir = System.getProperty("user.dir");
//        JFileChooser chooser = new JFileChooser(currentDir);
//        int r = chooser.showOpenDialog(null);
//        if (r == JFileChooser.APPROVE_OPTION) {
        File file = new File("prueba.txt");//chooser.getSelectedFile();
//        System.out.println("prueba");
//        TraductorVisitor traductor = new TraductorVisitor();
//        traductor.compile(file);
        
        
        System.out.println("\n\n//////////////////////////////////////////\n\n");
        
        InterpreteVisitor visitor = new InterpreteVisitor();
        visitor.interpret(file);
        System.exit(0);
    }

}
