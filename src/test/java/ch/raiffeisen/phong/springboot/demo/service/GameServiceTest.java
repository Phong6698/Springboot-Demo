package ch.raiffeisen.phong.springboot.demo.service;

import ch.raiffeisen.phong.springboot.demo.domain.Game;
import ch.raiffeisen.phong.springboot.demo.domain.Team;
import ch.raiffeisen.phong.springboot.demo.domain.TeamGame;
import ch.raiffeisen.phong.springboot.demo.repository.GameRepository;
import ch.raiffeisen.phong.springboot.demo.repository.TeamGameRepository;
import ch.raiffeisen.phong.springboot.demo.repository.TeamRepository;
import org.junit.jupiter.api.*;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("GameService")
class GameServiceTest {

    private GameRepository gameRepository;
    private TeamGameRepository teamGameRepository;
    private TeamRepository teamRepository;

    private GameService gameService;

    @BeforeEach
    void setup(){
        gameRepository = mock(GameRepository.class);
        teamGameRepository = mock(TeamGameRepository.class);
        teamRepository = mock(TeamRepository.class);
        gameService = new GameService();
        gameService.setGameRepository(gameRepository,teamGameRepository,teamRepository);
    }

    @Test
    @DisplayName("Get Game by Id")
    void getGameById() {
        //given
        Game game = new Game();
        game.setId(6);

        when(gameRepository.findOne(6)).thenReturn(game);

        //when
        Game resultGame = gameService.getGameById(6);

        //then
        verify(gameRepository, times(1)).findOne(6);
        assertEquals(6, resultGame.getId(), "game id should be 6");
    }

    @Test
    @Disabled
    void deleteGame() {
    }

    @Test
    void getPlayedGames() {
    }

    @Test
    void getPlayedGamesByTeamId() {
    }

    @Test
    void getUnplayedGames() {
    }

    @Test
    void getUnplayedGamesByTeamId() {
    }

    @Test
    void getGames() {
    }

    @Nested
    @DisplayName("Get Games by Team ID")
    class getGamesByTeamId {

        @Test
        @DisplayName("Team and TeamGame exists")
        void teamAndTeamGameExists() {
            //given
            Team team = new Team();
            team.setName("Test");
            team.setId(1);

            ArrayList<TeamGame> teamGames = new ArrayList<TeamGame>();
            ArrayList<Game> games = new ArrayList<Game>();

            for(int i=1; i<6; i++){
                TeamGame teamGame1 = new TeamGame();
                teamGame1.setId(i*10+1);
                teamGame1.setScore(10);
                teamGame1.setWinner(true);
                teamGames.add(teamGame1);

                TeamGame teamGame2 = new TeamGame();
                teamGame2.setId(i*10+2);
                teamGame2.setScore(2);
                teamGame2.setWinner(false);


                Game game = new Game();
                game.setId(i);
                teamGame1.setGame(game);
                teamGame2.setGame(game);
                game.setTeamGames(new ArrayList<TeamGame>());
                game.getTeamGames().add(teamGame1);
                game.getTeamGames().add(teamGame2);
                games.add(game);
            }

            team.setTeamGames(teamGames);

            when(teamRepository.findOne(1)).thenReturn(team);
            when(gameRepository.findAll(ArgumentMatchers.<Integer>anyList())).thenReturn(games);


            //when
            ArrayList<Game> gamesResult = (ArrayList) gameService.getGamesByTeamId(1);

            //then
            assertEquals(5, gamesResult.size(), "Games size should be 10");
            assertEquals(2, gamesResult.get(0).getTeamGames().size(), "TeamGames size should be 2");
        }

        @Test
        @DisplayName("Team dont exist")
        void teamDontExists(){
            //given
            when(teamGameRepository.findOne(1)).thenReturn(null);

            //when
            ArrayList<Game> gamesResult = (ArrayList) gameService.getGamesByTeamId(1);

            //then
            assertEquals(null, gamesResult, "GameResult should be null");
        }
    }



    @Test
    void saveGame() {
    }

}