package com.example.webappspringboot;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class MainRestController {
    @Autowired
    CredentialRepository credentialRepository;
    @Autowired
    private UserdetailRepository userdetailRepository;

    @GetMapping("/")
    public String getLandingPage(){
        return "landingpage";
    }
    @PostMapping("/signup1")
    public String signup(@RequestParam("username") String username,@RequestParam("password") String password){

        Credential credential=new Credential();
        credential.setUsername(username);
        credential.setPassword(password);
        credentialRepository.save(credential);
        return"signup";
    }


    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session){

        Optional<Credential> credValue=credentialRepository.findById(username);

        if(credValue.isPresent()){
            if(credValue.get().getPassword().equals(password)){
                session.setAttribute("username",username);
                return "dashboard";
            }
            else return "landingpage";
        }
        else return "landingpage";

    }

    @PostMapping("/signup2")
    public String signup2(@RequestParam("username") String username,@RequestParam("fname") String fname,@RequestParam("lname") String lname,@RequestParam("email") String email,@RequestParam("phone") String phone, HttpSession session){
        Userdetail userdetail =new Userdetail();
        userdetail.setUsername(username);
        userdetail.setFname(fname);
        userdetail.setLname(lname);
        userdetail.setEmail(email);
        userdetail.setPhone(phone);
        //session.setAttribute("username",username);
        userdetailRepository.save(userdetail);

        return "dashboard";
    }








    @GetMapping("/save")
    public String saveCredential(){
        Credential cr=new Credential();
        cr.setUsername("Aakash");
        cr.setPassword("Neel@123");
        credentialRepository.save(cr);
        return "New Credential Saved";
    }

}
