package data;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;


public class Function {


    public static void printStudent(ResultSet resultSet) throws SQLException {
        while(resultSet.next()){
            User user = new User();
            user.setId(resultSet.getInt(1));
            user.setFIO(resultSet.getString(2));
            user.setDateOfBirth(resultSet.getDate(3));
            user.setTest1(resultSet.getString(4));
            user.setDateTest1(resultSet.getDate(5));
            user.setTest2(resultSet.getString(6));
            user.setDateTest2(resultSet.getDate(7));
            user.setTest3(resultSet.getString(8));
            user.setDateTest3(resultSet.getDate(9));
            user.setTest4(resultSet.getString(10));
            user.setDateTest4(resultSet.getDate(11));
            user.setTest5(resultSet.getString(12));
            user.setDateTest5(resultSet.getDate(13));
            user.setTest6(resultSet.getString(14));
            user.setDateTest6(resultSet.getDate(15));
            user.setTest7(resultSet.getString(16));
            user.setDateTest7(resultSet.getDate(17));
            user.setTest8(resultSet.getString(18));
            user.setDateTest8(resultSet.getDate(19));
            user.setTest9(resultSet.getString(20));
            user.setDateTest9(resultSet.getDate(21));
            user.setTest10(resultSet.getString(22));
            user.setDateTest10(resultSet.getDate(23));
            user.setExam1(resultSet.getInt(24));
            user.setDateExam1(resultSet.getDate(25));
            user.setExam2(resultSet.getInt(26));
            user.setDateExam2(resultSet.getDate(27));
            user.setExam3(resultSet.getInt(28));
            user.setDateExam3(resultSet.getDate(29));
            user.setExam4(resultSet.getInt(30));
            user.setDateExam4(resultSet.getDate(31));
            user.setExam5(resultSet.getInt(32));
            user.setDateExam5(resultSet.getDate(33));

            System.out.println(user);
        }
    }
    //вывод всей базы данных
    public static void printBase(DBWorker worker){
        String query = "select * from users;";
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n Информация о всех студентах\n" +
                            "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        try  {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            Function.printStudent(resultSet);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //добавление студента в базу
    public static void addStudent(DBWorker worker){
        Scanner scanner = new Scanner(System.in);

        String insert = "INSERT into users ( FIO, dateOfBirth, test1, dateTest1, test2, dateTest2, test3, dateTest3, test4, dateTest4, test5, dateTest5, test6, dateTest6, test7, dateTest7, test8, dateTest8, test9, dateTest9, test10, dateTest10, exam1, dateExam1, exam2, dateExam2, exam3, dateExam3, exam4, dateExam4, exam5, dateExam5) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = null;
            preparedStatement = worker.getConnection().prepareStatement(insert);

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~\n" +
                               " Введите ФИО студента\n" +
                    "~~~~~~~~~~~~~~~~~~~~~~");
            String FIO = scanner.nextLine();
            preparedStatement.setString(1, FIO);

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                               " Введите дату рождения в таком формате ГГГГ-ММ-ДД\n" +
                    "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            String dateOfBirth = scanner.nextLine();
            preparedStatement.setString(2, dateOfBirth);

            String[] test = new String[10];
            Date[] dateTest = new Date[10];
            int chetchik = 3;

            for (int i = 0; i < 10; i++){
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                                   " Если " + (i+1) + " зачёт сдан введите + ,если нет введите -\n" +
                        "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                test[i] = scanner.nextLine();
                preparedStatement.setString(chetchik, test[i]);
                chetchik++;

                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                                   " Введите дату " + (i+1) + " зачёта в таком формате ГГГГ-ММ-ДД\n" +
                        "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                dateTest[i] = Date.valueOf(scanner.nextLine());
                preparedStatement.setDate(chetchik, dateTest[i]);
                chetchik++;
            }

            String[] examScore = new String[5];
            Date[] dateExams = new Date[5];

            for (int i = 0; i < 5; i++){
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                                   " Введите оценку за " + (i+1) + " экзамен\n" +
                        "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                examScore[i] = scanner.nextLine();
                preparedStatement.setInt(chetchik, Integer.parseInt(examScore[i]));
                chetchik++;

                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                        " Введите дату " + (i+1) + " экзамена в таком формате ГГГГ-ММ-ДД\n" +
                        "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                dateExams[i] = Date.valueOf(scanner.nextLine());
                preparedStatement.setDate(chetchik, dateExams[i]);
                chetchik++;
            }

            preparedStatement.execute();

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                               " Данные успешно добавлены\n" +
                               "~~~~~~~~~~~~~~~~~~~~~~~~~~");



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    //удаление студента из базы данных
    public static void deleteStudet(DBWorker worker){
        Scanner scanner = new Scanner(System.in);
        Function.printBase(worker);
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                           " Введите ФИО студента которого хотите удалить из базы\n" +
                           "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        String delFio = scanner.nextLine();

        PreparedStatement preparedStatement = null;
        String delete = new String("delete from users where FIO = ?");
        try {
            preparedStatement = worker.getConnection().prepareStatement(delete);
            preparedStatement.setString(1,delFio);
            preparedStatement.execute();

            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                               " Информацци о студенте успешно удалена\n" +
                    "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Корректировка информации о студенте
    public static void updateStudent(DBWorker worker){

        Scanner scanner = new Scanner(System.in);
        PreparedStatement preparedStatement = null;
        printBase(worker);
        try {
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                                 " Информацию о каком студенте хотите обновить? Введите ФИО\n" +
                                 "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            String fio = scanner.nextLine();

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                    " Что хотите обновить и на какое значение.\n" +
                    " Пример ввода: dateOfBirth = '2004-09-14', exam1 = 5\n" +
                    " Категорию вводить также как в выводе базы сверху)\n" +
                    " Название категории вводить без кавычек, изменения все кроме exam[i] вводить в одинарных кавычках\n" +
                    "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            String changes = scanner.nextLine();

            String update = new String("update users set " + changes + " where FIO = ?");

            preparedStatement = worker.getConnection().prepareStatement(update);
            preparedStatement.setString(1,fio);
            preparedStatement.execute();
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                                 " Информацци о студенте успешно обновлена\n" +
                                 "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void searchAge(DBWorker worker) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                           " Введите возраст, больше или равно которого всем студентам\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        int age = Integer.parseInt(scanner.nextLine());
        String query = "select * from users;";
        java.util.Date date = new java.util.Date();//Актуальная дата

        //преобразуем актульная дату в localdate
        Instant instant = date.toInstant();
        ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
        LocalDate actualDate = zdt.toLocalDate();
        LocalDate comparedDate = actualDate.minusYears(age);

        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            //вывод всей базы данных
            int countStudent = 0;
            while (resultSet.next()) {
                User user = new User();
                user.setDateOfBirth(resultSet.getDate(3));
                if (comparedDate.compareTo(user.getDateOfBirth().toLocalDate()) > 0){
                    user.setFIO(resultSet.getString(2));
                    countStudent++;
                    System.out.println(countStudent + ". " + user.getFIO());
                }

            }
            if (countStudent == 0){
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                                   " Студентов старше или с таким возрастом нет\n" +
                        "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void searchFIO(DBWorker worker){
        Scanner scanner = new Scanner(System.in);
        PreparedStatement preparedStatement = null;
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                           " Введите ФИО студента информацию о котором хотите найти\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        String fio = scanner.nextLine();
        String select = "select * from users where FIO = ?";
        try {
            preparedStatement = worker.getConnection().prepareStatement(select);
            preparedStatement.setString(1,fio);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                resultSet = preparedStatement.executeQuery();
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                        " Вот информация об этом студенте\n" +
                        "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                Function.printStudent(resultSet);
            }else{
                //resultSet.first();
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                                   " Студента с таким ФИО нет\n" +
                                   "~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }





    public static void sortedABC(DBWorker worker) {
        String select = "select * from users order by FIO ASC ;";
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(select);

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                               " Отсортированный список студентов по фамилиям в алфавитном порядке\n" +
                    "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            int countStudent = 0;
            while (resultSet.next()) {
                User user = new User();
                user.setFIO(resultSet.getString(2));
                countStudent++;
                System.out.println(countStudent + ". " + user.getFIO());

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void searchDebt(DBWorker worker) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                           " Информация о студентах которые сдали сессию без долгов\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        String select = "select * from users where test1 = '+' and test2='+' and test3 = '+' and test4='+' and test5 = '+' and test6='+' and test7 = '+' and test8='+' and test9 = '+' and test10='+' and (exam1 = 5 or exam1 = 4 or exam1 = 3) and  (exam2 = 5 or exam2 = 4 or exam2 = 3) and (exam3 = 5 or exam3 = 4 or exam3 = 3) and (exam4 = 5 or exam4 = 4 or exam4 = 3) and (exam5 = 5 or exam5 = 4 or exam5 = 3)";
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            int countStudent = 0;
            while (resultSet.next()) {
                User user = new User();
                user.setFIO(resultSet.getString(2));
                countStudent++;
                System.out.println(countStudent + ". " + user.getFIO());

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


public static void createTableCsv(DBWorker worker) {

        String COMMA_DELIMITER = ",";
        String NEW_LINE_SEPARATOR = "\n";
        String FILE_HEADER = " FIO, dateOfBirth, test1, dateTest1, test2, dateTest2, test3, dateTest3, test4, dateTest4, test5, dateTest5, test6, dateTest6, test7, dateTest7, test8, dateTest8, test9, dateTest9, test10, dateTest10, exam1, dateExam1, exam2, dateExam2, exam3, dateExam3, exam4, dateExam4, exam5, dateExam5";
        String query = "select * from users;";
        try  {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

        }catch (SQLException e){
            e.printStackTrace();
        }

        String fileName = "students.csv";

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);

            fileWriter.append(FILE_HEADER.toString());

            fileWriter.append(NEW_LINE_SEPARATOR);

            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setFIO(resultSet.getString(2));
                fileWriter.append(user.getFIO());
                fileWriter.append(COMMA_DELIMITER);
                user.setDateOfBirth(resultSet.getDate(3));
                fileWriter.append(String.valueOf(user.getDateOfBirth()));
                fileWriter.append(COMMA_DELIMITER);
                user.setTest1(resultSet.getString(4));
                fileWriter.append(user.getTest1());
                fileWriter.append(COMMA_DELIMITER);
                user.setDateTest1(resultSet.getDate(5));
                fileWriter.append(String.valueOf(user.getDateTest1()));
                fileWriter.append(COMMA_DELIMITER);
                user.setTest2(resultSet.getString(6));
                fileWriter.append(user.getTest2());
                fileWriter.append(COMMA_DELIMITER);
                user.setDateTest2(resultSet.getDate(7));
                fileWriter.append(String.valueOf(user.getDateTest2()));
                fileWriter.append(COMMA_DELIMITER);
                user.setTest3(resultSet.getString(8));
                fileWriter.append(user.getTest3());
                fileWriter.append(COMMA_DELIMITER);
                user.setDateTest3(resultSet.getDate(9));
                fileWriter.append(String.valueOf(user.getDateTest3()));
                fileWriter.append(COMMA_DELIMITER);
                user.setTest4(resultSet.getString(10));
                fileWriter.append(user.getTest4());
                fileWriter.append(COMMA_DELIMITER);
                user.setDateTest4(resultSet.getDate(11));
                fileWriter.append(String.valueOf(user.getDateTest4()));
                fileWriter.append(COMMA_DELIMITER);
                user.setTest5(resultSet.getString(12));
                fileWriter.append(user.getTest5());
                fileWriter.append(COMMA_DELIMITER);
                user.setDateTest5(resultSet.getDate(13));
                fileWriter.append(String.valueOf(user.getDateTest5()));
                fileWriter.append(COMMA_DELIMITER);
                user.setTest6(resultSet.getString(14));
                fileWriter.append(user.getTest6());
                fileWriter.append(COMMA_DELIMITER);
                user.setDateTest6(resultSet.getDate(15));
                fileWriter.append(String.valueOf(user.getDateTest6()));
                fileWriter.append(COMMA_DELIMITER);
                user.setTest7(resultSet.getString(16));
                fileWriter.append(user.getTest7());
                fileWriter.append(COMMA_DELIMITER);
                user.setDateTest7(resultSet.getDate(17));
                fileWriter.append(String.valueOf(user.getDateTest7()));
                fileWriter.append(COMMA_DELIMITER);
                user.setTest8(resultSet.getString(18));
                fileWriter.append(user.getTest8());
                fileWriter.append(COMMA_DELIMITER);
                user.setDateTest8(resultSet.getDate(19));
                fileWriter.append(String.valueOf(user.getDateTest8()));
                fileWriter.append(COMMA_DELIMITER);
                user.setTest9(resultSet.getString(20));
                fileWriter.append(user.getTest9());
                fileWriter.append(COMMA_DELIMITER);
                user.setDateTest9(resultSet.getDate(21));
                fileWriter.append(String.valueOf(user.getDateTest9()));
                fileWriter.append(COMMA_DELIMITER);
                user.setTest10(resultSet.getString(22));
                fileWriter.append(user.getTest10());
                fileWriter.append(COMMA_DELIMITER);
                user.setDateTest10(resultSet.getDate(23));
                fileWriter.append(String.valueOf(user.getDateTest10()));
                fileWriter.append(COMMA_DELIMITER);
                user.setExam1(resultSet.getInt(24));
                fileWriter.append(Integer.toString(user.getExam1()));
                fileWriter.append(COMMA_DELIMITER);
                user.setDateExam1(resultSet.getDate(25));
                fileWriter.append(String.valueOf(user.getDateExam1()));
                fileWriter.append(COMMA_DELIMITER);
                user.setExam2(resultSet.getInt(26));
                fileWriter.append(Integer.toString(user.getExam2()));
                fileWriter.append(COMMA_DELIMITER);
                user.setDateExam2(resultSet.getDate(27));
                fileWriter.append(String.valueOf(user.getDateExam2()));
                fileWriter.append(COMMA_DELIMITER);
                user.setExam3(resultSet.getInt(28));
                fileWriter.append(Integer.toString(user.getExam3()));
                fileWriter.append(COMMA_DELIMITER);
                user.setDateExam3(resultSet.getDate(29));
                fileWriter.append(String.valueOf(user.getDateExam3()));
                fileWriter.append(COMMA_DELIMITER);
                user.setExam4(resultSet.getInt(30));
                fileWriter.append(Integer.toString(user.getExam4()));
                fileWriter.append(COMMA_DELIMITER);
                user.setDateExam4(resultSet.getDate(31));
                fileWriter.append(String.valueOf(user.getDateExam4()));
                fileWriter.append(COMMA_DELIMITER);
                user.setExam5(resultSet.getInt(32));
                fileWriter.append(Integer.toString(user.getExam5()));
                fileWriter.append(COMMA_DELIMITER);
                user.setDateExam5(resultSet.getDate(33));
                fileWriter.append(String.valueOf(user.getDateExam5()));
                fileWriter.append(NEW_LINE_SEPARATOR);

            }
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                               " Данные успешно записаны в файл\n" +
                    "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        } catch (IOException e) {

            System.out.println("Error in CsvFileWriter!");

            e.printStackTrace();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter!");
                e.printStackTrace();
            }

        }
    }
    }

