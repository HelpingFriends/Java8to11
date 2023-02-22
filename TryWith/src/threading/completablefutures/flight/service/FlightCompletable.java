package threading.completablefutures.flight.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import threading.completablefutures.flight.Flight;
import threading.completablefutures.flight.ThreadUtil;

public class FlightCompletable extends CompletableFuture<List<Flight>>{

	
	@Override
	public Executor defaultExecutor() {
		return ThreadUtil.getExecutorService();
	}	

}
