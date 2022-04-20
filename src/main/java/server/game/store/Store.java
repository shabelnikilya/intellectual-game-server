package server.game.store;

import server.game.models.Question;

public interface Store {

    Question findQuestionById(Integer id);

}
