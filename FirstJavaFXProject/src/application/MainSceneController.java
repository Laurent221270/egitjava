package application;

import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainSceneController {
	@FXML
	private TextArea tfTitle;
	@FXML
	private AnchorPane anchrPaneOptions1_3;
	@FXML
	private CheckBox chkOption1;
	@FXML
	private CheckBox chkOption2;
	@FXML
	private CheckBox chkOption3;
	@FXML
	private ChoiceBox<String> choiceBox1;
	@FXML
	private Pane paneInfo;
	@FXML
	private Label labelInfo;
	@FXML
	private Label labelOptionCochee;

	
	public MainSceneController() {
		super();
	}
	
	
	
	// Event Listener on Button.onAction
	@FXML
	public void btnOkClicked(ActionEvent event) {
		Stage mainWindow= (Stage)tfTitle.getScene().getWindow();
		String title= tfTitle.getText();
		mainWindow.setTitle(title);
	}
	
	
	// Event Listener on CheckBox[#chkOption1].onMouseClicked
	@FXML
	public void cbOptionClicked(MouseEvent event) {
		
		Object obj= event.getSource();
		//System.out.println("object="+obj.toString());
		if(obj instanceof CheckBox){
			labelOptionCochee.setText("");
			CheckBox chkb= (CheckBox)obj;
			if(chkb.isSelected()) {
				labelOptionCochee.setText("option [" + chkb.getText() + "] sélectionnée");
			}
		}
				
		
		String optionsCochees="";
		ObservableList<Node> obvList= anchrPaneOptions1_3.getChildren();
		for(Node node : obvList) {
			if(node instanceof CheckBox) {
				CheckBox chkb= (CheckBox)node;
				if(chkb.isSelected()) {
					optionsCochees+= chkb.getText()+"\n";
				}
			}
		}
		labelInfo.setText("\noptions sélectionnées :\n"+ optionsCochees);
	}	
	
	
}
