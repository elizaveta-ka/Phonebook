package com.example.phonebook.repository;

import com.example.phonebook.model.PhoneBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPhoneBookRepository extends JpaRepository<PhoneBook, Long> {

    public static final String FIND_RECORDS = "SELECT * FROM phonebook WHERE deleted = false";
    @Query(value = FIND_RECORDS, nativeQuery = true)
    public List<PhoneBook> findRecords();
}
