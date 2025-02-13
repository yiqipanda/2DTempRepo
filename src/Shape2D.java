import java.util.ArrayList;

public class Shape2D {
    public ArrayList<Coordinate> verticesList;
    public Coordinate center;
    //Any transformation done to shape can also be done to center to get the new value of center.
    Shape2D(){
        verticesList = new ArrayList<>();
        center = new Coordinate(0,0); //Default value
    }
    public void calculateCenter(){
        int xcenter = 0;
        int ycenter = 0;
        for(Coordinate vertex: verticesList){
            xcenter+=vertex.x;
            ycenter+=vertex.y;
        }
        center.x = xcenter/verticesList.size();
        center.y = ycenter/verticesList.size();
    }
    public void addVertex(Coordinate... vertices){
        for(Coordinate vertex: vertices){
            verticesList.add(vertex);

        }
        calculateCenter();
    }
    public void rotateAroundCenter(double theta){
        rotateAroundPoint(this.center,theta);
    }
    public void rotateAroundPoint(Coordinate point, double theta){
        if(verticesList.isEmpty()){
            return;
        }
        center.rotate(theta,point.x,point.y);
        for(Coordinate vertex: verticesList){
            vertex.rotate(theta,point.x,point.y);
        }


    }
}
