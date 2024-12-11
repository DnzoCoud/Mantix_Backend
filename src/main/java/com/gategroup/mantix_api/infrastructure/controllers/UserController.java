package com.gategroup.mantix_api.infrastructure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gategroup.mantix_api.application.dto.UserDTO;
import com.gategroup.mantix_api.application.dto.request.StoreUserRequestDTO;
import com.gategroup.mantix_api.application.dto.response.ApiResponse;
import com.gategroup.mantix_api.application.usecases.user.FindAllUsers;
import com.gategroup.mantix_api.application.usecases.user.StoreUser;
import com.gategroup.mantix_api.infrastructure.adapters.BaseController;

@RestController
@RequestMapping("/api/users")
public class UserController extends BaseController {

    private final FindAllUsers finfAllUsers;
    private final StoreUser storeUser;

    @Autowired
    public UserController(FindAllUsers finfAllUsers, StoreUser storeUser) {
        this.finfAllUsers = finfAllUsers;
        this.storeUser = storeUser;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserDTO>>> all() {
        try {
            return responseSuccess("Lista de usuarios.", finfAllUsers.execute());
        } catch (Exception e) {
            return responseError("null");
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<UserDTO>> store(@RequestBody StoreUserRequestDTO requestDTO) {
        try {
            UserDTO user = storeUser.execute(requestDTO);
            return responseSuccess(user);
        } catch (Exception e) {
            return responseError(String.format(
                    "%s.", e.getMessage()));
        }
    }
}
