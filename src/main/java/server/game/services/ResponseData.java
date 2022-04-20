package server.game.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.grpc.stub.StreamObserver;
import lombok.extern.log4j.Log4j;
import server.game.grpc.DataServiceGrpc;
import server.game.grpc.ServerService;
import server.game.models.Question;
import server.game.store.HBStore;

@Log4j
public class ResponseData extends DataServiceGrpc.DataServiceImplBase {
    private final Gson gson = new GsonBuilder().create();

    @Override
    public void swap(ServerService.DataRequest request, StreamObserver<ServerService.DataResponse> responseObserver) {
        log.info("Метод swap запустился!");

        Question question = HBStore.getInstance().findQuestionById(request.getId());
        String responseObject = gson.toJson(question);

        ServerService.DataResponse response = ServerService.DataResponse.newBuilder()
                .setObject(responseObject).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();

        log.info("Передача данных от сервера окончена!");
    }
}
