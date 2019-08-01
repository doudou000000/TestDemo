package com.test.demo.test.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @Description: 时间格式化帮助类
 * 
 * format    根据指定的时间格式，格式化long型时间
 * format1	 yyyy-MM-dd,HH:mm:ss
 * format2	 HH:mm:ss
 * format3	 HH:mm
 * format4	 yyyy_MM_dd_HH_mm_ss_SSS
 * format5	 yyyy_MM_dd
 * format6	 yyyy_MM_dd_HH_mm_ss
 * format7	 yyyy-MM-dd HH:mm:ss:SSS
 * format8	 HH:mm:ss:SSS
 * format9	 MM/dd/yy HH:mm
 * format10  yyyy-MM-dd_HH_mm_ss
 * format11  yyyy-MM-dd HH:mm:ss
 * format12  mm:ss
 * parse     根据指定的时间格式，解析时间字符串
 * 
 *
 *
 */
public class DateFormatUtils {
	
	/**
	 * 
	* @Title: format
	* @Description: 根据指定的时间格式，格式化long型时间
	* @param dateType 时间格式
	* @param time long型日期
	* @return 格式化后的字符串
	* @return:String
	* Modification History:
	* Date  Author  Version  Description
	* ---------------------------------------------------------*
	 */
	public static String format(String dateType, long time) {
		return new SimpleDateFormat(dateType).format(time);
	}
	
	/**
	 * 
	* @Title: format1
	* @Description: 格式化时间(yyyy-MM-dd,HH:mm:ss)
	* @param time
	* @return
	* @return:String
	* Modification History:
	* Date  Author  Version  Description
	* ---------------------------------------------------------*
	 */
	public static String format1(long time) {
		return new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss").format(time);
	}

	/**
	 * 
	* @Title: format2
	* @Description: 格式化时间(HH:mm:ss)
	* @param time
	* @return
	* @return:String
	* Modification History:
	* Date  Author  Version  Description
	* ---------------------------------------------------------*
	 */
	public static String format2(long time) {
		return new SimpleDateFormat("HH:mm:ss").format(time);
	}

	/**
	 * 
	* @Title: format3
	* @Description: 格式化时间(HH:mm)
	* @param time
	* @return
	* @return:String
	* Modification History:
	* Date  Author  Version  Description
	* ---------------------------------------------------------*
	 */
	public static String format3(long time) {
		return new SimpleDateFormat("HH:mm").format(time);
	}

	/**
	 *
	 * @Title: format12
	 * @Description: 格式化时间(mm:ss)
	 * @param time
	 * @return
	 * @return:String
	 * Modification History:
	 * Date  Author  Version  Description
	 * ---------------------------------------------------------*
	 */
	public static String format12(long time) {
		return new SimpleDateFormat("mm:ss").format(time);
	}


	/**
	 * 
	* @Title: format4
	* @Description: 格式化时间(yyyy_MM_dd_HH_mm_ss_SSS)
	* @param time
	* @return
	* @return:String
	* @author: dingchao
	* @date: 2014-4-8
	* Modification History:
	* Date  Author  Version  Description
	* ---------------------------------------------------------*
	* 2014-4-8  dingchao v1.0.0   修改原因
	 */
	public static String format4(long time) {
		return new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss_SSS").format(time);
	}

	/**
	 * 
	* @Title: format5
	* @Description: 格式化时间(yyyy_MM_dd)
	* @param time
	* @return
	* @return:String
	* @author: dingchao
	* @date: 2014-4-8
	* Modification History:
	* Date  Author  Version  Description
	* ---------------------------------------------------------*
	* 2014-4-8  dingchao v1.0.0   修改原因
	 */
	public static String format5(long time) {
		return new SimpleDateFormat("yyyy_MM_dd").format(time);
	}

	/**
	 * 
	* @Title: format6
	* @Description:  格式化时间(yyyy_MM_dd_HH_mm_ss)
	* @param time
	* @return
	* @return:String
	* @author: dingchao
	* @date: 2014-4-8
	* Modification History:
	* Date  Author  Version  Description
	* ---------------------------------------------------------*
	* 2014-4-8  dingchao v1.0.0   修改原因
	 */
	public static String format6(long time) {
		return new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(time);
	}

	/**
	 * 
	* @Title: format7
	* @Description: 格式化时间(yyyy-MM-dd HH:mm:ss:SSS)
	* @param time
	* @return
	* @return:String
	* @author: dingchao
	* @date: 2014-4-8
	* Modification History:
	* Date  Author  Version  Description
	* ---------------------------------------------------------*
	* 2014-4-8  dingchao v1.0.0   修改原因
	 */
	public static String format7(long time) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(time);
	}
	
	/**
	 * 
	* @Title: format8
	* @Description: 格式化时间(HH:mm:ss:SSS)
	* @param time
	* @return
	* @return:String
	* @author: dingchao
	* @date: 2014-4-8
	* Modification History:
	* Date  Author  Version  Description
	* ---------------------------------------------------------*
	* 2014-4-8  dingchao v1.0.0   修改原因
	 */
	public static String format8(long time) {
		return new SimpleDateFormat("HH:mm:ss:SSS").format(time);
	}
	
	/**
	 * 
	* @Title: format9
	* @Description: 格式化时间(MM/dd/yy HH:mm)
	* @param time
	* @return
	* @return:String
	* @author: dingchao
	* @date: 2014-4-8
	* Modification History:
	* Date  Author  Version  Description
	* ---------------------------------------------------------*
	* 2014-4-8  dingchao v1.0.0   修改原因
	 */
	public static String format9(long time){
		return new SimpleDateFormat("MM/dd/yy HH:mm").format(time);
	}
	
	/**
	 * 
	* @Title: format10
	* @Description: 格式化时间(yyyy-MM-dd_HH_mm_ss)
	* @param time
	* @return
	* @return:String
	* @author: dingchao
	* @date: 2014-4-8
	* Modification History:
	* Date  Author  Version  Description
	* ---------------------------------------------------------*
	* 2014-4-8  dingchao v1.0.0   修改原因
	 */
	public static String format10(long time){
		return new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss").format(time);
	}
	
	/**
	 * 
	* @Title: format11
	* @Description: 格式化时间(yyyy-MM-dd HH:mm:ss)
	* @param time
	* @return
	* @return:String
	* @author: dingchao
	* @date: 2014-4-15
	* Modification History:
	* Date  Author  Version  Description
	* ---------------------------------------------------------*
	* 2014-4-15  dingchao v1.0.0   修改原因
	 */
	public static String format11(long time) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);
	}

	/**
	 * 
	* @Title: parse
	* @Description: 根据指定的时间格式，解析时间字符串
	* @param dateType 时间格式（例，yyyy-MM-dd_HH_mm_ss）
	* @param time 时间字符串 （例，2014-04-08_17_53_09）
	* @return 解析后的Date对象
	* @return:Date
	* @author: dingchao
	* @date: 2014-4-8
	* Modification History:
	* Date  Author  Version  Description
	* ---------------------------------------------------------*
	* 2014-4-8  dingchao v1.0.0   修改原因
	 */
	public static Date parse(String dateType, String time){
		Date date = null;
		try {
			date = new SimpleDateFormat(dateType).parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
}
