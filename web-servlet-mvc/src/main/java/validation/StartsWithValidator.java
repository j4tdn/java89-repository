package validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartsWithValidator implements ConstraintValidator<StartsWith, String> {

	private String prefix;
	
	@Override
	public void initialize(StartsWith startsWith) {
		this.prefix = startsWith.value();
	}
	
	@Override
	public boolean isValid(String input, ConstraintValidatorContext context) {
		
		return input != null && input.startsWith(prefix);
	}

}
