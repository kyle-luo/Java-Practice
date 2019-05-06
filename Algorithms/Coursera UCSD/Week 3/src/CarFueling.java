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
                if (stops[i] - stops[i - 1] <= tank) {
                    tankR =  tank - (stops[i] - currentP);  //tank refuel at previous gas station
                    currentP = stops[i];
                    count += 1;
                }
                else return -1;
            }
        }

        if (dist - currentP < tank) {
            if (dist - currentP <= tankR) return count;
            else return count + 1;                          //plus 1 because tank refuel at previous gas station
        }
        else return -1;
    }

    static int computeMinRefillsSlow(int dist, int tank, int[] stops) {
        
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
}
