package utils;


import com.ApiRestFull.restaurant_management.dto.OrderRequesResponseDto;
import com.ApiRestFull.restaurant_management.dto.OrderRequestDto;
import com.ApiRestFull.restaurant_management.model.OrderReques;
import com.ApiRestFull.restaurant_management.model.Users;

public class OrderRequesDtoConverter {

    public static OrderRequesResponseDto convertToResponseDto(OrderReques orderReques) {
        OrderRequesResponseDto dto = new OrderRequesResponseDto();
        dto.setId(orderReques.getId());
        dto.setDate(orderReques.getDate());
        dto.setTotal(orderReques.setTotal());
        dto.setUserId(orderReques.getUser().getId());
        return dto;
    }

    public static OrderReques convertToEntity(OrderRequestDto orderRequestDto, Users user) {
        OrderReques orderReques = new OrderReques();
        orderReques.setDate(orderRequestDto.getDate());
        orderReques.setUser(user);
        return orderReques;
    }
}
