package Study.Property;

public class TestProperty {
	
	@CustomAnnotation(UserAge=40)
	private int age;
	
	@CustomAnnotation(UserName="杨海英")
	private String name;
	
	public TestProperty() {
		this.age = 10;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public int getAge(){
		return this.age;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
}
