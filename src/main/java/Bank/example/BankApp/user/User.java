package Bank.example.BankApp.user;

import Bank.example.BankApp.account.Account;
import Bank.example.BankApp.contact.Contact;
import Bank.example.BankApp.role.Role;
import Bank.example.BankApp.transaction.Transaction;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="_user")

public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    @Column(unique=true)
    private String email;
    private String password;
    private boolean active;
    @OneToOne
    private Account account;
    @OneToMany(mappedBy = "user")
    private List<Contact> conatcts;
    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;
    @ManyToMany
    @JoinTable(
            name = "users_roles",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;


}
