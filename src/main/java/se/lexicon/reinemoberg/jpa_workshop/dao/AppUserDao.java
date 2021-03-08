package se.lexicon.reinemoberg.jpa_workshop.dao;

import se.lexicon.reinemoberg.jpa_workshop.entity.AppUser;
import se.lexicon.reinemoberg.jpa_workshop.entity.Product;

import java.util.List;

public interface AppUserDao {

    // basic CRUD
    AppUser create(AppUser appUser);

    AppUser findById(int id);

    List<AppUser> findAll();

    void remove(int id);

    AppUser merge(AppUser appUser);

    List<AppUser> saveAllAppUsers(List<AppUser> appUsers);

}
