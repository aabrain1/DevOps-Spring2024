package edu.westga.comp4420.notesapplication.test.model.add_notes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import edu.westga.comp4420.notesapplication.model.Note;


class TestAddingTopics {
	private Note blankNote;

    @Before
    public void setUp() {
        blankNote = new Note();
    }
	
	@Test
    public void testAddTopic() {
        blankNote.addBlankNote();
        blankNote.selectNote(0);
        blankNote.addTopic("Topic1");
        blankNote.addTopic("Topic2");
        List<String> expectedTopics = new ArrayList<>();
        expectedTopics.add("Topic1");
        expectedTopics.add("Topic2");
        assertEquals(expectedTopics, blankNote.getActiveNote().getTopics());
    }
}
