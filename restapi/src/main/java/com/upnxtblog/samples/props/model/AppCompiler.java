package com.upnxtblog.samples.props.model;

public class AppCompiler {
	private String timeout;
	private String outputFolder;
	
	public AppCompiler() {}

	public String getTimeout() {
		return timeout;
	}

	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}

	public String getOutputFolder() {
		return outputFolder;
	}

	public void setOutputFolder(String outputFolder) {
		this.outputFolder = outputFolder;
	}

	@Override
	public String toString() {
		return "Compiler{" + "timeout='" + timeout + '\'' + ", outputFolder='" + outputFolder + '\'' + '}';
	}

}
