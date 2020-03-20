package ua.lviv.lgs.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ua.lviv.lgs.domain.Level;
import ua.lviv.lgs.domain.Participant;

@Repository
public class ParticipantRepostory {

	private List<Participant> participants = new ArrayList<>();

	@PostConstruct
	public void init() {

		Participant participant4 = new Participant();
		participant4.setId(4);
		participant4.setName("Taras");
		participant4.setEmail("a@gmail.com");
		participant4.setLevel(Level.L3);
		participant4.setPrimarySkill("5 out of 10 hits");

		Participant participant1 = new Participant();
		participant1.setId(1);
		participant1.setName("Oleg");
		participant1.setEmail("o@gmail.com");
		participant1.setLevel(Level.L2);
		participant1.setPrimarySkill("3 out of 10 hits");

		Participant participant2 = new Participant();
		participant2.setId(2);
		participant2.setName("Kostya");
		participant2.setEmail("k@gmail.com");
		participant2.setLevel(Level.L4);
		participant2.setPrimarySkill("7 out of 10 hits");

		Participant participant3 = new Participant();
		participant3.setId(3);
		participant3.setName("Olya");
		participant3.setEmail("0@gmail.com");
		participant3.setLevel(Level.L5);
		participant3.setPrimarySkill("10 out of 10 hits");
		
		participants.add(participant4);
		participants.add(participant1);
		participants.add(participant2);
		participants.add(participant3);

	}

	public List<Participant> findAllParticipants() {

		return participants;

	}
	
	public Participant findOne(Integer id) {

		return participants.stream().filter(participant -> participant.getId() == id).findFirst().orElse(null);

	}
	
	public void save(Participant participant) {
		Participant participantToUpdate = null;

		if (participant.getId() != null) {
			//update
			participantToUpdate = findOne(participant.getId());
			int participantIndex = participants.indexOf(participantToUpdate);
			participantToUpdate.setName(participant.getName());
			participantToUpdate.setEmail(participant.getEmail());
			participantToUpdate.setLevel(participant.getLevel());
			participantToUpdate.setPrimarySkill(participant.getPrimarySkill());
			participants.set(participantIndex, participantToUpdate);
		} else {
			// save
			participant.setId(participants.size()+1);
			participants.add(participant);
		}
	}

	public void delete(int id) {
		Iterator<Participant> iter = participants.iterator();
		while (iter.hasNext()) {
			if (iter.next().getId() == id) {
				iter.remove();
			}
		}
	}

}
