package com.company.analyzeprime.controller.errorhandle.dto;

/**
 * Object returned in case of an error in the controllers
 */
public final class SimpleFieldErrorDTO {
	
	private final String fieldName;
    private final String message;

    public SimpleFieldErrorDTO(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getFieldName() {
        return fieldName;
    }
}
