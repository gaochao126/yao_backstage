package com.jiuyi.yao.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.JsonObject;

/**
 * 
 * @author zhb
 * @date 2015年3月22日
 */
public class Util {
	private final static Random random = new Random();

	public static boolean isNotEmpty(String str) {
		if (str == null || "".equals(str.trim())) {
			return false;
		} else {
			return true;
		}
	}

	public static String getUniqueSn() {
		String s = System.currentTimeMillis() + "";
		return s.substring(1) + "" + random.nextInt(9) + random.nextInt(9) + random.nextInt(9);
	}

	public static String getFormatId() {
		String s = System.currentTimeMillis() + "";
		return s.substring(2) + random.nextInt(9) + random.nextInt(9) + random.nextInt(9) + random.nextInt(9);
	}

	/**
	 * 手机号验证
	 * 
	 * @param str
	 * @return 验证通过返回true
	 */
	public static boolean isMobile(String str) {
		if (str == null) {
			return false;
		}
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
		m = p.matcher(str);
		b = m.matches();
		return b;
	}

	/**
	 * 电话号码验证
	 * 
	 * @param str
	 * @return 验证通过返回true
	 */
	public static boolean isPhone(String str) {
		Pattern p1 = null, p2 = null;
		Matcher m = null;
		boolean b = false;
		p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$"); // 验证带区号的
		p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$"); // 验证没有区号的
		if (str.length() > 9) {
			m = p1.matcher(str);
			b = m.matches();
		} else {
			m = p2.matcher(str);
			b = m.matches();
		}
		return b;
	}

	/**
	 * @description 字符串截取
	 * @param str
	 * @param beginIndex
	 * @param endIndex
	 * @return
	 */
	public static String substring(String str, int beginIndex, int endIndex) {
		if (str == null) {
			return null;
		}
		if (str.length() < endIndex + 1) {
			return str.substring(beginIndex);
		} else {
			return str.substring(beginIndex, endIndex) + "...";
		}
	}

	/**
	 * @description 判断map是否包含key
	 * @param map
	 * @param key
	 * @return
	 */
	public static boolean containsKey(Map<String, Object> map, String key) {
		if (map == null || !map.containsKey(key)) {
			return false;
		}
		return true;
	}

	/**
	 * @description 获取一周开始时间
	 * @return
	 * @throws ParseException
	 */
	public static Date getStartTimeOfWeek() throws ParseException {
		Calendar c = Calendar.getInstance();
		int day = c.get(Calendar.DAY_OF_WEEK);
		long time = System.currentTimeMillis();
		if (day > 1) {
			time = time - (day - 2) * 24 * 60 * 60 * 1000L;
		} else {
			time = time - 6 * 24 * 60 * 60 * 1000L;
		}
		Date date = new Date(time);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		date = sdf.parse(sdf.format(date));
		return date;
	}

	/**
	 * @description 获取一周结束时间
	 * @return
	 * @throws ParseException
	 */
	public static Date getEndTimeOfWeek() throws ParseException {
		Calendar c = Calendar.getInstance();
		int day = c.get(Calendar.DAY_OF_WEEK);
		long time = System.currentTimeMillis();
		if (day > 1) {
			time = time + (8 - day) * 24 * 60 * 60 * 1000L;
		}
		Date date = new Date(time);
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		date = sdf2.parse(sdf1.format(date) + " 23:59:59");
		return date;
	}

	/**
	 * @description 返回当前时间是周几
	 * @return
	 */
	public static int getCurrentDayOfWeek() {
		Calendar c = Calendar.getInstance();
		int day = c.get(Calendar.DAY_OF_WEEK);
		return day == 1 ? 7 : day - 1;
	}

