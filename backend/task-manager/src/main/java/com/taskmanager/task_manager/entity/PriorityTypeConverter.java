package com.taskmanager.task_manager.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class PriorityTypeConverter implements AttributeConverter<PriorityType, String> {

    @Override
    public String convertToDatabaseColumn(PriorityType priorityType) {
        if (priorityType == null) {
            return null;
        }

        return switch (priorityType) {
            case LOW -> "Low";
            case MEDIUM -> "Medium";
            case HIGH -> "High";
        };
    }

    @Override
    public PriorityType convertToEntityAttribute(String priority) {
        if (priority == null) {
            return null;
        }

        return switch (priority) {
            case "Low" -> PriorityType.LOW;
            case "Medium" -> PriorityType.MEDIUM;
            case "High" -> PriorityType.HIGH;
            default -> throw new IllegalArgumentException("Unknown priority: " + priority);
        };
    }
}