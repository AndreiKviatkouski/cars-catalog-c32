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

    public Advert(long id, String markCar, String modelCar, String colorCar, int yearCar, double priceCar, long idUser) {
        this.id = id;
        this.markCar = markCar;
        this.modelCar = modelCar;
        this.colorCar = colorCar;
        this.yearCar = yearCar;
        this.priceCar = priceCar;
        this.idUser = idUser;
        this.dateAdvert = dateAdvert;
    }

    public Advert(String markCar, String modelCar, String colorCar, int yearCar, double priceCar, long idUser, List<Message> message) {
        this.markCar = markCar;
        this.modelCar = modelCar;
        this.colorCar = colorCar;
        this.yearCar = yearCar;
        this.priceCar = priceCar;
        this.idUser = idUser;
    }

    public Advert(String markCar, String modelCar, String colorCar, int yearCar, double priceCar, long idUser) {
        this.markCar = markCar;
        this.modelCar = modelCar;
        this.colorCar = colorCar;
        this.yearCar = yearCar;
        this.priceCar = priceCar;
        this.idUser = idUser;
    }

    public Advert(String markCar, String modelCar, String colorCar, int yearCar, double priceCar, long idUser, String dateAdvert, String specificationAdvert) {
        this.markCar = markCar;
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
                "Mark car - " + markCar + ", model car - " + modelCar + ", color car - " + colorCar + ", year car - " + yearCar + ", price car - " + priceCar;
    }
}
