package test.common.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class Dateconverter extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map map, String[] value, Class c) {
		// TODO Auto-generated method stub
		String s = value[0];
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		Date d;
		try {
			d = sdf.parse(s);
			return d;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String convertToString(Map map, Object obj) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String s = sdf.format((Date)obj);
		return s;
	}

}
