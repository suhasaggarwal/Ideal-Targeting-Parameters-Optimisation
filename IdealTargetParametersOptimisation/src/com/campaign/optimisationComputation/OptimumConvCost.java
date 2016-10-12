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
import com.GenericOptimisationDataModel.ParameterConvCostDTO;
import com.GenericOptimisationDataModel.ParameterConvRateDTO;

public class OptimumConvCost {

	public static void main(String[] args) {

		String city;

		String spent = null;
		String conversions = null;
		String campaignId;
		ParameterConvCostDTO dto;
		Set<String> campIds = new HashSet<String>();
		int count;
		Map<String, Double> convcostmap = new HashMap<String, Double>();
		Map<String, String> parameterMarketmap = new HashMap<String, String>();
		List<Double> convcostList = new ArrayList<Double>();
		List<ParameterConvCostDTO> dtoList = new ArrayList<ParameterConvCostDTO>();
		int a;
		int b;
		int integercheck;
		int integercheck1;
		Double convcost;
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
							.cityConvCostoptimisation("DBM");

				if (m == 0 && n == 1)
					dtoList = CollectParameterOptimisationData
							.cityConvCostoptimisation("Adwords");

				if (m == 1 && n == 0)
					dtoList = CollectParameterOptimisationData
							.OSConvCostoptimisation("DBM");

				if (m == 1 && n == 1)
					dtoList = CollectParameterOptimisationData
							.OSConvCostoptimisation("Adwords");

				if (m == 2 && n == 0)
					dtoList = CollectParameterOptimisationData
							.SegmentConvCostoptimisation("DBM");

				if (m == 2 && n == 1)
					dtoList = CollectParameterOptimisationData
							.SegmentConvCostoptimisation("Adwords");

				for (int i = 0; i < dtoList.size(); i++) {
					dto = dtoList.get(i);
					campaignId = dto.getCampaignId();
					campIds.add(campaignId);
				}

				for (String campId : campIds) {
					for (ParameterConvCostDTO dto1 : dtoList) {
						if (dto1.getCampaignId().equals(campId)) {

							convcost = Double.parseDouble(dto1.getSpent())
									/ Double.parseDouble(dto1.getConversions());
							convcostmap.put(dto1.getParameter(), convcost);
							convcostList.add(convcost);

						}

					}

					Collections.sort(convcostList);
					integercheck1 = (convcostList.size() + 1) / 2;

					if (integercheck1 == (int) integercheck1)
						median = convcostList.get(integercheck1);
					else {
						a = (int) convcostList.size() / 2;
						b = (int) convcostList.size() + 1 / 2;
						median = (convcostList.get(a) + convcostList.get(b)) / 2;
					}

					max = Collections.max(convcostList);

					integercheck = (convcostList.size() + 1) / 4;

					if (integercheck == (int) integercheck) {
						IstQuartile = convcostList.get(integercheck);
						IIIrdQuartile = convcostList.get(3 * integercheck);
					} else {
						IstQuartile = convcostList.get((int) integercheck)
								+ convcostList.get((int) integercheck + 1) / 2;
						IIIrdQuartile = convcostList
								.get(3 * (int) integercheck)
								+ convcostList.get(3 * (int) integercheck + 1)
								/ 2;
					}

					for (Entry<String, Double> entry : convcostmap.entrySet()) {
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
						InsertOptimisedParametersData.cityConvCostoptimisation(
								campId, "DBM", parameterP1Map + parameterP2Map);

					if (m == 0 && n == 1)
						InsertOptimisedParametersData.cityConvCostoptimisation(
								campId, "Adwords", parameterP1Map
										+ parameterP2Map);

					if (m == 1 && n == 0)
						InsertOptimisedParametersData.OSConvCostoptimisation(
								campId, "DBM", parameterP1Map + parameterP2Map);

					if (m == 1 && n == 1)
						InsertOptimisedParametersData.OSConvCostoptimisation(
								campId, "Adwords", parameterP1Map
										+ parameterP2Map);

					if (m == 2 && n == 0)
						InsertOptimisedParametersData
								.SegmentConvCostoptimisation(campId, "DBM",
										parameterP1Map + parameterP2Map);

					if (m == 2 && n == 1)
						InsertOptimisedParametersData
								.SegmentConvCostoptimisation(campId, "Adwords",
										parameterP1Map + parameterP2Map);

				}

			}
		}

	}

}