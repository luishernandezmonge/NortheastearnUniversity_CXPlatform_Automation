package northeasternuniversity.cxplatform.utilities;

import java.net.HttpURLConnection;
import java.net.URL;

public class PageChecker {

	public PageChecker() {
	}

	public int getHttpResponse(String urlToCheckString) {

		HttpURLConnection connection;
		int responseCode;
		
		try {
			URL urltoCheck = new URL (urlToCheckString);
			connection = (HttpURLConnection) urltoCheck.openConnection();
			connection.connect();
			responseCode = connection.getResponseCode();
			connection.disconnect();

		} catch (Exception exception) {
			responseCode = 000;
		}
		return responseCode;
	}
	
	public Boolean isSuccessResponse(String urlToCheck){
		Boolean isASuccessfullResponse = false;
		int responseCode = this.getHttpResponse(urlToCheck);
		if (responseCode >= 200 || responseCode < 400)
			isASuccessfullResponse = true;
	
		return isASuccessfullResponse;
	}
	
//	public void printHttpResponse (String urlToCheck){
//		System.out.println(getHttpResponse(urlToCheck));
//	}

}
