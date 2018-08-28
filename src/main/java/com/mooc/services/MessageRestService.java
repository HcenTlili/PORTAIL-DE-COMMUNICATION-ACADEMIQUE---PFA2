package com.mooc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mooc.dao.MessageRepository;
import com.mooc.entities.Message;

@RestController
public class MessageRestService {

	@Autowired
	MessageRepository messageRepository;
	
	@RequestMapping(value="/messages", method=RequestMethod.GET)
	public List<Message> listesblogs()
	{
		return messageRepository.findAll();
	}
	@RequestMapping(value="/messages/{idMessage}", method=RequestMethod.GET)
	public Message getMessage(@PathVariable String idMessage)
	{
		return messageRepository.findOne(idMessage);
	}
	@RequestMapping(value="/messages", method=RequestMethod.POST)
	public void save(@RequestBody Message Message)
	{
		messageRepository.save(Message);
	}
	
	@RequestMapping(value="/messages/{idMessage}", method=RequestMethod.PUT)
	public void save(@RequestBody Message message , @PathVariable String idMessage)
	{
		message.setIdMessage(idMessage);
		messageRepository.save(message);
	}
	
	@RequestMapping(value="/messages/{idMessage}", method=RequestMethod.DELETE)
	public void delete(@PathVariable String idMessage)
	{
		messageRepository.delete(idMessage);
	}
}
