package co.edu.unal.usersdatabase.dataAccess.db;

import androidx.room.RoomDatabase;

import co.edu.unal.usersdatabase.dataAccess.dao.CompanyDao;
import co.edu.unal.usersdatabase.dataAccess.model.Company;

@androidx.room.Database(entities = {Company.class}, version = 3)
public abstract class Database extends RoomDatabase {
    public abstract CompanyDao companyDao();
}
