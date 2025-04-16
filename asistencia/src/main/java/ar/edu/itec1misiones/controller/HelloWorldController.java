package ar.edu.itec1misiones.controller;

import ar.edu.itec1misiones.dto.request.SaludoRequest;
import ar.edu.itec1misiones.dto.response.SaludoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/saludo")
public class HelloWorldController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello, World!";
    }

    @GetMapping(path = "/{name}")
    public String sayHello2(@PathVariable String name){
        return "Hello " + name;
    }

    @GetMapping(path="saludo")
    public ResponseEntity<SaludoResponse> getSaludo (SaludoRequest saludo){
        SaludoResponse saludoResponse = new SaludoResponse();
        saludoResponse.setMessage("que onda "+saludo.getMessage());

        return new ResponseEntity<>(saludoResponse, HttpStatus.OK);
    }
}
