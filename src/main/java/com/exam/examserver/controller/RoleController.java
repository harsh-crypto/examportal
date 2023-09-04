package com.exam.examserver.controller;

import com.exam.examserver.models.Role;
import com.exam.examserver.repository.RoleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
public class RoleController {
    private RoleRepository RoleRepo;

    @GetMapping("/AllRoles")
    ResponseEntity<?> showRoles(){
        List<Role> Roles = RoleRepo.findAll();
        return new ResponseEntity<>(Roles, HttpStatus.OK);
    }

    @GetMapping("/Roles/{RoleIdentifier}")
    ResponseEntity<?> showRoleByIdentifier(@requestParam("RoleIdentifier") Integer no){
        Role r = RoleRepo.findById(no).get();
        if(r!=null)return new ResponseEntity<>(r,HttpStatus.OK);
        else return new ResponseEntity<>("No role found with "+no,HttpStatus.OK);
    }

}
