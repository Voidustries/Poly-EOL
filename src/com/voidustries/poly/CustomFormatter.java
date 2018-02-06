package com.voidustries.poly;

/*
Class Created by Stone Monarch on 1/30/2018

Creator Comments:

        Formatter to keep a logfile in a easy to read format for quick DEBUGGING.

        Formatted as "dd/MM/yyyy hh:mm:ss:SSS - [*Level*} - [*SourceClassName.SourceMethodName*] - *Message*"
*/

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class CustomFormatter extends java.util.logging.Formatter {

    // Create a DateFormat to format the logger timestamp.
    private static final DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");

    @Override
    public String format(LogRecord record) {
        StringBuilder builder = new StringBuilder(1000);
        builder.append(df.format(new Date(record.getMillis()))).append(" - ");
        builder.append("[").append(record.getLevel()).append("] - ");
        builder.append("[").append(record.getSourceClassName()).append(".");
        builder.append(record.getSourceMethodName()).append("] - ");
        builder.append(formatMessage(record));
        builder.append("\n");
        return builder.toString();
    }

}
