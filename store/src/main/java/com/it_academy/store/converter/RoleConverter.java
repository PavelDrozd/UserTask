package com.it_academy.store.converter;



import com.it_academy.store.entity.User;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<User.Role, Integer> {

    @Override
    public Integer convertToDatabaseColumn(User.Role attribute) {
        switch (attribute) {
            case SALE_USER:
                return 2;
            case ADMINISTRATOR:
                return 3;
            case SECURE_API_USER:
                return 4;
            default:
                return 1;
        }
    }

    @Override
    public User.Role convertToEntityAttribute(Integer dbData) {
        switch (dbData) {
            case 2:
                return User.Role.SALE_USER;
            case 3:
                return User.Role.ADMINISTRATOR;
            case 4:
                return User.Role.SECURE_API_USER;
            default:
                return User.Role.CUSTOMER_USER;
        }
    }
}
