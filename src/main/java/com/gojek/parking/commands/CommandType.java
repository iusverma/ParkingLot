package com.gojek.parking.commands;

import com.gojek.parking.enums.Command;
/**
 * CommandType class for providing basic structure for all commands
 */
public abstract class CommandType {
    /* current command of execution */
    protected Command currentCommand;

    /* parameter for each command */
    protected String parameter;

    /* abstract execute method for each command,
     * each command will need to override it and
     * provide a default implementation
     */
    public abstract String execute();

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
}