package priv.lst.util;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteStreamHandler;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Created by xavier on 2018/5/2.
 */
public class CommandLineUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommandLineUtils.class);

    private static final DefaultExecutor EXECUTOR;

    static {
        EXECUTOR = new DefaultExecutor();
        //设置自己定义的streamHandler
        ExecuteStreamHandler streamHandler = new MyExecuteStreamHandler();
        EXECUTOR.setStreamHandler(streamHandler);
    }

    private CommandLineUtils() {
    }

    public static int doBlock(String command) throws IOException {
        File currentDir = new File("");
        EXECUTOR.setWorkingDirectory(currentDir.getAbsoluteFile());

        CommandLine commandLine = CommandLine.parse(command);
        return EXECUTOR.execute(commandLine);
    }

    public static void doBlock(String command, File executePath) throws IOException {
        EXECUTOR.setWorkingDirectory(executePath.getAbsoluteFile());

        CommandLine commandLine = CommandLine.parse(command);
        try {
            EXECUTOR.execute(commandLine);
        } catch (Exception e) {
            String msg = String.format("msg: %s, error msg: %s", ((MyExecuteStreamHandler) EXECUTOR.getStreamHandler()).getMsg(), ((MyExecuteStreamHandler) EXECUTOR.getStreamHandler()).getErrorMsg());
            LOGGER.error("execute command failed, command:{}, path: {}, error msg:{}", command, executePath, msg);
            throw new IOException("execute command failed");
        }
    }

    public static DefaultExecuteResultHandler doUnBlock(String command) throws IOException {
        File currentDir = new File("");
        EXECUTOR.setWorkingDirectory(currentDir.getAbsoluteFile());

        CommandLine commandLine = CommandLine.parse(command);
        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
        EXECUTOR.execute(commandLine, resultHandler);
        return resultHandler;
    }

    public static DefaultExecuteResultHandler doUnBlock(String command, File executePath) throws IOException {
        EXECUTOR.setWorkingDirectory(executePath.getAbsoluteFile());

        CommandLine commandLine = CommandLine.parse(command);
        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
        EXECUTOR.execute(commandLine, resultHandler);
        return resultHandler;
    }

    public static class MyExecuteStreamHandler implements ExecuteStreamHandler {
        private String msg = "";
        private String errorMsg = "";

        @Override
        public void setProcessInputStream(OutputStream os) throws IOException {

        }

        @Override
        public void setProcessErrorStream(InputStream is) throws IOException {
            String encoding = "UTF-8";
            try {
                byte[] filecontent = IOUtils.toByteArray(is);
                is.close();
                this.errorMsg = new String(filecontent, encoding);
            } catch (UnsupportedEncodingException e) {
                System.err.println("The OS does not support " + encoding);
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void setProcessOutputStream(InputStream is) throws IOException {
            String encoding = "UTF-8";
            try {
                byte[] filecontent = IOUtils.toByteArray(is);
                is.close();
                this.msg = new String(filecontent, encoding);
            } catch (UnsupportedEncodingException e) {
                System.err.println("The OS does not support " + encoding);
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void start() throws IOException {

        }

        @Override
        public void stop() throws IOException {

        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }


        public String getErrorMsg() {
            return errorMsg;
        }

        public void setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
        }
    }
}
