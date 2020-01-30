package be.ucm.DTO.client;

import be.ucm.DAL.entities.Client;
import be.ucm.DAL.entities.Order;

import java.io.Serializable;
import java.time.LocalDate;

public class ClientOrderDTO {
    private Integer id;
    private LocalDate date;

    public ClientOrderDTO(){}
    public ClientOrderDTO(Order order){
        this.id = order.getId();
        this.date = order.getDate();
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
