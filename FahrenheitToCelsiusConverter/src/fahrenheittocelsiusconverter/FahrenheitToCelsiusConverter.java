package fahrenheittocelsiusconverter;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class FahrenheitToCelsiusConverter extends JFrame implements ActionListener, ChangeListener {
    private JTextField tempCelsiusField;  // Holds temperature output value in Celsius
    private JTextField tempFahrenheitField;  // Holds temperature input value in Fahrenheit
    private JLabel fahrenheitLabel;          // Label for temperature input in Fahrenheit
    private JLabel celsiusLabel;            // Label for temperature in Celsius
    private JButton convertButton;     // Triggers temperature conversion
    private JSlider tempFahrenheitSlider;    // Slider for Fahrenheit input

    /* Constructor creates GUI components and adds GUI components
      using a GridBagLayout. */
    FahrenheitToCelsiusConverter() {
        int tempMin = 0;    // Temperature slider min value
        int tempMax = 212;   // Temperature slider max value
        int tempInit = 32;   // Temperature slider initial value
        GridBagConstraints layoutConst = null; // GUI component layout
      
    // Set frame's title
        setTitle("Temperature converter");
        
    // Create labels
        fahrenheitLabel = new JLabel("Enter Fahrenheit:");
        celsiusLabel = new JLabel("Celsius:");

        tempCelsiusField = new JTextField(10);
        tempCelsiusField.setEditable(false);

        convertButton = new JButton("Convert");
        convertButton.addActionListener(this);

    // Create slider that enables user to enter temperature in Fahrenheit
        tempFahrenheitSlider = new JSlider(tempMin, tempMax, tempInit);
        tempFahrenheitSlider.addChangeListener(this); // Use FahrenheitToCelsius's stateChanged()
        tempFahrenheitSlider.setMajorTickSpacing(10);
        tempFahrenheitSlider.setMinorTickSpacing(1);
        tempFahrenheitSlider.setPaintTicks(true);
        tempFahrenheitSlider.setPaintLabels(true);

        tempFahrenheitField = new JTextField(10);
        tempFahrenheitField.setEditable(false);
        tempFahrenheitField.setText("32");

    // Create frame and add components using GridBagLayout
        setLayout(new GridBagLayout());

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 320, 1, 1);
        layoutConst.anchor = GridBagConstraints.LINE_START;
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        layoutConst.gridwidth = 1;
        add(fahrenheitLabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 1, 1, 10);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 1;
        layoutConst.gridy = 0;
        layoutConst.gridwidth = 1;
        add(tempFahrenheitField, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(1, 10, 10, 10);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        layoutConst.gridwidth = 2;
        add(tempFahrenheitSlider, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 5);
        layoutConst.anchor = GridBagConstraints.LINE_END;
        layoutConst.gridx = 0;
        layoutConst.gridy = 2;
        layoutConst.gridwidth = 1;
        add(convertButton, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.anchor = GridBagConstraints.LINE_END;
        layoutConst.gridx = 1;
        layoutConst.gridy = 2;
        layoutConst.gridwidth = 1;
        add(celsiusLabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 1, 10, 10);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 2;
        layoutConst.gridy = 2;
        layoutConst.gridwidth = 2;
        add(tempCelsiusField, layoutConst);
    }

    /* Converts a temperature in Fahrenheit to Celsius. */
    public static double TempFahrenheightToCalsius(int fh) {
        int totFh = 0;          // Total Fahrenheit input by user
        double tempCelsius = 0.0;  // Corresponding temperature in Celsius

        tempCelsius = (totFh - 32) * (0.5556);  // Convert to Celsius
        return tempCelsius;
    }

    /* Called as slider value changes. Updates fields to display
      the numerical representation of the slider settings. */
    @Override
    public void stateChanged(ChangeEvent event) {
        int sliderVal = 0;        // Slider value (int)
        String strSliderVal = ""; // Slider value (string)

    // Get source of event (1 slider in GUI)
        JSlider sourceEvent = (JSlider) event.getSource();

        if (sourceEvent == tempFahrenheitSlider) {
            sliderVal = tempFahrenheitSlider.getValue();      // Get slider value
            strSliderVal = Integer.toString(sliderVal); // Conver to int
            tempFahrenheitField.setText(strSliderVal);        // Update display
        }

    }

    /* Called when button is pressed. Converts temperature to Calsius. */
    @Override
    public void actionPerformed(ActionEvent event) {
        int fahrenheitVal = 0;      // User defined temperature in Fahrenheit
        double celsiusVal = 0.0; // Corresponding temperature in Celsius

        fahrenheitVal = tempFahrenheitSlider.getValue();    // Get Fahrenheit slider value
        celsiusVal = (fahrenheitVal - 32) * (0.5556); // Convert fahrenheit to celsius, update celsiusVal

        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.HALF_UP);
        tempCelsiusField.setText(df.format(celsiusVal)); // Update Celsius temperature

        return;
    }

    /* Creates a FahrenheitToCelsiusConverter frame and makes it visible */
    public static void main(String[] args) {
        // Creates FahrenheitToCelsiusConverter frame and its components
        FahrenheitToCelsiusConverter myFrame = new FahrenheitToCelsiusConverter();

        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.pack();
        myFrame.setVisible(true);

        return;
    }
}