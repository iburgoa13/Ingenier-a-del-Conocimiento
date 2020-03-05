package Chronometer;

public class Chrono {
    private long _ini;
    private long _end;
    private boolean _start;
    public void start(){
        _ini = System.currentTimeMillis();
        _start = true;
    }
    public void stop(){
        _end = System.currentTimeMillis();
        _start=false;
    }

    public long getElapsedTime(){
        long t;
        if(_start){
            t = (System.currentTimeMillis()-_ini);

        }
        else{
            t = (_end-_ini);
        }
        return t;
    }
    public long getElapsedTimeSec(){
        long t;
        if(_start){
            t = (System.currentTimeMillis()-_ini)/1000;

        }
        else{
            t = (_end-_ini)/1000;
        }
        return t;
    }
}
