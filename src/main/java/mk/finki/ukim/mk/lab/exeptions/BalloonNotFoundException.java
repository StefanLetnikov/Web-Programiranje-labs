package mk.finki.ukim.mk.lab.exeptions;


public class BalloonNotFoundException extends RuntimeException {
    public BalloonNotFoundException(Long id) {
        super(String.format("Balloon with id: %d was not found", id));
    }
}
