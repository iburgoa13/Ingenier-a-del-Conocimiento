package Deal;

public class Transfer {
    protected Coordinates _ini;
    protected Coordinates _end;

    protected int[][] _obstacleMap;

    protected long  _costTime;

    public Transfer(Coordinates ori,Coordinates end, int[][] o){
        _ini = ori;
        _end = end;
        _obstacleMap = o;
        _costTime = 0;
    }
    public Transfer(){}

    public Coordinates getCoordIni(){
        return _ini;
    }
    public Coordinates getCoordEnd(){
        return _end;
    }
    public void setCoordIni(Coordinates i){
        _ini = i;
    }
    public void setCoordEnd(Coordinates e){
        _end = e;
    }

    public int[][] getObstacleMap(){
        return _obstacleMap;
    }
    public void setObstacleMap(int[][] x){
        _obstacleMap = x;
    }
    public long getCostTime(){
       return _costTime;
    }
    public void setCostTime(long l){
        _costTime = l;
    }

}
