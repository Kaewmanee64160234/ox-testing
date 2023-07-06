/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mavenproject1;

import java.sql.RowId;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Mavenproject1 {

    public String[][] list = {{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};
    public String start;
    public String turn;
    public boolean confirm;
    public int row;
    public int column;
    public boolean isEnd = false;

    Scanner sc = new Scanner(System.in);

    public void startGame() {

        System.out.println("Welcome to Game XO");
        System.out.print("Start Game (Y/N): ");
        start = sc.nextLine().toLowerCase();

        while (!start.equals("n") && !start.equals("y")) {
            System.out.print("Start Game (Y/N): ");
            start = sc.nextLine().toLowerCase();
        }
        if (start.equals("n")) {
            confirm = false;
        } else {
            confirm = true;
        }

    }

    public void nextTurn() {
        if (turn.equals("x")) {
            turn = "o";
        } else {
            turn = "x";
        }

    }

    public void showTable() {
        for (int i = 0; i < list.length; i++) {

            for (int j = 0; j < list[i].length; j++) {
                System.out.print(list[i][j] + "  ");

            }
            System.out.println();
        }

    }

    public void inputRandC() {
        System.out.print("Input row :");
        row = sc.nextInt();
        System.out.print("Input column :");
        column = sc.nextInt();
        if (((row > 0 && row < 4) && (column > 0 && column < 4))) {
            if (list[row - 1][column - 1].equals("-")) {
                list[row - 1][column - 1] = turn.toUpperCase();

            } else {

                while (((row > 0 && row < 4) && (column > 0 && column < 4)) && (!list[row - 1][column - 1].equals("-"))) {

                    System.out.println("that row and Column is already exits.2");
                    System.out.print("Input row :");
                    row = sc.nextInt();
                    System.out.print("Input column :");
                    column = sc.nextInt();

                }

                return;
            }

            checkWin();
            nextTurn();

        } else {
            return;
        }

    }

    public void showTurn() {
        System.out.println("--------------------");
        System.out.println("Your Turn >> " + turn.toUpperCase());
    }

    public void checkWin() {

        if (checkInLine() || checkCross() || checkTayang()) {

            System.out.println("+--------------------+");
            System.out.println("|    !!! " + turn + " Win !!!   |");
            System.out.println("+--------------------+");
            showTable();
            if (continute()) {
                reset();
            } else {
                isEnd = true;
            }

        }
        if (isEnd == false) {
            if (checkDraw()) {
                isEnd = true;
                System.out.println("+--------------------+");
                System.out.println("|    !!! Draw !!!    |");
                System.out.println("+--------------------+");
                showTable();
                if (continute()) {
                    reset();
                } else {
                    isEnd = true;
                }
            }
        }

    }

    public void reset() {
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                list[i][j] = "-";
            }
        }
    }

    public boolean checkInLine() {

        for (int j = 0; j < list[row - 1].length; j++) {
            if (!list[row - 1][j].toLowerCase().equals(turn)) {
                return false;
            }
        }

        return true;
    }

    public boolean checkDraw() {
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                if (list[i][j].toLowerCase().equals("-")) {
                    return false;
                }

            }

        }

        return true;
    }

    public boolean continute() {
        System.out.print("You want to continute (Y/N) : ");
        String str = sc.next();
        while (!str.toLowerCase().equals("n") && !str.toLowerCase().equals("y")) {
            System.out.print("You want to continute (Y/N) : ");
            str = sc.next();
        }
        if (str.equals("n")) {
            isEnd = true;
            System.out.println("GoodBye!!");
            return false;
        }

        return true;

    }

    public boolean checkCross() {
        for (int i = 0; i < list[row - 1].length; i++) {
            if (!list[i][column - 1].toLowerCase().equals(turn)) {
                return false;
            }

        }
        return true;
    }

    public boolean checkTayang() {
        if (row - 1 == column - 1) {
            for (int i = 0; i < list.length; i++) {
                if (!list[i][i].toLowerCase().equals(turn)) {
                    return false;
                }

            }
            return true;
        }
        if ((row + column) - 2 == list.length - 1) {
            for (int i = 0; i < list.length; i++) {
                if (!list[i][list.length - 1 - i].toLowerCase().equals(turn)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public void process() {
        showTable();
        showTurn();
        inputRandC();
    }

    public static void main(String[] args) {
        Mavenproject1 project = new Mavenproject1();

        Scanner kb = new Scanner(System.in);
        project.startGame();
        if (project.confirm != true) {
            System.out.println("GoodBye!!");
            return;
        }
        project.turn = "x";
        while (!project.isEnd) {
            project.process();
        }

    }
}

//
//package com.mycompany.mavenproject1;
//
//import java.util.Scanner;
//
//public class Mavenproject1 {
//
//    private String[][] list = {{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};
//    private String start;
//    private String turn;
//    private boolean confirm;
//    private int row;
//    private int column;
//    private boolean isEnd = false;
//
//    Scanner sc = new Scanner(System.in);
//
//    public void startGame() {
//        System.out.println("Welcome to Game XO");
//        System.out.print("Start Game (Y/N): ");
//        start = sc.nextLine().toLowerCase();
//
//        while (!start.equals("n") && !start.equals("y")) {
//            System.out.print("Start Game (Y/N): ");
//            start = sc.nextLine().toLowerCase();
//        }
//
//        confirm = start.equals("y");
//    }
//
//    public void nextTurn() {
//        turn = (turn.equals("x")) ? "o" : "x";
//    }
//
//    public void showTable() {
//        for (int i = 0; i < list.length; i++) {
//            for (int j = 0; j < list[i].length; j++) {
//                System.out.print(list[i][j] + "  ");
//            }
//            System.out.println();
//        }
//    }
//
//    public void inputRandC() {
//        System.out.print("Input row: ");
//        row = sc.nextInt();
//        System.out.print("Input column: ");
//        column = sc.nextInt();
//
//        if (row > 0 && row < 4 && column > 0 && column < 4) {
//            if (list[row - 1][column - 1].equals("-")) {
//                list[row - 1][column - 1] = turn.toUpperCase();
//            } else {
//                while (row > 0 && row < 4 && column > 0 && column < 4 && !list[row - 1][column - 1].equals("-")) {
//                    System.out.println("That row and column are already taken.");
//                    System.out.print("Input row: ");
//                    row = sc.nextInt();
//                    System.out.print("Input column: ");
//                    column = sc.nextInt();
//                }
//                return;
//            }
//            checkWin();
//            nextTurn();
//        } else {
//            return;
//        }
//    }
//
//    public void showTurn() {
//        System.out.println("--------------------");
//        System.out.println("Your Turn >> " + turn.toUpperCase());
//    }
//
//    public void checkWin() {
//        if (checkInLine() || checkCross() || checkDiagonal()) {
//            System.out.println("+--------------------+");
//            System.out.println("|    !!! " + turn.toUpperCase() + " Win !!!   |");
//            System.out.println("+--------------------+");
//            showTable();
//            if (continute()) {
//                reset();
//            } else {
//                isEnd = true;
//            }
//        }
//
//        if (!isEnd && checkDraw()) {
//            isEnd = true;
//            System.out.println("+--------------------+");
//            System.out.println("|    !!! Draw !!!    |");
//            System.out.println("+--------------------+");
//            showTable();
//            if (continute()) {
//                reset();
//            } else {
//                isEnd = true;
//            }
//        }
//    }
//
//    public void reset() {
//        for (int i = 0; i < list.length; i++) {
//            for (int j = 0; j < list[i].length; j++) {
//                list[i][j] = "-";
//            }
//        }
//    }
//
//    public boolean checkInLine() {
//        for (int j = 0; j < list[row - 1].length; j++) {
//            if (!list[row - 1][j].equalsIgnoreCase(turn)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public boolean checkDraw() {
//        for (int i = 0; i < list.length; i++) {
//            for (int j = 0; j < list[i].length; j++) {
//                if (list[i][j].equalsIgnoreCase("-")) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    public boolean continute() {
//        System.out.print("Do you want to continue (Y/N): ");
//        String str = sc.next().toLowerCase();
//        while (!str.equals("n") && !str.equals("y")) {
//            System.out.print("Do you want to continue (Y/N): ");
//            str = sc.next().toLowerCase();
//        }
//        if (str.equals("n")) {
//            isEnd = true;
//            System.out.println("Goodbye!!");
//            return false;
//        }
//        return true;
//    }
//
//    public boolean checkCross() {
//        for (int i = 0; i < list[row - 1].length; i++) {
//            if (!list[i][column - 1].equalsIgnoreCase(turn)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public boolean checkDiagonal() {
//        if (row - 1 == column - 1) {
//            for (int i = 0; i < list.length; i++) {
//                if (!list[i][i].equalsIgnoreCase(turn)) {
//                    return false;
//                }
//            }
//            return true;
//        }
//        if (row + column - 2 == list.length - 1) {
//            for (int i = 0; i < list.length; i++) {
//                if (!list[i][list.length - 1 - i].equalsIgnoreCase(turn)) {
//                    return false;
//                }
//            }
//            return true;
//        }
//        return false;
//    }
//
//    public void process() {
//        showTable();
//        showTurn();
//        inputRandC();
//    }
//
//    public static void main(String[] args) {
//        Mavenproject1 project = new Mavenproject1();
//        Scanner kb = new Scanner(System.in);
//        project.startGame();
//        if (!project.confirm) {
//            System.out.println("Goodbye!!");
//            return;
//        }
//        project.turn = "x";
//        while (!project.isEnd) {
//            project.process();
//        }
//    }
//}
