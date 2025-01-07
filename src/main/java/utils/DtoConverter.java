package utils;


import com.ApiRestFull.restaurant_management.dto.UserRequestDto;
import com.ApiRestFull.restaurant_management.dto.UserResponseDto;
import com.ApiRestFull.restaurant_management.model.Users;

public class DtoConverter {

    public static UserResponseDto convertToResponseDto(Users user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        dto.setAddress(user.getAddress());
        dto.setIsFrequent(user.getIsFrequent());
        return dto;
    }

    public static Users convertToEntity(UserRequestDto userRequestDTO) {
        Users user = new Users();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPhone(userRequestDTO.getPhone());
        user.setAddress(userRequestDTO.getAddress());
        user.setIsFrequent(userRequestDTO.getIsFrequent());
        return user;
    }
}
