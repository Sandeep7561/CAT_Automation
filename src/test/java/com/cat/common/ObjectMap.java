package com.cat.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class ObjectMap {
	protected static final Logger logger = LogManager.getLogger(GenericTemplateMethods.class.getName());
	//private static final String logProperttFilePath = System.getProperty("user.dir")+"\\resource\\objects\\log4j.properties";
	
	protected WebDriver driver;
  
  //property file and provide the locator information to the test.
  
  Properties properties;
  
  public ObjectMap(String mapFile)
  {
      properties = new Properties();
      try {
      FileInputStream Master = new FileInputStream(mapFile);
      properties.load(Master);
      Master.close();
          }catch (IOException e) {
            logger.info(e.getMessage());
         }
      }
	
  public By getLocator(String ElementName) throws Exception {
      //Read value using the logical name as Key
      String locator = properties.getProperty(ElementName);
      //Split the value which contains locator type and locator value
      String locatorType = locator.split(":")[0];
      String locatorValue = locator.split(":")[1];
      //System.out.println("Retrieving object of type '" + locatorType + "' and value '" + locatorValue + "' from the object map");
      //Return a instance of By class based on type of locator
        if(locatorType.toLowerCase().equals("id"))
              return By.id(locatorValue);
        else if(locatorType.toLowerCase().equals("name"))
              return By.name(locatorValue);
        else if((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class")))
              return By.className(locatorValue);
        else if((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag")))
              return By.tagName(locatorValue);
        else if((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link")))
              return By.linkText(locatorValue);
        else if(locatorType.toLowerCase().equals("partiallinktext"))
              return By.partialLinkText(locatorValue);
        else if((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css")))
              return By.cssSelector(locatorValue);
        else if(locatorType.toLowerCase().equals("xpath"))
              return By.xpath(locatorValue);
        else
                logger.info("Locator type '" + locatorType + "' not defined!!");
		return null;
      }
}
