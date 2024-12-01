package Bank.example.BankApp.Exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;
@RequiredArgsConstructor
public class ConstraintViolationException extends RuntimeException {
    @Getter
    private final Set<String> violations;
    @Getter
    private final String violationSource;
}
