package com.tylergrant.calc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;

public class Controller {

    @FXML
    private Text output;

    private long number1 = 0;
    private String operator = "";
    private boolean start = true;

    private Model model = new Model();

    @FXML
    private void processNumpad(ActionEvent event) {
        if (start) {
            output.setText("");
            start = false;
        }
        String value = ((Button)event.getSource()).getText(); //returns the text of the button that is on the button
        output.setText(output.getText() + value);
    }

    @FXML
    private void processOperator(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();

        if(!"=".equals(value)) {
            if(!operator.isEmpty())
                return;
            operator = value;
            number1 = Long.parseLong(output.getText());
            output.setText("");
        }
        else {
            if(operator.isEmpty())
                return;


            output.setText(String.valueOf(model.calculate(number1, Long.parseLong(output.getText()), operator)));//calculation
            operator = "";
            start = true;
        }
    }

}

