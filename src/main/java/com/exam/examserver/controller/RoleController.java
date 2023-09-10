package com.exam.examserver.controller;

import com.exam.examserver.VO.RoleVO;
import com.exam.examserver.models.Role;
import com.exam.examserver.repository.RoleRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
public class RoleController {
    private final RoleRepository RoleRepo;

    public RoleController( RoleRepository RP){
        this.RoleRepo = RP;
    }

    @GetMapping("/AllRoles")
    ResponseEntity<?> showRoles(int numberOfPages,int numberOfItems){
        Pageable pg = PageRequest.of(numberOfPages,numberOfItems);
        List<Role> Roles = RoleRepo.findAll(pg).getContent();
        return new ResponseEntity<>(Roles, HttpStatus.OK);
    }

    @GetMapping("/Roles/{RoleIdentifier}")
    ResponseEntity<?> showRoleByIdentifier(@RequestParam("RoleIdentifier") Integer no){
        Role r = new Role();
        try{r = RoleRepo.findById(no).get();
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
        }
        return new ResponseEntity<>(r,HttpStatus.OK);
    }
    @PostMapping("/Roles/createRole")
    ResponseEntity<?> createRole(@RequestBody RoleVO role){
        Role r = new Role();
        r.setRoleName(role.roleName());
        try{
            RoleRepo.save(r);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Cant create Role",HttpStatus.OK);

        }
        return new ResponseEntity<>("Role created: "+ r.getRoleName(),HttpStatus.OK);
    }

    @DeleteMapping("/Roles/Delete")
    ResponseEntity<?> deleteRole(@RequestBody RoleVO ID){
        Role r = RoleRepo.findByName(ID.roleName());
        try{RoleRepo.delete(r);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("can,t delete for the reason:"+e.getMessage(),HttpStatus.OK);
        }
    return new ResponseEntity<>("Deleted:"+r.getRoleName(),HttpStatus.OK);
    }
}
