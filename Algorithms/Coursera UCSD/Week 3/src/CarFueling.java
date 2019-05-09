import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops)
    {
        int currentP = 0;                                   //current position
        int tankR = tank;                                   //rank remain
        int count = 0;                                      //refuel count
        for (int i = 0; i < stops.length; i++) {
            if (stops[i] - currentP <= tankR) {
                tankR -= stops[i] - currentP;
                currentP = stops[i];
            }
            else {
                if (i > 0) {
                    if (stops[i] - stops[i - 1] <= tank) {
                        tankR = tank - (stops[i] - currentP);  //tank refuel at previous gas station
                        currentP = stops[i];
                        count += 1;
                    } else return -1;
                }
                else return -1;
            }
        }
        if (dist - currentP <= tank) {
            if (dist - currentP <= tankR) return count;
            else return count + 1;                          //plus 1 because tank refuel at previous gas station
        }
        else return -1;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }

/** below is test
//    static class Stop{
//        public int distanceFromLast;
//        public int distance;
//        public boolean refuelable;
//        public Stop(Stop last, int distance, boolean refuelable) {
//            this.distance = distance;
//            this.distanceFromLast = distance - (last == null? 0 : last.distance);
//            this.refuelable = refuelable;
//
//        }
//    }
//    public static int computeMinRefills2(int dist, int tank, int[] _stops) {
//        LinkedList<Stop> stops = new LinkedList<Stop>();
//        Stop curr = null;
//        for(int i = 0; i < _stops.length && _stops[i] < dist; i++) {
//            curr = new Stop(curr, _stops[i], true);
//            stops.add(curr);
//        }
//        stops.add(new Stop(curr, dist, false));
//        int fuel = tank;
//        int retVal = 0;
//        while(!stops.isEmpty()) {//I can refuel here
//            curr = stops.remove();
//            fuel -= curr.distanceFromLast;
//            dist -= curr.distanceFromLast;
//            int fuelTillNext = fuel - (stops.isEmpty() ? 0 : stops.peek().distanceFromLast);
//            if(fuel < 0) return -1;
//            if(fuelTillNext < 0 && curr.refuelable) {//I must refuel here
//                fuel = tank;
//                retVal++;
//            }
//        }
//        return retVal;
//    }


//    private static int[] distGen (int stationnum) {
//        int [] output = new int[stationnum + 1];
//        for (int i = 0; i < stationnum + 1; i++) {
//            output[i] = (int) (Math.random() * 10) + 1;
//        }
//        output = bubblesort(output);
//        return output;
//    }
//
//    private static int tankGen () {
//        return (int) (Math.random() * 10) + 1;
//    }
//
//    private static int[] bubblesort(int[] a) {
//        int[] list = a;
//        for (int i = 0; i < list.length - 1; i++) {
//            for (int j = 0; j < list.length - i - 1; j++) {
//                if (list[j] > list[j + 1]) {
//                    int temp = list[j];
//                    list[j] = list[j + 1];
//                    list[j + 1] = temp;
//                }
//            }
//        }
//        return list;
//    }
//
//    public static void test() {
//        while (true) {
//            int stationnum = 4;
//            int[] genresult = distGen(stationnum);
//            int dist = genresult[stationnum];
//            System.out.println("dist " + dist);
//            int tank = tankGen();
//            System.out.println("tank " + tank);
//            int[] stops = new int[stationnum];
//            for (int i = 0; i < stationnum; i++) {
//                stops[i] = genresult[i];
//            }
//            System.out.println("stations " + Arrays.toString(stops));
//            if (computeMinRefills(dist, tank, stops) == computeMinRefills2(dist, tank, stops)) {
//                System.out.println("OK");
//            }
//            else {
//                System.out.println(computeMinRefills(dist, tank, stops));
//                System.out.println(computeMinRefills2(dist, tank, stops));
//                break;
//            }
//        }
//    }

*/



}
