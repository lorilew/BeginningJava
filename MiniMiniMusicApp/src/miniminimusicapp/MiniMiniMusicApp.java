
package miniminimusicapp;

import javax.sound.midi.*;

public class MiniMiniMusicApp {

    public static void main(String[] args) {
        MiniMiniMusicApp mini = new MiniMiniMusicApp();
        mini.play();
    }
    
    public void play(){
        try{
            Sequencer player = MidiSystem.getSequencer();
            player.open();
            
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            
            Track track = seq.createTrack();
            
            
            //START PLAYING NOTE 44 (LOW 0 - HIGH 127)
            //MESSAGE TYPE 144 - NOTE ON
            //CHANNEL 1
            //VELOCITY 100 - DEFAULT
            ShortMessage a = new ShortMessage();
            a.setMessage(144,1,44,100);
            MidiEvent noteOn = new MidiEvent(a,1);
            
            //A TRACK HOLDS ALL THE MIDIEVENT OBJECTS
            track.add(noteOn);
            
            //END PLAYING NOTE
            //MESSAGE TYPE 128 - NOTE OFF
            ShortMessage b = new ShortMessage();
            b.setMessage(128,1,44,100);
            MidiEvent noteOff = new MidiEvent(b,16);
            track.add(noteOff);
            
            player.setSequence(seq);
            
            player.start();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
