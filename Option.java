public class Option {

    private String text;

    private Runnable optionCode;

    public Option(String text, Runnable optionCode) {
        this.text = text;
        this.optionCode = optionCode;
    }

    public Option() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Runnable getOptionCode() {
        return optionCode;
    }

    public void setOptionCode(Runnable optionCode) {
        this.optionCode = optionCode;
    }
}
