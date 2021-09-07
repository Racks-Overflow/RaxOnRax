package com.staxoverflow.demo.registration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;


    public RegistrationController() {
    }

    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }
}
