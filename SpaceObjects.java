import javax.swing.*;
import codedraw.*;
import java.awt.*;
import java.util.Random;

public class SpaceObjects {

        public static class OrbitPanel {
            private int width;
            private int height;
            CodeDraw cd;

            public OrbitPanel(int width, int height) {
                this.width = width;
                this.height = height;
                this.cd = new CodeDraw(width, height);
            }

            private void drawBody(int x, int y, int size, Color color) {
                cd.setColor(color);
                cd.fillCircle(x, y, size / 2.0);

            }

            public void paint() {
                cd.clear();
                int centerX = width / 2;
                int centerY = height / 2;
                cd.setColor(Color.BLACK);
                cd.fillRectangle(0, 0, width, height);
                // Draw the sun at the center
                drawBody(centerX, centerY, 40, Color.BLUE);
                Random random = new Random();

                for (int i = 0; i < 100; i++) {
                    int randomX = random.nextInt(width);
                    int randomY = random.nextInt(height);
                    cd.setColor(Color.YELLOW);
                    if (randomX < 230 || randomX > 270 || randomY < 230 || randomY > 270) {
                        cd.drawCircle(randomX, randomY, 0.5);
                    }
                }

                double percentRotation = System.currentTimeMillis() % 10000 / 10000.0;
                double angle = Math.PI * 2 * percentRotation;

                // Calculate moon position relative to earth
                int moonRadius = width / 10;
                int moonX = centerX + (int) (moonRadius * Math.cos(angle * 2));
                int moonY = centerY + (int) (moonRadius * Math.sin(angle * 2));

                drawBody(moonX, moonY, 10,Color.LIGHT_GRAY);

                cd.show();
            }

        }

        public static void main(String[] args){
            OrbitPanel orbitPanel = new OrbitPanel(500, 500);

            while (true) {

                orbitPanel.paint();
            }
        }
    }

