public class IllegalWordException extends IllegalArgumentException {
    public IllegalWordException(String Illegal_Word) {
        super(Illegal_Word);
        System.out.println(Illegal_Word);
    }
}

