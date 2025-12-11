package model.invasiontheatre;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import model.place.*;
import model.player.ClanChiefModel;

class InvasionTheatreModelTest {

	private InvasionTheatreModel theatre;
    private ArrayList<Place> places;
    private ArrayList<ClanChiefModel> chiefs;

    @BeforeEach
    void setUp() {
    	this.places = new ArrayList<>();
    	this.chiefs = new ArrayList<>();

        places.add(new RomanCity("a", 10, new ArrayList<>(), new ArrayList<>()));
        places.add(new RomanCity("b", 8, new ArrayList<>(), new ArrayList<>()));

        chiefs.add(new ClanChiefModel("A", "B", 1, new RomanCity("a", 10, new ArrayList<>(), new ArrayList<>())));
        chiefs.add(new ClanChiefModel("B", "C", 1, new RomanCity("b", 10, new ArrayList<>(), new ArrayList<>())));

        this.theatre = new InvasionTheatreModel("ascascasc", 5, places, chiefs);
    }
	
        @Test
        void testInvasionTheatreModel() {
            assertEquals("ascascasc", this.theatre.getName());
            assertEquals(5, this.theatre.getMaxNumberOfPlaces());
            assertEquals(this.places, this.theatre.getPlaces());
            assertEquals(this.chiefs, this.theatre.getClanChiefs());
        }

        @Test
        void testGetName() {
            assertEquals("ascascasc", theatre.getName());
        }

        @Test
        void testGetMaxNumberOfPlaces() {
            assertEquals(5, theatre.getMaxNumberOfPlaces());
        }

        @Test
        void testGetPlaces() {
            assertEquals(2, theatre.getPlaces().size());
            assertEquals("a", theatre.getPlaces().get(0).getName());
            assertEquals("b", theatre.getPlaces().get(1).getName());
        }

        @Test
        void testGetPlaceNames() {
            ArrayList<String> names = theatre.getPlaceNames();
            assertEquals(2, names.size());
            assertEquals("a (RomanCity)", names.get(0));
            assertEquals("b (RomanCity)", names.get(1));
        }

        @Test
        void testGetAllCharactersInfo() {
        	ArrayList<String> array = new ArrayList<String>();
        	array.add("=== a ===");
        	array.add("  (Aucun personnage)");
        	array.add("");
        	array.add("=== b ===");
        	array.add("  (Aucun personnage)");
        	array.add("");
        	
            assertEquals(this.theatre.getAllCharactersInfo(), array);
        }

        @Test
        void testGetClanChiefs() {
            assertEquals(2, theatre.getClanChiefs().size());
            assertEquals("A", theatre.getClanChiefs().get(0).getName());
            assertEquals("B", theatre.getClanChiefs().get(1).getName());
        }

        @Test
        void testGetNumberClanChiefs() {
            assertEquals(2, theatre.getNumberClanChiefs());
        }

        @Test
        void testGetTotalNumberOfCharacters() {
            assertEquals(0, theatre.getTotalNumberOfCharacters());
        }

        @Test
        void testIsBattlefieldPresent() {
            assertEquals(this.theatre.isBattlefieldPresent(), false);
        }

        @Test
        void testFightBelligerents() {
            assertEquals(this.theatre.fightBelligerents(), new ArrayList<>());
        }

        @Test
        void testGetAvailableBattlefields() {
            assertEquals(this.theatre.getAvailableBattlefields(), new ArrayList<>());
        }

        @Test
        void testCanAddPlace() {
            assertTrue(theatre.canAddPlace());
        }

        @Test
        void testAddPlace() {
            Place newPlace = new RomanCity("Lyon", 6, new ArrayList<>(), new ArrayList<>());
            assertTrue(theatre.addPlace(newPlace));
            assertEquals(3, theatre.getPlaces().size());
        }

        @Test
        void testGetClanChief() {
            assertEquals("A", theatre.getClanChief(0).getName());
            assertEquals("B", theatre.getClanChief(1).getName());
        }

        @Test
        void testGetTransferDestinations() {
            ArrayList<Place> dest = theatre.getTransferDestinations();
            assertEquals(0, dest.size()); 
        }

}
