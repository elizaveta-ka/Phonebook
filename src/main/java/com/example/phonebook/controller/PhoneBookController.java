package com.example.phonebook.controller;

import com.example.phonebook.model.PhoneBook;
import com.example.phonebook.repository.IPhoneBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class PhoneBookController {

    private IPhoneBookRepository iPhoneBookRepository;

    @Autowired
    public PhoneBookController(IPhoneBookRepository iPhoneBookRepository) {
        this.iPhoneBookRepository = iPhoneBookRepository;
    }

    @GetMapping("/phonebook")
    public String showRecords(Model model) {
        List<PhoneBook> phoneBookList = iPhoneBookRepository.findRecords();
        model.addAttribute("phoneBookList", phoneBookList);

        return "record";
    }

    @PostMapping("/delete/record")
    public ResponseEntity<String> deleteRecord(@RequestParam Long id) {
        PhoneBook phoneBook = iPhoneBookRepository.getById(id);
        phoneBook.setDeleted(true);
        iPhoneBookRepository.save(phoneBook);

        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @PostMapping("/edit/record")
    public ResponseEntity<String> editRecord(@RequestParam String name, String phone, Long id) {
        PhoneBook phoneBook = iPhoneBookRepository.getReferenceById(id);
        phoneBook.setPhone(phone);
        phoneBook.setName(name);
        phoneBook.setDate(LocalDate.now());
        iPhoneBookRepository.save(phoneBook);
        LocalDate localDate = phoneBook.getDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        return new ResponseEntity<>(localDate.format(formatter), HttpStatus.OK);
    }

    @GetMapping("/add/record")
    public ResponseEntity<Long> addRecord() {
        PhoneBook phoneBook = new PhoneBook();
        iPhoneBookRepository.save(phoneBook);

        return new ResponseEntity<>(phoneBook.getId(), HttpStatus.OK);
    }
}
