package com.example.rwbybackend.model.user;

import com.example.rwbybackend.model.ID;
import com.example.rwbybackend.model.books.Department;
import com.sun.istack.NotNull;
import lombok.*;
import org.apache.commons.codec.binary.Hex;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import static org.springframework.util.StringUtils.isEmpty;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = {"department", "role"})
public class User extends ID {

    @Column
    private String employeeId;

    @Column(name = "username")
    private String username;    // email

    @NotNull
    @Pattern(regexp = "[a-f0-9]{128}")
    @Setter(value = AccessLevel.PACKAGE)
    private String password;
    @Column
    private String lastname;
    @Column
    private String name;
    @Column
    private String patronym;
    @Column
    private String position;
    @Column(name = "cell_phone")
    private String cellPhone;
    @Column(name = "office_phone")
    private String officePhone;
    @Column(name = "home_phone")
    private String homePhone;

    @Column
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_role")
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    List<UserToken> userTokens;

    public boolean verifyPassword(String cleartext) {

        if (isEmpty(cleartext)) {
            return false;
        }
        String checkPassword = encryptPassword(cleartext);
        return checkPassword.equals(password);
    }

    private String encryptPassword(String rawPassword) {

        try {
            MessageDigest digester = MessageDigest.getInstance("SHA-512");
            byte[] encryptedBytes = digester.digest(rawPassword.getBytes());
            return new String(Hex.encodeHex(encryptedBytes, true));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
