package Bank.example.BankApp.validator;

import Bank.example.BankApp.Exception.ConstraintViolationException;
import Bank.example.BankApp.account.AccountRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ObjectValidator<T> {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();//creer un validateur et recuperer l'objet validator
    private final Validator validator = factory.getValidator();

    public void validate(T objectToValidate ) {
        Set<ConstraintViolation<T> >violations= validator.validate(objectToValidate);
        if (!violations.isEmpty()) {
            Set<String> errorMsg=violations
                    .stream().map(ConstraintViolation::getMessage)
                    .collect(Collectors.toSet());
            throw new ConstraintViolationException(errorMsg,objectToValidate.getClass().getName());
         }
    }

}
