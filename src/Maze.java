import java.util.concurrent.ThreadLocalRandom;

public class Maze {

    int rows;
    int cols;
    int[][] data;

    Maze(int cols, int rows) {
        this.rows = rows;
        this.cols = cols;
        this.data = new int[this.rows][this.cols];
    }

    public void setColRow(int col, int row, int value) {
        this.data[row][col] = value;
    }

    public void drawRect(int startX, int startY, int width, int height, int value) {
        for (int x = startX; x < startX + width; x++) {
            this.data[startY][x] = value;
        }
        for (int y = startY + 1; y < startY + height - 1; y++) {
            this.data[y][0] = value;
            this.data[y][startY + width - 1] = value;
        }

        for (int x = startX; x < startX + width; x++) {
            this.data[startY + height - 1][x] = value;
        }
    }

    public void fillRect(int startX, int startY, int width, int height, int value) {
        for (int y = startY; y < startY + height; y++) {
            for (int x = startX; x < startX + width; x++) {
                this.data[y][x] = value;
            }
        }
    }

    public void findPath(int x, int y, int min, int value) {
        if (this.data[y][x] == 6) {
            return;
        }

        this.data[y][x] = value;

        int newX = x;
        int newY = y;

        if (this.data[y-1][x] < min && this.data[y-1][x] > 4) {
            newX = x;
            newY = y-1;
            min = this.data[y-1][x];
        }
        if (this.data[y][x + 1] < min && this.data[y][x + 1] > 4) {
            newX = x + 1;
            newY = y;
            min = this.data[y][x + 1];
        }
        if (this.data[y + 1][x] < min && this.data[y + 1][x] > 4) {
            newX = x;
            newY = y + 1;
            min = this.data[y + 1][x];
        }
        if (this.data[y][x - 1] < min && this.data[y][x - 1] > 4) {
            newX = x - 1;
            newY = y;
            min = this.data[y][x - 1];
        }
        findPath(newX, newY, min, value);

    }

    public boolean findExit(int x, int y, int value) {
        this.data[y][x] = value;

        value += 1;
        // value %= 255;

        if (this.data[y - 1][x] == 3 || this.data[y][x + 1] == 3 || this.data[y + 1][x] == 3
                || this.data[y][x - 1] == 3) {
            return true;
        }

        if (this.data[y - 1][x] == 0) {
            if (findExit(x, y - 1, value)) {
                return true;
            }
        }
        if (this.data[y][x + 1] == 0)
            if (findExit(x + 1, y, value)) {
                return true;
            }
        if (this.data[y + 1][x] == 0)
            if (findExit(x, y + 1, value)) {
                return true;
            }
        if (this.data[y][x - 1] == 0)
            if (findExit(x - 1, y, value)) {
                return true;
            }
        return false;
    }

    private int getRandomNums(int count) {
        return ThreadLocalRandom.current().nextInt(1, count + 1) * 2;
    }

    public void generate(int startX, int startY, int width, int height, int value) {

        if (width < 3 || height < 3) {
            return;
        }

        // check orientation of remaining space
        if (width > height) {

            // remaining area is more wide than tall -> draw vertical separation line at a
            // random location
            int randCol = getRandomNums(width / 2) + startX - 1;
            for (int row = startY; row < startY + height; row++) {
                data[row][randCol] = value;
            }

            // open one break through at a random location in the separation line
            int randBreakThrough = getRandomNums(height / 2) + startY;
            data[randBreakThrough][randCol] = 0;

            // generate recursive maze in the remaining left half
            generate(startX, startY, randCol - startX, height, value);
            // generate recursive maze in the remaining right half
            generate(randCol + 1, startY, width - randCol + startX - 1, height, value);

        } else {
            // remaining area is more tall than wide -> draw horizontal separation line at a
            // random location
            int randRow = getRandomNums(height / 2) + startY - 1;
            for (int col = startX; col < startX + width; col++) {
                data[randRow][col] = value;
            }

            // open one break through at a random location in the separation line
            int randBreakThrough = getRandomNums(width / 2) + startX;
            data[randRow][randBreakThrough] = 0;

            // generate recursive maze in the remaining top half
            generate(startX, startY, width, randRow - startY, value);
            // generate recursive maze in the remaining bottom half
            generate(startX, randRow + 1, width, height - randRow + startY - 1, value);
        }

    }
}
