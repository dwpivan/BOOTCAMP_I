package com.bootcampfinal.java.event.web;

import com.bootcampfinal.java.event.service.IUserService;
import com.bootcampfinal.java.event.web.model.UserModel;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/user")
@Slf4j
public class UserController {
    @Autowired
    private final IUserService userService;

    /**
     * Get list of users
     * @return
     * @throws Exception
     */
    @GetMapping()
    @Operation(summary = "Get list of users")
    public ResponseEntity<Object> getAll() throws Exception {
        List<UserModel> response =  userService.findAll();
        log.info("getAll" + "OK");
        log.debug(response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Get login name and description
     * @return
     * @throws Exception
     */
    @GetMapping(path = { "{email}/{password}" }, produces = { "application/json" })
    public ResponseEntity<Object> login(@PathVariable("email") String email, @PathVariable("password") String password) throws Exception {
        UserModel response =  userService.login(email, password);
        log.info("getByEmailAndPassword" + "OK");
        log.debug(response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Get user by id
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping(path = { "{id}" }, produces = { "application/json" })
    public ResponseEntity<UserModel> getById(@PathVariable("id") Long id) throws Exception{
        UserModel response = userService.findById(id);
        log.info("getById" + "OK");
        log.debug(id.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Create user
     * @param userModel
     * @return
     * @throws Exception
     */
    @PostMapping()
    public ResponseEntity<Object> create(@RequestBody UserModel userModel) throws Exception {
        UserModel response = userService.create(userModel);
        log.info("create" + "OK");
        log.debug(userModel.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Update user by id
     * @param id
     * @param userModel
     * @throws Exception
     */
    @PutMapping(path = { "{id}" }, produces = { "application/json" })
    public void update(
            @PathVariable("id") Long id,
            @RequestBody UserModel userModel) throws Exception {
        userService.update(id, userModel);
        log.info("update" + "OK");
        log.debug(id.toString()+ "/" + userModel.toString());
    }

    /**
     * Delete user by id
     * @param id
     * @throws Exception
     * @author aangulom
     */
    @DeleteMapping({ "{id}" })
    public void deleteById(@PathVariable("id") Long id) throws Exception {
        userService.deleteById(id);
        log.info("deleteById" + "OK");
        log.debug(id.toString());
    }
}

