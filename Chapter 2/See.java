public class See {
    public static void main(String[] args) {
        var tb = new TextBox();
        //tb.setText("Hello World");
        //System.out.println(tb); // no need to call the toString method since the println method automatically calls the toString method on any object.
        show(tb);

        var point1 = new Point(1, 2);
        var point2 = new Point(1, 2);

        System.out.println(point1.equals(point2));

        System.out.println(point1.hashCode());
        System.out.println(point2.hashCode());

        //Polymorphism
        UIControl[] controls = {new TextBox(), new CheckBox()};
        for (var control : controls) 
            control.render();
    }


    //Upcasting and Downcasting.
    public static void show(UIControl control) {
        if (control instanceof TextBox) {
            var textBox = (TextBox) control;
            textBox.setText("Hello World");
        }
        System.out.println(control);
    }
}
