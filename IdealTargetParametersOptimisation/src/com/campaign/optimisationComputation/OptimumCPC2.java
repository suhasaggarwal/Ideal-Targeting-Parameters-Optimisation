package com.campaign.optimisationComputation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.GenericOptimisationDataModel.CollectParameterOptimisationData;
import com.GenericOptimisationDataModel.InsertOptimisedParametersData;
import com.GenericOptimisationDataModel.ParameterCPCDTO;

public class OptimumCPC2 {

	public static void main(String[] args) {

		String city;
		String impressions = null;
		String clicks = null;
		String campaignId;
		Set<String> campIds = new HashSet<String>();
		ParameterCPCDTO dto;
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

		// Loop will incorporate support for each channel

		for (int m = 0; m < 3; m++) {

			for (int n = 0; n < 2; n++) {

				if (m == 0 && n == 0)
					dtoList = CollectParameterOptimisationData
							.cityCPCoptimisation("DBM");

				if (m == 0 && n == 1)
					dtoList = CollectParameterOptimisationData
							.cityCPCoptimisation("Adwords");

				if (m == 1 && n == 0)
					dtoList = CollectParameterOptimisationData
							.OSCPCoptimisation("DBM");

				if (m == 1 && n == 1)
					dtoList = CollectParameterOptimisationData
							.OSCPCoptimisation("Adwords");

				if (m == 2 && n == 0)
					dtoList = CollectParameterOptimisationData
							.SegmentCPCoptimisation("DBM");

				if (m == 2 && n == 1)
					dtoList = CollectParameterOptimisationData
							.SegmentCPCoptimisation("Adwords");

				for (int i = 0; i < dtoList.size(); i++) {
					dto = dtoList.get(i);
					campaignId = dto.getCampaignId();
					campIds.add(campaignId);
				}

				for (String campId : campIds) {
					for (ParameterCPCDTO dto1 : dtoList) {
						if (dto1.getCampaignId().equals(campId)) {

							cpc = Double.parseDouble(dto1.getSpent())
									/ Double.parseDouble(dto1.getClicks());
							cpcmap.put(dto1.getParameter(), cpc);
							cpcList.add(cpc);

						}

					}

					Collections.sort(cpcList);
					integercheck1 = (cpcList.size() + 1) / 2;

					if (integercheck1 == (int) integercheck1)
						median = cpcList.get(integercheck1);
					else {
						a = (int) cpcList.size() / 2;
						b = (int) cpcList.size() + 1 / 2;
						median = (cpcList.get(a) + cpcList.get(b)) / 2;
					}

					max = Collections.max(cpcList);

					integercheck = (cpcList.size() + 1) / 4;

					if (integercheck == (int) integercheck) {
						IstQuartile = cpcList.get(integercheck);
						IIIrdQuartile = cpcList.get(3 * integercheck);
					} else {
						IstQuartile = cpcList.get((int) integercheck)
								+ cpcList.get((int) integercheck + 1) / 2;
						IIIrdQuartile = cpcList.get(3 * (int) integercheck)
								+ cpcList.get(3 * (int) integercheck + 1) / 2;
					}

					for (Entry<String, Double> entry : cpcmap.entrySet()) {
						System.out.println("Key:" + entry.getKey() + "Value:"
								+ entry.getValue());

						if (entry.getValue() < IstQuartile) {
							parameterMarketmap.put(entry.getKey(), "P1");
							parameterP1Map += entry.getKey() + ",";
						}

						if (entry.getValue() > IstQuartile
								&& entry.getValue() < IIIrdQuartile) {
							parameterMarketmap.put(entry.getKey(), "P2");
							parameterP2Map += entry.getKey() + ",";
						}

					}

					if (m == 0 && n == 0)
						InsertOptimisedParametersData.cityCPCoptimisation(
								campId, "DBM", parameterP1Map + parameterP2Map);

					if (m == 0 && n == 1)
						InsertOptimisedParametersData.cityCPCoptimisation(
								campId, "Adwords", parameterP1Map
										+ parameterP2Map);

					if (m == 1 && n == 0)
						InsertOptimisedParametersData.OSCPCoptimisation(campId,
								"DBM", parameterP1Map + parameterP2Map);

					if (m == 1 && n == 1)
						InsertOptimisedParametersData.OSCPCoptimisation(campId,
								"Adwords", parameterP1Map + parameterP2Map);

					if (m == 2 && n == 0)
						InsertOptimisedParametersData.SegmentCPCoptimisation(
								campId, "DBM", parameterP1Map + parameterP2Map);

					if (m == 2 && n == 1)
						InsertOptimisedParametersData.SegmentCPCoptimisation(
								campId, "Adwords", parameterP1Map
										+ parameterP2Map);

				}

			}
		}

	}

}