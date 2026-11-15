package com.taskmanager.task_manager.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class StatusTypeConverter implements AttributeConverter<StatusType, String> {

    @Override
    public String convertToDatabaseColumn(StatusType statusType) {
        if (statusType == null) {
            return null;
        }

        return switch (statusType) {
            case PENDING -> "Pending";
            case IN_PROGRESS -> "In Progress";
            case COMPLETED -> "Completed";
        };
    }

    @Override
    public StatusType convertToEntityAttribute(String status) {
        if (status == null) {
            return null;
        }

        return switch (status) {
            case "Pending" -> StatusType.PENDING;
            case "In Progress" -> StatusType.IN_PROGRESS;
            case "Completed" -> StatusType.COMPLETED;
            default -> throw new IllegalArgumentException("Unknown status: " + status);
        };
    }
}