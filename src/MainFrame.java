import com.sun.tools.javac.comp.Flow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    //Declare components
    private JLabel fx;
    private JLabel x2;
    private JLabel x;
    private JTextField textField;
    private JTextField x2Text;
    private JTextField xText;
    private JTextField cText;
    private JButton enterButton;
    private Canvas canvas;
    private FlowLayout flow;

    public MainFrame(){
        //Setup main window
        super("Grapher");
        setSize(600,600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //Initialize components
        fx = new JLabel("f(x) =");
        x2Text = new JTextField(3);
        x2 = new JLabel("x² + ");
        xText = new JTextField(3);
        x = new JLabel("x + ");
        cText = new JTextField(3);
        enterButton = new JButton("Graph");
        canvas = new Display();
        flow = new FlowLayout();

        ArrayList<Component> comp = new ArrayList<Component>();
        comp.add(fx);
        comp.add(x2);
        comp.add(x);

        for(Component x : comp){
            x.setFont(new Font("TimesRoman", Font.ITALIC | Font.BOLD, 15));
        }

        canvas.setBackground(Color.white);

        //Container will hold canvas at center and JPanel at south
        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());
        container.setLayout(new BorderLayout());

        Container bottom = new Container();
        bottom.setLayout(new FlowLayout());

        JPanel eqPanel = new JPanel();
        eqPanel.setLayout(flow);

        eqPanel.add(fx);
        eqPanel.add(x2Text);
        eqPanel.add(x2);
        eqPanel.add(xText);
        eqPanel.add(x);
        eqPanel.add(cText);

        bottom.add(eqPanel);
        //eqPanel.add(textField);

        //JPanel will hold components as a FlowLayout
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.add(enterButton);

        bottom.add(bottomPanel);

        //Add canvas and JPanel to container
        container.add(canvas, BorderLayout.CENTER);
        container.add(bottom, BorderLayout.SOUTH);

        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }
}
