package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StartUiController {

	@FXML
	private Button StartGameButton;

	@FXML
	void ClickStartGameButton(ActionEvent event) {

		try {
			StartGameButton.getScene().getWindow().hide();
			Parent root = FXMLLoader.load(getClass().getResource("TheGame.fxml"));

			Stage stage = new Stage();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
