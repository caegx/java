public abstract class UIControl {
    private boolean isEnabled;

    /* public UIControl() {
        System.out.println("UIControl");
    } */

    public boolean isEnabled() {
        return isEnabled;
    }

    public abstract void render();
}
