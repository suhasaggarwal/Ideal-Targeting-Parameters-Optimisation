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
import com.stringutil.StatisticsUtil;
import com.stringutil.StringSimplifier;

public class OptimumCTR {

	
	public static Pattern specialPattern
     = Pattern.compile("[\\p{InCombiningDiacriticalMarks}\\p{IsLm}\\p{IsSk}]+");
	
	public static void main(String[] args) {

		String city;
		String impressions = null;
		String clicks = null;
		String campaignId;
		ParameterCTRDTO dto;
		Set<String> campIds = new HashSet<String>();
		int count;
		Map<String, Double> ctrmap = new HashMap<String, Double>();
		Map<String, String> parameterMarketmap = new HashMap<String, String>();
		List<Double> ctrList = new ArrayList<Double>();
		List<ParameterCTRDTO> dtoList = new ArrayList<ParameterCTRDTO>();
		int a;
		int b;
		int integercheck;
		int integercheck1;
		Double ctr;
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
							.cityCTRoptimisation("DBM");

				if (m == 0 && n == 1)
					dtoList = CollectParameterOptimisationData
							.cityCTRoptimisation("Adwords");

				
				if (m == 0 && n == 2)
					dtoList = CollectParameterOptimisationData
							.cityCTRoptimisation("Facebook");

				
				
				if (m == 1 && n == 0)
					dtoList = CollectParameterOptimisationData
							.OSCTRoptimisation("DBM");

				if (m == 1 && n == 1)
					dtoList = CollectParameterOptimisationData
							.OSCTRoptimisation("Adwords");

				if (m == 1 && n == 2)
					dtoList = CollectParameterOptimisationData
							.OSCTRoptimisation("Facebook");

				
				
				if (m == 2 && n == 0)
					dtoList = CollectParameterOptimisationData
							.SegmentCTRoptimisation("DBM");

				if (m == 2 && n == 1)
					dtoList = CollectParameterOptimisationData
							.SegmentCTRoptimisation("Adwords");

				
				if (m == 2 && n == 2)
					dtoList = CollectParameterOptimisationData
							.SegmentCTRoptimisation("Facebook");

				
				if (m == 3 && n == 0)
					dtoList = CollectParameterOptimisationData
							.AgeCTRoptimisation("DBM");

				if (m == 3 && n == 1)
					dtoList = CollectParameterOptimisationData
							.AgeCTRoptimisation("Adwords");

				
				if (m == 3 && n == 2)
					dtoList = CollectParameterOptimisationData
							.AgeCTRoptimisation("Facebook");
				
				
				if (m == 4 && n == 0)
					dtoList = CollectParameterOptimisationData
							.GenderCTRoptimisation("DBM");

				if (m == 4 && n == 1)
					dtoList = CollectParameterOptimisationData
							.GenderCTRoptimisation("Adwords");

				
				if (m == 4 && n == 2)
					dtoList = CollectParameterOptimisationData
							.GenderCTRoptimisation("Facebook");
				
				
				
				
				
				
				campIds.clear();
				
				for (int i = 0; i < dtoList.size(); i++) {
					dto = dtoList.get(i);
					campaignId = dto.getCampaignId();
					campIds.add(campaignId);
				}

				for (String campId : campIds) {
					
					
					ctrmap.clear();
					ctrList.clear();
					parameterMarketmap.clear();
					parameterP1Map="P1:";
					parameterP2Map="P2:"; 
					
					
					for (ParameterCTRDTO dto1 : dtoList) {
						if (dto1.getCampaignId().equals(campId)) {

							if(dto1.getImpressions().equals("0")==false && dto1.getClicks().equals("0")==false)
							{
							
							ctr = Double.parseDouble(dto1.getClicks())
									/ Double.parseDouble(dto1.getImpressions());
							
							if(m == 2 && n == 0)
									{
								      parsedKey = StringSimplifier.simplifiedString(dto1.getParameter());
								      System.out.println(parsedKey);
								      finalkey=parsedKey.replace("\"","");
								      optimumKey = finalkey.split("-a");
								      if(optimumKey.length > 2)
								      ctrmap.put(optimumKey[optimumKey.length-2], ctr);
									}
							
														
							ctrmap.put(dto1.getParameter(), ctr);
							ctrList.add(ctr);
							}
						}

					}

					if(ctrList.isEmpty()==false)
					{
					Collections.sort(ctrList);
			
					int middle = ((ctrList.size()) / 2);
					if(ctrList.size() % 2 == 0){
					Double medianA = ctrList.get(middle);
				    Double medianB = ctrList.get(middle-1);
					 median = (medianA + medianB) / 2;
					} else{
					 median = ctrList.get(middle + 1);
					}
					
									
					max = Collections.max(ctrList);
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
					
					IstQuartile = StatisticsUtil.quartile1(ctrList);
					IIIrdQuartile = StatisticsUtil.quartile3(ctrList);
					
					
					
					
					
					
					
					for (Entry<String, Double> entry : ctrmap.entrySet()) {
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
						InsertOptimisedParametersData.cityCTRoptimisation(
								campId, "DBM", parameterP1Map + parameterP2Map);

					if (m == 0 && n == 1)
						InsertOptimisedParametersData.cityCTRoptimisation(
								campId, "Adwords", parameterP1Map + parameterP2Map);

					if (m == 0 && n == 2)
						InsertOptimisedParametersData.cityCTRoptimisation(
								campId, "Facebook", parameterP1Map + parameterP2Map);
					
					
					if (m == 1 && n == 0)
						InsertOptimisedParametersData.OSCTRoptimisation(campId,
								"DBM", parameterP1Map + parameterP2Map);

					if (m == 1 && n == 1)
						InsertOptimisedParametersData.OSCTRoptimisation(campId,
								"Adwords", parameterP1Map + parameterP2Map);

					if (m == 1 && n == 2)
						InsertOptimisedParametersData.OSCTRoptimisation(campId,
								"Facebook", parameterP1Map + parameterP2Map);
					
					
					
					if (m == 2 && n == 0){
						
						parameterP1Map=parameterP1Map.replace("\"","");
						parameterP2Map=parameterP2Map.replace("\"","");
						
						InsertOptimisedParametersData.SegmentCTRoptimisation(
								campId, "DBM", parameterP1Map + parameterP2Map);
                        
						
						System.out.println(parameterP1Map + parameterP2Map);
						
						
					}
						
					if (m == 2 && n == 1)
						InsertOptimisedParametersData.SegmentCTRoptimisation(
								campId, "Adwords", parameterP1Map
										+ parameterP2Map);

					if (m == 2 && n == 2)
						InsertOptimisedParametersData.SegmentCTRoptimisation(
								campId, "Facebook", parameterP1Map
										+ parameterP2Map);

					if (m == 3 && n == 0)
						InsertOptimisedParametersData.AgeCTRoptimisation(campId,
								"DBM", parameterP1Map + parameterP2Map);

					if (m == 3 && n == 1)
						InsertOptimisedParametersData.AgeCTRoptimisation(campId,
								"Adwords", parameterP1Map + parameterP2Map);

					if (m == 3 && n == 2)
						InsertOptimisedParametersData.AgeCTRoptimisation(campId,
								"Facebook", parameterP1Map + parameterP2Map);
					
					if (m == 4 && n == 0)
						InsertOptimisedParametersData.GenderCTRoptimisation(campId,
							"DBM", parameterP1Map + parameterP2Map);

					if (m == 4 && n == 1)
						InsertOptimisedParametersData.GenderCTRoptimisation(campId,
								"Adwords", parameterP1Map + parameterP2Map);

					if (m == 4 && n == 2)
						InsertOptimisedParametersData.GenderCTRoptimisation(campId,
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