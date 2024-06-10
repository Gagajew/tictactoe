package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    @Test
    public void testPlayerMarker(){
        char expectedMarker = 'X';
        Player player = new Player(expectedMarker);
        char actualMarker = player.getMarker();
        assertEquals(expectedMarker, actualMarker, "Marker ist 'X'");
    }
}