package Study.Property;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try
    	{
    		desrilizable();
	    	testRefactor();
	    	getProperty();
    	}
    	catch(Exception exception)
    	{
    		System.out.println("出现异常");
    	}
    	finally {
			System.out.println("finally");
		}
    }

	private static void getProperty() {
		String filePath = App.class.getResource("/").getPath()+"Study/Property/TestProperties.properties";
		ResourceLoader.getProperties(filePath.substring(1).replace("/", "\\"));
		String value = ResourceLoader.getValue("AppID");
		System.out.println(value);
	}

	private static void testRefactor() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> testPorperty = Class.forName("Study.Property.TestProperty");
		TestProperty instance = (TestProperty)testPorperty.newInstance();
		Field[] fields = testPorperty.getDeclaredFields();
		for (Field field : fields) {
			
			if(field.isAnnotationPresent(CustomAnnotation.class));
			CustomAnnotation customAnnotation = field.getAnnotation(CustomAnnotation.class);
			
			if(field.getName() == "age"){
				field.setAccessible(true);
				field.set(instance, 50);
				System.out.println(instance.getAge());
			}
			
			if(customAnnotation!=null)
			{
				System.out.println(customAnnotation.UserName());
			}
			
		    Annotation[] fieldAnnotaions = field.getAnnotations();
		    for (Annotation annotation : fieldAnnotaions) {
				System.out.println(annotation);
			}
		}
	}
	
	private static void desrilizable(){
		try{
			String propertyJson = "{\"age\":10,\"name\":\"hehe\"}";
			Class<?> testPorperty = Class.forName("Study.Property.TestProperty");
			TestProperty object= (TestProperty)new ObjectMapper().readValue(propertyJson,  TypeFactory.rawClass(testPorperty));
			System.out.println(String.format("UserName:%s,Age:%s" , object.getAge(), object.getName()));
		}
		catch(Exception exception){
			System.out.println("exception");
		}
		finally {
			System.out.println("finally");
		}		
	}
}
