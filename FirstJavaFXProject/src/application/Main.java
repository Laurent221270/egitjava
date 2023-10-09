package application;
	

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;


public class Main extends Application {
	
	
	
	
	public Main() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			
			//remplissage de la choiceBox
			ObservableList<Node> obvList = root.getChildrenUnmodifiable();
			for(Node node : obvList) {
				if(node instanceof ChoiceBox) {
					if(node.getId().equals("choiceBox1")){
						System.out.println("choiceBox1");
						// string array
				        String st[] = { "Arnab", "Andrew", "Ankit", "None" };
				        ChoiceBox<String> chBx= (ChoiceBox<String>)node;
				        chBx.setItems(FXCollections.observableArrayList(st));
				        break;
					}
				}
			}
			
			
			primaryStage.setTitle("Hello World!");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void init(){
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
