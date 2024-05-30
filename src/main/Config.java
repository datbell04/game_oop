package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Config {
    GamePanel gp;
    public Config(GamePanel gp){
        this.gp = gp;
    }
   

    public void saveConfig(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Config.txt"));
            

            // Full Screen
            if(gp.fullScreenOn == true){
                bw.write("On");
            }
            if(gp.fullScreenOn == false){
                bw.write("Off");
            }
        

            // Music  Se volume 
            bw.newLine();
            bw.write(String.valueOf(gp.music.volumeScale));

            bw.newLine();
            bw.write(String.valueOf(gp.se.volumeScale));

            bw.newLine();
            bw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader("Config.txt"));
            String s = br.readLine();
            if(s.equals("On")){
                gp.fullScreenOn = true;
            }
            if(s.equals("Off")){
                gp.fullScreenOn = false;
            }

            s = br.readLine();
            gp.music.volumeScale = Integer.parseInt(s);
            s = br.readLine();
            gp.se.volumeScale = Integer.parseInt(s);

            br.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
