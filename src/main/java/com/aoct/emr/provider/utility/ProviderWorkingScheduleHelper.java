package com.aoct.emr.provider.utility;

import java.util.ArrayList;
import java.util.List;

import com.aoct.emr.provider.entity.ProviderWorkingScheduleEntity;
import com.aoct.emr.provider.uiRequest.ProviderWorkingScheduleRequest;

public class ProviderWorkingScheduleHelper {

    public static ProviderWorkingScheduleEntity convertFromWorkingScheduleRequest(ProviderWorkingScheduleRequest scheduleRequest) {
        ProviderWorkingScheduleEntity scheduleEntity = new ProviderWorkingScheduleEntity();
        scheduleEntity.setTitle(scheduleRequest.getTitle());
        scheduleEntity.setFacility(scheduleRequest.getFacility());
        scheduleEntity.setWorkingDays(scheduleRequest.getWorkingDays());
        scheduleEntity.setStartTime(scheduleRequest.getStartTime());
        scheduleEntity.setEndTime(scheduleRequest.getEndTime());
        scheduleEntity.setLunchStartTime(scheduleRequest.getLunchStartTime());
        scheduleEntity.setLunchEndTime(scheduleRequest.getLunchEndTime());
        scheduleEntity.setApprovalFlag(scheduleRequest.isApprovalFlag());
        scheduleEntity.setReasonForLeave(scheduleRequest.getReasonForLeave());
        scheduleEntity.setScheduleType(scheduleRequest.getScheduleType());

        return scheduleEntity;
    }

    public static ProviderWorkingScheduleRequest convertToWorkingScheduleRequest(ProviderWorkingScheduleEntity scheduleEntity) {
        ProviderWorkingScheduleRequest scheduleRequest = new ProviderWorkingScheduleRequest();
        scheduleRequest.setTitle(scheduleEntity.getTitle());
        scheduleRequest.setFacility(scheduleEntity.getFacility());
        scheduleRequest.setWorkingDays(scheduleEntity.getWorkingDays());
        scheduleRequest.setStartTime(scheduleEntity.getStartTime());
        scheduleRequest.setEndTime(scheduleEntity.getEndTime());
        scheduleRequest.setLunchStartTime(scheduleEntity.getLunchStartTime());
        scheduleRequest.setLunchEndTime(scheduleEntity.getLunchEndTime());
        scheduleRequest.setApprovalFlag(scheduleEntity.isApprovalFlag());
        scheduleRequest.setReasonForLeave(scheduleEntity.getReasonForLeave());
        scheduleRequest.setScheduleType(scheduleEntity.getScheduleType());
        scheduleRequest.setProviderId(scheduleEntity.getProvider().getProviderId());

        return scheduleRequest;
    }

    public static List<ProviderWorkingScheduleRequest> convertToWorkingScheduleRequests(List<ProviderWorkingScheduleEntity> scheduleEntities) {
        List<ProviderWorkingScheduleRequest> scheduleRequests = new ArrayList<>();
        for (ProviderWorkingScheduleEntity scheduleEntity : scheduleEntities) {
            scheduleRequests.add(convertToWorkingScheduleRequest(scheduleEntity));
        }
        return scheduleRequests;
    }
}

