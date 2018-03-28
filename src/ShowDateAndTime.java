import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
public class ShowDateAndTime
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Date d1=new Date();
		Calendar c1=Calendar.getInstance();//getInstance函数返回值类型默认为GregorianCalendar型
		SimpleDateFormat s1=new SimpleDateFormat("现在的时间为:\nyyyy年MM月dd日\nE\nHH:mm:ss");
		String str1=s1.format(c1.getTime())+"\nJXL制";
		JOptionPane.showMessageDialog(null,str1);
	}
}