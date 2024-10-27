public class TextBox extends UIControl {
    private String text = "";

    /* public TextBox() {
        System.out.println("Textbox");
    } */

    public void render() {
        System.out.println("Render Text Box.");
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
    
}
