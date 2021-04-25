package com.example.restart;

import com.example.restart.BadRequest.BadRequestException;
import com.example.restart.Player.Player;
import com.example.restart.Player.PlayerRepository;
import javassist.tools.web.BadHttpRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class PlayerService {
    private final PlayerRepository playerRepository;

    PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    public void addNewShoe(Player player) {
Boolean existEmail = playerRepository.selectExistsEmail(player.getName());
var a = player.getName();
        if (existEmail) {
                throw new BadRequestException(
                        "Email " + player.getName()+"is already taken");



        }
        playerRepository.save(player);

    }

    public  List<Player> getShoes() {
        return playerRepository.findAll();
    }

    public void deleteById(Long Id) {
        playerRepository.deleteById(Id);
    }
}
