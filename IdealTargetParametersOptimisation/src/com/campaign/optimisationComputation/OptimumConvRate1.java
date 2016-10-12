package com.campaign.optimisationComputation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

import com.GenericOptimisationDataModel.CollectParameterOptimisationData;
import com.GenericOptimisationDataModel.InsertOptimisedParametersData;
import com.GenericOptimisationDataModel.ParameterCTRDTO;
import com.GenericOptimisationDataModel.ParameterConvRateDTO;
import com.stringutil.StatisticsUtil;
import com.stringutil.StringSimplifier;

public class OptimumConvRate1 {

	
	public static Pattern specialPattern
     = Pattern.compile("[\\p{InCombiningDiacriticalMarks}\\p{IsLm}\\p{IsSk}]+");
	
	public static void main(String[] args) {

		String city;
		String impressions = null;
		String clicks = null;
		String campaignId;
		ParameterConvRateDTO dto;
		Set<String> campIds = new HashSet<String>();
		int count;
		Map<String, Double> convratemap = new HashMap<String, Double>();
		Map<String, String> parameterMarketmap = new HashMap<String, String>();
		List<Double> convrateList = new ArrayList<Double>();
		List<ParameterConvRateDTO> dtoList = new ArrayList<ParameterConvRateDTO>();
		int a;
		int b;
		int integercheck;
		int integercheck1;
		Double convrate;
		Double max;
		Double median;
		Double IstQuartile;
		Double IIIrdQuartile;
		String parameterP1Map = "P1:";
		String parameterP2Map = "P2:";
        String[] optimumKey = null;
        String parsedKey = null;
        String finalkey = null;
        
        
		// Loop will incorporate support for each channel

	//	PrintStream out = null;
	//	try {
	//		out = new PrintStream(new FileOutputStream("output.txt"));
	//	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
	//		e.printStackTrace();
	//	}
	//	System.setOut(out);
		
		
		for (int m = 0; m < 5; m++) {

			for (int n = 0; n < 3; n++) {

				if (m == 0 && n == 0)
					dtoList = CollectParameterOptimisationData
							.cityConvRateoptimisation("DBM");

				if (m == 0 && n == 1)
					dtoList = CollectParameterOptimisationData
							.cityConvRateoptimisation("Adwords");

				if (m == 0 && n == 2)
					dtoList = CollectParameterOptimisationData
							.cityConvRateoptimisation("Facebook");

				
				
				if (m == 1 && n == 0)
					dtoList = CollectParameterOptimisationData
							.OSConvRateoptimisation("DBM");

				if (m == 1 && n == 1)
					dtoList = CollectParameterOptimisationData
							.OSConvRateoptimisation("Adwords");

				if (m == 1 && n == 2)
					dtoList = CollectParameterOptimisationData
							.OSConvRateoptimisation("Facebook");
				
				
				
				if (m == 2 && n == 0)
					dtoList = CollectParameterOptimisationData
							.SegmentConvRateoptimisation("DBM");

				if (m == 2 && n == 1)
					dtoList = CollectParameterOptimisationData
							.SegmentConvRateoptimisation("Adwords");

				
				if (m == 2 && n == 2)
					dtoList = CollectParameterOptimisationData
							.SegmentConvRateoptimisation("Facebook");
				
				if (m == 3 && n == 0)
				    dtoList = CollectParameterOptimisationData
							.AgeConvRateoptimisation("DBM");

				if (m == 3 && n == 1)
					dtoList = CollectParameterOptimisationData
							.AgeConvRateoptimisation("Adwords");

				
				if (m == 3 && n == 2)
					dtoList = CollectParameterOptimisationData
							.AgeConvRateoptimisation("Facebook");
				
				if (m == 4 && n == 0)
					dtoList = CollectParameterOptimisationData
							.GenderConvRateoptimisation("DBM");

				if (m == 4 && n == 1)
					dtoList = CollectParameterOptimisationData
							.GenderConvRateoptimisation("Adwords");

				
				if (m == 4 && n == 2)
					dtoList = CollectParameterOptimisationData
							.GenderConvRateoptimisation("Facebook");
				
				
				campIds.clear();
				
				for (int i = 0; i < dtoList.size(); i++) {
					dto = dtoList.get(i);
					campaignId = dto.getCampaignId();
					campIds.add(campaignId);
				}

				for (String campId : campIds) {
					
					
					convratemap.clear();
					convrateList.clear();
					parameterMarketmap.clear();
					parameterP1Map="P1:";
					parameterP2Map="P2:"; 
					
					
					for (ParameterConvRateDTO dto1 : dtoList) {
						if (dto1.getCampaignId().equals(campId)) {

							if(dto1.getConversions().equals("0")==false)
							{
							
								convrate = Double.parseDouble(dto1.getConversions());
							
							if(m == 2 && n == 0)
									{
								      parsedKey = StringSimplifier.simplifiedString(dto1.getParameter());
								      System.out.println(parsedKey);
								      finalkey=parsedKey.replace("\"","");
								      optimumKey = finalkey.split("-a");
								      if(optimumKey.length > 2)
								      convratemap.put(optimumKey[optimumKey.length-2], convrate);
									}
							
														
							convratemap.put(dto1.getParameter(), convrate);
							convrateList.add(convrate);
							}
						}

					}

					if(convrateList.isEmpty()==false)
					{
					Collections.sort(convrateList);
			
					int middle = ((convrateList.size()) / 2);
					if(convrateList.size() % 2 == 0){
					Double medianA = convrateList.get(middle);
				    Double medianB = convrateList.get(middle-1);
					 median = (medianA + medianB) / 2;
					} else{
					 median = convrateList.get(middle + 1);
					}
					
									
					max = Collections.max(convrateList);
/*
					integercheck = (ctrList.size() + 1) / 4;

					if (isEvenlyDivisable(ctrList.size() + 1,4)) {
						IstQuartile = ctrList.get((int)integercheck);
						IIIrdQuartile = ctrList.get(3 * (int)integercheck);
					} else {
						IstQuartile = ctrList.get((int) integercheck)
								+ ctrList.get((int) integercheck + 1) / 2;
						IIIrdQuartile = ctrList.get(3 * (int) integercheck)
								+ ctrList.get(3 * (int) integercheck + 1) / 2;
					}
*/
					
					IstQuartile = StatisticsUtil.quartile1(convrateList);
					IIIrdQuartile = StatisticsUtil.quartile3(convrateList);
					
					
					
					
					
					
					
					for (Entry<String, Double> entry : convratemap.entrySet()) {
						System.out.println("Key:" + entry.getKey() + "Value:"
								+ entry.getValue());

						if (entry.getValue() >= IIIrdQuartile
								&& entry.getValue() <= max) {
							parameterMarketmap.put(entry.getKey(), "P1");
							parameterP1Map += entry.getKey() + ",";
						}

						if (entry.getValue() >= median
								&& entry.getValue() < IIIrdQuartile) {
							parameterMarketmap.put(entry.getKey(), "P2");
							parameterP2Map += entry.getKey() + ",";
						}

					}

					if (m == 0 && n == 0)
						InsertOptimisedParametersData.cityConvRateoptimisation(
								campId, "DBM", parameterP1Map + parameterP2Map);

					if (m == 0 && n == 1)
						InsertOptimisedParametersData.cityConvRateoptimisation(
								campId, "Adwords", parameterP1Map
										+ parameterP2Map);

					if (m == 0 && n == 2)
						InsertOptimisedParametersData.cityConvRateoptimisation(
								campId, "Facebook", parameterP1Map
										+ parameterP2Map);
					
					
					if (m == 1 && n == 0)
						InsertOptimisedParametersData.OSConvRateoptimisation(campId,
								"DBM", parameterP1Map + parameterP2Map);

					if (m == 1 && n == 1)
						InsertOptimisedParametersData.OSConvRateoptimisation(campId,
								"Adwords", parameterP1Map + parameterP2Map);

					if (m == 1 && n == 2)
						InsertOptimisedParametersData.OSConvRateoptimisation(campId,
								"Facebook", parameterP1Map + parameterP2Map);
					
					
					
					if (m == 2 && n == 0){
						
						parameterP1Map=parameterP1Map.replace("\"","");
						parameterP2Map=parameterP2Map.replace("\"","");
						
						InsertOptimisedParametersData.SegmentConvRateoptimisation(
								campId, "DBM", parameterP1Map + parameterP2Map);
                        
						
						System.out.println(parameterP1Map + parameterP2Map);
						
						
					}
						
					if (m == 2 && n == 1)
						InsertOptimisedParametersData.SegmentConvRateoptimisation(
								campId, "Adwords", parameterP1Map
										+ parameterP2Map);

					if (m == 2 && n == 2)
						InsertOptimisedParametersData.SegmentConvRateoptimisation(
								campId, "Facebook", parameterP1Map
										+ parameterP2Map);
					
					
				
					if (m == 3 && n == 0)
						InsertOptimisedParametersData.AgeConvRateoptimisation(campId,
								"DBM", parameterP1Map + parameterP2Map);

					if (m == 3 && n == 1)
						InsertOptimisedParametersData.AgeConvRateoptimisation(campId,
								"Adwords", parameterP1Map + parameterP2Map);

					if (m == 3 && n == 2)
						InsertOptimisedParametersData.AgeConvRateoptimisation(campId,
								"Facebook", parameterP1Map + parameterP2Map);		
					
					
					if (m == 4 && n == 0)
						InsertOptimisedParametersData.GenderConvRateoptimisation(campId,
							 "DBM", parameterP1Map + parameterP2Map);

					if (m == 4 && n == 1)
						InsertOptimisedParametersData.GenderConvRateoptimisation(campId,
								"Adwords", parameterP1Map + parameterP2Map);

					if (m == 4 && n == 2)
						InsertOptimisedParametersData.GenderConvRateoptimisation(campId,
								"Facebook", parameterP1Map + parameterP2Map);
					
					
					
					
					}

				}
			}
		}

	}

	public static boolean isEvenlyDivisable(int a, int b) {
	    return a % b == 0;
	}
	
	
	
}