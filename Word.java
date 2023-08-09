import java.util.regex.*;

public class Word implements Comparable<Word> {
    private String words;

    public Word (String w) {
        if(w!=null && w.matches("^[a-zA-Z]*$")){
           this.words = w;
        }else{
           throw new IllegalWordException(w);
        }
    }
    public void setWord(String w){

        if(w!=null && w.matches("^[a-zA-Z]*$")){
            this.words = w;
        }else{
            throw new IllegalWordException(w);
        }

    }
    public String getWord(){
        return words;
    }
    public boolean equals(Word other) {
        return ( other != null
                && getClass() == other.getClass()
                && words.equals(((Word) other).words)
        );
    }
    public String toString() {
        return words;
    }

    @Override
    public int compareTo(Word other) {
        return words.compareTo(other.toString());
    }
}

/*
Class Word implements Comparable<Word>{

String data;


Word( String d) {
          // check d, throw IllegalWordException if d is illegal.
/*public class BadWalletMain {

    static String[] dataSource =  {"B5","Q","B18","Q","B10","P","N","BAD","D","Q","D"};
    static Wallet myWallet = new Wallet();

    public static void main (String[] args) {
        // try / catch begins here
        for (int i=0;i<dataSource.length;i++){
            char dataItem = dataSource[i].charAt(0);
            if (dataItem == 'B') {
                int billValue= Integer.parseInt(dataSource[i].substring(1,dataSource[i].length()));
                myWallet.addToWallet(new Bill(billValue));
            }
            else
            if (dataItem == 'Q')
                myWallet.addToWallet(new Quarter());
            else
            if (dataItem == 'D')
                myWallet.addToWallet(new Dime());
            else
            if (dataItem == 'N')
                myWallet.addToWallet(new Nickel());
            else
            if (dataItem == 'P')
                myWallet.addToWallet(new Penny());
        }

        myWallet.print();
        System.out.println("My wallet contains: $"+myWallet.getValue());
    }

} */
          // use Regular Expression to check if d only contains letters.
          //Refer
          // PowerPoints used in Lecture/ Regular Expressions
