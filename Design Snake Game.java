/*
    Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are not familiar with the game.
    The snake is initially positioned at the top left corner (0,0) with length = 1 unit.
    You are given a list of food's positions in row-column order. When a snake eats the food, its length and the game's score both increase by 1.
    Each food appears one by one on the screen. For example, the second food will not appear until the first food was eaten by the snake.
    When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.
    
    Link: https://leetcode.com/problems

    Example:  
        Given width = 3, height = 2, and food = [[1,2],[0,1]].
        Snake snake = new Snake(width, height, food);

        Initially the snake appears at position (0,0) and the food at (1,2).
        
        |S| | |
        | | |F|

        snake.move("R"); -> Returns 0

        | |S| |
        | | |F|

        snake.move("D"); -> Returns 0

        | | | |
        | |S|F|

        snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )

        | |F| |
        | |S|S|

        snake.move("U"); -> Returns 1

        | |F|S|
        | | |S|

        snake.move("L"); -> Returns 2 (Snake eats the second food)

        | |S|S|
        | | |S|

        snake.move("U"); -> Returns -1 (Game over because snake collides with border)
    
    Solution: None

    Source: https://leetcode.com/discuss/106684/my-java-solution-easy-to-understand
*/

/** Initialize your data structure here.
    @param width - screen width
    @param height - screen height 
    @param food - A list of food positions
    E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    int width;
    int height;
    int[][] food;
    int length;
    List<int[]> list;
    int x;
    int y;
    int k;
public SnakeGame(int width, int height, int[][] food) {
    this.width = width;
    this.height = height;
    this.food = food;
    length = 0;
    list = new ArrayList<int[]> ();
    x = 0;
    y = 0;
    k = 0;
}

/** Moves the snake.
    @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
    @return The game's score after the move. Return -1 if game over. 
    Game over when snake crosses the screen boundary or bites its body. */
public int move(String direction) {
    if (direction.equals("U")) {
        if (x - 1 < 0) {
            return -1;
        }
        x = x - 1;
    } else if (direction.equals("L")) {
        if (y - 1 < 0) {
            return -1;
        }
        y = y - 1;
    } else if (direction.equals("R")) {
        if (y + 1 >= width) {
            return -1;
        }
        y = y + 1;
    } else if (direction.equals("D")) {
        if (x + 1 >= height) {
            return -1;
        }
        x = x + 1;
    } else {
        return -1;
    }

    int[] pos = {x, y};
    for (int i = 1; i < list.size(); i ++) {
    // do not need to check the first position, since it will be empty soon
        if (list.get(i)[0] == x && list.get(i)[1] == y) {
            return -1;
        }
    }
    if (k < food.length && food[k][0] == x && food[k][1] == y) {
    // will reach a fruit and increase the length in next step
        length ++;
        k ++;
    } else if (list.size() > 0) {
    // otherwise, just move one step forward
        list.remove(0);
    }
    list.add(pos);
    return length;
}
