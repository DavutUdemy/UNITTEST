package com.example.restart;

import com.example.restart.Player.Player;
import com.example.restart.Player.PlayerRepository;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.assertj.core.api.BDDAssumptions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.HttpClientErrorException;
import org.yaml.snakeyaml.events.Event;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
class RestartApplicationTests {
    @Mock
    private PlayerRepository playerRepository;

    private PlayerService playerService;

@Mock
    private AutoCloseable autoCloseable;


    @BeforeEach
    void SetUP() {
        AutoCloseable autoCloseable = MockitoAnnotations.openMocks(this);
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
    void addNewShoe() {
        Player player = new Player(
                "PLAYER1",
                "player@gmail.com"
        );

        playerService.addNewShoe(player);
        ArgumentCaptor<Player>playerArgumentCaptor = ArgumentCaptor.forClass(Player.class);
        verify(playerRepository).save(playerArgumentCaptor.capture());
        Player player1 =  playerArgumentCaptor.getValue();
        assertThat(player1).isEqualTo(player);

    }

    @Test
    void willThrowWhenEmailIsTaken(){
        Player player = new Player(
                "PLAYER1",
                "player@gmail.com"
        );
        boolean a = true;
        given(playerRepository.selectExistsEmail(player.getName())).willReturn(true);
        //  playerService.addNewShoe(player);
        assertThatThrownBy(()->playerService.addNewShoe(player)).isInstanceOf(HttpClientErrorException.BadRequest.class).hasMessageContaining("Email is already taken");

    }


    @Test
    public void testRemoveSomething() throws Exception {
        Long ID =3L;


    }

}


