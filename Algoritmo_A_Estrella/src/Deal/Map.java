package Deal;

import java.util.ArrayList;

public class Map {
    protected int _w;
    protected int _h;
    protected ArrayList<ArrayList<Node>> _map;
    private int _iniX;
    private int _iniY;
    protected  int _endX;
    protected int _endY;
    private int[][] _mapObs;

    public Map(int h, int w){
        _w = w;
        _h = h;
        _mapObs = new int[_w+1][_h+1];
        createMap();
        createBorderMap();

    }

    public void createMap(){
        Node n;
        _map = new ArrayList<ArrayList<Node>>();
        for(int i = 0; i < _w;i++){
            _map.add(new ArrayList<Node>());
            for(int j = 0; j < _h; j++){
                n = new Node(i,j);
                if(_mapObs[i][j]==1)
                    n.setObs(true);
                _map.get(i).add(n);
            }
        }
    }
    public void createBorderMap(){
        for(int i = 0; i < _w; i++){
            for(int j = 0; j < _h; j++){
                Node n = _map.get(i).get(j);
                if(j!=0)
                    n.setN(_map.get(i).get(j-1));
                if(j!=0 && i !=_w-1)
                    n.setNE(_map.get(i+1).get(j-1));
                if(i!=_w-1)
                    n.setE(_map.get(i+1).get(j));
                if(i!=_w-1 && j!=_h-1)
                    n.setSE(_map.get(i+1).get(j+1));
                if(j!=_h-1)
                    n.setS(_map.get(i).get(j+1));
                if(i!=0 && j !=_h-1)
                    n.setSO(_map.get(i-1).get(j+1));
                if(i!=0)
                    n.setO(_map.get(i-1).get(j));
                if(i!=0 && j!=0)
                    n.setNO(_map.get(i-1).get(j-1));
            }
        }
    }
    public ArrayList<ArrayList<Node>> getNodes(){
        return _map;
    }
    public void setObs(int x, int y, boolean o){
        _map.get(x).get(y).setObs(o);
    }
    public Node getNode(int i, int j){
        return _map.get(i).get(j);
    }

    public void setLocalitationIni(int i, int j){
        _map.get(_iniX).get(_iniY).setStart(false);
        _map.get(i).get(j).setStart(true);
        _iniX = i;
        _iniY = j;
    }
    public void setLocalitationEnd(int i, int j){
        _map.get(_endX).get(_endY).setG(false);
        _map.get(i).get(j).setG(true);
        _endX = i;
        _endY = j;
    }


    public int getIniX(){
        return _iniX;
    }
    public int getIniY(){
        return _iniY;
    }
    public Node getNodeIni(){
        return _map.get(_iniX).get(_iniY);
    }

    public int getEndX(){
        return _endX;
    }
    public int getEndY(){
        return _endY;
    }
    public Node getNodeEnd(){
        return _map.get(_endX).get(_endY);
    }

    public float getDistance(Node n1, Node n2){
        if(n1.getX()==n2.getX() || n1.getY()==n2.getY()){
            return 1*(_h+_w);
        }
        else{
            return (float) 1.7*(_h+_w);
        }
    }
    public int getAltura(){
        return _h;
    }
    public int getAnchura(){
        return _w;
    }
    public void clear(){
        _iniY=0;
        _iniX=0;
        _endY=0;
        _endX=0;
        createMap();
        createBorderMap();
    }
    public void setMapObs(int[][] m){
        _mapObs = m;
        createMap();
        createBorderMap();
    }
}
