package com.manning.sbip.twitch.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manning.sbip.twitch.model.Conference;
import com.manning.sbip.twitch.repository.ConferenceRepository;

@Service 
public class ConferenceServiceImpl implements ConferenceService {
	private ConferenceRepository conferenceRepository;
	@Autowired
	public ConferenceServiceImpl(ConferenceRepository conferenceRepository) {
		super();
		this.conferenceRepository = conferenceRepository;
	}

	@Override
	public Conference CreatConference(Conference conference) {
		// TODO Auto-generated method stub
		return conferenceRepository.save(conference);
	}

	@Override
	public void updateConference(long id, Conference conference) {
		// TODO Auto-generated method stub
		Optional<Conference> optionalConference = conferenceRepository.findById(id);
		if(optionalConference.isPresent()) { 
			Conference dbConference= optionalConference.get();
			dbConference.setName(conference.getName()); 
			dbConference.setLocation(conference.getLocation());
			dbConference.setDateTime(conference.getDateTime());
			dbConference.setSpeaker(conference.getSpeaker());
			dbConference.setStatus(conference.isStatus()); 
			conferenceRepository.save(dbConference);
			}
		
	}

	@Override
	public Iterable<Conference> getConferences() {
		// TODO Auto-generated method stub
		return conferenceRepository.findAll();
	}

	@Override
	public Optional<Conference> getConferenceById(long id) {
		// TODO Auto-generated method stub
		return conferenceRepository.findById(id);
	}

	@Override
	public void deleteConference(long id) {
		// TODO Auto-generated method stub
		conferenceRepository.deleteById(id);
		
	}

}
