package ru.tagall.emulatesystem.application.session.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "out_system_key")
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class OutSystemKey {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "out_system_key_seq")
    @SequenceGenerator(name = "out_system_key_seq", sequenceName = "out_system_key_seq", allocationSize = 1)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "out_system_id")
    private OutSystem outSystem;

    @Column(name = "key")
    private String key;
}
