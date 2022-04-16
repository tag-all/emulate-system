package ru.tagall.emulatesystem.application.session.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

/**
 * Пользователь.
 *
 * @author Iurii Babalin.
 */
@Data
@Entity
@Table(name = "customer")
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", allocationSize = 1)
    private Long id;

    @Column(name = "company_name")
    private String companyName;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Session> sessionsList;

    @OneToMany(mappedBy = "lastBetCustomer", cascade = CascadeType.ALL)
    private List<Session> sessionBetList;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<CustomerKey> customerKeys;
}