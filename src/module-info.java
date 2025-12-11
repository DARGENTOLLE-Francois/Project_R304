module game {

    // --- VIEW LAYER ---
    exports view.character;
    exports view.invasiontheatreview;
    exports view.lycanthrope;
    exports view.player;
    exports view.utils;

    // --- CONTROLLER LAYER ---
    exports controller.character;
    exports controller.invasiontheatre;
    exports controller.player;

    // --- MODEL LAYER ---
    exports model.character;
    exports model.food;
    exports model.invasiontheatre;
    exports model.lycanthrope;
    exports model.magicpotion;
    exports model.place;
    exports model.player;

    // --- EXCEPTIONS ---
    exports includes.exception;
	requires junit;
	requires org.junit.jupiter.api;
}