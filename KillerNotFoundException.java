public class KillerNotFoundException extends RuntimeException {
    public KillerNotFoundException(int id) {
        super(String.format("Killer with id %d not found", id));
    }
}
