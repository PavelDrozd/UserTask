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
                return 1;
            case ADMINISTRATOR:
                return 2;
            case SECURE_API_USER:
                return 3;
            default:
                return 0;
        }
    }

    @Override
    public User.Role convertToEntityAttribute(Integer dbData) {
        switch (dbData) {
            case 1:
                return User.Role.SALE_USER;
            case 2:
                return User.Role.ADMINISTRATOR;
            case 3:
                return User.Role.SECURE_API_USER;
            default:
                return User.Role.CUSTOMER_USER;
        }
    }
}
