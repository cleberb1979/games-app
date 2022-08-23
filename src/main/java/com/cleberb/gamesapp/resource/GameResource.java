package com.cleberb.gamesapp.resource;

import com.cleberb.gamesapp.model.Game;
import com.cleberb.gamesapp.repository.GameRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GameResource {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping("/games")
    public List<Game> listar(){
        return gameRepository.findAll();
    }

    @GetMapping("/games/{id}")
    public Game listarJogoPorId(@PathVariable Long id){
        return gameRepository.findById(id).get();
    }

    @PostMapping("/games")
    @ResponseStatus(HttpStatus.CREATED)
    public Game save(@RequestBody Game game){
        return gameRepository.save(game);
    }

    @PutMapping("/games/{id}")
    public Game update(@PathVariable Long id, @RequestBody Game game){
        Game gameAtual = gameRepository.findById(id).get();
        BeanUtils.copyProperties(game, gameAtual, "id");
        return gameRepository.save(gameAtual);
    }

    @DeleteMapping("/games/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        gameRepository.deleteById(id);
    }
}
