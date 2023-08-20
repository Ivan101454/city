package by.ivan.city.dto.converters;


import by.ivan.city.dto.core.UserDTO;
import by.ivan.city.models.User;
import by.ivan.city.models.enums.Role;
import by.ivan.city.models.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
@Setter
@Getter
@AllArgsConstructor
public class UserDtoToEntityConverter implements Converter<UserDTO, User> {

    public User convert(UserDTO userDTO) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userDTO, User.class);


        return user;

    }
}



