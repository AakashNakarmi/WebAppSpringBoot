package com.example.webappspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Rest API does CRUD - Create Read Update and Delete

@RestController
@RequestMapping("/api/0.1")
public class MainRestController {

    @Autowired
    UserdetailRepository userdetailRepository;

    @PostMapping("getuseremail")
    public ResponseEntity<Userdetail> getUserdetailsByEmail(@RequestParam("email") String email){
        if(userdetailRepository.findByEmail(email).isPresent()){
            return new ResponseEntity<>(userdetailRepository.findByEmail(email).get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
    @CrossOrigin("http://localhost:4200")
    @GetMapping("dummy")
    public Userdetail dummydetail(){
        Userdetail userdetail=new Userdetail();
        userdetail.setUsername("JAs");
        userdetail.setEmail("jas@123");
        userdetail.setFname("JAS");
        userdetail.setLname("Singh");
        userdetail.setPhone("9971");
        return userdetail;
    }



}
