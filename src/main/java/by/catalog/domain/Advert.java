package by.catalog.domain;

import by.catalog.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Advert {

    private long id;
    private String markCar;
    private String modelCar;
    private String colorCar;
    private int yearCar;
    private double priceCar;
    private long idUser;
    private String dateAdvert;
    private String specificationAdvert;
    private List<Message> message;

    public Advert(long id, String modelCar, String colorCar, int yearCar, double priceCar, long idUser) {
        this.id = id;
        this.modelCar = modelCar;
        this.colorCar = colorCar;
        this.yearCar = yearCar;
        this.priceCar = priceCar;
        this.idUser = idUser;
    }

    public Advert(String modelCar, String colorCar, int yearCar, double priceCar, long idUser, List<Message> message) {
        this.modelCar = modelCar;
        this.colorCar = colorCar;
        this.yearCar = yearCar;
        this.priceCar = priceCar;
        this.idUser = idUser;
        this.message = message;
    }

    public Advert(String modelCar, String colorCar, int yearCar, double priceCar, long idUser) {
        this.modelCar = modelCar;
        this.colorCar = colorCar;
        this.yearCar = yearCar;
        this.priceCar = priceCar;
        this.idUser = idUser;
    }


    @Override
    public String toString() {

        UserService userService = new UserService();
        return
                "Model car - " + modelCar + ", color car - " + colorCar + ", year car - " + yearCar + ", price car - " + priceCar;
    }
}
