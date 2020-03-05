package Controller;

import Chronometer.Chrono;
import Deal.Algorithm_Astar;
import Deal.Map;
import Deal.Transfer;
import Heuristic.Heuristic;

public class Controller {
    public static final int CALCULAR_CAMINO_MAS_CORTO = 001;
    public static final int GET_CAMINO_MAS_CORTO = 002;
    Algorithm_Astar pathFinder;
    private Heuristic interfazHeuristic;
    private Map mapaLogico;







    public Controller(int anchuraTablero, int alturaTablero) {

        // Inicializamos el mapa.
        mapaLogico = new Map(anchuraTablero, alturaTablero);
        // Inicializamos la heurística.
        interfazHeuristic = new Heuristic();

        // Inicializamos el algoritmo
        pathFinder = new Algorithm_Astar(mapaLogico, interfazHeuristic);
       // System.out.println(pathFinder.getClosedList().toString());
    }







    public Object action(int evento, Object datos) {


        switch (evento) {

            case CALCULAR_CAMINO_MAS_CORTO:{
                Transfer miTransfer = (Transfer) datos;

                Chrono crono = new Chrono();
                crono.start();
                pathFinder.calculateRoadShorter(miTransfer.getCoordIni(),miTransfer.getCoordEnd(),miTransfer.getObstacleMap());
                crono.stop();

                miTransfer = new Transfer();
                miTransfer.setCostTime(crono.getElapsedTime());
                datos = miTransfer;

            }break;

            case GET_CAMINO_MAS_CORTO:

                datos = pathFinder.getRoad();

                break;

            default:
                break;
        }
        return datos;
    }
}
