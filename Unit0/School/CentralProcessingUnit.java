package Unit0.School;

public class CentralProcessingUnit {
    private int cores;
    private int volts;
    private int frequency;
    private String socketType;

    public String getSocketType(){return socketType;}
    public int getCores(){return cores;}
    public int getVolts(){return volts;}
    public int getFrequency(){return frequency;}

    public CentralProcessingUnit(int cores,int volts,int frequency,String socketType){
        this.volts = volts;
        this.cores = cores;
        this.frequency = frequency;
        this.socketType = socketType;
    }

    public void upgrade(String stat){
        if (stat.equals("cores"))
            cores += 4;
        else if (stat.equals("volts"))
            volts += 5;
        else if (stat.equals("frequency"))
            frequency+=1;
    }

    public boolean isValid(){
        if (cores<8)
            return false;
        if (volts<60)
            return false;
        if (frequency<3)
            return false;
        if (!socketType.equals("AM4"))
            return false;
        return true;
    }
}
