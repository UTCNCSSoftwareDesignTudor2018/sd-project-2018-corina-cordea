package sd.project.business.validators;

public interface Validator<T> {

	public boolean validate(T t);
}
