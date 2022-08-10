package net.golbarg.findday;

import java.text.ParseException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FindViewController {
	@FXML
	private Label lblDay;
	@FXML
	private Label lblMonth;
	@FXML
	private Label lblYear;

	@FXML
	private TextField txtDay;
	@FXML
	private TextField txtMonth;
	@FXML
	private TextField txtyear;

	@FXML
	private Button btnFindDay;

	@FXML
	private Label lblResult;

	@FXML
	private void initialize() {
		txtDay.textProperty().addListener(new OnlyNumberChangeListener(txtDay));
		txtMonth.textProperty().addListener(new OnlyNumberChangeListener(txtMonth));
		txtyear.textProperty().addListener(new OnlyNumberChangeListener(txtyear));

		btnFindDay.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String day = txtDay.getText();
				String month = txtMonth.getText();
				String year = txtyear.getText();
				System.out.println(day + "/" + month + "/" + year);

				try {

					if (isInpusValid()) {
						String resultDayName = FindDay.findDayOfWeek(Integer.parseInt(day), Integer.parseInt(month),
								Integer.parseInt(year));
						resultDayName = resultDayName.substring(0, resultDayName.indexOf(' '));
						lblResult.setText(resultDayName);
					} else {
						lblResult.setText("No valid inputs");
					}
				} catch (ParseException exception) {
					lblResult.setText(exception.getMessage());
					exception.printStackTrace();
				}
			}
		});
	}

	public boolean isInpusValid() {
		boolean isValid = true;
		if (!(txtDay.getText().length() > 0)) {
			isValid = false;
		}

		if (!(txtMonth.getText().length() > 0)) {
			isValid = false;
		}

		if (!(txtyear.getText().length() > 0)) {
			isValid = false;
		}

		return isValid;
	}
}
