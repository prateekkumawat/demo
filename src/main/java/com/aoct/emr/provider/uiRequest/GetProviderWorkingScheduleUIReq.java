package com.aoct.emr.provider.uiRequest;

import lombok.Data;

@Data
public class GetProviderWorkingScheduleUIReq {
	
	private long providerId;
	private int month;
	private int year;
	

}
