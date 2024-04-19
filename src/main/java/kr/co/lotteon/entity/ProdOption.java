package kr.co.lotteon.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "prodoption")
public class ProdOption {
    @Id
    public int optNo;
    public int prodNo;
    public String optName;
    public String optValue;
    public int optPrice;
    public int optStock;
}
