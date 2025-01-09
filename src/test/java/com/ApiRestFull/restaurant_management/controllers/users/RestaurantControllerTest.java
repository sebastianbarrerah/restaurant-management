//package com.ApiRestFull.restaurant_management.controllers.users;
//
//import com.ApiRestFull.restaurant_management.dto.RestaurantRequestDto;
//import com.ApiRestFull.restaurant_management.dto.RestaurantResponseDto;
//import com.ApiRestFull.restaurant_management.model.Restaurant;
//import com.ApiRestFull.restaurant_management.services.RestaurantService;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.reactive.server.WebTestClient;
//import utils.RestaurantDtoConverter;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyLong;
//import static org.mockito.Mockito.*;
//
//class RestaurantControllerTest {
//
//    private final WebTestClient webTestClient;
//    private final RestaurantService restaurantService;
//
//    RestaurantControllerTest() {
//        restaurantService = mock(RestaurantService.class);
//        webTestClient = WebTestClient.bindToController(new RestaurantController(restaurantService)).build();
//    }
//
//    @Test
//    @DisplayName("Buscar todos los restaurantes")
//    void findAllRestaurants() {
//        List<Restaurant> restaurants = getRestaurants();
//        List<RestaurantResponseDto> responseDtos = restaurants.stream()
//                .map(RestaurantDtoConverter::convertToResponseDto)
//                .toList();
//
//        when(restaurantService.ListRestaurants()).thenReturn(restaurants);
//
//        webTestClient.get()
//                .uri("/api/restaurant")
//                .exchange()
//                .expectStatus().isOk()
//                .expectHeader().contentType(MediaType.APPLICATION_JSON)
//                .expectBodyList(RestaurantResponseDto.class)
//                .hasSize(3)
//                .value(response -> {
//                    assertEquals(responseDtos.get(0).getName(), response.get(0).getName());
//                    assertEquals(responseDtos.get(1).getName(), response.get(1).getName());
//                    assertEquals(responseDtos.get(2).getName(), response.get(2).getName());
//                });
//
//        verify(restaurantService).ListRestaurants();
//    }
//
//    @Test
//    @DisplayName("Buscar restaurante por ID")
//    void findRestaurantById() {
//        Restaurant restaurant = new Restaurant(1L, "Restaurante la casona", "Descripción", "Dirección", 5556784, "Medellín");
//        RestaurantResponseDto responseDto = RestaurantDtoConverter.convertToResponseDto(restaurant);
//
//        when(restaurantService.findRestaurantById(anyLong())).thenReturn(restaurant);
//
//        webTestClient.get()
//                .uri("/api/restaurant/{id}", 1L)
//                .exchange()
//                .expectStatus().isOk()
//                .expectHeader().contentType(MediaType.APPLICATION_JSON)
//                .expectBody(RestaurantResponseDto.class)
//                .value(response -> assertEquals(responseDto.getName(), response.getName()));
//
//        verify(restaurantService).findRestaurantById(anyLong());
//    }
//    @Test
//    @DisplayName("Agregar restaurante")
//    void addRestaurant() {
//        Restaurant restaurant = new Restaurant("Restaurante la casona", "Restaurante local donde viviras la mejor experiencia de la gastronomia local", "calle 31 c 24 # 12", 5556784, "medellin" );
//        doNothing().when(restaurantService).addRestaurant(any(Restaurant.class));
//
//
//        webTestClient.post()
//                .uri("/api/restaurant/add")
//                .contentType(MediaType.APPLICATION_JSON)
//                .bodyValue(restaurant)
//                .exchange()
//                .expectStatus().isCreated()
//                .expectHeader().contentType(MediaType.APPLICATION_JSON)
//                .expectBody(Restaurant.class)
//                .value(response -> {
//                    assertEquals(restaurant.getName(), response.getName());
//                    assertEquals(restaurant.getDescription(), response.getDescription());
//                    assertEquals(restaurant.getAddress(), response.getAddress());
//                    assertEquals(restaurant.getPhone(), response.getPhone());
//                    assertEquals(restaurant.getCity(), response.getCity());
//                });
//
//        Mockito.verify(restaurantService).addRestaurant(any());
//    }
//
//    @Test
//    @DisplayName("Editar restaurante")
//    void editRestaurant() {
//
//        Restaurant restaurant = new Restaurant("Restaurante la casona", "Restaurante local donde viviras la mejor experiencia de la gastronomia local", "calle 31 c 24 # 12", 5556784, "medellin");
//
//        when(restaurantService.editRestaurant(anyLong(), any(Restaurant.class))).thenReturn(restaurant);
//
//        webTestClient.put()
//                .uri("/api/restaurant/edit/{id}", 1l)
//                .contentType(MediaType.APPLICATION_JSON)
//                .bodyValue(restaurant)
//                .exchange()
//                .expectStatus().isOk()
//                .expectHeader().contentType(MediaType.APPLICATION_JSON)
//                .expectBody(Restaurant.class)
//                .value(response -> {
//                    assertEquals(restaurant.getName(), response.getName());
//                    assertEquals(restaurant.getDescription(), response.getDescription());
//                    assertEquals(restaurant.getAddress(), response.getAddress());
//                    assertEquals(restaurant.getPhone(), response.getPhone());
//                    assertEquals(restaurant.getCity(), response.getCity());
//                });
//
//        Mockito.verify(restaurantService).editRestaurant(anyLong(), any(Restaurant.class));
//
//    }
//
//    @Test
//    @DisplayName("Eliminar restaurante")
//    void removeRestaurant() {
//        doNothing().when(restaurantService).removeRestaurant(anyLong());
//
//        webTestClient.delete()
//                .uri("/api/restaurant/delete/{id}", 1L)
//                .exchange()
//                .expectStatus().isNoContent();
//
//        verify(restaurantService).removeRestaurant(anyLong());
//    }
//
//
//    private List<Restaurant> getRestaurants() {
//        return List.of(
//                new Restaurant(1L, "Restaurante la casona", "Descripción", "Dirección", 5556784, "Medellín"),
//                new Restaurant(2L, "Restaurante las delicias", "Descripción", "Dirección", 5756784, "Medellín"),
//                new Restaurant(3L, "El descanso", "Descripción", "Dirección", 8764327, "Cali")
//        );
//    }
//}
