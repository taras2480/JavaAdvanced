package ua.lviv.lgs.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.dao.ParticipantRepostory;
import ua.lviv.lgs.domain.Participant;

@Service
public class ParticipantService {
	
	@Autowired
	ParticipantRepostory participantRepostory;
	
	public List<Participant> findAllParticipants() {

		return participantRepostory.findAllParticipants();

	}

	public Participant findOne(Integer id) {

		return participantRepostory.findOne(id);

	}

	public void save(Participant participant) {
		
		participantRepostory.save(participant);

	}

	public void delete(Integer id) {
		participantRepostory.delete(id);
	}

}
