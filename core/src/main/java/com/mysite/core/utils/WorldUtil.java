package com.mysite.core.utils;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

import org.apache.commons.lang3.StringUtils;

public class WorldUtil {

    private WorldUtil() {};

    /**
     * Get the current world which the user is in
     * @param path - the current page's path
     * @return the world using the page's title
     */
    public static String getCurrentWorld(String currentPath, PageManager pageManager) {
        String currentWorld = StringUtils.EMPTY;
        if(StringUtils.isBlank(currentPath)) {
            return currentWorld;
        }
        Page currentPage = pageManager.getPage(currentPath);

        //TODO INT-404: return a title from the page
        
        return currentWorld;
        
    }

    /**
     * Translates the message into the desired language
     * @param the message to be translated
     * @param the language to translate to
     * @return the translated message
     */
    public static String getTranslatedMessage(String message, String language) {
        return message + " ("+language+") ";
    }
}