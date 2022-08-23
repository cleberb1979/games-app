package com.cleberb.gamesapp.resource;

import com.cleberb.gamesapp.exceptions.ResourceNotFoundException;
import com.cleberb.gamesapp.model.Game;
import com.cleberb.gamesapp.repository.GameRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class GameResource {

    private Logger logger = Logger.getLogger(GameResource.class.getName());

    @Autowired
    private GameRepository gameRepository;

    @GetMapping("/games")
    public List<Game> findAll(){
        logger.info("Finding all games!");
        return gameRepository.findAll();
    }

    @GetMapping("/games/{id}")
    public Game findById(@PathVariable Long id){
        logger.info("Finding one game!");
        return gameRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }

    @PostMapping("/games")
    @ResponseStatus(HttpStatus.CREATED)
    public Game save(@RequestBody Game game){
        logger.info("Saving one game!");
        return gameRepository.save(game);
    }

    @PutMapping("/games/{id}")
    public Game update(@PathVariable Long id, @RequestBody Game game){
        logger.info("Updating one game!");
        Game gameAtual = gameRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        BeanUtils.copyProperties(game, gameAtual, "id");
        return gameRepository.save(gameAtual);
    }

    @DeleteMapping("/games/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        logger.info("Deleting one game!");
        var entity = gameRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        gameRepository.delete(entity);
    }
}
