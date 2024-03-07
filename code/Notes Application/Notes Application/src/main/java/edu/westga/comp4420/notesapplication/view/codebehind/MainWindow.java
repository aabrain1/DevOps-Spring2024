package edu.westga.comp4420.notesapplication.view.codebehind;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

import edu.westga.comp4420.notesapplication.Main;

/**
 * CodeBehind To Handle Processing for the MainWindow
 *
 * @author	Comp 4420
 * @version Spring 2024
 */
public class MainWindow {
	
	@FXML
    private Button addNoteBtn;

    @FXML
    private Button notesBtn;
	
	@FXML
    private ListView<String> notesDisplay;
	
	private ObservableList<String> notes = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        assert this.notesBtn != null : "fx:id=\"notesBtn\" was not injected: check your FXML file 'MainWindow.fxml'.";
		
		this.openNotesPage();
		
		this.notesDisplay.setItems(this.notes);
		this.notesDisplay.setOnMouseClicked(event -> this.handleNoteClicked(event));
		
    }
	private void openNotesPage() {
		this.notesBtn.setOnAction(
			(event) -> {
				try {
					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(Main.class.getResource(Main.NOTES_DIALOG));
					loader.load();
					Parent parent = loader.getRoot();
					Scene scene = new Scene(parent);
					Stage homeStage = new Stage();
					homeStage.setTitle(Main.NOTES_TITLE);
					homeStage.setScene(scene);
					homeStage.initModality(Modality.APPLICATION_MODAL);
					homeStage.showAndWait();
				} catch (IOException e) {
					Alert alertWindow = new Alert(Alert.AlertType.ERROR);
					alertWindow.setContentText("Unable to launch the Notes Window");
					alertWindow.showAndWait();
				}
			}
		);
	}
	
	@FXML
    void addNewNote(MouseEvent event) {
		this.notes.add("");
		this.notesDisplay.getSelectionModel().select(this.notes.size() - 1);
    }
	
	 private void handleNoteClicked(MouseEvent event) {
       int selectedIndex = this.notesDisplay.getSelectionModel().getSelectedIndex();
       if (selectedIndex >= 0 && selectedIndex != this.notesDisplay.getSelectionModel().getSelectedIndex()) {
           this.notesDisplay.getSelectionModel().select(selectedIndex);
		   this.openNotesPage();
        }
    }
}
