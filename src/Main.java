import java.awt.Color;
import java.awt.Point;

/**
 * This class demos the features of SimpleGrid.
 * <p>
 * Click and drag to flip the color of any cell you move over.
 */
public class Main {
    public static void main(String[] args) {
        SimpleGrid grid = new SimpleGrid(10, 10, 50, 5, "Simple Grid Testing");
        grid.addLayer();
        grid.setAutoRepaint(false);

        grid.setGridlineColor(Color.WHITE);
        grid.setColor(1, Color.BLUE);
        grid.setColor(-1, Color.CYAN);

        Point current = null;
        Point last = new Point(0, 0);
        while (true) {
            Point p = grid.getMousePosition();
            if (p != null && grid.isMouseDown() && !p.equals(current)) {
                grid.set(p, 1 - grid.get(p));
                current = p;
            }
            if (!grid.isMouseDown()) {
                current = null;
            }

            // Update hover highlighting
            grid.set(1, last, 0);
            grid.set(1, p, -1);
            last = p;

            grid.repaint();
        }
    }
}
