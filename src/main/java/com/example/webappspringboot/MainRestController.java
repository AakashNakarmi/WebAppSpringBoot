package com.example.webappspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class MainRestController {
    @Autowired
    CredentialRepository credentialRepository;


    @Autowired
    private UserdetailRepository userdetailRepository;


    @Autowired
    UsertypelinkRepository usertypelinkRepository;

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
        return "interdashboard";
    }


    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session, Model model){

        Optional<Credential> credValue=credentialRepository.findById(username);

        if(credValue.isPresent()){
            if(credValue.get().getPassword().equals(password)){
                session.setAttribute("username",username);
                Optional<Userdetail> userdetail=userdetailRepository.findById(username);

                List<Usertypelink> usertypelinks= usertypelinkRepository.findAll();
                Optional<Usertypelink> usertypelink=usertypelinks.stream().filter(usertypelink1
                        ->usertypelink1.getUsername().equals(username)).findAny();

                if(userdetail.isPresent()) {

                    model.addAttribute("userdetail", userdetail.get());
                    if (usertypelink.isPresent()) {
                        if (usertypelink.get().getType().equals("BUYER")) {
                            return "buyerdashboard";
                        } else if (usertypelink.get().getType().equals("SELLER")) {
                            return "sellerdashboard";
                        } else {
                            return "interdashboard";
                        }
                    } else {
                        return "interdashboard";
                    }
                }
                else return "interdashboard";
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
        session.setAttribute("username",username);
//        session.setAttribute("fname",fname);
//        session.setAttribute("lname",lname);
//        session.setAttribute("email",email);
//        session.setAttribute("phone",phone);

        userdetailRepository.save(userdetail);

        return "landingpage";
    }


//    @GetMapping("/save")
//    public String saveCredential(){
//        Credential cr=new Credential();
//        cr.setUsername("Aakash");
//        cr.setPassword("Neel@123");
//        credentialRepository.save(cr);
//        return "New Credential Saved";
//    }

}
