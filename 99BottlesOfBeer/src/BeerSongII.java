/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lauren
 */
public class BeerSongII {
    public static void main(String[] args){
        //99 bottles of beer on the wall.
        //99 bottles of beer.
        //Take one down
        //Pass it around.
        //98 bottles of beer on the wall.
        //...
        //2 bottles of beer on the wall.
        //2 bottles of beer.
        //...
        //...
        //1 1 bottle of beer on the wall...
        // No more bottles of beer on the wall. 
        int num = 99;
        String word = "bottles";

        while( num > 0){
            if(num == 1){
                    word = "bottle";           
            }
            System.out.println(num + " " + word + " of beer on the wall.");
            System.out.println(num + " " + word + " of beer!");
            System.out.println("Take one down,");
            System.out.println("Pass it around,");
            num = num - 1;
        }
        System.out.println("No more bottles of beer on the wall.");
    }
}
