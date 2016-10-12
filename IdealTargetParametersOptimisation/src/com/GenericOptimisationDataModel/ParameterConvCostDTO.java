package com.GenericOptimisationDataModel;

public class ParameterConvCostDTO {

	private String parameter;
	public String getParameter() {
		return parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	public String getSpent() {
		return spent;
	}
	public void setSpent(String spent) {
		this.spent = spent;
	}
	public String getConversions() {
		return conversions;
	}
	public void setConversions(String conversion) {
		this.conversions = conversion;
	}
	public String getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}
	private String spent;
    private String conversions;
    private String campaignId;
 

    private String analyseddate;
	
	
	public String getAnalyseddate() {
		return analyseddate;
	}
	public void setAnalyseddate(String analyseddate) {
		this.analyseddate = analyseddate;
	}
}
