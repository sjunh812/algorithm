import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        ArrayList<Route> routeList = new ArrayList<>();
       
        for (int[] route : routes) {
            routeList.add(new Route(route[0], route[1]));
        }
        
        Collections.sort(routeList);
        
        ArrayList<Route> cameraRouteList = new ArrayList<>();
        cameraRouteList.add(routeList.get(0));
        
        for (int i = 1; i < routeList.size(); i++) {
            int cameraRouteStart = cameraRouteList.get(cameraRouteList.size() - 1).getStart();
            int cameraRouteEnd = cameraRouteList.get(cameraRouteList.size() - 1).getEnd();
            int routeStart = routeList.get(i).getStart();
            int routeEnd = routeList.get(i).getEnd();
            
            if (cameraRouteEnd >= routeStart) {
                int start = Math.max(cameraRouteStart, routeStart);
                int end = Math.min(cameraRouteEnd, routeEnd);
                cameraRouteList.get(cameraRouteList.size() - 1).set(start, end);
            } else {
                cameraRouteList.add(routeList.get(i));
            }
        }
        
        return cameraRouteList.size();
    }
}

class Route implements Comparable<Route> {
    
    private int start;
    private int end;
    
    public Route(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    public int getStart() {
        return this.start;
    }
    
    public int getEnd() {
        return this.end;
    }
    
    public void set(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    @Override
    public int compareTo(Route other) {
        return this.start - other.start;
    }
}