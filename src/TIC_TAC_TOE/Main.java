package TIC_TAC_TOE;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static char map[][];
    private static final int SIZE = 5;
    private static final int DOT_TO_WIN = 4;
    private static final char ELEMENT_EMPTY = '_';
    private static final char ELEMENT_X = 'X';
    private static final char ELEMENT_0 = '0';
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            playerTurn();
            printMap();
            if (isWin(ELEMENT_X)) {
                System.out.println("Победил игрок");
                break;
            }
            if (isMapFull()) {
                System.out.println("Игра окончена. Ничья");
                break;

            }
            turnAI();
            printMap();
            if (isWin(ELEMENT_0)) {
                System.out.println("Победил ИИ");
                break;
            }
            if (isMapFull()) {
                System.out.println("Игра окончена. Ничья");
                break;
            }
        }
    }

    public static boolean isWin(char DOT_TO_WIN) {
        for (int i = 0; i < SIZE; i++) {
            if ((map[i][0] == DOT_TO_WIN && map[i][1] == DOT_TO_WIN && map[i][2] == DOT_TO_WIN && map[i][3] == DOT_TO_WIN)
               || (map[0][i] == DOT_TO_WIN && map[1][i] == DOT_TO_WIN && map[2][i] == DOT_TO_WIN && map[3][i] == DOT_TO_WIN))
                return true;
            if ((map[0][0] == DOT_TO_WIN && map[1][1] == DOT_TO_WIN && map[2][2] == DOT_TO_WIN && map[3][3] == DOT_TO_WIN))
                return true;
            if ((map[0 + 1][0] == DOT_TO_WIN && map[1 + 1][1] == DOT_TO_WIN && map[2 + 1][2] == DOT_TO_WIN && map[3 + 1][3] == DOT_TO_WIN))
                return true;
            if ((map[3][0] == DOT_TO_WIN && map[2][1] == DOT_TO_WIN && map[1][2] == DOT_TO_WIN && map[0][3] == DOT_TO_WIN))
                return true;
            if ((map[1][4] == DOT_TO_WIN && map[2][3] == DOT_TO_WIN && map[3][2] == DOT_TO_WIN && map[4][1] == DOT_TO_WIN))
                return true;
            if ((map[4][4] == DOT_TO_WIN && map[3][3] == DOT_TO_WIN && map[2][2] == DOT_TO_WIN && map[1][1] == DOT_TO_WIN))
                return true;
            if ((map[4][3] == DOT_TO_WIN && map[3][2] == DOT_TO_WIN && map[2][1] == DOT_TO_WIN && map[1][0] == DOT_TO_WIN))
                return true;
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == ELEMENT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void turnAI() {
        int x, y;
        do {
            System.out.println("Ход ИИ");
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!checkTurn(x, y));
        System.out.println("ИИ походил в точку" + "[" + (x + 1) + " " + (y + 1) + "]");
        map[x][y] = ELEMENT_0;
    }

    public static boolean checkTurn(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) return false;
        if (map[x][y] == ELEMENT_EMPTY) return true;
        return false;
    }

    public static void playerTurn() {
        int x, y;
        do {
            System.out.println("Ход игрока. Введите координаты x y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
            if (checkTurn(x, y)) {

            } else {
                System.out.println("Введенная координата не верна, попробуйте еще раз");
            }
        } while (!checkTurn(x, y));
        map[x][y] = ELEMENT_X;
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[j][i] = ELEMENT_EMPTY;
            }

        }
    }

}
