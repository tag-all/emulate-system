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

@Data
@Entity
@Table(name = "out_system")
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class OutSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "out_system_seq")
    @SequenceGenerator(name = "out_system_seq", sequenceName = "out_system_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "outSystem", cascade = CascadeType.ALL)
    private List<OutSystemKey> outSystemKeys;
}
