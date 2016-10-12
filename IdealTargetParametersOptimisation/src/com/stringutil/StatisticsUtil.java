package com.stringutil;

import java.util.List;

public class StatisticsUtil {


	 public static Double median(List<Double> list,  int start, int end) {
	        int size = end - start;

	        if (size % 2 == 1) {
	            return list.get(start + (size + 1) / 2 - 1);
	        } else {
	            Double result = list.get(start + (size) / 2 - 1);
	            result = result+list.get(start + (size) / 2);
	            return (result/2);
	        }
	    }

	    public static Double quartile1(List<Double> list){
	        final int size = list.size();
	        if (size % 2 == 1) {
	            if (size > 1) {
	                return median(list, 0, size / 2 + 1);
	            } else {
	                return median(list, 0, 1);
	            }
	        } else {
	            return median(list, 0, size / 2);
	        }
	    }

	    public static Double quartile3(List<Double> list) {
	        final int size = list.size();
	        if (size % 2 == 1) {
	            if (size > 1) {
	                return median(list, size / 2, size);
	            } else {
	                return median(list, 0, 1);
	            }
	        } else {
	            return median(list, size / 2, size);
	        }
	    }














}
