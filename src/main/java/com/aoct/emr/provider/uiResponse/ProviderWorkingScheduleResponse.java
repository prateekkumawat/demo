package com.aoct.emr.provider.uiResponse;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ProviderWorkingScheduleResponse {
    private LocalDate workingDay;
    private String startTime;
    private String endTime;
    private String lunchStartTime;
    private String lunchEndTime;
    private boolean approvalFlag;
    private String reasonForLeave;
    private String scheduleType;
}

