package server.game;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.log4j.Log4j;
import server.game.services.ResponseData;

import java.io.IOException;

@Log4j
public class StartServer {

    public static void main(String[] args) {
        log.info("Запустился Main!");

        Server server = ServerBuilder.forPort(9000)
                .addService(new ResponseData()).build();
        try {
            server.start();

            log.info("Сервер запущен!");

            server.awaitTermination();
        } catch (InterruptedException | IOException e) {
            log.error("Ошибка в классе StartSever", e);
            server.shutdownNow();
        }
    }
}
