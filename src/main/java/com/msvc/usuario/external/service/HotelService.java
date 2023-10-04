package com.msvc.usuario.external.service;

import com.msvc.usuario.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "hotel-service")
public interface HotelService {

    @GetMapping("/hoteles/{hotelId}")
    Hotel getHotel(@PathVariable String hotel);

}
