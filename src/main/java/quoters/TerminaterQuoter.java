package quoters;

public class TerminaterQuoter implements IQuoter {

    private String message;


    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void sayQuote() {
        System.out.println("message = " + message);
    }
}