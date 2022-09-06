package com.example.phonebook.repository;

import com.example.phonebook.model.PhoneBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPhoneBookRepository extends JpaRepository<PhoneBook, Long> {
}
