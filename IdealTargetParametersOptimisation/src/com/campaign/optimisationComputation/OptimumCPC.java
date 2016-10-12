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
import com.GenericOptimisationDataModel.ParameterCPCDTO;
import com.GenericOptimisationDataModel.ParameterCTRDTO;
import com.stringutil.StatisticsUtil;
import com.stringutil.StringSimplifier;

public class OptimumCPC {

	
	public static Pattern specialPattern
     = Pattern.compile("[\\p{InCombiningDiacriticalMarks}\\p{IsLm}\\p{IsSk}]+");
	
	public static void main(String[] args) {

		String city;
		String impressions = null;
		String clicks = null;
		String campaignId;
		ParameterCPCDTO dto;
		Set<String> campIds = new HashSet<String>();
		int count;
		Map<String, Double> cpcmap = new HashMap<String, Double>();
		Map<String, String> parameterMarketmap = new HashMap<String, String>();
		List<Double> cpcList = new ArrayList<Double>();
		List<ParameterCPCDTO> dtoList = new ArrayList<ParameterCPCDTO>();
		int a;
		int b;
		int integercheck;
		int integercheck1;
		Double cpc;
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
							.cityCPCoptimisation("DBM");

				if (m == 0 && n == 1)
					dtoList = CollectParameterOptimisationData
							.cityCPCoptimisation("Adwords");

				if (m == 0 && n == 2)
					dtoList = CollectParameterOptimisationData
							.cityCPCoptimisation("Facebook");
				
				if (m == 1 && n == 0)
					dtoList = CollectParameterOptimisationData
							.OSCPCoptimisation("DBM");

				if (m == 1 && n == 1)
					dtoList = CollectParameterOptimisationData
							.OSCPCoptimisation("Adwords");

				if (m == 1 && n == 2)
					dtoList = CollectParameterOptimisationData
							.OSCPCoptimisation("Facebook");

					
				if (m == 2 && n == 0)
					dtoList = CollectParameterOptimisationData
							.SegmentCPCoptimisation("DBM");

				if (m == 2 && n == 1)
					dtoList = CollectParameterOptimisationData
							.SegmentCPCoptimisation("Adwords");

				if (m == 2 && n == 2)
					dtoList = CollectParameterOptimisationData
							.SegmentCPCoptimisation("Facebook");
				
				
				
				if (m == 3 && n == 0)
					dtoList = CollectParameterOptimisationData
						     .AgeCPCoptimisation("DBM");

				if (m == 3 && n == 1)
					dtoList = CollectParameterOptimisationData
							.AgeCPCoptimisation("Adwords");

				if (m == 3 && n == 2)
					dtoList = CollectParameterOptimisationData
							.AgeCPCoptimisation("Facebook");
				
				
				if (m == 4 && n == 0)
					dtoList = CollectParameterOptimisationData
							.GenderCPCoptimisation("DBM");

				if (m == 4 && n == 1)
					dtoList = CollectParameterOptimisationData
							.GenderCPCoptimisation("Adwords");

				if (m == 4 && n == 2)
					dtoList = CollectParameterOptimisationData
							.GenderCPCoptimisation("Facebook");
				
				
				
				
				
				
				
				
				
				campIds.clear();
				
				for (int i = 0; i < dtoList.size(); i++) {
					dto = dtoList.get(i);
					campaignId = dto.getCampaignId();
					campIds.add(campaignId);
				}

				for (String campId : campIds) {
					
					
					cpcmap.clear();
					cpcList.clear();
					parameterMarketmap.clear();
					parameterP1Map="P1:";
					parameterP2Map="P2:"; 
					
					
					for (ParameterCPCDTO dto1 : dtoList) {
						if (dto1.getCampaignId().equals(campId)) {

							if(dto1.getSpent().equals("0")==false && dto1.getClicks().equals("0")==false)
							{
							
								cpc = Double.parseDouble(dto1.getSpent())
										/ Double.parseDouble(dto1.getClicks());
							
							if(m == 2 && n == 0)
									{
								      parsedKey = StringSimplifier.simplifiedString(dto1.getParameter());
								      System.out.println(parsedKey);
								      finalkey=parsedKey.replace("\"","");
								      optimumKey = finalkey.split("-a");
								      if(optimumKey.length > 2)
								      cpcmap.put(optimumKey[optimumKey.length-2], cpc);
									}
							
														
							cpcmap.put(dto1.getParameter(), cpc);
							cpcList.add(cpc);
							}
						}

					}

					if(cpcList.isEmpty()==false)
					{
					Collections.sort(cpcList);
			
					int middle = ((cpcList.size()) / 2);
					if(cpcList.size() % 2 == 0){
					Double medianA = cpcList.get(middle);
				    Double medianB = cpcList.get(middle-1);
					 median = (medianA + medianB) / 2;
					} else{
					 median = cpcList.get(middle + 1);
					}
					
									
					max = Collections.max(cpcList);
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
					
					IstQuartile = StatisticsUtil.quartile1(cpcList);
					IIIrdQuartile = StatisticsUtil.quartile3(cpcList);
					
					
					
					
					
					
					
					for (Entry<String, Double> entry : cpcmap.entrySet()) {
						System.out.println("Key:" + entry.getKey() + "Value:"
								+ entry.getValue());

						if (entry.getValue() < IstQuartile) {
							parameterMarketmap.put(entry.getKey(), "P1");
							parameterP1Map += entry.getKey() + ",";
						}

						if (entry.getValue() >= IstQuartile
								&& entry.getValue() <= IIIrdQuartile) {
							parameterMarketmap.put(entry.getKey(), "P2");
							parameterP2Map += entry.getKey() + ",";
						}

					}

					if (m == 0 && n == 0)
						InsertOptimisedParametersData.cityCPCoptimisation(
								campId, "DBM", parameterP1Map + parameterP2Map);

					if (m == 0 && n == 1)
						InsertOptimisedParametersData.cityCPCoptimisation(
								campId, "Adwords", parameterP1Map + parameterP2Map);

					if (m == 0 && n == 2)
						InsertOptimisedParametersData.cityCPCoptimisation(
								campId, "Facebook", parameterP1Map + parameterP2Map);

					
					
					
					if (m == 1 && n == 0)
						InsertOptimisedParametersData.OSCPCoptimisation(campId,
								"DBM", parameterP1Map + parameterP2Map);

					if (m == 1 && n == 1)
						InsertOptimisedParametersData.OSCPCoptimisation(campId,
								"Adwords", parameterP1Map + parameterP2Map);

					if (m == 1 && n == 2)
						InsertOptimisedParametersData.OSCPCoptimisation(campId,
								"Facebook", parameterP1Map + parameterP2Map);
					
					
					if (m == 2 && n == 0){
						
						parameterP1Map=parameterP1Map.replace("\"","");
						parameterP2Map=parameterP2Map.replace("\"","");
						
						InsertOptimisedParametersData.SegmentCPCoptimisation(
								campId, "DBM", parameterP1Map + parameterP2Map);
                        
						
						System.out.println(parameterP1Map + parameterP2Map);
						
						
					}
						
					if (m == 2 && n == 1)
						InsertOptimisedParametersData.SegmentCPCoptimisation(
								campId, "Adwords", parameterP1Map
										+ parameterP2Map);

				
					if (m == 2 && n == 2)
						InsertOptimisedParametersData.SegmentCPCoptimisation(
								campId, "Facebook", parameterP1Map
										+ parameterP2Map);

					
					if (m == 3 && n == 0)
						InsertOptimisedParametersData.AgeCPCoptimisation(campId,
								"DBM", parameterP1Map + parameterP2Map);

					if (m == 3 && n == 1)
						InsertOptimisedParametersData.AgeCPCoptimisation(campId,
								"Adwords", parameterP1Map + parameterP2Map);

					if (m == 3 && n == 2)
						InsertOptimisedParametersData.AgeCPCoptimisation(campId,
								"Facebook", parameterP1Map + parameterP2Map);
					
					
					if (m == 4 && n == 0)
						InsertOptimisedParametersData.GenderCPCoptimisation(campId,
							     "DBM", parameterP1Map + parameterP2Map);

					if (m == 4 && n == 1)
						InsertOptimisedParametersData.GenderCPCoptimisation(campId,
								"Adwords", parameterP1Map + parameterP2Map);

					if (m == 4 && n == 2)
						InsertOptimisedParametersData.GenderCPCoptimisation(campId,
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