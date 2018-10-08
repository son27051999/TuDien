// class lưu trữ mảng Word
import java.lang.String;
public class Dictionary {
    final static int n = 1000;
    public static Word words[];

    Dictionary() {
        words = new Word[n];
    }

    public static int lengthWord(){ // TRẢ LẠI ĐỘ DÀI MẢNG WORDS
        return words.length;
    }

    public static void input(String word,String mean, int count){ // KHỞI TẠO MẢNG WORD
        words[count] = new Word(word, mean);
    }
}