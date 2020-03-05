package Deal;

public class Coordinates<_x> {
    protected int _x;
    protected int _y;

    public Coordinates(int x, int y){
        _x = x;
        _y = y;
    }

    public int getCoordX() {
        return _x;
    }
    public int getCoordY(){
        return _y;
    }
    public void setCoordX(int x){
        _x = x;
    }
    public void setCoordY(int y){
        _y = y;
    }
}
