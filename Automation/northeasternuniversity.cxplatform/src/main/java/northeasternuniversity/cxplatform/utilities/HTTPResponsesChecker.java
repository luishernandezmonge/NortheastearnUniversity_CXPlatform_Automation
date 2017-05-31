/**
 * 
 */
package northeasternuniversity.cxplatform.utilities;

/**
 * @author luishernandez
 *
 */
public class HTTPResponsesChecker {

	private int HTTPResponseStatus;

	public HTTPResponsesChecker() {

	}

//	public int checkHTTPResponseForURL(String urlToCheck, WebDriverManager driverManager) {
//		int statusCode;
//		
//		Response response = driverManager.getDriver().get(urlToCheck);
//	    statusCode = Integer.parseInt(response.getStatus().toString());
//		
//		return statusCode;
//	}
//	
	public Boolean isOKStatus(int statusCode){
		if (statusCode>=200 && statusCode<300)
			return true;
		else return false;
	}

	public int getHTTPResponseStatus(String urlToCheck) {
		return HTTPResponseStatus;
	}

	public void setHTTPResponseStatus(int hTTPResponseStatus) {
		HTTPResponseStatus = hTTPResponseStatus;
	}

}
