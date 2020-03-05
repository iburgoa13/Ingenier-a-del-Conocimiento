package Deal;

import java.util.ArrayList;

public class Node {
    protected Map _map;
    protected Node _N,_S,_E,_O,_NO,_NE,_SE,_SO;
    protected ArrayList<Node> _neighborList;
    protected boolean _visit;
    protected float _distanceStart;
    protected float _heuristicDistanceG;
    protected Node _previus;
    protected int _x;
    protected int _y;
    protected  boolean _obstacle;
    protected boolean _isStart;
    protected boolean _isGoal;

    public Node(int x, int y){
        _neighborList = new ArrayList<Node>();
        _x = x;
        _y = y;
        _visit = false;
        _distanceStart = Integer.MAX_VALUE;
        _obstacle = false;
        _isStart = false;
        _isGoal = false;
    }


    public Node(int x, int y, boolean v, float dS, boolean obs, boolean st, boolean ig){
        _x = x;
        _y = y;
        _distanceStart = dS;
        _obstacle = obs;
        _isGoal = ig;
        _isStart = st;
        _visit = v;
        _neighborList = new ArrayList<Node>();
    }
    public Node GetN(){
        return _N;
    }
    public void setN(Node n){
        if(_neighborList.contains(_N))
            _neighborList.remove(_N);
        _neighborList.add(n);
        _N = n;
    }
    public Node getNE(){
        return _NE;
    }
    public void setNE(Node ne){
        if(_neighborList.contains(_NE))
            _neighborList.remove(_NE);
        _neighborList.add(ne);
        _NE = ne;
    }



    public Node getE(){
        return _E;
    }

    public void setE(Node e){
        if(_neighborList.contains(_E))
            _neighborList.remove(_E);
        _neighborList.add(e);
        _E = e;
    }

    public Node getSE(){
        return  _SE;
    }

    public void setSE(Node se){
        if(_neighborList.contains(_SE))
            _neighborList.remove(_SE);
        _neighborList.add(se);
        _SE = se;
    }

    public Node getS(){
        return  _S;
    }
    public void setS(Node s){
        if(_neighborList.contains(_S))
            _neighborList.remove(_S);
        _neighborList.add(s);
        _S = s;
    }

    public Node getSO(){
        return _SO;
    }

    public void setSO(Node so){
        if(_neighborList.contains(_SO))
            _neighborList.remove(_SO);
        _neighborList.add(so);
        _SO = so;
    }

    public Node getO(){
        return this._O;
    }
    public void setO(Node o){
        if(_neighborList.contains(_O))
            _neighborList.remove(_O);
        _neighborList.add(o);
        _O = o;
    }

    public Node getNO(){
        return _NO;
    }
    public void setNO(Node no){
        if(_neighborList.contains(_NO))
            _neighborList.remove(_NO);
        _neighborList.add(no);
        _NO = no;
    }

    public ArrayList<Node> getNeighBorList(){
        return _neighborList;
    }
    public boolean getVisit(){
        return _visit;
    }
    public void setVisit(boolean v){
        _visit = v;
    }
    public float gerDistanceStart(){
        return _distanceStart;
    }
    public void setDistanceStart(float f){
        _distanceStart = f;
    }
    public Node getPrevius(){
        return _previus;
    }
    public void setPrevius(Node p){
        _previus = p;
    }
    public float getHeuristicDistanceG(){
        return _heuristicDistanceG;
    }
    public void setHeuristicDG(float h){
        _heuristicDistanceG = h;
    }
    public int getX(){
        return _x;
    }
    public void setX(int x){
        _x = x;
    }
    public int getY(){
        return _y;
    }
    public void setY(int y){
        _y = y;
    }
    public boolean getObs(){
        return _obstacle;
    }
    public void setObs(boolean o){
        _obstacle = o;
    }
    public boolean getStart(){
        return _isStart;
    }
    public void setStart(boolean i){
        _isStart = i;
    }
    public boolean getG(){
        return _isGoal;
    }
    public void setG(boolean g){
        _isGoal = g;
    }
    public boolean equals(Node n){
        return n._x == _x && n._y == _y;
    }
    public int compareTo(Node other){
        float total = _heuristicDistanceG+_distanceStart;
        float other_total = other._heuristicDistanceG+other._distanceStart;
        if(total < other_total)return -1;
        if(total > other_total)return 1;
        return 0;

    }





}
