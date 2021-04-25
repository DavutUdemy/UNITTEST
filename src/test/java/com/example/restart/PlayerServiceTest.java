package com.example.restart;

import com.example.restart.Player.Player;
import com.example.restart.Player.PlayerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.base.MockitoInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class PlayerServiceTest {
    @Autowired
    private PlayerRepository playerRepository;
    @Mock private PlayerService playerService;


    private AutoCloseable autoCloseable;


    @BeforeEach
    void SetUP() {
        AutoCloseable autoCloseable = MockitoAnnotations.openMocks(this)
;
        playerService= new PlayerService(playerRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllStudent(){

        playerService.getShoes();
        verify(playerRepository).findAll();

    }

        @Test
        @Disabled
        void addNewShoe() {
        }

        @Test
        @Disabled
        void getShoes() {
        }
    }
