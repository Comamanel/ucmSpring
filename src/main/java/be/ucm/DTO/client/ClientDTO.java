package be.ucm.DTO.client;

import be.ucm.DAL.entities.Client;
import be.ucm.DAL.entities.Order;
import jdk.nashorn.internal.objects.annotations.Getter;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class ClientDTO {
    private Integer id;
    @NotNull
    @Size(min = 6, max = 50)
    private String name;
    @NotNull
    @Size(min = 6, max = 50)
    private String firstName;
    private String address;
    private List<ClientOrderDTO> orders;

    public ClientDTO() {
    }
    public ClientDTO(Client client){
        this.id = client.getId();
        this.name = client.getName();
        this.firstName = client.getFirstName();
        this.address = client.getAddress().toString();
        this.orders = client.getOrders()
                .stream()
                .map(ClientOrderDTO::new)
                .collect(Collectors.toList());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ClientOrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<ClientOrderDTO> orders) {
        this.orders = orders;
    }
}
