package com.mysite.core.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

import org.junit.jupiter.api.Test;

public class WorldUtilTest {

    /**
     * Expect: getCurrentWorld should not return null
     */
    @Test
    public void getCurrentWorldNullTest() {
        PageManager pageManager = mock(PageManager.class);
        Page mockPage = mock(Page.class);
        when(pageManager.getPage(anyString())).thenReturn(mockPage);
        when(mockPage.getTitle()).thenReturn("title");
        when(mockPage.getPageTitle()).thenReturn("pagetitle");
        when(mockPage.getNavigationTitle()).thenReturn("navtitle");
        //TODO INT-404: test that output is not null

    }

    //TODO - write a test to check that the output of getCurrentWorld returns the intended title
    
}