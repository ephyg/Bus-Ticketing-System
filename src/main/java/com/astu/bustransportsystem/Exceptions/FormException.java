package com.astu.bustransportsystem.Exceptions;

public class FormException extends Exception {
    public String formElement;
    public String errorMessage;

    public FormException( String formElement, String errorMessage) {
        super(errorMessage);
        this.formElement = formElement;
        this.errorMessage = errorMessage;
    }

}
