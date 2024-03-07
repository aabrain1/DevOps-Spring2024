package edu.westga.comp4420.notesapplication.view.codebehind;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

import java.io.IOException;

import edu.westga.comp4420.notesapplication.Main;


/**
 * CodeBehind To Handle Processing for the NotesWindow
 *
 * @author	Comp 4420
 * @version Spring 2024
 */
public class NotesWindow {
	
    @FXML
    private Button homeBtn;
	
	 @FXML
    private TextArea noteTxtArea;
	
	@FXML
    public void initialize() {
        assert this.homeBtn != null : "fx:id=\"homeBtn\" was not injected: check your FXML file 'NotesWindow.fxml'.";
		this.openHomePage();

    }
	
	private void openHomePage() {
		this.homeBtn.setOnAction(
			(event) -> {
				try {
					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(Main.class.getResource(Main.GUI_RESOURCE));
					loader.load();
					Parent parent = loader.getRoot();
					Scene scene = new Scene(parent);
					Stage notesStage = new Stage();
					notesStage.setTitle(Main.WINDOW_TITLE);
					notesStage.setScene(scene);
					notesStage.initModality(Modality.APPLICATION_MODAL);
					notesStage.showAndWait();
				} catch (IOException e) {
					Alert alertWindow = new Alert(Alert.AlertType.ERROR);
					alertWindow.setContentText("Unable to launch the Notes Window");
					alertWindow.showAndWait();
				}
			}
		);
	}
}

