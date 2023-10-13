package pe.isil.microservicios_2978.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.isil.microservicios_2978.model.Game;
import pe.isil.microservicios_2978.repository.GameRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api_2978/games")
public class GameController{

    @Autowired
    private GameRepository gameRepository;

    //insert a new game
    @PostMapping("/check")
    public Game store(@RequestBody Game game){
        game.setId(0);//setting the id in 0, to insert
        return gameRepository.save(game);
    }

    //get games by id
    @GetMapping("/getById/{id}")
    public Optional<Game> getById(@PathVariable("id") Integer id){
        return gameRepository.findById(id);
    }

    //Get all games
    @GetMapping("/getAll")
    public List<Game> getAll(){
        return gameRepository.findAll();
    }

    //obtener productos por name
    @GetMapping("/getByName/{name}")
    public List<Game> getByName(@PathVariable("name") String name){
        return gameRepository.findByName(name);
    }
    //actualizar un producto
    @PutMapping("/update/{id}")
    public Game actualizar(@RequestBody Game game, @PathVariable("id") Integer id){
        Game gameDB = gameRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("The game with this Id can't be found, sorry: " + id));
        gameDB.setId(game.getId());
        gameDB.setName(game.getName());
        gameDB.setCategory(game.getCategory());
        gameDB.setConsole(game.getConsole());
        gameDB.setProtagonist(game.getProtagonist());

        return gameRepository.save(gameDB);
    }

    @DeleteMapping("/delete/{id}")
    public boolean eliminar(@PathVariable("id") Integer id){
        try {
            gameRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }

}
