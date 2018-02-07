package com.ai.photo.common.util;

import java.math.BigDecimal;

public class NumberUtil {
	public static final int DOUBLE_PRECISON = 2;
	public static final int ROUND_TYPE = BigDecimal.ROUND_HALF_UP;

	public static double fmtDouble(double d){
		BigDecimal bigDecimal = new BigDecimal(d);
		return bigDecimal.setScale(DOUBLE_PRECISON, ROUND_TYPE).doubleValue();
	}
}
