public class Main {

    public static void main(String[] args) {
        MainFrame a = new MainFrame();
        Shape2D shape = new Shape2D();
        shape.addVertex(new Coordinate(150,150));
        shape.addVertex(new Coordinate(250,150));

        shape.addVertex(new Coordinate(250,250));
        shape.addVertex(new Coordinate(150,250));

        a.panel.addShape2D(shape);

        for(Shape2D el: a.panel.Shape2DList){

            for(Coordinate v: el.verticesList){

                System.out.println(v.x+" "+v.y);
            }
        }
        shape.calculateCenter();
        for(int i=0;i<3600;i++){

            shape.rotateAroundPoint(shape.center,Math.PI/90);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            a.panel.repaint();
            for(Shape2D el: a.panel.Shape2DList){

                for(Coordinate v: el.verticesList){

                    System.out.println(v.x+" "+v.y);
                }
            }
        }

    }
}