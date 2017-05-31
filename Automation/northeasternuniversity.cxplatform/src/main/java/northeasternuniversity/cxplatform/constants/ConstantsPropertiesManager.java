package northeasternuniversity.cxplatform.constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ConstantsPropertiesManager {
	private String baseUrl;
	private String webBrowser;
	private Properties sharedExecutionConstants;

	public ConstantsPropertiesManager(String filePath) {

		this.sharedExecutionConstants = new Properties();
		
		try {
			
			sharedExecutionConstants.load(new FileInputStream(filePath));
			
			this.baseUrl = sharedExecutionConstants.getProperty("northeastern.edu_baseUrl");
			this.webBrowser = sharedExecutionConstants.getProperty("webBrowser");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getWebBrowser() {
		return webBrowser;
	}

	public void setWebBrowser(String webBrowser) {
		this.webBrowser = webBrowser;
	}

	public Properties getSharedExecutionConstants() {
		return sharedExecutionConstants;
	}

	public void setSharedExecutionConstants(Properties sharedExecutionConstants) {
		this.sharedExecutionConstants = sharedExecutionConstants;
	}
}
