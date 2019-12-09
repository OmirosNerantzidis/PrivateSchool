
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateschool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author omiro
 */
public class PrivateSchool {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println("PRIVATE SCHOOL - THE JAVA PROGRAM");
        System.out.println("---------------------------------");
        System.out.println("");
        System.out.println("Written by Omiros Nerantzidis");
        System.out.println("");
        System.out.println("Tested in NetBeans IDE 8.2");
        System.out.println("");

        // Intro Music
        String soundFile = "music\\\\indy.wav";
        InputStream in;
        try {
            in = new FileInputStream(soundFile);

            AudioStream audioStream = new AudioStream(in);

            AudioPlayer.player.start(audioStream);

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }

        ////
        Menus.Intro.intro();

    }

}
