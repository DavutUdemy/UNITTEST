package com.example.restart;
  import com.example.restart.Player.Player;
  import com.example.restart.Player.PlayerRepository;
 import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "api/v1/shoe")

public class ProductController {
    private final PlayerRepository playerRepository;
    private final PlayerService playerService;

    public ProductController(PlayerRepository playerRepository, PlayerService playerService) {
        this.playerRepository = playerRepository;
        this.playerService = playerService;
    }


    @PostMapping
    public void registerNewShoe(@RequestBody Player player){
        playerService.addNewShoe(player);

    }

    @GetMapping
    public List<Player> getShoes(){
        return playerService.getShoes();
    }    @DeleteMapping
    public void DeleteAll(){
        playerRepository.deleteAll();
    }
    @DeleteMapping("{id}")
    public void DeleteById(@PathVariable Long Id){
         playerService.deleteById(Id);
    }
}
