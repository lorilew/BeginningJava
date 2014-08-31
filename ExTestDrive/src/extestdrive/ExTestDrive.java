

package extestdrive;

class MyEx extends Exception{}

public class ExTestDrive {

    public static void main(String[] args) {
        
        String test = "yes";
        try{
            System.out.print("t");
            doRisky(test);
            System.out.print("a");
        } catch(MyEx e) {
            System.out.print("o");
        } finally {
            System.out.print("w");
            System.out.println("s");
        }
    
    }
    static void doRisky(String t) throws MyEx {
        System.out.print("h");
        System.out.print("r");
        if ("yes".equals(t)){
            throw new MyEx();
        }
    }
}
    
