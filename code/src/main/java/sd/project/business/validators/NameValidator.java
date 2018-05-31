package sd.project.business.validators;

import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import sd.project.data.entity.Client;

public class NameValidator implements Validator<Client>{

	private static final String NAME_PATTERN = "[a-zA-Z][a-zA-Z ]*" ;

	public boolean validate(Client s) {
		Pattern pattern = Pattern.compile(NAME_PATTERN);
		if (!pattern.matcher(s.getClientName()).matches()) {
			JOptionPane.showMessageDialog(new JFrame(),"The name is not valid");
			return false;
		}
		return true;
	}
}
