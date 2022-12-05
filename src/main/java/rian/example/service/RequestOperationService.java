package rian.example.service;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.redis.datasource.RedisDataSource;
import io.quarkus.redis.datasource.string.StringCommands;
import io.quarkus.redis.datasource.value.ValueCommands;

@SuppressWarnings("deprecation")
@ApplicationScoped
public class RequestOperationService {

	private ValueCommands<String, String> commands;
	private final StringCommands<String, String> comm;

	public RequestOperationService(RedisDataSource ds) {
		commands = ds.value(String.class);
		comm = ds.string(String.class);

	}

	String get(String key) {
		String value = commands.get(key);
		if (value == null) {
			return "";
		}
		return value;
	}

	void set(String key, String value) {
		comm.set(key, value);
	}

}