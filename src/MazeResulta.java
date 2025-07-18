import java.util.*;

public class MazeResulta {
    private List<Cell> path;
    private boolean found;

    public MazeResulta(List<Cell> path, boolean found) {
        this.path = path;
        this.found = found;
    }

    public List<Cell> getPath() {
        return path;
    }

    public boolean isFound() {
        return found;
    }
}
