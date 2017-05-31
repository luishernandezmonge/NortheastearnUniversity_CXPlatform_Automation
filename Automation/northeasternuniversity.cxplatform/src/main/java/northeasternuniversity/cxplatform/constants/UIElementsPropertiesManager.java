package northeasternuniversity.cxplatform.constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UIElementsPropertiesManager {
	Properties sharedUIElementsLocators;

	public UIElementsPropertiesManager(String filePath) {
		sharedUIElementsLocators = new Properties();
		try {
			sharedUIElementsLocators.load(new FileInputStream(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Properties getSharedUIElementsLocators() {
		return sharedUIElementsLocators;
	}

	public void setSharedUIElementsLocators(Properties sharedUIElementsLocators) {
		this.sharedUIElementsLocators = sharedUIElementsLocators;
	}
	
	public Properties getSharedDataOfExecutionLocators() {
		return sharedUIElementsLocators;
	}

}


