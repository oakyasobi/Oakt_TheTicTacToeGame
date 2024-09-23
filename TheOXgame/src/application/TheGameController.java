package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;

public class TheGameController implements Initializable {

	@FXML
	private Button OneOne;

	@FXML
	private Button OneTwo;

	@FXML
	private Button OneZero;

	@FXML
	private Button RestartButton;

	@FXML
	private Text TheText;

	@FXML
	private Button TwoOne;

	@FXML
	private Button TwoTwo;

	@FXML
	private Button TwoZero;

	@FXML
	private Button ZeroOne;

	@FXML
	private Button ZeroTwo;

	@FXML
	private Button setClear;

	@FXML
	private Button ZeroZero;

	@FXML
	void ClickOneOne(ActionEvent event) {
	//	theTurnCondition(OneOne);
		TheData.theGame[1][1] = setDataToGameArray();
		theTurnCondition(OneOne);
		System.out.println(TheData.theGame[1][1]);
		isXIsTheWinner();
		isOIsTheWinner();
	}

	@FXML
	void ClickOneTwo(ActionEvent event) {
	//	theTurnCondition(OneTwo);
		TheData.theGame[2][1] = setDataToGameArray();
		theTurnCondition(OneTwo);
		System.out.println(TheData.theGame[2][1]);
		isXIsTheWinner();
		isOIsTheWinner();
	}

	@FXML
	void ClickOneZero(ActionEvent event) {
	//	theTurnCondition(OneZero);
		TheData.theGame[0][1] = setDataToGameArray();
		theTurnCondition(OneZero);
		System.out.println(TheData.theGame[0][1]);
		isXIsTheWinner();
		isOIsTheWinner();
	}

	@FXML
	void ClickRestartButton(ActionEvent event) {

		setClear(ZeroZero);
		setClear(ZeroOne);
		setClear(ZeroTwo);
		setClear(OneZero);
		setClear(OneOne);
		setClear(OneTwo);
		setClear(TwoZero);
		setClear(TwoOne);
		setClear(TwoTwo);
		TheText.setText("Start The Game !");
		for (int i = 0; i < TheData.theGame.length; i++) {
			for (int j = 0; j < TheData.theGame.length; j++) {
				TheData.theGame[i][j] = 0;
			}
		}
		TheData.turn=true;
	}

	@FXML
	void ClickTwoOne(ActionEvent event) {
	//	theTurnCondition(TwoOne);
		TheData.theGame[1][2] = setDataToGameArray();
		theTurnCondition(TwoOne);
		System.out.println(TheData.theGame[1][2]);
		isXIsTheWinner();
		isOIsTheWinner();
	}

	@FXML
	void ClickTwoTwo(ActionEvent event) {
	//	theTurnCondition(TwoTwo);
		TheData.theGame[2][2] = setDataToGameArray();
		theTurnCondition(TwoTwo);
		System.out.println(TheData.theGame[2][2]);
		isXIsTheWinner();
		isOIsTheWinner();
	}

	@FXML
	void ClickTwoZero(ActionEvent event) {
	//	theTurnCondition(TwoZero);
		TheData.theGame[0][2] = setDataToGameArray();
		theTurnCondition(TwoZero);
		System.out.println(TheData.theGame[0][2]);
		isXIsTheWinner();
		isOIsTheWinner();
	}

	@FXML
	void ClickZeroOne(ActionEvent event) {
	//	theTurnCondition(ZeroOne);
		TheData.theGame[1][0] = setDataToGameArray();
		theTurnCondition(ZeroOne);
		System.out.println(TheData.theGame[1][0]);
		isXIsTheWinner();
		isOIsTheWinner();
	}

	@FXML
	void ClickZeroTwo(ActionEvent event) {
	//	theTurnCondition(ZeroTwo);
		TheData.theGame[2][0] = setDataToGameArray();
		theTurnCondition(ZeroTwo);
		System.out.println(TheData.theGame[2][0]);
		isXIsTheWinner();
		isOIsTheWinner();
	}

	@FXML
	void ClickZeroZero(ActionEvent event) {
	//	theTurnCondition(ZeroZero);
		TheData.theGame[0][0] = setDataToGameArray();
		theTurnCondition(ZeroZero);
		System.out.println(TheData.theGame[0][0]);
		isXIsTheWinner();
		isOIsTheWinner();
	}

