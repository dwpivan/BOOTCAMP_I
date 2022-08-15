package com.bootcampfinal.java.event.service.mapper;

import com.bootcampfinal.java.event.domain.User;
import com.bootcampfinal.java.event.web.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userModelToUser (UserModel model);

    UserModel userToUserModel (User user);

    List<UserModel> usersToUserModels(List<User> users);


    @Mapping(target = "id", ignore = true)
    void update(@MappingTarget User entity, UserModel updateEntity);
}
