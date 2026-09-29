package co.test.technicaltest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    private Long id;
    private String ownerName;
    private double balance;

    public void debit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Jumlah transfer harus lebih dari 0");
        }
        if (balance < amount) {
            throw new IllegalArgumentException("Saldo tidak mencukupi");
        }
        balance -= amount;
    }

    public void credit(double amount) {
        balance += amount;
    }

}
