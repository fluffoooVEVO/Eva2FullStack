package Evaluacion2FS.Figuritas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Evaluacion2FS.Figuritas.Repository.EdicionRepository;

@RestController
@RequestMapping("/edicion")
public class EdicionController {

    @Autowired
    private EdicionRepository edicionRepository;


    



}