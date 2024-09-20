package uk.ac.aston.oop.javafx.assessed;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import uk.ac.aston.oop.javafx.assessed.model.CD;
import uk.ac.aston.oop.javafx.assessed.model.Database;
import javafx.beans.binding.Bindings;


public class AddController {
	
	@FXML private Label playTimeLbl;
	@FXML private Label trackNumberLbl;
	@FXML private Slider playTimeSld;
	@FXML private Slider trackNumberSld;
	@FXML private TextField titleField;
	@FXML private TextField artistField;
	@FXML private CheckBox ownBox;

	private boolean confirmed = false;
	private Database d;
	
	public AddController(Database d) {
		this.d = d;
	}
	
	@FXML
	public void initialize() {
		playTimeLbl.textProperty().bind(Bindings.format("Playing time: %.0f", playTimeSld.valueProperty()));
		trackNumberLbl.textProperty().bind(Bindings.format("Number of tracks: %.0f", trackNumberSld.valueProperty()));
	}
	
	@FXML
	public void createPressed() {
		int playTime = (int) playTimeSld.valueProperty().get();
		int trackNumber = (int) trackNumberSld.valueProperty().get();
		boolean owned = ownBox.isSelected();

		CD newCD = new CD(titleField.getText(), artistField.getText(), trackNumber, playTime);
		newCD.setOwn(owned);
		d.addItem(newCD);
		this.confirmed = true;
		playTimeLbl.getScene().getWindow().hide();
	}
	
	@FXML
	public void cancelPressed() {
		playTimeLbl.getScene().getWindow().hide();
	}
	
	public boolean isConfirmed() {
		return confirmed;
	}
	
	
	
	
	
	
}
