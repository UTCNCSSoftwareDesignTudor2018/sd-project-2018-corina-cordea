package sd.project.business.validators;

import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import sd.project.data.entity.Client;

public class PhoneValidator implements Validator<Client>{
	
	private static final String PHONE_PATTERN = "\\d{10}" ;

	public boolean validate(Client t) {
		Pattern pattern = Pattern.compile(PHONE_PATTERN);
		if (!pattern.matcher(t.getClientPhoneNumber()).matches()) {
			JOptionPane.showMessageDialog(new JFrame(),"The phone number is not valid");
			return false;
		}
		return true;
	}
}
