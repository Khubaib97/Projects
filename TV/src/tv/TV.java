/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tv;

/**
 *
 * @author Khubaib
 */
public class TV {
int channel;
int volume;
boolean on;
public TV(){
    channel = 1;
    volume = 1;
    on = true;
}
public void turnOn(){
    on = true;
}
public void turnOff(){
    on = false;
}
public void setChannel(int chnl){
    if(chnl<1 || chnl>120){
        System.out.println("Channel out of range.");
    }
    else{
    channel = chnl;
    }
}
public void setVolume(int vlm){
    if(vlm<1 || vlm>7){
        System.out.println("Volume out of range.");
    }
    else{
    volume = vlm;
    }
}
public void channelUp(){
    if(channel==120){
        channel = 1;
    }
    else{
    channel++;
    }
}
public void channelDown(){
    if(channel==1){
        channel = 120;
    }
    else{
    channel--;
    }
}
public void volumeUp(){
    if(volume==7){
        System.out.println("Volume at max.");
    }
    else{
    volume++;
    }
}
public void volumeDown(){
    if(volume==1){
        System.out.println("Volume at min.");
    }
    else{
    volume--;
    }
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TV tv = new TV();
        while(tv.on==true){
            System.out.println("");
        }
    }
    
}
