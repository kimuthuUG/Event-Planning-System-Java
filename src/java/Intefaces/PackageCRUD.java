package Intefaces;

import Models.Package;
import java.util.List;

//using Interfaces
public interface PackageCRUD {
    public List list_array();
    public Package list(int id);
    public boolean add(Package p);
    public boolean edit(Package p);
    public boolean delete(int id);
}
