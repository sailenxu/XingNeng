package com.test.log;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.Writer;
import org.apache.log4j.Logger;
import org.apache.log4j.Appender;
import org.apache.log4j.WriterAppender;

public class LogAppender extends Thread {
    protected PipedReader reader;

    public LogAppender(String appenderName) throws IOException {

        Logger root = Logger.getRootLogger();
        // ��ȡ�Ӽ�¼�������Դ
        Appender appender = root.getAppender(appenderName);
        // ����һ��δ���ӵ��������ܵ�
        reader = new PipedReader();
        // ����һ�������ӵ�����������������ӵ�reader
        Writer writer = new PipedWriter(reader);
        // ���� appender �����
        ((WriterAppender) appender).setWriter(writer);
    }
}