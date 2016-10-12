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
import com.GenericOptimisationDataModel.ParameterConvRateDTO;


public class OptimumConvRate {

	public static void main(String[] args) {

		String city;
		String impressions = null;
		String conversions = null;
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

		// Loop will incorporate support for each channel

		for (int m = 0; m < 3; m++) {

			for (int n = 0; n < 2; n++) {

				if (m == 0 && n == 0)
					dtoList = CollectParameterOptimisationData
							.cityConvRateoptimisation("DBM");

				if (m == 0 && n == 1)
					dtoList = CollectParameterOptimisationData
							.cityConvRateoptimisation("Adwords");

				if (m == 1 && n == 0)
					dtoList = CollectParameterOptimisationData
							.OSConvRateoptimisation("DBM");

				if (m == 1 && n == 1)
					dtoList = CollectParameterOptimisationData
							.OSConvRateoptimisation("Adwords");

				if (m == 2 && n == 0)
					dtoList = CollectParameterOptimisationData
							.SegmentConvRateoptimisation("DBM");

				if (m == 2 && n == 1)
					dtoList = CollectParameterOptimisationData
							.SegmentConvRateoptimisation("Adwords");

				for (int i = 0; i < dtoList.size(); i++) {
					dto = dtoList.get(i);
					campaignId = dto.getCampaignId();
					campIds.add(campaignId);
				}

				for (String campId : campIds) {
					for (ParameterConvRateDTO dto1 : dtoList) {
						if (dto1.getCampaignId().equals(campId)) {

							convrate = Double.parseDouble(dto1.getConversions())
									/ Double.parseDouble(dto1.getImpressions());
							convratemap.put(dto1.getParameter(), convrate);
							convrateList.add(convrate);

						}

					}

					Collections.sort(convrateList);
					integercheck1 = (convrateList.size() + 1) / 2;

					if (integercheck1 == (int) integercheck1)
						median = convrateList.get(integercheck1);
					else {
						a = (int) convrateList.size() / 2;
						b = (int) convrateList.size() + 1 / 2;
						median = (convrateList.get(a) + convrateList.get(b)) / 2;
					}

					max = Collections.max(convrateList);

					integercheck = (convrateList.size() + 1) / 4;

					if (integercheck == (int) integercheck) {
						IstQuartile = convrateList.get(integercheck);
						IIIrdQuartile = convrateList.get(3 * integercheck);
					} else {
						IstQuartile = convrateList.get((int) integercheck)
								+ convrateList.get((int) integercheck + 1) / 2;
						IIIrdQuartile = convrateList.get(3 * (int) integercheck)
								+ convrateList.get(3 * (int) integercheck + 1) / 2;
					}

					for (Entry<String, Double> entry : convratemap.entrySet()) {
						System.out.println("Key:" + entry.getKey() + "Value:"
								+ entry.getValue());

						if (entry.getValue() > IIIrdQuartile
								&& entry.getValue() < max) {
							parameterMarketmap.put(entry.getKey(), "P1");
							parameterP1Map += entry.getKey() + ",";
						}

						if (entry.getValue() > median
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

					if (m == 1 && n == 0)
						InsertOptimisedParametersData.OSConvRateoptimisation(campId,
								"DBM", parameterP1Map + parameterP2Map);

					if (m == 1 && n == 1)
						InsertOptimisedParametersData.OSConvRateoptimisation(campId,
								"Adwords", parameterP1Map + parameterP2Map);

					if (m == 2 && n == 0)
						InsertOptimisedParametersData.SegmentConvRateoptimisation(
								campId, "DBM", parameterP1Map + parameterP2Map);

					if (m == 2 && n == 1)
						InsertOptimisedParametersData.SegmentConvRateoptimisation(
								campId, "Adwords", parameterP1Map
										+ parameterP2Map);

				}

			}
		}

	}

}