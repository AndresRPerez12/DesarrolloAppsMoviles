package co.edu.unal.usersdatabase.dataAccess;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

import co.edu.unal.usersdatabase.dataAccess.db.Database;
import co.edu.unal.usersdatabase.dataAccess.model.Company;

public class CompanyRepository {

    private String DB_NAME = "dadm_companies";
    private Database database;

    public CompanyRepository(Context context){
        database = Room.databaseBuilder(context, Database.class, DB_NAME).
                allowMainThreadQueries().fallbackToDestructiveMigration().build();
    }

    public List<Company> getAllUsers(){
        return database.companyDao().getAllUsers();
    }

    public Company getCompanyById(int id){
        return database.companyDao().getCompanyById(id);
    }

    public Company getCompanyByEmail(String email){
        return database.companyDao().getCompanyByEmail(email);
    }

    public void createCompany(final Company company){
        database.companyDao().createCompany(company);
    }

    public void updateCompany(final Company company){
        database.companyDao().updateCompany(company);
    }

    public void deleteUser(int id){
        Company company = database.companyDao().getCompanyById(id);
        database.companyDao().deleteCompany(company);
    }

}
