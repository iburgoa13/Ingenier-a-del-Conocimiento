package Deal;

import Heuristic.HeuristicI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Algorithm_Astar {
    protected Map _map;
    protected HeuristicI _heu;
    private ArrayList<Node> _closedList;
    private ListaNodosOrdenadas _openList;
    private Road _road;
    public Algorithm_Astar(Map m, HeuristicI h){
        _map = m;
        _heu = h;
        _closedList = new ArrayList<Node>();
        _openList = new ListaNodosOrdenadas();
    }
    public ArrayList<Node> getClosedList(){
        return _closedList;
    }
    public Road calculateRoadShorter(Coordinates ini, Coordinates fin, int[][] obs){
        _map.setLocalitationIni(ini.getCoordX(),ini.getCoordY());
        _map.setLocalitationEnd(fin.getCoordX(),fin.getCoordY());
        _map.setMapObs(obs);
        _closedList = new ArrayList<Node>();
        _openList = new ListaNodosOrdenadas();

        if(_map.getNode(fin.getCoordX(),fin.getCoordY()).getObs()){
            return null;
        }
        _map.getNodeIni().setDistanceStart(0);
        _closedList.clear();
        _openList.clear();
        _openList.add(_map.getNodeIni());




        while(_openList.size()!=0){
            Node act = _openList.getFirst();
            if(act.getX()== _map.getEndX() && act.getY()== _map.getEndY()){
                return rebuildRoad(act);
            }
            _openList.remove(act);
            _closedList.add(act);


            for(Node n : act.getNeighBorList()){
                boolean bestN;
                if(_closedList.contains(n))continue;
                if(!n.getObs()){
                    float d = act.gerDistanceStart()+ _map.getDistance(act,n);
                    if(!_openList.contains(n)){
                        _openList.add(n);
                        bestN = true;
                    }
                    else if(d < act.gerDistanceStart()){
                        bestN = true;
                    }
                    else bestN = false;
                    if(bestN){
                        n.setPrevius(act);
                        n.setDistanceStart(d);
                        n.setHeuristicDG(_heu.calculateDistanceToEnd(n.getX(),n.getY(),_map.getEndX(),_map.getEndY()));
                    }
                }
            }
        }
        return null;
    }

    public Map getMap(){
        return _map;
    }
    public Road getRoad(){
        return _road;
    }
    private Road rebuildRoad(Node act) {
        Road r = new Road();
        while(act.getPrevius()!=null){
            r.preprendWayPoint(act);
            act = act.getPrevius();
        }
        _road = r;
        return r;
    }

    public void paintRoad(){
        Node n;
        for(int x=0; x<_map.getAnchura(); x++) {

            if (x==0) {
                for (int i=0; i<=_map.getAnchura(); i++)
                    System.out.print("-");
                System.out.println();
            }
            System.out.print("|");

            for(int y=0; y<_map.getAltura(); y++) {
                n = _map.getNode(x, y);
                if (n.getObs()) {
                    System.out.print("O");
                } else if (n.getStart()) {
                    System.out.print("I");
                } else if (n.getG()) {
                    System.out.print("F");
                } else if (_road.contains(n.getX(), n.getY())) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
                if (y==_map.getAltura())
                    System.out.print("_");
            }

            System.out.print("|");
            System.out.println();
        }
        for (int i=0; i<=_map.getAnchura(); i++)
            System.out.print("-");
    }

    private class ListaNodosOrdenadas {
        //Lista de nodos.
        private ArrayList<Node> list = new ArrayList<Node>();

        public Node getFirst() {
            return list.get(0);
        }

        public void clear() {
            list.clear();
        }

        public void add(Node node) {
            list.add(node);
            list.sort(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    if( o1.getHeuristicDistanceG() < o2.getHeuristicDistanceG())return 1;
                    return 0;
                }
            });
        }

        public void remove(Node n) {
            list.remove(n);
        }

        public int size() {
            return list.size();
        }
        // devuelve si esta ese nodo en la lista.
        public boolean contains(Node n) {
            return list.contains(n);
        }
    }
}
