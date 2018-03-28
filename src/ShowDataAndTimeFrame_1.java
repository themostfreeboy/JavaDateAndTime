import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class ShowDataAndTimeFrame_1 extends JFrame implements ChangeListener
{
	JLabel jlb1=new JLabel("",JLabel.CENTER);
	JLabel jlb2=new JLabel("",JLabel.CENTER);
	JLabel jlb3=new JLabel("",JLabel.CENTER);
	String str1="0";
	String str2="0";
	String str3="0";
	JProgressBar jpb1;
	public ShowDataAndTimeFrame_1()
	{
		JFrame jf1=new JFrame("Date And Time(Made By JXL)");
		JPanel jpl1=new JPanel();//jf1整体布局
		jpl1.setLayout(new BorderLayout());
		JPanel jpl2=new JPanel(new GridLayout(4,1));
		jpl2.add(jlb1);
		jpl2.add(jlb2);
		jpl1.add(new JLabel("日期时间显示(JXL制)",JLabel.CENTER),BorderLayout.NORTH);
		try
		{
			String LocalIP=InetAddress.getLocalHost().getHostAddress();//获取本机IP地址
			jpl1.add(new JLabel("本机IP地址为："+LocalIP,JLabel.CENTER),BorderLayout.SOUTH);
		} 
		catch (UnknownHostException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jpb1=new JProgressBar();
		jpb1.setOrientation(JProgressBar.HORIZONTAL); //设置进度条方向为水平
		jpb1.setMinimum(0);//设置最小值为0
		jpb1.setMaximum(59);//设置最大值为60
		jpb1.setValue(0);//设置初值为0
		jpb1.setStringPainted(false);//设置进度条上不显示进度
		jpb1.addChangeListener(this);//增加时间监听器
		jpb1.setToolTipText ("时间秒数进度条");//设置提示信息为“时间秒数进度条”
		jlb3.setToolTipText ("显示当前的秒数");
		jpl2.add(jpb1);
		jpl2.add(jlb3);
		jpl1.add(jpl2,BorderLayout.CENTER);
		jf1.add(jpl1);
		jf1.setSize(350,170);
		jf1.setLocationRelativeTo(null);
		jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf1.setVisible(true);
		Thread thread1=new Thread(new Thread_ShowDateAndTime());
        thread1.start();
        Thread thread2=new Thread(new Thread_JProgressBar());
        thread2.start();
	}
	public class Thread_ShowDateAndTime implements Runnable
	{
			public void run()
			{
				while(true)
				{
					Date d1=new Date();
					Calendar c1=Calendar.getInstance();//getInstance函数返回值类型默认为GregorianCalendar型
					SimpleDateFormat s1=new SimpleDateFormat("yyyy年MM月dd日    E");
					str1=s1.format(c1.getTime());
					SimpleDateFormat s2=new SimpleDateFormat("HH:mm:ss");
					str2=s2.format(c1.getTime());
					SimpleDateFormat s3=new SimpleDateFormat("ss");
					str3=s3.format(c1.getTime());
					jlb1.setText(str1);
					jlb2.setText(str2);
				}
			}
	}
	public class Thread_JProgressBar implements Runnable
	{
			public void run()
			{
				while(true)
				{
					jpb1.setValue(Integer.parseInt(str3));
				}
			}
	}
	public void stateChanged(ChangeEvent e)//进度条的处理
	{
    	     if(e.getSource()==jpb1)//加密进度条
    	     {
	             jlb3.setText("当前秒数："+str3);
    	     }
    }
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new ShowDataAndTimeFrame_1();
	}
}
