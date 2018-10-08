// file hiển thị kết quả
public class DictionaryCommandline {
    public   static Dictionary obWord;
    public DictionaryManagement obCount;
    // object obCOUNT dùng để truy cập vào biến đếm Word(countWord) trong DictonaryManagen
    DictionaryCommandline(){
        obWord = new Dictionary();
        obCount = new DictionaryManagement();
    }

    public void showAllWords() {
        System.out.println("|--------------------------------------------------------------------|");
        System.out.printf("|%12s%12s%12s%12s", "WORD", "|", "MEAN", "|");
        System.out.println();
        for (int i = 0; i <= obCount.countWord; i++) {
            obWord.words[i].displayWord();
        }
        System.out.println("|--------------------------------------------------------------------|");
    }
}