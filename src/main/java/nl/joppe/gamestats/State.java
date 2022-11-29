package nl.joppe.gamestats;

import nl.joppe.audio.AudioPlayer;
import nl.joppe.game.Game;
import nl.joppe.ui.MenuButton;

import java.awt.event.MouseEvent;

public class State {
    protected Game game;

    public State(Game game) {
        this.game = game;
    }

    public boolean isIn(MouseEvent e, MenuButton mb) {
        return mb.getBounds().contains(e.getX(), e.getY());
    }

    public Game getGame() {
        return game;
    }

    @SuppressWarnings("incomplete-switch")
    public void setGameState(Gamestate state) {
        switch (state) {
        //    case MENU -> game.getAudioPlayer().playSong(AudioPlayer.MENU_1);
        //    case PLAYING -> game.getAudioPlayer().setLevelSong(game.getPlaying().getLevelManager().getLevelIndex());
        }

        Gamestate.state = state;
    }

}