package co.edu.unal.usersdatabase.dataAccess.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.io.Serializable;
import java.util.List;

@Entity(indices = {@Index(value = {"email"}, unique = true)})
public class Company implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "url")
    private String url;

    @ColumnInfo(name = "phoneNumber")
    private String phoneNumber;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "services")
    private String services;

    @ColumnInfo(name = "classification")
    private String classification;

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        if( name != null ) stringBuilder.append(name + '\n');
        if( url != null ) stringBuilder.append(url + '\n');
        if( phoneNumber != null ) stringBuilder.append("Tel: " +phoneNumber + '\n');
        if( email != null ) stringBuilder.append(email + '\n');
        if( services != null ) stringBuilder.append("Servicios: " + services + '\n');
        if( classification != null ) stringBuilder.append("Clasificación: " + classification + '\n');
        return stringBuilder.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
}
