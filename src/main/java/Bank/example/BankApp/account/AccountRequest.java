package Bank.example.BankApp.account;

import Bank.example.BankApp.user.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountRequest {

    @NotNull(message = "IBAN should not be NULL")//null
    @NotEmpty(message = "IBAN should not be empty") //""
    @NotBlank(message = "IBAN should not be blank")// " "
    private String iban;
    @NotNull(message = "user id should not be NULL")//null
    private Integer userId;

}
