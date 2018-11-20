package chuvaev.cloud.handler.keyboard;

import chuvaev.cloud.event.keyboard.KeyboardCommandEvent;
import chuvaev.cloud.event.keyboard.KeyboardInitEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;


@ApplicationScoped
public class KeyboardInitHandler {

    @Inject
    private Event<KeyboardCommandEvent> keyboardInputCommandEvent;

    public void observe(@Observes final KeyboardInitEvent event){

        System.out.println();
        System.out.println("*** WELCOME TO COMMAND LINE INTERFACE ***");
        System.out.println("*** ENTER \"help\" FOR LIST OF COMMANDS ***");
        keyboardInputCommandEvent.fire(new KeyboardCommandEvent());
    }
}
