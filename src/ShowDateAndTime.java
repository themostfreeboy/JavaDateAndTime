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
		Calendar c1=Calendar.getInstance();//getInstance��������ֵ����Ĭ��ΪGregorianCalendar��
		SimpleDateFormat s1=new SimpleDateFormat("���ڵ�ʱ��Ϊ:\nyyyy��MM��dd��\nE\nHH:mm:ss");
		String str1=s1.format(c1.getTime())+"\nJXL��";
		JOptionPane.showMessageDialog(null,str1);
	}
}