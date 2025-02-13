import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


class MainPanel extends JPanel{
    public ArrayList<Shape2D> Shape2DList;
    MainPanel(){
        this.setSize(new Dimension(500,500));
        Shape2DList = new ArrayList<>();
    }
    public void addShape2D(Shape2D object){
        Shape2DList.add(object);
    }
    public void construct2D(Graphics2D graphics){

        for(int i=0;i<Shape2DList.size();i++){
            Shape2D shape = Shape2DList.get(i);
            for(int j=0;j<shape.verticesList.size()-1;j++){

                graphics.drawLine((int)shape.verticesList.get(j).x,(int)shape.verticesList.get(j).y,(int)shape.verticesList.get(j+1).x,(int)shape.verticesList.get(j+1).y);
            }
            Coordinate lastCoordinate = shape.verticesList.get(shape.verticesList.size()-1);
            graphics.drawLine((int)shape.verticesList.get(0).x,(int)shape.verticesList.get(0).y,(int)lastCoordinate.x,(int)lastCoordinate.y);
        }
    }
    public void paint(Graphics d){
        Graphics2D g = (Graphics2D) d;
        g.setStroke(new BasicStroke(5));
        construct2D(g);
    }

}
public class MainFrame extends JFrame {
    MainPanel panel;
    MainFrame(){
        panel = new MainPanel();
        this.setTitle("Graphics");
        this.add(panel);
        this.pack();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(255,255,255));
        this.setResizable(false);
        this.setSize(500,500);
        this.setVisible(true);
    }
}


