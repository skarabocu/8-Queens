//Sinan Karabocuoglu & Oktay Comu
//13 February 2018
//Table Components

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class TableComponents {
    //attitudes
    public String game = "";//final plan of the game
    public String display = "";
    public static ArrayList<ArrayList<ArrayList<Integer>>> combinations = new ArrayList<ArrayList<ArrayList<Integer>>>();//arraylist for all the combinations
    public ArrayList<Location> queens = new ArrayList<Location>();
    public int boxes[][] = //the board array
            {
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
            };

    public TableComponents() {

    }

    public boolean isSafe(int cx, int cy) {
        boolean safe = true;
        //vertical check
        for (int i = 0; i < 8; i++) {
            if ((boxes[i][cy] == 1)) {
                safe = false;
                break;
            }
        }
        //**********************
        //horizontal check
        for (int i = 0; i < 8; i++) {
            if ((boxes[cx][i] == 1)) {
                safe = false;
                break;
            }
        }
        //***********************
        //diagonal check
        //left bottom
        for (int row = cx, col = cy; row >= 0 && col < 8; row--, col++) {
            if (boxes[row][col] == 1) {
                safe = false;
                break;
            }
        }
        //right top
        for (int row = cx, col = cy; row < 8 && col >= 0; row++, col--) {
            if (boxes[row][col] == 1) {
                safe = false;
                break;
            }
        }
        //left top
        for (int row = cx, col = cy; row >= 0 && col >= 0; row--, col--) {
            if (boxes[row][col] == 1) {
                safe = false;
                break;
            }
        }
        //right bottom
        for (int row = cx, col = cy; row < 8 && col < 8; row++, col++) {
            if (boxes[row][col] == 1) {
                safe = false;
                break;
            }
        }
        //***********************
        return safe;
    }

    public void queenDraw(int x, int y)//positioning the queens
    {
        if ((y == 1) && (x == 8)) {
        } else if (y == 8) {
            System.out.println("done");

            combinations.add(new ArrayList<ArrayList<Integer>>());

            System.out.println(printQueen());//prints the current alignment
            game = "";//resets the game display for printing
            int nx = queens.get(queens.size() - 1).getRow();
            int ny = queens.get(queens.size() - 1).getColum();
            queens.remove(queens.size() - 1);
            boxes[nx][ny] = 0;
            queenDraw(nx + 1, ny);
        } else if (x == 8) {
            int nx = queens.get(queens.size() - 1).getRow();
            int ny = queens.get(queens.size() - 1).getColum();
            queens.remove(queens.size() - 1);
            boxes[nx][ny] = 0;
            queenDraw(nx + 1, ny);
        } else if (isSafe(x, y)) {
            boxes[x][y] = 1;
            Location location = new Location(x, y);
            queens.add(location);
            x = 0;
            queenDraw(x, y + 1);
        } else {
            queenDraw(x + 1, y);
        }

    }

    public String printQueen()//printing the result
    {
        for (int a = 0; a < 8; a++) {
            combinations.get(combinations.size()-1).add(new ArrayList<Integer>());
            for (int b = 0; b < 8; b++) {
                game = game + boxes[a][b] + "  ";
                combinations.get(combinations.size()-1).get(a).add(boxes[a][b]);
            }
            game = game + "\n";
        }
        return game + "\n";
    }


}