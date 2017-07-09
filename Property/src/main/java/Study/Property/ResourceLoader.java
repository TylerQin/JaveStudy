package Study.Property;

import java.io.File;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ResourceLoader {

	private static Map<String, String> propertiesMap = new HashMap<String, String>();
	
	public static void getProperties(String fileName){		
		try
		{
			FileInputStream inputStream = new FileInputStream(new File(fileName));
			Properties properties = new Properties();
			properties.load(inputStream);
			Enumeration<?> keys = properties.keys();
			
			while (keys.hasMoreElements()) {
				String key = (String) keys.nextElement();
				propertiesMap.put(key, properties.getProperty(key));
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("finally");
		}
	}
	
	public static String getValue(String key) {
		
		if(propertiesMap.containsKey(key)){
			return propertiesMap.get(key);
		}
		
		return "";
	}
}
