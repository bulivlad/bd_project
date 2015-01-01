package ro.autoDealerSales.web.domain;

/**
 * Created by Buli on 12/25/2014.
 */
public class CarFeature {

    Integer id;
    String description;

    public CarFeature(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public CarFeature(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
