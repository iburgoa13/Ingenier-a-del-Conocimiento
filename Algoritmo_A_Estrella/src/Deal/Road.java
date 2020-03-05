package Deal;

import java.util.ArrayList;

public class Road {
    protected ArrayList<Node> _coordRoad;
    public Road(){
        _coordRoad = new ArrayList<Node>();
    }
    public int getLength(){
        return _coordRoad.size();
    }
    public Node getCoordRoad(int index){
        return _coordRoad.get(index);
    }

    public int getX(int index){
        return _coordRoad.get(index).getX();
    }
    public int getY(int i){
        return _coordRoad.get(i).getY();
    }
    public void addCoordNode(Node n){
        _coordRoad.add(n);
    }
    //al principio
    public void preprendWayPoint(Node n){
        _coordRoad.add(0,n);
    }
    public boolean contains(int x, int y){
        Node o = new Node(x,y);
        for(Node n: _coordRoad){
            if(n.equals(o))return true;
        }
        return false;
    }
}
