package com.mysite.core.services;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpService {

    Logger log = LoggerFactory.getLogger(HttpService.class);

    public String allWorlds="{\"status\":\"success\",\"message\":\"\",\"response\":[{\"name\":\"Earth\",\"species\":\"Terran\",\"population\":123456},{\"name\":\"Shakuras\",\"species\":\"Protoss\",\"population\":10000},{\"name\":\"Tarsonis\",\"species\":\"Zerg\",\"population\":0}]}";
    public String newWorlds="{\"status\":\"success\",\"message\":\"\",\"response\":[{\"name\":\"Aiur\",\"species\":\"Protoss\",\"population\":123456},{\"name\":\"Shakuras\",\"species\":\"Protoss\",\"population\":10000},{\"name\":\"Tarsonis\",\"species\":\"Zerg\",\"population\":0}]}";


    /**
     * Makes a HTTP call to an API
     * @param endpoint to be used
     * @param responseClass the class to format response to
     * @return response as the class defined in responseClass
     */
    public <T> T callApi(String endpoint, Class<T> responseClass) { //NOSONAR - mock method

        String jsonResponse = StringUtils.EMPTY;
        if("/worlds/new".equals(endpoint)) {
            jsonResponse = newWorlds;
        } else if("/worlds/all".equals(endpoint)) {
            jsonResponse = allWorlds;
        }
        return parseResponse(jsonResponse, responseClass);
    }

    /**
	 * Parse response into defined ResponseBean class. Returns null if failed to parse.
	 * @param response in json format
	 * @param type - the class to format the json response to
	 * @return response using the input class
	 */
	private <T> T parseResponse(String responseStr, Class<T> type) {
        //TODO
		return null;
	}
}