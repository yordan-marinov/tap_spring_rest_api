package com.yoranm.user_api_service.user;


import com.yoranm.user_api_service.models.AddressModel;
import com.yoranm.user_api_service.models.TransactionModel;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class UserModel {

    @Id
    private UUID userId;
    private String firstName;
    private String lastName;
    @OneToMany
    @JoinColumn()
    private List<AddressModel> addresses;
    @OneToMany
    private List<TransactionModel> transactions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserModel userModel = (UserModel) o;
        return userId != null && Objects.equals(userId, userModel.userId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
