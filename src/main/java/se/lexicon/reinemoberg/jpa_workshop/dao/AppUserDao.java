package se.lexicon.reinemoberg.jpa_workshop.dao;

import se.lexicon.reinemoberg.jpa_workshop.entity.AppUser;
import se.lexicon.reinemoberg.jpa_workshop.entity.Product;

import java.util.List;
import java.util.Optional;

public interface AppUserDao {

    //Basic CRUD
    AppUser create(AppUser appUser);

    AppUser findById(int id);

    List<AppUser> findAll();

    void remove(int id);

    AppUser merge(AppUser appUser);

    List<AppUser> saveAllAppUsers(List<AppUser> appUsers);

    //Custom CRUD
    Optional<AppUser> findAppUserByEmail(String email);

}
