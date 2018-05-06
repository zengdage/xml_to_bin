package view;

public class App {
	
	static App app = new App();
	public static String app_name;
	
	private App() {
		
	}
	
	public static App getInstace() {
		if(app==null) {
			app = new App();
		}
		return app;
	}
	
	
}
