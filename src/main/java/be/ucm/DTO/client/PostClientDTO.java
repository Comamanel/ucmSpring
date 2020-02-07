package be.ucm.DTO.client;

import be.ucm.DAL.entities.Client;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class PostClientDTO {
    @Size(min = 6, max = 50)
    private String name;
    @Size(min = 6, max = 50)
    private String firstName;
    @NotNull
    @Size(min = 6, max = 50)
    private String login;
    @NotNull
    @Size(min = 6, max = 50)
    private String password;
    private PostClientAddressDTO address;

    public PostClientDTO(){}

    public Client toEntity(){
        Client client = new Client();
        client.setLogin(this.login);
        client.setPassword(this.password);
        return client;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public PostClientAddressDTO getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLogin(String login) {
        System.out.println("SET LOGIN");
        this.login = login;
    }

    public void setPassword(String password) {
        System.out.println("SET PW");
        this.password = password;
    }

    public void setAddress(PostClientAddressDTO address) {
        this.address = address;
    }

    class PostClientAddressDTO{
        private String number;
        private String street;
        private String zipCode;
        private String city;

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }
}
