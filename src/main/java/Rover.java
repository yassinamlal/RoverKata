import java.io.IOException;

public class Rover{
    private int x;
    private int y;
    private static final int EDGEMAX = 8;
    private static final int EDGEMIN = 1;
    private static final String MESSAGE_OBSTACLE = "there is an obstacle";

    public Rover(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public void moveRoverForwardBackward(boolean forward, boolean backward) throws IOException {
        if (forward && !backward && this.x != EDGEMAX) {
            if (!isObstacle(this.x + 1, this.y)) {
                this.x += 1;
            }else throw new IOException(MESSAGE_OBSTACLE);

        } else if (forward && !backward) {
            this.x = 1;
        }
        if (!forward && backward && this.x != EDGEMIN) {
            if (!isObstacle(this.x - 1, this.y)) {
                this.x -= 1;
            }else throw new IOException(MESSAGE_OBSTACLE);
        } else if (!forward && backward) {
            this.x = 8;
        }
    }


    public void moveRoverLeftRight(boolean left, boolean right) throws IOException {
        if (left && !right && this.y != EDGEMAX) {
            if (!isObstacle(this.x, this.y + 1)) {
                this.y += 1;
            }else throw new IOException(MESSAGE_OBSTACLE);
        } else if (left && !right) {
            this.y = 1;
        }
        if (!left && right && this.y != EDGEMIN) {
            if (!isObstacle(this.x, this.y - 1)) {
                this.y -= 1;
            }else throw new IOException(MESSAGE_OBSTACLE);

        } else if (!left && right) {
            this.y = 8;
        }
    }


    public boolean isObstacle(int x, int y) {

        //I guess that there is an obstacle in (4,4)
        return (x == 4 && y == 4);
    }


}
