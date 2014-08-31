package jukebox1;

import java.util.*;
import java.io.*;

public class JukeBox1 {
    
    //Somewhere to store the song lists
    ArrayList<Song> songList = new ArrayList<Song> ();
    
    public static void main(String [] args) {
        new JukeBox1().go();
    }
    
    //A new inner class that implements Comparator
    class ArtistCompare implements Comparator<Song> {
        public int compare(Song one, Song two) {
            return one.getArtist().compareTo(two.getArtist());
        }
    }
    
    // The method that starts loading the file and
    //then prints the Songlist array
    public void go(){
        getSongs();
        System.out.println(songList);
        //Call the static Collections sort() method
        Collections.sort(songList);
        System.out.println("\n Compare Title \n"+ songList);
        
        //make a new instance of the camparatorinner class
        ArtistCompare artistCompare = new ArtistCompare();
        Collections.sort(songList, artistCompare);
        System.out.println("\n Compare Artist \n"+ songList);
        
    }
    
    void getSongs(){
        try {
            File file = new File("SongList.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine())!= null){
                addSong(line);
            }
        }catch (Exception ex) { ex.printStackTrace(); }
    }
    
    void addSong(String lineToParse){
        String[] tokens = lineToParse.split("/");
        Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
        songList.add(nextSong);
    }
 }
 class Song implements Comparable<Song> {
     String title;
     String artist;
     String rating;
     String bpm;
     
     public int compareTo(Song s){
         return title.compareTo(s.getTitle());
     }
     
     Song(String t, String a, String r, String b) {
         title = t;
         artist = a;
         rating = r;
         bpm = b;
     }
     
     public String getTitle() {
         return title;
     }
     public String getArtist() {
         return artist;
     }
     public String getRating() {
         return rating;
     }
     public String getBpm(){
         return bpm;
     }
     // We override toString() because when you do a prinln(aSongObject)
     //we want to see the title not each element in the list.
     public String toString(){
         return title;
     }
 }