package Bank.example.BankApp.account;

import Bank.example.BankApp.user.User;
import Bank.example.BankApp.validator.ObjectValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    private final ObjectValidator<AccountRequest> validator;

    public Integer save(AccountRequest accountRequest){
       validator.validate(accountRequest);
        return accountRepository.save(
                accountMapper.toAccount(
                        accountRequest)
        ).getId();
    }
}
