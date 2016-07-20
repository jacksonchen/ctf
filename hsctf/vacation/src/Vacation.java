/**
 * Created with IntelliJ IDEA.
 * User: Jackson
 * Date: 5/20/15
 * Time: 12:00 AM
 * To change this template use File | Settings | File Templates.
 */

import java.io.*;
import java.util.*;

public class Vacation {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("vacationer_test1.txt"));
        String firstLine = f.readLine();
        String[] firstTokens = firstLine.split(" ");
        int numPlanets = Integer.parseInt(firstTokens[0]);
        int connections = Integer.parseInt(firstTokens[1]);

        ArrayList<Path> allPaths = new ArrayList<Path>(connections);
        while (allPaths.size() < connections) {
            allPaths.add(null);
        }
        ArrayList<Planet> planets = new ArrayList<Planet>(numPlanets);
        while (planets.size() < numPlanets) {
            planets.add(null);
        }
        for (int i = 0; i < connections; i++) {
            String line = f.readLine();
            String[] tokens = line.split(" ");
            int originID = Integer.parseInt(tokens[0]);
            int destID = Integer.parseInt(tokens[1]);
            int time = Integer.parseInt(tokens[2]);
            int cost = Integer.parseInt(tokens[3]);
            Planet foundOrigin = null;
            Planet foundDest = null;

            Planet origin = new Planet(originID);
            Planet dest = new Planet(destID);
            Path aPath = null;

            for (Planet planet : planets) {
                if (planet != null) {
                    if (planet.equalsTo(origin)) {
                        foundOrigin = planet;
                    }
                    if (planet.equalsTo(dest)) {
                        foundDest = planet;
                    }
                }

            }
            if (foundOrigin == null) {
                if (foundDest == null) {
                    aPath = new Path(origin, dest, time, cost);
                    planets.set(destID, dest);
                }
                else {
                    aPath = new Path(origin, foundDest, time, cost);
                }
                planets.set(originID, origin);
            }
            else {
                if (foundDest == null) {
                    aPath = new Path(foundOrigin, dest, time, cost);
                    planets.set(destID, dest);
                }
                else {
                    aPath = new Path(foundOrigin, foundDest, time, cost);
                }
            }

            allPaths.add(aPath);
        }

        for (Path aPath : allPaths) {
            aPath.origin.fromPaths.add(aPath);
            aPath.dest.toPaths.add(aPath);
        }

//        for (Planet planet : planets) {
//            System.out.println(planet.paths.size());
//        }

        for (int i = numPlanets - 1; i >= 0; i--) {
            for (Path subPath : planets.get(i).toPaths) {
                if (subPath.cost == 0) {
                    subPath.origin.minTime += subPath.time;
                }
                else {
                    subPath.origin.minTimeCost += subPath.time;
                }
            }
        }


    }

    private static class Planet {
        private int id;
        private List<Path> fromPaths;
        private List<Path> toPaths;
        private int minTime;
        private int minTimeCost;

        public Planet(int id) {
            this.id = id;
            this.fromPaths = new ArrayList<Path>();
            this.toPaths = new ArrayList<Path>();
            this.minTime = 0;
            this.minTimeCost = 0;
        }

        public boolean equalsTo(Planet b) {
            return (this.id == b.id);
        }
    }

    private static class Path {
        private Planet origin;
        private Planet dest;
        private int time;
        private int cost;

        public Path(Planet origin, Planet dest, int time, int cost) {
            this.origin = origin;
            this.dest = dest;
            this.time = time;
            this.cost = cost;
        }

        public String toString() {
            return Integer.toString(this.time);
        }

    }

    private static class Route {
        private int cost;
        private int time;
        private List<Planet> enRoute;

        public Route() {
            this.cost = 0;
            this.time = 0;
            this.enRoute = new ArrayList<Planet>();
        }
    }
}
