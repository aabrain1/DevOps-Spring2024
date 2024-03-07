package edu.westga.comp4420.notesapplication.test.model.add_notes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import edu.westga.comp4420.notesapplication.model.Note;


class TestAddNotes {
	
	private Note blankNote;

    @Before
    public void setUp() {
        blankNote = new Note();
    }

    @Test
    public void testAddBlankNote() {
        blankNote.addBlankNote();
        assertEquals(1, blankNote.getNotes().size());
        assertEquals("", blankNote.getNotes().get(0).getText());
    }

    @Test
    public void testAddDuplicateTopic() {
        blankNote.addBlankNote();
        blankNote.selectNote(0);
        blankNote.addTopic("Topic1");
        blankNote.addTopic("Topic1");
        List<String> expectedTopics = new ArrayList<>();
        expectedTopics.add("Topic1");
        assertEquals(expectedTopics, blankNote.getActiveNote().getTopics());
    }

    @Test
    public void testAddEmptyTopic() {
        blankNote.addBlankNote();
        blankNote.selectNote(0);
        blankNote.addTopicToNote("");
        assertTrue(blankNote.getActiveNote().getTopics().isEmpty());
    }

}
