package edu.westga.comp4420.notesapplication.test.model.add_notes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import edu.westga.comp4420.notesapplication.model.Note;


class TestRemovingNotes {
	
	private Note blankNote;

    @Before
    public void setUp() {
        blankNote = new Note();
    }
	
	@Test
    public void testRemoveNote() {
        blankNote.addBlankNote();
        blankNote.selectNote(0);
        blankNote.removeNote();
        assertTrue(blankNote.getNotes().isEmpty());
        assertNull(blankNote.getActiveNote());
    }
	
}
