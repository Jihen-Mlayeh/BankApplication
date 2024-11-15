package Bank.example.BankApp.account;

import Bank.example.BankApp.user.User;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Account {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique=true)
    private String  iban;
    @OneToOne
    @JoinColumn(name = "user_id")//account porteuse de l'info
    private User user;


}
