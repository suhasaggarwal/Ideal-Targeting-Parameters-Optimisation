package com.GenericOptimisationDataModel;

public class ParameterCTRDTO {

	public String getParameter() {
		return parameterValue;
	}

	public void setParameter(String parameter) {
		this.parameterValue = parameter;
	}

	public String getImpressions() {
		return impressions;
	}

	public void setImpressions(String impressions) {
		this.impressions = impressions;
	}

	public String getClicks() {
		return clicks;
	}

	public void setClicks(String clicks) {
		this.clicks = clicks;
	}

	public String getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}

	private String parameterValue;
	private String impressions;
	private String clicks;
	private String campaignId;
	private String analyseddate;

	public String getAnalyseddate() {
		return analyseddate;
	}

	public void setAnalyseddate(String analyseddate) {
		this.analyseddate = analyseddate;
	}
}
