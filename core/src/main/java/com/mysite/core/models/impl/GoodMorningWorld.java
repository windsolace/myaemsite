/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.mysite.core.models.impl;

import static org.apache.sling.api.resource.ResourceResolver.PROPERTY_RESOURCE_TYPE;

import javax.annotation.PostConstruct;

import com.day.cq.wcm.api.PageManager;
import com.mysite.core.models.Greetings;
import com.mysite.core.services.HttpService;
import com.mysite.core.utils.WorldUtil;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.settings.SlingSettingsService;

@Model(adaptables = Resource.class)
public class GoodMorningWorld implements Greetings{

    @ValueMapValue(name=PROPERTY_RESOURCE_TYPE, injectionStrategy=InjectionStrategy.OPTIONAL)
    @Default(values="No resourceType")
    protected String resourceType;

    @OSGiService
    private SlingSettingsService settings;
    @SlingObject
    private Resource currentResource;
    @SlingObject
    private ResourceResolver resourceResolver;

    private String message;

    @PostConstruct
    protected void init() {
        PageManager pageManager = resourceResolver.adaptTo(PageManager.class);

        String currentWorld = WorldUtil.getCurrentWorld(pageManager.getContainingPage(currentResource).getPath(), pageManager);

        // Say Good Morning to the current world in the correct language
        message = "Good Morning "+ currentWorld+"!";

        //call GETWORLDS()

    }

    public String getMessage() {
        return message;
    }

    /**
     * TODO INT-500 - get worlds from API
     */
    // public CLAZZ GETWORLDS() {
    //     HttpService http = new HttpService();
    //     http.callApi(endpoint, CLAZZ);
    // }

    @Override
    public String getLanguage() {
        return currentResource.getValueMap().get("language", String.class);
    }

}
