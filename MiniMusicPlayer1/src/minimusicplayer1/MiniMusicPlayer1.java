package minimusicplayer1;

import javax.sound.midi.*;

public class MiniMusicPlayer1 {

    public static void main(String[] args) {
        
        try{
            //music machine
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            
            //track holder
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            //track
            Track track = seq.createTrack();
            
            //make a bunch of events, notes 5-61
            for(int i = 5; i <61; i++){
                
                track.add(makeEvent(144,1,i,100,i));
                track.add(makeEvent(128,1,i,100,i+2));
                
            }//end loop
            
            //start running
            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();
            
        } catch (Exception ex) { ex.printStackTrace(); }   
        
    }//close main
    
    public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick){
        
        MidiEvent event = null;
        try{
            //make message and create the event
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
            
        } catch (Exception e) {}
        return event;
        
    }//close make event
    
}//close class
