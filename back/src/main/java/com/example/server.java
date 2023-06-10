package com.example;
import java.util.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api")
@SpringBootApplication
public class server {
    public static void main(String[] args) {
        SpringApplication.run(server.class, args);
    }
    @GetMapping("/data/{number}")
    public String getData(@PathVariable int number) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Create a Map to represent the JSON structure
            Map<String, Integer> data = new HashMap<>();
            Database db = new Database(100);
            Tuple t = db.get_tuple(number);
            String json = new String();
            if(t.getP1() > 0){
                data.put("p1", t.getP1());
                data.put("p2", t.getP2());
                data.put("n", number);
                json = objectMapper.writeValueAsString(data);

            }
            else{
                json = "Não foi encontrado nenhuma tupla";
            }
    
            // Serialize the Map to JSON string
    
            return json;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null; // Handle the exception accordingly
        }
    }
}
