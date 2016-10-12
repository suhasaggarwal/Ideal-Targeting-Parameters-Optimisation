package com.GenericOptimisationDataModel;

public class ParameterConvRateDTO {

	private String parameter;

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getConversions() {
		return conversions;
	}

	public void setConversions(String conversion) {
		this.conversions = conversion;
	}

	public String getImpressions() {
		return impressions;
	}

	public void setImpressions(String impression) {
		this.impressions = impression;
	}

	public String getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}

	private String conversions;
	private String impressions;
	private String campaignId;

	private String analyseddate;

	public String getAnalyseddate() {
		return analyseddate;
	}

	public void setAnalyseddate(String analyseddate) {
		this.analyseddate = analyseddate;
	}

}
