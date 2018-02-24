package com.paic.arch.interviews.impl;

import com.paic.arch.interviews.TimeConverter;

/**
 * 
* @create by wei.hu on 2018年2月23日 下午7:05:28
 */
public class TimeConverterImpl implements TimeConverter{

	@Override
	public String convertTime(String aTime) {
		StringBuffer result = new StringBuffer();
		String [] time = aTime.trim().split(":");
		String hour = time[0];//时
		String minute = time[1];//分
		String scond = time[2];//秒
		
		//顶端： 偶数秒是Y,奇数秒是O
		if(Integer.parseInt(scond) % 2 == 0){
			result.append("Y");
		}else{
			result.append("O");
		}
		result.append("\r\n");//换行
		//第一行： 时除以5取整
		Integer one = Integer.parseInt(hour) / 5;
		result = bulid(result, 4, one);
		//第二行：时对5取余
		Integer two = Integer.parseInt(hour) % 5;
		result = bulid(result, 4, two);
		//第三行：分除以5取整
		Integer three = Integer.parseInt(minute) / 5;
		result = bulid(result, 11, three);
		//第四行：分对5取余
		Integer four = Integer.parseInt(minute) % 5;
		for (int i = 0; i < four; i++) {
			result.append("Y");
		}
		for (int i = 0; i < 4 - four; i++) {
			result.append("O");
		}
		return result.toString();
	}
	
	public StringBuffer bulid(StringBuffer str,Integer length,Integer r){
		if (11 == length) {
			for (int i = 0; i < r; i++) {
				// 判断是否是3的倍数
				if (0 == (i + 1) % 3) {
					str.append("R");
				} else {
					str.append("Y");
				}
			}
		} else {
			for (int i = 0; i < r; i++) {
				str.append("R");
			}
		}
		// 加上剩余的O
		for (int i = 0; i < length - r; i++) {
			str.append("O");
		}
		str.append("\r\n");//换行
		return str;
	}
}
