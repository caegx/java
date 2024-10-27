
public interface Resizable {

    void resize(int size);
    void resize(int x, int y);
    void resizeTo(UIWidget widget); // we segregate interfaces with methods that do different things.
    // if you have an interface with methods that do different things, segregate them into different interfaces.  

}