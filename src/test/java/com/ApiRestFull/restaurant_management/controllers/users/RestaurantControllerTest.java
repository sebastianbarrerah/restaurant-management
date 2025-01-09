package com.ApiRestFull.restaurant_management.controllers.users;

import com.ApiRestFull.restaurant_management.model.Restaurant;
import com.ApiRestFull.restaurant_management.services.RestaurantService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RestaurantControllerTest {

    private final WebTestClient webTestClient;
    private final RestaurantService restaurantService;

    RestaurantControllerTest() {
        restaurantService = mock(RestaurantService.class);
        webTestClient = WebTestClient.bindToController(new RestaurantController(restaurantService)).build();
    }
    @Test
    @DisplayName("Buscar todos los restaurantes")
    void findAllRestaurants() {
        when(restaurantService.ListRestaurants()).thenReturn(getRestaurants());

        webTestClient.get()
                .uri("/api/restaurant")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(Restaurant.class)
                .hasSize(3)
                .value(restaurant -> {
                    assertEquals("Restaurante la casona", restaurant.get(0).getName());
                    assertEquals("Restaurante las delicias", restaurant.get(1).getName());
                    assertEquals("El descanso", restaurant.get(2).getName());
                });

        Mockito.verify(restaurantService).ListRestaurants();
    }

    @Test
    @DisplayName("Buscar restaurante por id")
    void findRestaurantById() {

        Restaurant restaurant = new Restaurant( 1l, "Restaurante la casona", "Restaurante local donde viviras la mejor experiencia de la gastronomia local", "calle 31 c 24 # 12", 5556784, "medellin" );
        when(restaurantService.findRestaurantById(anyLong())).thenReturn(restaurant);

        webTestClient.get()
                .uri("/api/restaurant/{id}", 1l)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(Restaurant.class)
                .value(restaurante -> {
                    assertEquals(restaurante.getName(), restaurant.getName());
                    assertEquals(restaurante.getDescription(), restaurant.getDescription());
                    assertEquals(restaurante.getAddress(), restaurant.getAddress());
                    assertEquals(restaurante.getPhone(), restaurant.getPhone());
                    assertEquals(restaurante.getCity(), restaurant.getCity());
                });

        Mockito.verify(restaurantService).findRestaurantById(anyLong());

    }

    @Test
    @DisplayName("Agregar restaurante")
    void addRestaurant() {
        Restaurant restaurant = new Restaurant("Restaurante la casona", "Restaurante local donde viviras la mejor experiencia de la gastronomia local", "calle 31 c 24 # 12", 5556784, "medellin" );
        doNothing().when(restaurantService).addRestaurant(any(Restaurant.class));


        webTestClient.post()
                .uri("/api/restaurant/add")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(restaurant)
                .exchange()
                .expectStatus().isCreated()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(Restaurant.class)
                .value(response -> {
                    assertEquals(restaurant.getName(), response.getName());
                    assertEquals(restaurant.getDescription(), response.getDescription());
                    assertEquals(restaurant.getAddress(), response.getAddress());
                    assertEquals(restaurant.getPhone(), response.getPhone());
                    assertEquals(restaurant.getCity(), response.getCity());
                });

        Mockito.verify(restaurantService).addRestaurant(any());
    }

    @Test
    @DisplayName("Editar restaurante")
    void editRestaurant() {

        Restaurant restaurant = new Restaurant("Restaurante la casona", "Restaurante local donde viviras la mejor experiencia de la gastronomia local", "calle 31 c 24 # 12", 5556784, "medellin");

        when(restaurantService.editRestaurant(anyLong(), any(Restaurant.class))).thenReturn(restaurant);

        webTestClient.put()
                .uri("/api/restaurant/edit/{id}", 1l)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(restaurant)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(Restaurant.class)
                .value(response -> {
                    assertEquals(restaurant.getName(), response.getName());
                    assertEquals(restaurant.getDescription(), response.getDescription());
                    assertEquals(restaurant.getAddress(), response.getAddress());
                    assertEquals(restaurant.getPhone(), response.getPhone());
                    assertEquals(restaurant.getCity(), response.getCity());
                });

        Mockito.verify(restaurantService).editRestaurant(anyLong(), any(Restaurant.class));

    }


    @Test
    @DisplayName("Eliminar restaurante")
    void removeRestaurant() {

        doNothing().when(restaurantService).removeRestaurant(anyLong());

        webTestClient.delete()
                .uri("/api/restaurant/borrar/{id}", 1l)
                .exchange()
                .expectStatus().isNoContent();

        Mockito.verify(restaurantService).removeRestaurant(anyLong());

    }

    private List<Restaurant> getRestaurants() {
        return List.of(new Restaurant("Restaurante la casona", "Restaurante local donde viviras la mejor experiencia de la gastronomia local", "calle 31 c 24 # 12", 5556784, "medellin" ),
                new Restaurant("Restaurante las delicias", "El mejor sitio para disfrutar de nuevos platillos", "calle 43 b 12 # 12", 5756784, "medellin" ),
                new Restaurant("El descanso", "Comida unica, experiencia maravillosa. Asi te sentiras en el descanso", "carrea 45 a 32 # 09", 8764327, "cali" ));
    }

}