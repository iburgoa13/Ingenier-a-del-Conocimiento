package Heuristic;

public class Heuristic implements HeuristicI {

    @Override
    public float calculateDistanceToEnd(int iniX, int iniY, int endX, int endY) {
        float _dx = endX - iniX;
        float _dy = endY -iniY;
        double a;
        double b;
         a = (float)Math.pow(_dx,2);
         b = (float)Math.pow(_dy,2);
        return (float) Math.sqrt(a+b);
    }
}
