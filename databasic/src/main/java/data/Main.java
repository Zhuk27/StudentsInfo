package data;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        DBWorker worker = new DBWorker();
        Scanner scanner = new Scanner(System.in);

        String number = "Not null";

        while (!number.equals("0")) {
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~menu~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                    "1  - вывод информации о всех студентах\n" +
                    "2  - добавление студента в базу\n" +
                    "3  - удаление студента из базы\n" +
                    "4  - обновление информации о студенте\n" +
                    "5  - поиск студентов которым исполнилось заданное количество лет\n" +
                    "6  - поиск информации о студенте по ФИО\n" +
                    "7  - вывод отсортированного списка студентов по фамилиям в алфавитном порядке\n" +
                    "8  - вывод списка студентов, которые сдали сессию без долгов\n" +
                    "9  - создать файл с таблицей и записать в него всю информацию из базы\n" +
                    "0  - завершить работу программы\n" +
                    "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                    "Введите номер нужной операции:");

            number = scanner.nextLine();

            if (number.equals("1")){
                Function.printBase(worker);
            }if (number.equals("2")){
                Function.addStudent(worker);
            }if (number.equals("3")){
                Function.deleteStudet(worker);
            }if (number.equals("4")){
                Function.updateStudent(worker);
            }if (number.equals("5")){
                Function.searchAge(worker);
            }if (number.equals("6")){
                Function.searchFIO(worker);
            }if (number.equals("7")){
                Function.sortedABC(worker);
            }if (number.equals("8")){
                Function.searchDebt(worker);
            }if (number.equals("9")){
                Function.createTableCsv(worker);
            }if (number.equals("0")){
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                                   " До свидания, хорошего дня)))\n" +
                        "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }

        }

    }

}
