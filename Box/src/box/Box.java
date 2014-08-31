package box;

import java.io.*;

public class Box implements Serializable {

    private int width;
    private int height;
    
    public void setWidth(int w){
        width = w;
    }
    
    public void setHeight(int h){
        height = h;
    }
    
    public static void main(String[] args) {
        
        Box myBox = new Box();
        myBox.setWidth(50);
        myBox.setHeight(20);
        
        try{
            //Connect to a file box.ser if it exists
            //If not, a new file is made.
            FileOutputStream fs = new FileOutputStream("box.ser");
            //chain to the connection stream 
            ObjectOutputStream os = new ObjectOutputStream(fs);
            //Tell it to write an object
            os.writeObject(myBox);
            os.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
}
