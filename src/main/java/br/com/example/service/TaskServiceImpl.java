package br.com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.example.rest.YoutubeRestService;

@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private YoutubeRestService service;

	@Override
	public String createTask(String channelId) {
		return service.requestVideosByChannelId(channelId);
	}

}
