package allanli;

import java.text.SimpleDateFormat;
import java.util.Date;

public class sad {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		// System.out.println(sdf.format(new Date()));
		java.util.Date udate = new java.util.Date();
		System.out.println(sdf.format(udate));
	}
}
