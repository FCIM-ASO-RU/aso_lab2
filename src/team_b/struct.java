package team_b;

public class struct {
    public boolean error;
    public String message;
    public boolean stopSignal;
    public int storeCurrent;
    public int fromAll;
    public struct(){
        error = false;
        message = "";
        stopSignal = false;
        storeCurrent = 0;
        fromAll = 0;
    }
}