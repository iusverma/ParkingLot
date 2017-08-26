package com.gojek.parking.commands;

import com.gojek.parking.enums.Command;

public abstract class CommandType {
    protected Command currentCommand;
    protected String parameter;
    public abstract String execute();
    public String getParameter() {
        return parameter;
    }
    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
}