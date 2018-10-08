import java.util.Scanner;
import java.io.*;
import java.util.*;

public class DictionaryManagement {
    final static int m = 1000;
    public static int  countWord = -1; // biến đếm số từ trong mảng từ điển;
    static Dictionary obWord = new Dictionary();
    static DictionaryCommandline word = new DictionaryCommandline();
    DictionaryManagement(){
    }

    public static void menu() { //HIỂN THỊ MENU
        System.out.println("1.Add Word");
        System.out.println("2.Search");
        System.out.println("3.List All");
        System.out.println("4.Nhập dữ liệu từ file:");
    }

    public static void insertFromFile(){   // đọc dữ liệu từ file
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\New folder (2)\\son.txt"));
            String textInALine;
            while ((textInALine = br.readLine()) != null) {
                 String subStr1, subStr2;  //subStr1 : word; subStr2: mean
                 int countChar = 0;  //biến đếm kí tự trong teInAline
                 while(textInALine.charAt(countChar) != '\t'){
                     countChar++;
                 }
                 subStr1 = textInALine.substring(0,countChar);
                 subStr2 = textInALine.substring(countChar+1);
                 countWord++;
                 obWord.input(subStr1,subStr2,countWord);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void insertFromCommandline() {  // ADD WORD
        terminate:
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Word:");
            String word = sc.nextLine();
            System.out.print("Mean:");
            String mean = sc.nextLine();
            obWord.input(word, mean, countWord);
            while (true) {
                System.out.print("Nhập Y để tiếp tục, N để thoát:");
                String NY = sc.next();
                if (NY.equals("N")) break terminate;
                else if (NY.equals("Y")) {
                    countWord++;
                    break;
                } else {
                    System.out.println("Nhập chưa chính xác mời nhập lại.");
                    continue;
                }
            }
        }
    }

    public static void option() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            menu();
            System.out.print("Option:");
            int luaChon = sc.nextInt();
            switch (luaChon) {
                case 1:
                    countWord++;
                    insertFromCommandline();
                    break;
                case 3:
                    word.showAllWords();
                    break;
                case 4:
                    insertFromFile();
                    break;
                default:
                    System.out.println("Nhập sai mời nhập lại");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        DictionaryManagement td = new DictionaryManagement();
        td.option();
    }
}
 