package sd.project.business.validators;

import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import sd.project.data.entity.Client;

public class EmailValidator implements Validator<Client>{
		
		private static final String EMAIL_PATTERN = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}" ;

		public boolean validate(Client t) {
			Pattern pattern = Pattern.compile(EMAIL_PATTERN);
			if (!pattern.matcher(t.getClientEmail()).matches()) {
				JOptionPane.showMessageDialog(new JFrame(),"The email address is not valid");
				return false;
			}
			return true;
		}
}