	/**
	 * @description 根据日期获取星期
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static int getDayOfWeek(Date date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = sdf.parse(sdf.format(new Date()));
		Date targetDate = sdf.parse(sdf.format(date));
		if (currentDate.getTime() == targetDate.getTime()) {
			return getCurrentDayOfWeek();
		} else if (currentDate.getTime() < targetDate.getTime()) {
			return (int) ((targetDate.getTime() - currentDate.getTime()) / (24 * 60 * 60 * 1000) + getCurrentDayOfWeek()) % 7;
		} else if (currentDate.getTime() > targetDate.getTime()) {
			return (int) (getCurrentDayOfWeek() + 7 - (currentDate.getTime() - targetDate.getTime()) / (24 * 60 * 60 * 1000) % 7) % 7;
		}
		return 0;
	}

	/**
	 * @description 根据日期获取一周的日期(从周一到周日)
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static List<Date> getDateListOfWeek(Date date) throws ParseException {
		List<Date> list = new ArrayList<Date>();
		int dayOfWeek = getDayOfWeek(date);
		Date firstDay = new Date(date.getTime() - (dayOfWeek - 1) * 24 * 60 * 60 * 1000L);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		firstDay = sdf.parse(sdf.format(firstDay));
		list.add(firstDay);
		for (int i = 1; i < 7; i++) {
			list.add(new Date(firstDay.getTime() + i * 24 * 60 * 60 * 1000L));
		}
		return list;
	}

	/**
	 * @description 根据生日计算岁数
	 * @param date
	 * @return
	 */
	public static int getAgeByBirthday(Date birthday) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str1 = sdf.format(birthday);
		String str2 = sdf.format(date);
		if (Integer.parseInt(str2.split("-")[1]) > Integer.parseInt(str1.split("-")[1])) {
			return Integer.parseInt(str2.split("-")[0]) - Integer.parseInt(str1.split("-")[0]);
		}
		if (Integer.parseInt(str2.split("-")[1]) < Integer.parseInt(str1.split("-")[1])) {
			return Integer.parseInt(str2.split("-")[0]) - Integer.parseInt(str1.split("-")[0]) + 1;
		}
		if (Integer.parseInt(str2.split("-")[1]) == Integer.parseInt(str1.split("-")[1])) {
			if (Integer.parseInt(str2.split("-")[2]) >= Integer.parseInt(str1.split("-")[2])) {
				return Integer.parseInt(str2.split("-")[0]) - Integer.parseInt(str1.split("-")[0]);
			}
			if (Integer.parseInt(str2.split("-")[2]) < Integer.parseInt(str1.split("-")[2])) {
				return Integer.parseInt(str2.split("-")[0]) - Integer.parseInt(str1.split("-")[0]) + 1;
			}
		}
		return 0;
	}

	/**
	 * @description get value by key from json
	 * @param json
	 * @param key
	 * @return
	 */
	public static String getValueByKeyFromJson(String json, String key) {
		if (!Util.isNotEmpty(json)) {
			return null;
		}
		JsonObject jo = Constants.jsonParser.parse(json).getAsJsonObject();
		if (!jo.has(key)) {
			return null;
		}

		return jo.get(key).getAsString();
	}

	/**
	 * @description getPassTime
	 * @param date
	 * @return
	 */
	public static String getPassTime(Date date) {
		long agoTime = System.currentTimeMillis() - date.getTime();
		if (agoTime > 60 * 60 * 1000L && agoTime < 24 * 60 * 60 * 1000L) {
			return agoTime / (60 * 60 * 1000L) + "小时以前";
		}

		if (agoTime < 60 * 60 * 1000L && agoTime > 60 * 1000L) {
			return agoTime / (60 * 1000L) + "分钟以前";
		}

		if (agoTime < 60 * 1000L) {
			return "刚刚";
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date _date = new Date();
		String[] strs = sdf.format(date).split("-");
		int year = Integer.parseInt(strs[0]);
		int month = Integer.parseInt(strs[1]);
		int day = Integer.parseInt(strs[2]);
		strs = sdf.format(_date).split("-");
		int _year = Integer.parseInt(strs[0]);
		int _month = Integer.parseInt(strs[1]);
		int _day = Integer.parseInt(strs[2]);

		if (year + 1 < _year) {
			if (month < _month) {
				return _year - year + "年以前";
			}
			if (month > _month) {
				return _year - year - 1 + "年以前";
			}
		}

		if (year + 1 == _year) {
			if (month < _month) {
				return "1年以前";
			}
			if (month > _month) {
				if (12 - month + _month > 1) {
					return 12 - month + _month + "个月以前";
				} else {
					if (day <= _day) {
						return "1个月以前";
					} else {
						return agoTime / (24 * 60 * 60 * 1000L) + "天以前";
					}
				}
			}
			if (month == _month) {
				if (day <= _day) {
					return "1年以前";
				}
				if (day > _day) {
					return "11个月以前";
				}
			}
		}

		if (year == _year) {
			if (month + 1 < _month) {
				return _month - month + "个月以前";
			}
			if (month + 1 == _month) {
				if (day <= _day) {
					return "1个月以前";
				} else {
					return agoTime / (24 * 60 * 60 * 1000L) + "天以前";
				}
			}
			if (month == _month) {
				if (day < _day) {
					return _day - day + "天以前";
				}
			}
		}

		return null;
	}
}