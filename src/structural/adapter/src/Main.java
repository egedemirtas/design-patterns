import adapter.GeometricShapeObjectAdapter;
import adapter.RhombusClassAdapter;
import adapter.TriangleClassAdapter;
import extra.Rhombus;
import extra.Triangle;
import model.Circle;
import model.Drawing;
import model.Rectangle;

public class Main {
    public static void main(String[] args) {

        // Shape belong to our team
        // Handling this interface is not a problem
        // "Drawing" is the client in our case
        System.out.println("Creating drawing of shapes...");
        Drawing drawing = new Drawing();
        drawing.addShape(new Rectangle());
        drawing.addShape(new Circle());

        System.out.println("Drawing...");
        drawing.draw();
        System.out.println("Resizing...");
        drawing.resize();

        System.out.println("___________________________________");
        // now we have to work with GeometricShape which belongs to another team
        // but we have to make Shape and GeometricShape compatible
        // "Drawing" (client) has to be able to work with both Shape and GeometricShape
        System.out.println("Creating drawing of shapes...");
        Drawing drawingObjectAdapter = new Drawing();
        drawingObjectAdapter.addShape(new Rectangle());
        drawingObjectAdapter.addShape(new Circle());
        drawingObjectAdapter.addShape(new GeometricShapeObjectAdapter(new Triangle()));
        drawingObjectAdapter.addShape(new GeometricShapeObjectAdapter(new Rhombus()));

        System.out.println("Drawing...");
        drawingObjectAdapter.draw();
        System.out.println("Resizing...");
        drawingObjectAdapter.resize();


        System.out.println("___________________________________");
        System.out.println("Creating drawing of shapes...");
        Drawing drawingClassAdapter = new Drawing();
        drawingClassAdapter.addShape(new Rectangle());
        drawingClassAdapter.addShape(new Circle());
        drawingClassAdapter.addShape(new TriangleClassAdapter());
        drawingClassAdapter.addShape(new RhombusClassAdapter());

        System.out.println("Drawing...");
        drawingClassAdapter.draw();
        System.out.println("Resizing...");
        drawingClassAdapter.resize();
    }
}