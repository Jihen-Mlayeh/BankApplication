package Bank.example.BankApp.transaction;

import Bank.example.BankApp.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private Integer id;
    private String destinantionIban;
    private LocalDate transactionDate;
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
