package ui;

public class OrderingSystemRunner {

	public static void main(String[] args) {
		if(args.length >= 1) {
			if(args[0].equals("sample")) {
				System.out.println(args[0]);
				SampleMenu.loadSampleData();
			}
		}
		new UIController();

	}

}
