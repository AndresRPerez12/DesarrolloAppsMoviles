package co.edu.unal.usersdatabase.dataAccess.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import co.edu.unal.usersdatabase.dataAccess.model.Company;

@Dao
public interface CompanyDao {
    @Query("SELECT * FROM company")
    List<Company> getAllUsers();

    @Query("SELECT * FROM company WHERE id = :id")
    Company getCompanyById(int id);

    @Query("SELECT * FROM company WHERE email = :email")
    Company getCompanyByEmail(String email);

    @Insert
    void createCompany(Company company);

    @Update
    void updateCompany(Company company);

    @Delete
    void deleteCompany(Company company);

    @Query("SELECT * FROM company WHERE name LIKE '%' || :filterName || '%'")
    List<Company> filterByName(String filterName);

    @Query("SELECT * FROM company WHERE classification LIKE '%' || :filterClassification || '%'")
    List<Company> filterByClassification(String filterClassification);
}
