package org.abc.app.logger;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "log")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Log {

    public Boolean isSuccessful;
    @Column(length = 50)
    public String converterType;
    @Column(length = 50)
    public String input;
    @Column(length = 50)
    public String result;
    @Column(length = 300)
    public String description;
    @Id
    @GeneratedValue
    private Long id;
    @CreationTimestamp
    private Date createdAt = new Date();
}
