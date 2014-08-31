package minimusicplayer2;

import javax.sound.midi.*;

//implement the listener interface
public class MiniMusicPlayer2 implements ControllerEventListener {

    public static void main(String[] args) {
        MiniMusicPlayer2 mini = new MiniMusicPlayer2();
        mini.go();
    }
    public void go() {    
        try{
            //music machine
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            
            //register for events with the sequencer
            //this time we only want event #127
            int[] eventsIWant = {127};
            sequencer.addControllerEventListener(this, eventsIWant);
            
            
            //track holder
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            //track
            Track track = seq.createTrack();
            
            //make a bunch of events, notes 5-61
            for(int i = 5; i <61; i++){
                
                track.add(makeEvent(144,1,i,100,i));
                
                //insert our own ControllerEvent for event #127
                //message 176 event type contollerEvent
                track.add(makeEvent(176,1,127,0,i));
                
                track.add(makeEvent(128,1,i,100,i+2));
                
            }//end loop
            
            //start running
            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();
            
        } catch (Exception ex) { ex.printStackTrace(); }   
        
    }//close main
    
    //event handler method
    public void controlChange(ShortMessage event){
        System.out.println("la");
    }
    
    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick){
        
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