	public void theTurnCondition(Button x) {
		if (TheData.turn == true) {
			x.setDisable(true);
			x.setText("O");
			x.setStyle(
					"-fx-background-color: #f03e79; -fx-font-size: 67px; -fx-border-color: #d8bee6; -fx-border-width: 1px; -fx-opacity: 1.0;");
			TheData.turn = false;
			TheText.setText("The Player X turn");
		} else {
			x.setDisable(true);
			x.setText("X");
			x.setStyle(
					"-fx-background-color: #a5f0b2; -fx-font-size: 67px; -fx-border-color: #d8bee6; -fx-border-width: 1px; -fx-opacity: 1.0;");
			TheData.turn = true;
			TheText.setText("The Player O turn");
		}
	}

	public void setClear(Button y) { 
		y.setStyle(null);
		y.setText("");
		y.setDisable(false);
		y.setStyle("-fx-border-color: #bfabeb;");
	}

	public void Disable(Button z) {
		z.setDisable(true);
		z.setStyle("-fx-border-color: #bfabeb;");
		z.setStyle(
				"-fx-font-size: 67px; -fx-border-width: 1px; ");
		
	}

	public int setDataToGameArray() {
		System.out.println(TheData.turn);
		if (TheData.turn == true) {
			return 1;
		}
		return 2;
	}

	public void isOIsTheWinner() {
		for (int i = 0; i < TheData.theGame.length; i++) {
			if (TheData.theGame[i][0] == 1 && TheData.theGame[i][1] == 1 && TheData.theGame[i][2] == 1
					|| TheData.theGame[0][i] == 1 && TheData.theGame[1][i] == 1 && TheData.theGame[2][i] == 1) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Game Over");
				alert.setContentText("The Winner Is Player O!");
				Disable(ZeroZero);
				Disable(ZeroOne);
				Disable(ZeroTwo);
				Disable(OneZero);
				Disable(OneOne);
				Disable(OneTwo);
				Disable(TwoZero);
				Disable(TwoOne);
				Disable(TwoTwo);
				TheText.setText("The Winner Is PlayerO!");
				alert.showAndWait();
			}
		}
		if (TheData.theGame[0][0] == 1 && TheData.theGame[1][1] == 1 && TheData.theGame[2][2] == 1
				|| TheData.theGame[0][2] == 1 && TheData.theGame[1][1] == 1 && TheData.theGame[2][0] == 1) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Game Over");
			alert.setContentText("The Winner Is Player O!");
			Disable(ZeroZero);
			Disable(ZeroOne);
			Disable(ZeroTwo);
			Disable(OneZero);
			Disable(OneOne);
			Disable(OneTwo);
			Disable(TwoZero);
			Disable(TwoOne);
			Disable(TwoTwo);
			TheText.setText("The Winner Is PlayerO!");
			alert.showAndWait();
		}
	}

	public void isXIsTheWinner() {
		for (int i = 0; i < TheData.theGame.length; i++) {
			if (TheData.theGame[i][0] == 2 && TheData.theGame[i][1] == 2 && TheData.theGame[i][2] == 2
					|| TheData.theGame[0][i] == 2 && TheData.theGame[1][i] == 2 && TheData.theGame[2][i] == 2) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Game Over");
				alert.setContentText("The Winner Is Player X!");
				Disable(ZeroZero);
				Disable(ZeroOne);
				Disable(ZeroTwo);
				Disable(OneZero);
				Disable(OneOne);
				Disable(OneTwo);
				Disable(TwoZero);
				Disable(TwoOne);
				Disable(TwoTwo);
				TheText.setText("TheWinnerIs PlayerX!");
				alert.showAndWait();
			}
		}
		if (TheData.theGame[0][0] == 2 && TheData.theGame[1][1] == 2 && TheData.theGame[2][2] == 2
				|| TheData.theGame[0][2] == 2 && TheData.theGame[1][1] == 2 && TheData.theGame[2][0] == 2) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Game Over");
			alert.setContentText("The Winner Is Player X!");
			Disable(ZeroZero);
			Disable(ZeroOne);
			Disable(ZeroTwo);
			Disable(OneZero);
			Disable(OneOne);
			Disable(OneTwo);
			Disable(TwoZero);
			Disable(TwoOne);
			Disable(TwoTwo);
			TheText.setText("TheWinnerIs PlayerX!");
			alert.showAndWait();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		TheData.turn=true;

	}
}
