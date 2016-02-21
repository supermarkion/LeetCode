import java.io.*;
import java.util.*;


class Position {
    private long x;
    private long y;
    private String orient;

    Position(long x, long y, String orien) {
        this.x = x;
        this.y = y;
        this.orient = orien;
    }

    public long getX() {
        return this.x;
    }

    public void setX(long newX) {
        this.x = newX;
    }

    public long getY() {
        return this.y;
    }

    public void setY(long newY) {
        this.y = newY;
    }

    public String getOrient() {
        return this.orient;
    }

    public void setOrient(String newOrient) {
        this.orient = newOrient;
    }
}


public class Explorer {

    // In this program, we assume all input file follow question description
    // and saved in a static file
    public static void main (String[] args) throws IOException {

        // we assume the input info will be saved in a file name "input"
        // In this file, first line is the upper-right of the area,
        // and each two lines represent to one explorers information.
        Explorer ep = new Explorer();
        String path = "input";
        List<Position> locations = ep.runExplorers(path, ep);

        // then, we display each explorer final location
        for (Position location : locations) {
            System.out.println(location.getX() + " " + location.getY() + " " + location.getOrient());
        }

    }

    /*
    * This method used to read input file content, and transform its
    * content to a string list. The first line is size of area, and
    * each next two lines is an explorer movmenet command.
    *
    * */
    private List<String> readFile(String path) throws IOException {
        List<String> content = new ArrayList<String>();

        try {
            FileReader fr = new FileReader(path);
            BufferedReader textReader = new BufferedReader(fr);
            String line;

            while ((line = textReader.readLine()) != null) {
                content.add(line);
                // System.out.println(line);
            }
            textReader.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return content;
    }

    /*
    * This method used to control explorers based on the input file
     * information. If the input file is not complete, we will stop
     * running.
     *
    * */
    public List<Position> runExplorers(String path, Explorer ep) throws IOException {

        List<Position> locations = new ArrayList<Position>();
        List<String> content = ep.readFile(path);

        // if we find content is empty, or size is even, it means
        // input file is not complete.
        if (content.isEmpty() || content.size() % 2 == 0) {
            System.out.println("Input file is not complete.");
            return locations;
        }

        // when input file is complete, we get the size of planet
        String firstLine = content.get(0);
        String[] firstLines = firstLine.split("\\s+");
        Long maxRow = Long.parseLong(firstLines[0]);
        Long maxCol = Long.parseLong(firstLines[1]);

        // after we get boundary of area, then we move explorer as
        // command
        int count = 1;
        while (count < content.size()) {
            String startPosition = content.get(count);
            String command = content.get(count + 1);
            Position location = moveExplorer(startPosition, command, maxRow, maxCol);
            locations.add(location);
            count += 2;
        }
        return locations;
    }

    /*
    * This method used to move the explorer based on the given startPosition
    * and commands, then return this explorer final location. At the time,
    * we assume all format follow question description.
    *
    * */
    private Position moveExplorer(String startPosition, String command, long maxRow, long maxCol) {
        // we use start location to get first position of this explorer
        String[] startPositions = startPosition.split("\\s+");
        Position location = new Position(Long.parseLong(startPositions[0]),
                                        Long.parseLong(startPositions[1]),
                                        startPositions[2]);
        // then we split this commands into single command
        char[] commands = command.toCharArray();
        for (int i = 0; i < commands.length; i++) {
            movePosition(location, commands[i], maxRow, maxCol);
        }
        return location;
    }

    /*
    * This method used to move this explorer based on given command,
    * and this command can only be 'L', 'R' and 'M'. At the same time,
    * we use maxRow, and maxCol to make explorer not over range of area
    *
    * */
    private void movePosition(Position explorer, char command, long maxRow, long maxCol) {
        String orient = explorer.getOrient();

        if (command == 'L') {
            if (orient.equals("N")) {
                explorer.setOrient("W");
            } else if (orient.equals("W")) {
                explorer.setOrient("S");
            } else if (orient.equals("S")) {
                explorer.setOrient("E");
            } else {
                explorer.setOrient("N");
            }
        } else if (command == 'R') {
            if (orient.equals("N")) {
                explorer.setOrient("E");
            } else if (orient.equals("E")) {
                explorer.setOrient("S");
            } else if (orient.equals("S")) {
                explorer.setOrient("W");
            } else {
                explorer.setOrient("N");
            }
        } else { // we assume it must be M
            if (orient.equals("N")) {
                if (explorer.getY() + 1 <= maxCol) {
                    explorer.setY(explorer.getY() + 1);
                }
            } else if (orient.equals("S")) {
                if (explorer.getY() - 1 >= 0) {
                    explorer.setY(explorer.getY() - 1);
                }
            } else if (orient.equals("W")) {
                if (explorer.getX() - 1 >= 0) {
                    explorer.setX(explorer.getX() - 1);
                }
            } else {
                if (explorer.getX() + 1 <= maxRow) {
                    explorer.setX(explorer.getX() + 1);
                }
            }
        }
    }
}
