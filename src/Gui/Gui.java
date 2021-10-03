package Gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Date;

public class Gui {
    JFrame frame;

    int guiX = 300;
    int guiY = 125;

    int screenX = Toolkit.getDefaultToolkit().getScreenSize().width / 3;
    int screenY = Toolkit.getDefaultToolkit().getScreenSize().height / 3;

    public Gui(){
        createWindow();
    }

    private void createWindow(){
        frame = new JFrame();
        changeFrameSettings();
    }

    private void changeFrameSettings(){
        frame.setVisible(true);

        frame.setSize(getSize());
        frame.setResizable(false);

        frame.setLocationRelativeTo(null);
        frame.setLocation(getLocation());

        frame.setTitle("Clock");

        frame.getContentPane().setBackground(Color.BLACK);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        changeFrameIcon();
    }

    private Dimension getSize(){
        return new Dimension(guiX, guiY);
    }

    private Point getLocation(){
        return new Point(screenX, screenY);
    }

    private void changeFrameIcon(){
        frame.setIconImage(new ImageIcon("clock.png").getImage());
        createAndSetLayout();
    }

    GroupLayout gl;

    private void createAndSetLayout(){
        gl = new GroupLayout(frame.getContentPane());
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);
        frame.getContentPane().setLayout(gl);
        createAndAddComponents();
    }

    JLabel hour_text;
    JLabel minute_text;
    JLabel second_text;
    
    private void createAndAddComponents(){
        Border black_line = BorderFactory.createLineBorder(Color.PINK);

        JLabel clock_text = new JLabel("Clock");
        clock_text.setFont(new Font("Walker Bot LDR Regular", Font.PLAIN, 20));
        clock_text.setBackground(Color.BLACK);
        clock_text.setForeground(Color.GREEN);

        hour_text = new JLabel();
        hour_text.setFont(new Font("Walker Bot LDR Regular", Font.PLAIN, 20));
        hour_text.setBackground(Color.BLACK);
        hour_text.setForeground(Color.GREEN);
        hour_text.setBorder(black_line);

        minute_text = new JLabel();
        minute_text.setFont(new Font("Walker Bot LDR Regular", Font.PLAIN, 20));
        minute_text.setBackground(Color.BLACK);
        minute_text.setForeground(Color.GREEN);
        minute_text.setBorder(black_line);

        second_text = new JLabel();
        second_text.setFont(new Font("Walker Bot LDR Regular", Font.PLAIN, 20));
        second_text.setBackground(Color.BLACK);
        second_text.setForeground(Color.GREEN);
        second_text.setBorder(black_line);

        JLabel random = new JLabel("");
        JLabel h = new JLabel("H:");
        JLabel m = new JLabel("M:");
        JLabel s = new JLabel("S:");

        h.setFont(new Font("Walker Bot LDR Regular", Font.PLAIN, 20));
        h.setBackground(Color.BLACK);
        h.setForeground(Color.GREEN);

        m.setFont(new Font("Walker Bot LDR Regular", Font.PLAIN, 20));
        m.setBackground(Color.BLACK);
        m.setForeground(Color.GREEN);

        s.setFont(new Font("Walker Bot LDR Regular", Font.PLAIN, 20));
        s.setBackground(Color.BLACK);
        s.setForeground(Color.GREEN);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(clock_text).addComponent(random))
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(random).addComponent(h))
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(random).addComponent(hour_text))
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(random).addComponent(m))
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(random).addComponent(minute_text))
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(random).addComponent(s))
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(random).addComponent(second_text)));


        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(clock_text).addComponent(random).addComponent(random).addComponent(random).addComponent(random).addComponent(random).addComponent(random))
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(random).addComponent(h).addComponent(hour_text).addComponent(m).addComponent(minute_text).addComponent(s).addComponent(second_text)));

        startTasks();
    }

    private void startTasks(){
        Thread one = new Thread(()->{
            while(true) {
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException ie){
                    System.out.println(ie.getMessage());
                }
                long millis = System.currentTimeMillis();
                Date date = new Date(millis);
                String time = String.valueOf(date).split(" ")[3];
                String hours = time.split(":")[0];
                String minute = time.split(":")[1];
                String second = time.split(":")[2];
                if(Integer.parseInt(hours)>12) {
                	hour_text.setText(String.valueOf(Integer.parseInt(hours)-12));
                }else {
                	hour_text.setText(hours);
                }
                minute_text.setText(minute);
                second_text.setText(second);
            }
        });
        one.start();
    }
}

