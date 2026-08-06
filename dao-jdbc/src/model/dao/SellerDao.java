package model.dao;

import model.entities.Seller;
import model.entities.Seller;

import java.util.List;

public interface SellerDao {

    void insert(Seller obj); // inserir no banco
    void update(Seller obj);
    void delete(Integer id);
    Seller findById(Integer id);
    List<Seller> findAll();


}
