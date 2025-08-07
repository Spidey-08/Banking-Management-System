import javax.swing.*;

public class XYZ extends JFrame{
    public static void main(String s[])
    {
        XYZ x1 = new XYZ();
         x1.setVisible(true);
       int x=5;
      for(int i=1;i<=500;i+=10)
      {
        x1.setLocation(600-x,600-x); x=x+5;
        x1.setSize(i,i);
          try{Thread.sleep(30);}catch(Exception e){}
      }
    }
    
}
