package Bank.example.BankApp.account;

import Bank.example.BankApp.user.User;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public static Account toAccount(AccountRequest request){
        return Account.builder()
                .iban(request.getIban()).user(User.builder()
                        .id(request.getUserId()).build()).build();

    }

}
